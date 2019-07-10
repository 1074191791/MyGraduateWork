package cn.crms.service;

import cn.crms.pojo.EasyUIDatagrid;
import cn.crms.pojo.Student;

/**
 * @author zhous
 * @create 2019-03-12 15:18
 */
public interface StudentService {

    /**
     * 学生登录功能
     * @param student
     * @return
     */
    Student studentLogin(Student student);

    /**
     * 显示所有学生信息，并做分页
     * @param pageSize
     * @param pageNumber
     * @return
     */
    EasyUIDatagrid showStudent(int pageSize,int pageNumber);

    /**
     * 修改学生信息
     */
    int updateStudent(Student record);

    Student selectStudentById(Long id);

    /**
     * 修改权限
     * @param record
     * @return
     */
    int updatePrivilege(Student record);

    /**
     * 增加用户
     * @param student
     * @return
     */
    int addStudent(Student student);

    /**
     * 删除用户
     * @param student
     * @return
     */
    int delStudent(Student student);

    /**
     * 跟新用户密码及其他信息
     * @param record
     * @return
     */
    int updateStudentPass(Student record);

    /**
     * 通过uid获取用户
     * @param uid
     * @return
     */
    Student selectStudentByUId(String uid);
}
