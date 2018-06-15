package com.xkcoding.securitydemo.repository;

import com.xkcoding.securitydemo.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * 用户 Repository
 * </p>
 *
 * @package: com.xkcoding.securitydemo.repository
 * @description： 用户 Repository
 * @author: yangkai.shen
 * @date: Created in 2018/6/14 下午2:38
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
	SysUser findByUsername(String username);
}
