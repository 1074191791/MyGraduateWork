package cn.crms.service;

/**
 * @author zhous
 * @create 2019-03-22 21:32
 */
public interface SeasonService {

    /**
     * 修改选择的课表
     * @param options
     * @return
     */
    int seasonUpdate(String options);

    String selectSeason();
}
