package com.mesite.infrastructure.gatewayimpl.database.repository.v1;//package com.mesite.infrastructure.gatawayimpl.database.repository;
//
//import com.mesite.module.tms.entity.TmsTestRepsVo;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface TmsTestRepository extends JpaRepository<TmsTest, Integer> {
//    @Query(value = "SELECT count(id) from tms_test  where tms_test_reps_id=?1", nativeQuery = true)
//    int countByTmsTestRepsId(Integer qRepsId);
//
//    @Query(value = "SELECT count(id) from tms_test  where tms_test_reps_id=?1 and tx_id=?2", nativeQuery = true)
//    int countByTmsTestRepsIdAndTxId(Integer qRepsId, Integer txId);
//
//    @Query(value = "SELECT singleChoice,multipleChoice,verdict,interpose,shortAnswer,groupQuestion ,totalQuestion FROM( SELECT count( id ) AS singleChoice FROM tms_test WHERE tms_test_reps_id = ?1 AND tx_id = 0 ) AS t0,( SELECT count( id ) AS multipleChoice FROM tms_test WHERE tms_test_reps_id = ?1 AND tx_id = 1 ) AS t1, ( SELECT count( id ) AS verdict FROM tms_test WHERE tms_test_reps_id = ?1 AND tx_id = 2 ) AS t2,( SELECT count( id ) AS interpose FROM tms_test WHERE tms_test_reps_id = ?1 AND tx_id = 3 ) AS t3,( SELECT count( id ) AS shortAnswer FROM tms_test WHERE tms_test_reps_id = ?1 AND tx_id = 4 ) AS t4,( SELECT count( id ) AS groupQuestion FROM tms_test WHERE tms_test_reps_id = ?1 AND tx_id = 5 ) AS t5,( SELECT count( id ) AS totalQuestion FROM tms_test WHERE tms_test_reps_id = 1  ) AS t6", nativeQuery = true)
//    List<TmsTestRepsVo> countByTmsTestRepsIdAndTxIdAll(Integer qRepsId);
//
//
//}