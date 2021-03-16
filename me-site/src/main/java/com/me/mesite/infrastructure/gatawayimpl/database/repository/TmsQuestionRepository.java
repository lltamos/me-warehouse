package com.me.mesite.infrastructure.gatawayimpl.database.repository;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TmsQuestionRepository extends JpaRepository<TmsQuestion, Integer> {
    int countByTmsQuestionRepsId(Integer qRepsId);

    int countByTmsQuestionRepsIdAndTxId(Integer qRepsId, Integer txId);

    List<TmsQuestion> findByTimao(Integer tiMao);
}