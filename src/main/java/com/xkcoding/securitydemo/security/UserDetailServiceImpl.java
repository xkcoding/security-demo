package com.xkcoding.securitydemo.security;

import cn.hutool.core.util.StrUtil;
import com.xkcoding.securitydemo.model.SysUser;
import com.xkcoding.securitydemo.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 自定义用户认证逻辑
 * </p>
 *
 * @package: com.xkcoding.securitydemo.service
 * @description： 自定义用户认证逻辑
 * @author: yangkai.shen
 * @date: Created in 2018/6/14 下午2:41
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Component
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	private SysUserRepository sysUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser sysUser = sysUserRepository.findByUsername(username);
		if (sysUser == null) {
			throw new UsernameNotFoundException(StrUtil.format("用户名为{}的用户不存在", username));
		}
		return sysUser;
	}
}
