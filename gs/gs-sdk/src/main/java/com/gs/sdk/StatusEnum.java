package com.gs.sdk;

public enum StatusEnum {
	SUCCESS(0),FAIL(1);
	private int value;
	private StatusEnum(int value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
}
