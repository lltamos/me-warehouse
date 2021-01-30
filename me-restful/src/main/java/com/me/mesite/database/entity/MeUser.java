package com.me.mesite.database.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="me_user")
@Data
public class MeUser {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String phone;

    private String email;

    private String realName;

    private String nickName;

    private int sex;

    private String idCard;

    private String highestEducation;

    private String password;

    private int status;

    private String avatar;

    private String remark;

    private Long ctime;

    private Long gtime;



}
