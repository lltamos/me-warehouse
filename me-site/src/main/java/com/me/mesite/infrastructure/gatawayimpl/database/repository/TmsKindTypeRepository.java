package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsKindType;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsQuestionReps;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TmsKindTypeRepository extends JpaRepository<TmsKindType, Integer> {

}