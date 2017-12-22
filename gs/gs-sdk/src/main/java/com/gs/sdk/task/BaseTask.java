package com.gs.sdk.task;

/**
 * 基本任务
 * @author shaozhen
 *
 */
public interface BaseTask {
	public BaseTaskStatusEnum getBaseTaskStatusEnum();
	public void handle();
	public void setBaseTaskStatusEnum(BaseTaskStatusEnum waiting);
}
