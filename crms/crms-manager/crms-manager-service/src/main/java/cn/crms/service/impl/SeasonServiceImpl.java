package cn.crms.service.impl;

import cn.crms.mapper.SeasonMapper;
import cn.crms.service.SeasonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhous
 * @create 2019-03-22 21:33
 */
@Service
public class SeasonServiceImpl implements SeasonService {

    @Resource
    SeasonMapper seasonMapper;

    @Override
    public int seasonUpdate(String options) {
        return seasonMapper.updateSeason(options);
    }

    @Override
    public String selectSeason() {
        return seasonMapper.selectSeason();
    }
}
