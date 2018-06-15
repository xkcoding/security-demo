package com.xkcoding.securitydemo.repository;

import com.xkcoding.securitydemo.SecurityDemoApplicationTests;
import com.xkcoding.securitydemo.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <p>
 * SysSysUserRepositoryTest
 * </p>
 *
 * @package: com.xkcoding.securitydemo.repository
 * @description： SysSysUserRepositoryTest
 * @author: yangkai.shen
 * @date: Created in 2018/6/14 下午3:29
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Slf4j
public class SysSysUserRepositoryTest extends SecurityDemoApplicationTests {
	@Autowired
	private SysUserRepository sysUserRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	public void findByUsername() {
		SysUser admin = sysUserRepository.findByUsername("admin");
		Assert.assertEquals("admin", admin.getUsername());
	}

	@Test
	public void save() {
		String password = passwordEncoder.encode("admin");
		log.info("【保存用户】password: {}", password);
		SysUser sysUser = new SysUser();
		sysUser.setUsername("admin");
		sysUser.setPassword(password);
		sysUser.setEnable(true);
		sysUser.setCreateTime(System.currentTimeMillis());
		sysUser.setUpdateTime(System.currentTimeMillis());
		sysUser.setAuthorities("admin");

		SysUser save = sysUserRepository.save(sysUser);
		Assert.assertNotNull(save.getId());
	}
}