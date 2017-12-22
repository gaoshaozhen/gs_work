package enums;

public enum EnabledEnum {
	VALID(1, "有效"), INVALID(0, "无效");
	private int code;
	private String desc;

	private EnabledEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public EnabledEnum getEnum(Integer code) {
		EnabledEnum result = null;
		if (code != null) {
			for (EnabledEnum en : EnabledEnum.values()) {
				if (en.code == code) {
					result = en;
					break;
				}
			}
		}
		return result;
	}
}
