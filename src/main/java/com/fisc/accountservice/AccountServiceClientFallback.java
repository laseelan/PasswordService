package com.fisc.accountservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fisc.accountservice.model.User;

@Component
public class AccountServiceClientFallback implements AccountServiceClient {

	private static final Logger log = LoggerFactory.getLogger(AccountServiceClient.class);

	public User account(Long id) {
		log.error("Account service is not available");
		return null;
	}

	public User accountByUserId(String userId) {
		log.error("Account service is not available");
		return null;
	}
}
