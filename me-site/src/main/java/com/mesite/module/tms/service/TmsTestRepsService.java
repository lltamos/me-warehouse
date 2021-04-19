package com.mesite.module.tms.service;

import com.mesite.domain.common.BasePage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTestReps;
import com.mesite.module.tms.entity.TmsTestRepsVo;

/**
 * <p>
 * 试题库 服务类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
public interface TmsTestRepsService extends IService<TmsTestReps> {

    BasePage<TmsTestRepsVo> findTestRepsLists(Integer page, Integer limit, String key);

    boolean createQuestionReps(TmsTestRepsVo tmsQuestionRepsVo);
}
