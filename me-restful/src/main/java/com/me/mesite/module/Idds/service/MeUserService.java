package com.me.mesite.module.Idds.service;

import cn.hutool.core.bean.BeanUtil;
import com.me.mesite.common.exception.RRException;
import com.me.mesite.common.validator.Assert;
import com.me.mesite.database.entity.MeUser;
import com.me.mesite.database.repository.MeUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;

@Service
public class MeUserService {
    @Resource
    private MeUserRepository meUserRepository;

    public Page<MeUser> findAll(Integer page, Integer limit) {
        Assert.isNull(page, "page is empty");
        Assert.isNull(limit, "limit is empty");
        Pageable pageable = PageRequest.of(page, limit);
        return meUserRepository.findAll(pageable);
    }

    public MeUser findById(Long id) {
        Assert.isNull(id, "id is empty");

        Optional<MeUser> optional = meUserRepository.findById(id);
        if (optional.isPresent()) {
            throw new RRException(id + " is no such element");
        }
        return optional.get();
    }

    public MeUser save(Long id, MeUser meUser) {
        if (id == null || Objects.isNull(meUser) || meUser.getId() == null) {
            return meUserRepository.save(meUser);
        }
        Assert.isNull(id, "id is empty");
        MeUser meUserDetail = meUserRepository.getOne(id);
        Assert.isNull(meUserDetail, "can't find belong id of element");
        meUser.setId(meUserDetail.getId());
        meUserRepository.save(meUser);
        return meUser;
    }
}
