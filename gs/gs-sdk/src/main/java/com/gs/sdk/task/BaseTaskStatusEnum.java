package com.gs.sdk.task;

public enum BaseTaskStatusEnum {
	WAITING(-1, "等待处理"), HANDLING(0, "处理中"), END(1, "处理完毕");
	private int code;
	private String desc;

	private BaseTaskStatusEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
	
	public static String getDesc(Integer code){
		BaseTaskStatusEnum en = getEnum(code);
		return en != null ? en.getDesc() : null;
	}
	

	public static BaseTaskStatusEnum getEnum(Integer code) {
		if (code != null) {
			for (BaseTaskStatusEnum en : BaseTaskStatusEnum.values()) {
				if (code == en.getCode()) {
					return en;
				}
			}
		}
		return null;
	}
}
