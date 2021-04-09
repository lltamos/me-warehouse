package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.UpmsTrainee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpmsTraineeRepository extends JpaRepository<UpmsTrainee, Integer> {

    Page<UpmsTrainee> findByPhoneStartingWith(String phone, Pageable pageable);
}