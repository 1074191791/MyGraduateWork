package cn.crms.mapper;

import cn.crms.pojo.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhous
 * @create 2019-03-12 20:13
 */
public interface MenuMapper {
    @Select("select * from menu where pid = 0")
    List<Menu> selectAll();

    @Select("select * from menu where pid = #{0} and status >= #{1}")
    List<Menu> selectByPid(int pid, int status);

    @Select("select * from menu where status >= #{0} and pid = 0")
    List<Menu> slectByStatus(int status);
}
