package com.gs.sdk.task.fixed;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;

import com.gs.sdk.task.BaseTask;
import com.gs.sdk.task.BaseTaskFactory;
import com.gs.common.utils.LogMaker;

public class FixedTaskFactory implements BaseTaskFactory {
	Logger log = LogMaker.make();

	ConcurrentLinkedQueue<BaseTask> taskQueue = null;
	ExecutorService fixedThreadPool = null;

	public FixedTaskFactory(int workNum) {
		taskQueue = new ConcurrentLinkedQueue<>();
		fixedThreadPool = Executors.newFixedThreadPool(workNum);
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
		while (!taskQueue.isEmpty()) {
			fixedThreadPool.execute(new FixedWorker(taskQueue.poll()));
		}
	}
}
