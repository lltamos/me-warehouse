package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsQuestionReps;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.UpmsCUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TmsQuestionRepsRepository extends JpaRepository<TmsQuestionReps, Long> {

    Page<TmsQuestionReps> findTmsQuestionRepsBy(String phone, Pageable pageable);
}