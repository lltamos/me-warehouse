package com.me.mesite.module.Idds.service;

import com.me.mesite.common.exception.RRException;
import com.me.mesite.common.utils.SortUtils;
import com.me.mesite.common.utils.UUIDS;
import com.me.mesite.common.validator.Assert;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.MeUser;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.MeUserRepository;
import com.me.mesite.module.Idds.config.Constant;
import org.apache.commons.lang.StringUtils;
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

    public Page<MeUser> findMeLists(Integer page, Integer limit, String key) {
        Assert.isNull(page, "page is empty");
        Assert.isNull(limit, "limit is empty");
        Pageable pageable = PageRequest.of(page - 1, limit, SortUtils.buildDESC(Constant.UTIME));
        return StringUtils.isEmpty(key) ? meUserRepository.findAll(pageable) : meUserRepository.findMeUserByPhoneStartingWith(key, pageable);
    }

    public MeUser findById(Long id) {
        Assert.isNull(id, "id is empty");

        Optional<MeUser> optional = meUserRepository.findById(id);

        if (!optional.isPresent()) {
            throw new RRException(id + " is no such element");
        }
        return optional.get();
    }

    public MeUser save(MeUser meUser) {

        Assert.isNull(meUser, " User can't find belong id of element");


        Long currentTimeMillis = System.currentTimeMillis();
        if (Objects.nonNull(meUser) && meUser.getId() == null) {
            meUser.setCtime(currentTimeMillis);
            meUser.setUtime(currentTimeMillis);
            meUser.setApprovalStatus(0);
            meUser.setApprovalTime(0L);
            meUser.setSetup(0);
            meUser.setUuid(UUIDS.getDateUUID());
            return meUserRepository.save(meUser);
        }

        MeUser meUserPre = meUserRepository.getOne(meUser.getId());
        Assert.isNull(meUserPre, "user is not exist");
        meUserPre.setAvatar(meUser.getAvatar());
        meUserPre.setPhone(meUser.getPhone());
        meUserPre.setEmail(meUser.getEmail());
        meUserPre.setNickname(meUser.getNickname());
        meUserPre.setRealname(meUser.getRealname());
        meUserPre.setLocale(meUser.getLocale());
        meUserPre.setUtime(currentTimeMillis);
        meUserRepository.save(meUserPre);
        return meUser;
    }

    public void delete(Long id) {
        Assert.isNull(id, "id is not null");
        meUserRepository.deleteById(id);
    }
}
