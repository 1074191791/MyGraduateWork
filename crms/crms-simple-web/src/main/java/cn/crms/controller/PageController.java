package cn.crms.controller;

import cn.crms.Intercepter.NoAuthAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 页面跳转Controller
 * @author zhous
 * @create 2019-03-15 9:32
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public String showIndex() {
        return "login";
    }

    @NoAuthAnnotation
    @RequestMapping("supermanager")
    public String showSuperManager() {
        return "supermanager";
    }

    @RequestMapping("error")
    public String showError() {
        return "error";
    }

    @RequestMapping("sys/role")
    public String showRole() {
        return "sys/role";
    }

    @RequestMapping("sys/privilege")
    public String showPrivilege() {
        return "sys/privilege";
    }

    @RequestMapping("sys/privilege_edit")
    public String showPrivilegeEdit() {
        return "sys/privilege_edit";
    }

    @RequestMapping("sys/role_edit")
    public String showRoleEdit() {
        return "sys/role_edit";
    }

    @RequestMapping("sys/role_add")
    public String showRoleAdd() {
        return "sys/role_add";
    }

    @RequestMapping("sys/role_message")
    public String showRoleMessage() {
        return "sys/role_message";
    }

    @RequestMapping("logOut")
    public String logOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("login",null);
        return "login";
    }

    @RequestMapping("sys/self_message")
    public String showSelfMessage() {
        return "sys/self_message";
    }

    @RequestMapping("class/lesson_add")
    public String addLesson() {
        return "class/lesson_add";
    }

    @RequestMapping("class/lesson_sel")
    public String selLesson() {
        return "class/lesson_sel";
    }


    @RequestMapping("class/timetable_show")
    public String showTimeTable() {
        return "class/timetable_show";
    }

    @RequestMapping("class/timetable_choice")
    public String showTimeTableChoice() {
        return "class/timetable_choice";
    }

    @RequestMapping("equipment/equipment_add")
    public String showEquipmentAdd() {
        return "equipment/equipment_add";
    }

    @RequestMapping("equipment/equipment_sel")
    public String showEquipmentSel() {
        return "equipment/equipment_sel";
    }

    @RequestMapping("equipment/equipment_update")
    public String showEquipmentUpdate() {
        return "equipment/equipment_update";
    }


    @RequestMapping("class/lesson_sel_remark")
    public String showLessonSelRemark() {
        return "class/lesson_sel_remark";
    }

    @RequestMapping("orders/orders_add")
    public String showordersAdd() {
        return "orders/orders_add";
    }

    @RequestMapping("orders/orders_sel")
    public String showOrdersSel() {
        return "orders/orders_sel";
    }

    @RequestMapping("orders/orders_mine")
    public String orders_mine() {
        return "orders/orders_mine";
    }

}
