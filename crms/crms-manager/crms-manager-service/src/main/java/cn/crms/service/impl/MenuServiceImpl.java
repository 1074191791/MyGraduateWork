package cn.crms.service.impl;

import cn.crms.mapper.MenuMapper;
import cn.crms.pojo.Menu;
import cn.crms.pojo.MenuAttributes;
import cn.crms.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhous
 * @create 2019-03-12 20:19
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    MenuMapper menuMapper;

    @Override
    public List<Menu> selectAll() {
        List<Menu> list = menuMapper.selectAll();
        for (Menu menu : list) {
            List<Menu> childrenMenus = menuMapper.selectByPid(menu.getId(),menu.getStatus());
            for (Menu children : childrenMenus) {
                MenuAttributes attribute = new MenuAttributes();
                attribute.setFilename(children.getFilename());
                children.setAttributes(attribute);
            }
            menu.setChildren(childrenMenus);
        }
        return list;
    }

    @Override
    public List<Menu> selectByStatus(int status) {
        //List<Menu> list = menuMapper.selectAll();
        List<Menu> list = menuMapper.slectByStatus(status);
        for (Menu menu : list) {
            List<Menu> childrenMenus = menuMapper.selectByPid(menu.getId(), status);
            for (Menu children : childrenMenus) {
                MenuAttributes attribute = new MenuAttributes();
                attribute.setFilename(children.getFilename());
                children.setAttributes(attribute);
            }
            menu.setChildren(childrenMenus);
        }
        return list;
    }
}
