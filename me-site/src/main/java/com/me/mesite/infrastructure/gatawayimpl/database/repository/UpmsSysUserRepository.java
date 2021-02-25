package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.UpmsSUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpmsSysUserRepository extends JpaRepository<UpmsSUser, Integer> {

}
