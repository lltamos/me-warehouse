package com.me.mesite.infrastructure.gatawayimpl.database.mapper;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTestPackage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TmsTestPackageMapper {

    List<TmsTestPackage> selectTmsTestPackage(@Param("tmsKindTypeId") Integer tmsKindTypeId,
                                              @Param("tmsCourseTypeId") Integer tmsCourseTypeId,
                                              @Param("title") String title,
                                              @Param("from") Integer from,
                                              @Param("limit") Integer limit);

    Integer countTmsTestPackage(@Param("tmsKindTypeId") Integer tmsKindTypeId,
                                @Param("tmsCourseTypeId") Integer tmsCourseTypeId,
                                @Param("title") String title);
}
