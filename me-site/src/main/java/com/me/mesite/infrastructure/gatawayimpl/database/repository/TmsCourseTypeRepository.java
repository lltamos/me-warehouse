package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsCourseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TmsCourseTypeRepository extends JpaRepository<TmsCourseType, Integer> {

}