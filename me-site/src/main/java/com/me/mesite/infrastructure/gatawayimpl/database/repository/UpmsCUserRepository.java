package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.UpmsCUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpmsCUserRepository extends JpaRepository<UpmsCUser, Long> {

    Page<UpmsCUser> findMeUserByPhoneStartingWith(String phone, Pageable pageable);
}