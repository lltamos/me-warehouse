package com.mesite.infrastructure.gatewayimpl.database.repository.impl;

import com.mesite.infrastructure.gatewayimpl.database.dataobject.MeArea;
import com.mesite.infrastructure.gatewayimpl.database.mapper.IMeAreaMapper;
import com.mesite.infrastructure.gatewayimpl.database.repository.MeAreaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 地区表 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class MeAreaServiceImpl extends ServiceImpl<IMeAreaMapper, MeArea> implements MeAreaService {

}
