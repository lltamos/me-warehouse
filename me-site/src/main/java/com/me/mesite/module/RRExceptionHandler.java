package com.me.mesite.module;

import com.me.mesite.common.exception.RRException;
import com.me.mesite.common.utils.AppBaseResult;
import com.me.mesite.common.utils.HttpStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

/**
 * 异常处理器
 */
@Slf4j
@RestControllerAdvice
public class RRExceptionHandler {


    /**
     * 自定义异常
     */
    @ExceptionHandler(RRException.class)
    public AppBaseResult handleRRException(RRException e) {
        AppBaseResult appBaseResult = new AppBaseResult();
        appBaseResult.setCode(e.getCode());
        appBaseResult.setMessage(e.getMessage());
        return appBaseResult;
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public AppBaseResult handleDuplicateKeyException(DuplicateKeyException e) {
        log.error(e.getMessage(), e);
        return AppBaseResult.error(HttpStatus.SC_FORBIDDEN, "数据库中已存在该记录");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public AppBaseResult handleIllegalArgumentException(IllegalArgumentException e) {
        log.error(e.getMessage(), e);
        return AppBaseResult.error(HttpStatus.SC_CONFLICT, "参数非法");
    }


    @ExceptionHandler(NoSuchElementException.class)
    public AppBaseResult handleAuthorizationException(NoSuchElementException e) {
        log.error(e.getMessage(), e);
        return AppBaseResult.error(HttpStatus.SC_CONFLICT, "No value present");
    }

//	@ExceptionHandler(AuthorizationException.class)
//	public AppBaseResult handleAuthorizationException(AuthorizationException e){
//		logger.error(e.getMessage(), e);
//		return AppBaseResult.error(HttpStatus.SC_UNAUTHORIZED,"没有权限，请联系管理员授权");
//	}

    @ExceptionHandler(Exception.class)
    public AppBaseResult handleException(Exception e) {
        log.error(e.getMessage(), e);
        return AppBaseResult.error();
    }
}
