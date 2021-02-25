package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.UpmsCUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpmsCUserRepository extends JpaRepository<UpmsCUser, Integer> {

    Page<UpmsCUser> findUpmsCUserByPhoneStartingWith(String phone, Pageable pageable);
}