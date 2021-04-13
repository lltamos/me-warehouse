package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTestReps;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TmsTestRepsRepository extends JpaRepository<TmsTestReps, Integer> {


    Page<TmsTestReps> findAllByLocked(Integer locked, Pageable pageable);

    Page<TmsTestReps> findAllByLockedAndNameStartsWith(Integer locked, String name, Pageable pageable);

}