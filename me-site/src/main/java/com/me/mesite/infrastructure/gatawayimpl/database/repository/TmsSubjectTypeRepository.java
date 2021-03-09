package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsSubjectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TmsSubjectTypeRepository extends JpaRepository<TmsSubjectType, Integer>, JpaSpecificationExecutor<TmsSubjectType> {

}