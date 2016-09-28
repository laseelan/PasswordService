package com.fisc.passwordservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fisc.passwordservice.core.PasswordResetService;
import com.fisc.passwordservice.core.ResetStatus;

@RestController
public class PasswordResetController {

	private PasswordResetService service;

	public PasswordResetController(PasswordResetService service) {
		this.service = service;
	}

	@RequestMapping(path = "/reset-password", method = RequestMethod.POST)
	public ResponseEntity<ResetStatus> resetPassword(@RequestParam("userId") String userId) throws Exception {
		try {
			service.resetPassword(userId);
			return new ResponseEntity<>(ResetStatus.success(userId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(ResetStatus.failed(userId, e.getMessage()), HttpStatus.BAD_GATEWAY);
		}
	}
}
