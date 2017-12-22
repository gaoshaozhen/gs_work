package com.gs.sdk.task.fixed;

import com.gs.sdk.task.BaseTask;
import com.gs.sdk.task.BaseTaskStatusEnum;
import com.gs.sdk.task.BaseWorker;

public class FixedWorker implements BaseWorker, Runnable{

	private BaseTask currentTask;
	
	public FixedWorker(BaseTask currentTask){
		this.currentTask = currentTask;
	}

	@Override
	public void startWork() {
		if(currentTask != null){
			currentTask.setBaseTaskStatusEnum(BaseTaskStatusEnum.HANDLING);
			currentTask.handle();
			currentTask.setBaseTaskStatusEnum(BaseTaskStatusEnum.END);
			currentTask = null;
		}
	}

	@Override
	public void run() {
		startWork();
	}
}
