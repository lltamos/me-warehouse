package com.me.mesite.database.repository;

import com.me.mesite.database.entity.MeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MeUserRepository extends JpaRepository<MeUser, String>, JpaSpecificationExecutor<MeUser> {

}