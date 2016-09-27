package com.fisc.passwordservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fisc.passwordservice.core.PasswordResetService;

@RestController
public class PasswordResetController {

	private static final Logger log = LoggerFactory.getLogger(PasswordResetController.class);

	private PasswordResetService service;

	public PasswordResetController(PasswordResetService service) {
		this.service = service;
	}

	@RequestMapping(path = "/reset-password", method = RequestMethod.POST)
	public String resetPassword(String userId) throws Exception {
		return service.resetPassword(userId);
	}
}
