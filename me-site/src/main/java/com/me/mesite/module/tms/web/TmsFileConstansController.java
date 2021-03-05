package com.me.mesite.module.tms.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tms/type")
@Slf4j
public class TmsFileConstansController {

    private static final Log log1 = LogFactory.getLog(TmsFileConstansController.class);


    @GetMapping("list")
    public void list(Integer page, Integer limit, String key) {
        System.out.println(1);
    }

}
