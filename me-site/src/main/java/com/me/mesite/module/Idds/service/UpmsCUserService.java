package com.me.mesite.module.Idds.service;

import com.me.mesite.common.exception.RRException;
import com.me.mesite.common.utils.SortUtils;
import com.me.mesite.common.utils.UUIDS;
import com.me.mesite.common.validator.Assert;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.UpmsCUser;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.UpmsCUserRepository;
import com.me.mesite.module.Idds.config.Constant;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class UpmsCUserService {
    @Resource
    private UpmsCUserRepository upmsCUserRepository;

    public Page<UpmsCUser> findMeLists(Integer page, Integer limit, String key) {
        Assert.isNull(page, "page is empty");
        Assert.isNull(limit, "limit is empty");
        Pageable pageable = PageRequest.of(page - 1, limit, SortUtils.buildDESC(Constant.UTIME));
        return StringUtils.isEmpty(key) ? upmsCUserRepository.findAll(pageable) : upmsCUserRepository.findUpmsCUserByPhoneStartingWith(key, pageable);
    }

    public UpmsCUser findById(Integer id) {
        Assert.isNull(id, "id is empty");

        Optional<UpmsCUser> optional = upmsCUserRepository.findById(id);

        if (!optional.isPresent()) {
            throw new RRException(id + " is no such element");
        }
        return optional.get();
    }

    public UpmsCUser save(UpmsCUser upmsUser) {

        Assert.isNull(upmsUser, " User can't find belong id of element");


        Date currentTimeMillis = new Date();
        if (upmsUser.getId() == null) {
            upmsUser.setCtime(currentTimeMillis);
            upmsUser.setUtime(currentTimeMillis);
            upmsUser.setApprovalStatus(0);
            upmsUser.setApprovalTime(0L);
            upmsUser.setSetup(0);
            upmsUser.setUuid(UUIDS.getDateUUID());
            return upmsCUserRepository.save(upmsUser);
        }

        UpmsCUser upmsUserPre = upmsCUserRepository.getOne(upmsUser.getId());
        Assert.isNull(upmsUserPre, "user is not exist");
        upmsUserPre.setAvatar(upmsUser.getAvatar());
        upmsUserPre.setPhone(upmsUser.getPhone());
        upmsUserPre.setEmail(upmsUser.getEmail());
        upmsUserPre.setNickname(upmsUser.getNickname());
        upmsUserPre.setRealname(upmsUser.getRealname());
        upmsUserPre.setLocale(upmsUser.getLocale());
        upmsUserPre.setUtime(currentTimeMillis);
        upmsCUserRepository.save(upmsUserPre);
        return upmsUser;
    }

    public void delete(Integer id) {
        Assert.isNull(id, "id is not null");
        upmsCUserRepository.deleteById(id);
    }
}
