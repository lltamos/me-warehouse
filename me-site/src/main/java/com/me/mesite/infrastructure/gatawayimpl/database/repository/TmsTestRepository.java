package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TmsTestRepository extends JpaRepository<TmsTest, Integer> {
    int countByTmsTestRepsId(Integer qRepsId);
    int countByTmsTestRepsIdAndTxId(Integer qRepsId, Integer txId);
}