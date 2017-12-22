package com.gs.common.utils;

import org.slf4j.Logger;

public class LogMaker {
	public static Logger make() {
		Throwable t = new Throwable();
		StackTraceElement directCaller = t.getStackTrace()[1];
		return org.slf4j.LoggerFactory.getLogger(directCaller.getClassName());
	}
}
