package com.me.mesite.infrastructure.gatawayimpl.database.mapper;


import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsQuestion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TmsQuestionMapper {

    List<TmsQuestion> selectByTmsQuestionIdAndTxIdTiganLike(@Param("tmsQuestionId") Integer tmsQuestionId,
                                                            @Param("txId") Integer txId,
                                                            @Param("tiGan") String tiGan,
                                                            @Param("from") Integer from,
                                                            @Param("limit") Integer limit);

}