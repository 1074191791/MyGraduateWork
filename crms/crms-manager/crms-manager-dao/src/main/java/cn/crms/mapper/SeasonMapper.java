package cn.crms.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author zhous
 * @create 2019-03-22 21:36
 */
public interface SeasonMapper {

    @Update("update season set options = #{0} ")
    int updateSeason(String options);

    @Select("select options from season where id = 1")
    String selectSeason();
}
