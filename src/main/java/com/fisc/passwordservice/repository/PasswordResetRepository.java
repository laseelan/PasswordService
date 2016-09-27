package com.fisc.passwordservice.repository;

public interface PasswordResetRepository {
	public void resetPassword(String userId, String password);
}
