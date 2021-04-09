package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTestPaperPackgeShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TmsTestPaperPackgeShipRepository extends JpaRepository<TmsTestPaperPackgeShip, Integer>, JpaSpecificationExecutor<TmsTestPaperPackgeShip> {

}