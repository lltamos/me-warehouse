package com.me.mesite.infrastructure.gatawayimpl.database.mapper;


import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTest;
import org.apache.ibatis.annotations.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface TmsTestMapper {

    List<TmsTest> selectByTmsTestIdAndTxIdTiganLike(@Param("tmsTestId") Integer tmsTestId,
                                                        @Param("txId") Integer txId,
                                                        @Param("tiGan") String tiGan,
                                                        @Param("from") Integer from,
                                                        @Param("limit") Integer limit);

    Integer countByTmsTestIdAndTxIdTiganLike(@Param("tmsTestId") Integer tmsTestId,
                                                        @Param("txId") Integer txId,
                                                        @Param("tiGan") String tiGan);

}