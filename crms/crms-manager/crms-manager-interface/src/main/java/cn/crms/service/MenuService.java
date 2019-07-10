package cn.crms.service;

import cn.crms.pojo.Menu;

import java.util.List;

/**
 * @author zhous
 * @create 2019-03-12 20:19
 */
public interface MenuService {
    List<Menu> selectAll();
    List<Menu> selectByStatus(int status);


}
