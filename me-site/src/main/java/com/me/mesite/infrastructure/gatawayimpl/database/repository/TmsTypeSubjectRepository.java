package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTypeSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TmsTypeSubjectRepository extends JpaRepository<TmsTypeSubject, Integer>, JpaSpecificationExecutor<TmsTypeSubject> {

}