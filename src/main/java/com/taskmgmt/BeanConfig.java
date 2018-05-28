package com.taskmgmt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.taskmgmt.domain.wrapper.UserCompanyWrap;

@Configuration
public class BeanConfig {

	@Bean
	public UserCompanyWrap userCompanyWrap() {
		return new UserCompanyWrap();
	}
	
}
