package com.mesite.module.tms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTypeSubjectCourseShip;
import com.mesite.infrastructure.gatewayimpl.database.mapper.ITmsTypeSubjectCourseShipMapper;
import com.mesite.module.tms.service.TmsTypeSubjectCourseShipService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 专业和课程关联表 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class TmsTypeSubjectCourseShipServiceImpl extends ServiceImpl<ITmsTypeSubjectCourseShipMapper, TmsTypeSubjectCourseShip> implements TmsTypeSubjectCourseShipService {

}
