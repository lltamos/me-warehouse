package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTypeSubjectCourseShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TmsTypeSubjectCourseShipRepository extends JpaRepository<TmsTypeSubjectCourseShip, Integer>, JpaSpecificationExecutor<TmsTypeSubjectCourseShip> {

}