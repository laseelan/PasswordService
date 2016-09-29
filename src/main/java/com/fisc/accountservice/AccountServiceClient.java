package com.fisc.accountservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fisc.accountservice.model.User;

//@FeignClient(name = "reddit-service", url = "${com.deswaef.reddit.url}")
@FeignClient(name = "account-service", url = "http://account-service:80", fallback = AccountServiceClientFallback.class)
public interface AccountServiceClient {

	@RequestMapping(path = "/account/{id}", method = RequestMethod.GET)
	public User account(@PathVariable("id") Long id);

	@RequestMapping(path = "/account", method = RequestMethod.GET)
	public User accountByUserId(@RequestParam("userId") String userId);
}
