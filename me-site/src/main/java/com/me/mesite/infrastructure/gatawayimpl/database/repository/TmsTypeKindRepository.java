package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTypeKind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TmsTypeKindRepository extends JpaRepository<TmsTypeKind, Integer>, JpaSpecificationExecutor<TmsTypeKind> {

}