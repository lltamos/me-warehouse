package com.me.mesite.module.Idds.service;

import com.me.mesite.database.entity.UpmsSysUser;
import com.me.mesite.database.repository.UpmsSysUserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UpmsSysUserService {
    @Resource
    private UpmsSysUserRepository upmsSysUserRepository;

    public List<UpmsSysUser> findAll() {
        return upmsSysUserRepository.findAll();
    }
}
