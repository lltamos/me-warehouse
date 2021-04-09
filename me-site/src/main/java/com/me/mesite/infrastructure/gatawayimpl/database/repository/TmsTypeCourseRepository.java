package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTypeCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TmsTypeCourseRepository extends JpaRepository<TmsTypeCourse, Integer>, JpaSpecificationExecutor<TmsTypeCourse> {

}