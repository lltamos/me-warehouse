package com.mesite.infrastructure.gatewayimpl.database.repository.impl;

import com.mesite.infrastructure.gatewayimpl.database.dataobject.CurCourseDocs;
import com.mesite.infrastructure.gatewayimpl.database.mapper.ICurCourseDocsMapper;
import com.mesite.infrastructure.gatewayimpl.database.repository.CurCourseDocsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 随堂资料，随堂讲义 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-16
 */
@Service
public class CurCourseDocsServiceImpl extends ServiceImpl<ICurCourseDocsMapper, CurCourseDocs> implements CurCourseDocsService {

}
