package com.fisc.passwordservice.core;

public class ResetStatus {
	public String target;

	public String errorReason;

	public static ResetStatus success(String target) {
		ResetStatus status = new ResetStatus();
		status.target = target;
		return status;
	}

	public static ResetStatus failed(String target, String reason) {
		ResetStatus status = new ResetStatus();
		status.target = target;
		status.errorReason = reason;
		return status;
	}
}
