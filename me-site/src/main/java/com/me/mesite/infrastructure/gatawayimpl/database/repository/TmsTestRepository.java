package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface TmsTestRepository extends JpaRepository<TmsTest, Integer> {
    @Query(value = "SELECT count(id) from tms_test  where tms_test_reps_id=?1", nativeQuery = true)
    int countByTmsTestRepsId(Integer qRepsId);

    @Query(value = "SELECT count(id) from tms_test  where tms_test_reps_id=?1 and tx_id=?2", nativeQuery = true)
    int countByTmsTestRepsIdAndTxId(Integer qRepsId, Integer txId);

    @Query(value = "SELECT tx_id as tx,count(id) as num FROM tms_test WHERE tms_test_reps_id= ?1 GROUP BY  tx_id ORDER BY tx_id", nativeQuery = true)
    List<Map<Integer, Object>> countByTmsTestRepsIdAndTxIdAll(Integer qRepsId);


}