package cn.crms.controller;

import cn.crms.pojo.Menu;
import cn.crms.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhous
 * @create 2019-03-12 20:00
 */
@Controller
public class MenuController {

    @Resource
    private MenuService menuService;

    @RequestMapping("showMenu")
    @ResponseBody
    public List<Menu> showMenu(int status){
        List<Menu> list = menuService.selectByStatus(status);
        return list;
    }
}
