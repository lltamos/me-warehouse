package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.MeUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeUserRepository extends JpaRepository<MeUser, Long> {

    Page<MeUser> findMeUserByPhoneStartingWith(String phone, Pageable pageable);
}