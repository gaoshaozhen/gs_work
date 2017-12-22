package com.gs.sdk.task;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;

import com.gs.common.utils.LogMaker;

/**
 * 处理任务的工人 处理完一个任务后就去获取新任务，没有任务就结束工作，等待被替换 适合间隔时间较长，定时运行大批任务
 * 工人每次只处理一个任务，failureType 为true时则当处理出现异常时任务没有处理完毕则重新加到任务列表
 * @author shaozhen
 *
 */
public class DefaultWorker implements BaseWorker, Runnable,
		UncaughtExceptionHandler {
	Logger log = LogMaker.make();
	private ConcurrentLinkedQueue<BaseTask> taskList;
	private String id = null;
	private BaseTask currentTask = null;
	private AtomicBoolean failureType = new AtomicBoolean(false);

	public DefaultWorker(ConcurrentLinkedQueue<BaseTask> taskList) {
		init(taskList, null, null);
	}

	public DefaultWorker(ConcurrentLinkedQueue<BaseTask> taskList, String id) {
		init(taskList, id, null);
	}

	public DefaultWorker(ConcurrentLinkedQueue<BaseTask> taskList,
			Boolean failureType) {
		init(taskList, null, failureType);
	}

	public DefaultWorker(ConcurrentLinkedQueue<BaseTask> taskList, String id,
			Boolean failureType) {
		init(taskList, id, failureType);
	}

	private void init(ConcurrentLinkedQueue<BaseTask> taskList, String id,
			Boolean failureType) {
		Objects.requireNonNull(id == null || id.trim().equals("") ? null : id,
				"工人id不能为空");
		this.taskList = taskList;
		this.id = UUID.randomUUID().toString();
		if (Boolean.TRUE.equals(failureType)) {
			this.failureType.set(true);
		}
	}

	@Override
	public void startWork() {
		while (taskList != null && !taskList.isEmpty()) {
			System.out.println(String.format("工人%s开始工作", id));
			currentTask = taskList.poll();
			currentTask.handle();
			System.out.println(String.format("工人%s结束工作", id));
		}
	}

	@Override
	public void run() {
		startWork();
	}

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		String msg = null;
		if (failureType.get()) {
			BaseTaskStatusEnum status = currentTask.getBaseTaskStatusEnum();
			if (status != BaseTaskStatusEnum.END) {
				currentTask.setBaseTaskStatusEnum(BaseTaskStatusEnum.WAITING);
				taskList.add(currentTask);
				msg = status.getDesc() + ",状态改为等待处理并重新加入任务列表中";
			}
		}
		log.warn("工人{}异常死亡, 当前任务状态 {},{}", id, msg, e.getMessage());
	}
}
