package cn.crms.controller;

import cn.crms.service.SeasonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author zhous
 * @create 2019-03-22 21:28
 */
@Controller
@RequestMapping("season")
public class SeasonController {

    @Resource
    SeasonService seasonService;

    @ResponseBody
    @RequestMapping("seasonUpdate")
    public int sessonUpdate(String options) {
        //System.out.println("options = " + options);
        return seasonService.seasonUpdate(options);
    }

    @ResponseBody
    @RequestMapping("selectSeason")
    public String selectSeason() {
        //System.out.println("options = " + options);
        return seasonService.selectSeason();
    }

}
