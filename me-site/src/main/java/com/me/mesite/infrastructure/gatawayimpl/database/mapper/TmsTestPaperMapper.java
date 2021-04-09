package com.me.mesite.infrastructure.gatawayimpl.database.mapper;


import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTestPager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TmsTestPaperMapper {

    List<TmsTestPager> selectTmsTestPaper(@Param("tmsKindTypeId") Integer tmsKindTypeId,
                                          @Param("tmsCourseTypeId") Integer tmsCourseTypeId,
                                          @Param("title") String title,
                                          @Param("from") Integer from,
                                          @Param("limit") Integer limit);

    Integer countTmsTestPaper(@Param("tmsKindTypeId") Integer tmsKindTypeId,
                              @Param("tmsCourseTypeId") Integer tmsCourseTypeId,
                              @Param("title") String title);

}