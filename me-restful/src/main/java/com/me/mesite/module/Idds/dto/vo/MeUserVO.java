package com.me.mesite.module.Idds.dto.vo;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.MeUser;
import lombok.Data;

@Data
public class MeUserVO extends MeUser {
    public String Key;
}
