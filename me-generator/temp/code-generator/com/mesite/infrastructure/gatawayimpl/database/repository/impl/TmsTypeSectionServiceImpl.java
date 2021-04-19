package com.mesite.infrastructure.gatewayimpl.database.repository.impl;

import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTypeSection;
import com.mesite.infrastructure.gatewayimpl.database.mapper.ITmsTypeSectionMapper;
import com.mesite.infrastructure.gatewayimpl.database.repository.TmsTypeSectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程下的章下面的节 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class TmsTypeSectionServiceImpl extends ServiceImpl<ITmsTypeSectionMapper, TmsTypeSection> implements TmsTypeSectionService {

}
