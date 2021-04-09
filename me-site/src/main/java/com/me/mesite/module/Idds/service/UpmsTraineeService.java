package com.me.mesite.module.Idds.service;

import com.me.mesite.common.exception.RRException;
import com.me.mesite.common.utils.SortUtils;
import com.me.mesite.common.utils.UUIDS;
import com.me.mesite.common.validator.Assert;
import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.UpmsTrainee;
import com.me.mesite.infrastructure.gatawayimpl.database.repository.UpmsTraineeRepository;
import com.me.mesite.module.Idds.config.Constant;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

@Service
public class UpmsTraineeService {
    @Resource
    private UpmsTraineeRepository upmsTraineeRepository;

    public Page<UpmsTrainee> findMeLists(Integer page, Integer limit, String key) {
        Assert.isNull(page, "page is empty");
        Assert.isNull(limit, "limit is empty");
        Pageable pageable = PageRequest.of(page - 1, limit, SortUtils.buildDESC(Constant.UTIME));
        return StringUtils.isEmpty(key) ? upmsTraineeRepository.findAll(pageable) : upmsTraineeRepository.findByPhoneStartingWith(key, pageable);
    }

    public UpmsTrainee findById(Integer id) {
        Assert.isNull(id, "id is empty");

        Optional<UpmsTrainee> optional = upmsTraineeRepository.findById(id);

        if (!optional.isPresent()) {
            throw new RRException(id + " is no such element");
        }
        return optional.get();
    }

    public UpmsTrainee save(UpmsTrainee upmsTrainee) {
        Assert.isNull(upmsTrainee, " User can't find belong id of element");
        Date currentTimeMillis = new Date();
        if (upmsTrainee.getId() == null) {
            upmsTrainee.setCtime(currentTimeMillis);
            upmsTrainee.setUtime(currentTimeMillis);
            upmsTrainee.setApprovalStatus(0);
            upmsTrainee.setApprovalTime(0L);
            upmsTrainee.setSetup(0);
            upmsTrainee.setUuid(UUIDS.getDateUUID());
            return upmsTraineeRepository.save(upmsTrainee);
        }
        UpmsTrainee upmsTraineePre = upmsTraineeRepository.getOne(upmsTrainee.getId());
        Assert.isNull(upmsTraineePre, "user is not exist");
        upmsTraineePre.setAvatar(upmsTrainee.getAvatar());
        upmsTraineePre.setPhone(upmsTrainee.getPhone());
        upmsTraineePre.setEmail(upmsTrainee.getEmail());
        upmsTraineePre.setNickName(upmsTrainee.getNickName());
        upmsTraineePre.setRealName(upmsTrainee.getRealName());
        upmsTraineePre.setLocale(upmsTrainee.getLocale());
        upmsTraineePre.setUtime(currentTimeMillis);
        upmsTraineeRepository.save(upmsTraineePre);
        return upmsTrainee;
    }

    public void delete(Integer id) {
        Assert.isNull(id, "id is not null");
        upmsTraineeRepository.deleteById(id);
    }
}
