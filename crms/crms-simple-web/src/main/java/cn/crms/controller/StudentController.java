package cn.crms.controller;

import cn.crms.pojo.EasyUIDatagrid;
import cn.crms.pojo.Student;
import cn.crms.service.StudentService;
import org.apache.zookeeper.Login;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zhous
 * @create 2019-03-15 21:53
 */
@Controller
public class StudentController {

    @Resource
    private StudentService studentService;

    @ResponseBody
    @RequestMapping("showRole")
    public EasyUIDatagrid showStudents(@RequestParam(defaultValue = "4")int rows,@RequestParam(defaultValue = "1") int page) {
        EasyUIDatagrid datagrid = studentService.showStudent(rows, page);
        return datagrid;
    }

    @ResponseBody
    @RequestMapping("updateStudent")
    public int updateStudent(Student student) {
        int i = studentService.updateStudent(student);
        return i;
    }


    @RequestMapping("updateStudentForSelf")
    public String updateStudentForSelf(Student student,HttpServletRequest requset) {
        int i = studentService.updateStudentPass(student);
        if(i > 0 && student.getPassword()!= null && student.getPassword().length() != 0) {
            requset.getSession().setAttribute("login",null);
        } else{
            requset.getSession().setAttribute("login", student);
        }
        return "supermanager";
    }

    @RequestMapping("getStudentById")
    public String selectStudentById(Long id, HttpServletRequest request) {
        Student student = studentService.selectStudentById(id);
        request.setAttribute("selected",student);
        return "sys/role_message";
    }

    @ResponseBody
    @RequestMapping("addStudent")
    public int addStudent(Student student) {
        int i = studentService.addStudent(student);
        return i;
    }

    @ResponseBody
    @RequestMapping("delStudent")
    public int delStudent(Student student) {
        //System.out.println("student = " + student);
        int i = studentService.delStudent(student);
        return 1;
    }

    @RequestMapping("getStudentByUId")
    public String selectStudentById(String uid, HttpServletRequest request) {
        Student student = studentService.selectStudentByUId(uid);
        request.setAttribute("selected",student);
        return "sys/role_message";
    }


}
