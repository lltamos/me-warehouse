package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTestPaperShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TmsTestPaperShipRepository extends JpaRepository<TmsTestPaperShip, Integer>, JpaSpecificationExecutor<TmsTestPaperShip> {

    List<TmsTestPaperShip> findByTmsTestPaperIdOrderByRank(Integer tmsTestPaperId);
}