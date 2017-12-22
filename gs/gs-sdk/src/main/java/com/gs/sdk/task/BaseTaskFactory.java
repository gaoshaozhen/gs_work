package com.gs.sdk.task;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 基本任务工厂
 * @author shaozhen
 *
 */
public interface BaseTaskFactory {
	public void addTask(BaseTask task);
	public void addTaskList(ConcurrentLinkedQueue<BaseTask> queue);
	
	public void startWork();
	
}
