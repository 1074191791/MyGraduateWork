package cn.crms.controller;

import cn.crms.pojo.EasyUIDatagrid;
import cn.crms.pojo.Student;
import cn.crms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhous
 * @create 2019-03-21 7:52
 */
@Controller
public class PrivilegeController {

    @Resource
    private StudentService studentService;

    @ResponseBody
    @RequestMapping("showPrivilege")
    public EasyUIDatagrid getAllStudent(@RequestParam(defaultValue = "4")int rows, @RequestParam(defaultValue = "1") int page) {
        EasyUIDatagrid datagrid = studentService.showStudent(rows, page);
        return datagrid;
    }


    @ResponseBody
    @RequestMapping("updatePrivilege")
    public int updatePrivilege(Student student) {
        int i = studentService.updatePrivilege(student);
        return i;
    }


}
