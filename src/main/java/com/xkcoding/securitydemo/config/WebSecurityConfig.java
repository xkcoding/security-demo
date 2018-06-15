package com.xkcoding.securitydemo.config;

import com.xkcoding.securitydemo.security.MyAuthenticationFailureHandler;
import com.xkcoding.securitydemo.security.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <p>
 * Security 配置
 * </p>
 *
 * @package: com.xkcoding.securitydemo.config
 * @description： Security 配置
 * @author: yangkai.shen
 * @date: Created in 2018/6/14 上午10:12
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

	@Autowired
	private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().successHandler(myAuthenticationSuccessHandler).failureHandler(myAuthenticationFailureHandler).and().authorizeRequests().anyRequest().authenticated();
	}
}
