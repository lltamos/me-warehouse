package com.me.mesite.domain.vo;

import com.me.mesite.infrastructure.gatawayimpl.database.dataobject.TmsTestPaperShip;
import lombok.Data;

import java.util.List;

@Data
public class TmsTestPaperShipVo {
    Integer testPaperId;
    List<TmsTestPaperShip> paperShipList;
}
