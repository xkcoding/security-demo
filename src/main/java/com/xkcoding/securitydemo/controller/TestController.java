package com.xkcoding.securitydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 测试
 * </p>
 *
 * @package: com.xkcoding.securitydemo.controller
 * @description： 测试
 * @author: yangkai.shen
 * @date: Created in 2018/6/14 上午11:13
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@RequestMapping("/test")
@RestController
public class TestController {

	@GetMapping
	public String test() {
		return "test";
	}
}
