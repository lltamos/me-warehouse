package com.me.mesite.module.Idds.service;

import com.me.mesite.common.exception.RRException;
import com.me.mesite.common.validator.Assert;
import com.me.mesite.database.entity.MeUser;
import com.me.mesite.database.repository.MeUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class MeUserService {
    @Resource
    private MeUserRepository meUserRepository;

    public Page<MeUser> findAll(Integer from, Integer limit) {
        Assert.isNull(from, "from is empty");
        Assert.isNull(limit, "limit is empty");
        Pageable pageable = PageRequest.of(from, limit);
        return meUserRepository.findAll(pageable);
    }

    public MeUser findById(Long id) {
        Optional<MeUser> optional = meUserRepository.findById(id);
        if (optional.isPresent()) {
            throw new RRException(id + " is no such element");
        }
        return optional.get();
    }

    public MeUser save(Long id, MeUser meUser) {
        Assert.isNull(id, "id is empty");
        MeUser meUserDetail = meUserRepository.getOne(id);
        Assert.isNull(meUserDetail, "can't find belong id of element");
        meUser.setId(meUserDetail.getId());
        meUserRepository.save(meUser);
        return meUser;

    }
}
