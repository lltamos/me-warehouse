package com.mesite.module.tms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTypeChapter;
import com.mesite.infrastructure.gatewayimpl.database.mapper.ITmsTypeChapterMapper;
import com.mesite.module.tms.service.TmsTypeChapterService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程下的章 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class TmsTypeChapterServiceImpl extends ServiceImpl<ITmsTypeChapterMapper, TmsTypeChapter> implements TmsTypeChapterService {

}
