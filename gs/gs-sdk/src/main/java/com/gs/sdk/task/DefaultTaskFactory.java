package com.gs.sdk.task;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.slf4j.Logger;
import org.springframework.util.CollectionUtils;

import com.gs.common.utils.LogMaker;

/**
 * 默认任务处理工厂
 * 对任务队列建立多个线程处理
 * 每次下达开工命令后
 * 检测已有工人是否繁忙，若还没有开过工则开工
 * 若是某个工人已经结束所有工作则舍弃并用新工人替换并立即开工
 * 
 * @author shaozhen
 *
 */
public class DefaultTaskFactory implements BaseTaskFactory {

	Logger log = LogMaker.make();

	ConcurrentLinkedQueue<BaseTask> taskQueue = null;
	List<Thread> workers = null;

	public DefaultTaskFactory(int workNum) {
		taskQueue = new ConcurrentLinkedQueue<>();
		workers = new Vector<>();
		for (int i = 0; i < workNum; i++) {
			workers.add(new Thread(new DefaultWorker(taskQueue, String.valueOf(i), null)));
		}
	}

	public int getWaitingTaskNumber() {
		return taskQueue.size();
	}

	@Override
	public void addTask(BaseTask task) {
		taskQueue.add(task);

	}

	@Override
	public void addTaskList(ConcurrentLinkedQueue<BaseTask> queue) {
		if (queue != null) {
			taskQueue.addAll(queue);
		}
	}

	@Override
	public synchronized void startWork() {
		if (!CollectionUtils.isEmpty(workers)) {
			Thread worker;
			for (int i =0, size = workers.size(); i < size; i++) {
				worker = workers.get(i);
				switch (worker.getState()) {
				case NEW:
					worker.start();
					break;
				case TERMINATED:
					worker = new Thread(new DefaultWorker(taskQueue, String.valueOf(i)));
					worker.start();
					break;
				default:
					break;
				}
			}
		}
	}
}
