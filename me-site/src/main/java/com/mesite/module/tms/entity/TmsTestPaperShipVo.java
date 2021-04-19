package com.mesite.module.tms.entity;

import com.mesite.infrastructure.gatewayimpl.database.dataobject.TmsTestPaperShip;
import lombok.Data;

import java.util.List;

@Data
public class TmsTestPaperShipVo {
    Integer testPaperId;
    List<TmsTestPaperShip> paperShipList;
}
