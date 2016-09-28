package com.fisc.passwordservice.core;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fisc.accountservice.AccountServiceClient;
import com.fisc.accountservice.model.User;
import com.fisc.passwordservice.repository.PasswordResetRepository;
import com.fisc.passwordservice.util.EncryptUtil;
import com.fisc.passwordservice.util.PasswordGenerator;

@Service
class PasswordResetServiceImpl implements PasswordResetService {

	// generates an 8 length password by default
	private static final int USER_GENERATE_PASSWORD_LENGTH = 8;

	private PasswordResetRepository repository;
	@Autowired
	private AccountServiceClient accountServiceClient;

	@Autowired
	public PasswordResetServiceImpl(PasswordResetRepository repository) {
		this.repository = repository;
	}

	@Override
	public String resetPassword(String userId) {

		User user = accountServiceClient.accountByUserId(userId);

		if (user == null) {
			throw new ServiceException("user not found for userId: " + userId);
		} else if (user.getId() == null) {
			throw new ServiceException("error while pulling user info");
		}

		String generatedPassword = PasswordGenerator.generateRandomPassword(USER_GENERATE_PASSWORD_LENGTH);

		repository.resetPassword(userId, EncryptUtil.getMD5String(generatedPassword));
		return generatedPassword;

	}
}
