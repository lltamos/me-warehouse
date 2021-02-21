package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.UpmsSysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpmsSysUserRepository extends JpaRepository<UpmsSysUser, Long> {

}
