package com.gs.sdk.task;

import org.slf4j.Logger;

import com.gs.common.utils.LogMaker;

/**
 * 基础类任务类，不是线程安全
 * 不能线程共享
 * @author shaozhen
 *
 */
public class DefaultTask implements BaseTask {
	Logger log = LogMaker.make();
	
	private volatile BaseTaskStatusEnum status = BaseTaskStatusEnum.WAITING;

	@Override
	public BaseTaskStatusEnum getBaseTaskStatusEnum() {
		return status;
	}
	
	public void setBaseTaskStatusEnum(BaseTaskStatusEnum en){
		this.status = en;
	}

	@Override
	public void handle() {
		status = BaseTaskStatusEnum.HANDLING;
		log.debug("任务开始处理");
		log.debug("任务结束处理");
		status = BaseTaskStatusEnum.END;
	}
}
