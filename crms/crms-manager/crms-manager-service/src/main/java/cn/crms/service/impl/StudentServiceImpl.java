package cn.crms.service.impl;

import cn.crms.common.utils.MD5Utils;
import cn.crms.common.utils.SnowFlake;
import cn.crms.mapper.StudentMapper;
import cn.crms.pojo.EasyUIDatagrid;
import cn.crms.pojo.Student;
import cn.crms.pojo.StudentExample;
import cn.crms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhous
 * @create 2019-03-12 15:17
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student studentLogin(Student student) {
        student.setPassword(MD5Utils.toMD5(student.getPassword()+MD5Utils.SALT));
        return studentMapper.selectByStudent(student);
    }

    @Override
    public EasyUIDatagrid showStudent(int pageSize, int pageNumber) {
        EasyUIDatagrid datagrid = new EasyUIDatagrid();
        datagrid.setRows(studentMapper.selectByPage(pageSize*(pageNumber-1),pageSize));
        datagrid.setTotal(studentMapper.selectCount());
        return datagrid;
    }

    @Override
    public int updateStudent(Student record) {
        return studentMapper.updateStudent(record);
    }

    @Override
    public Student selectStudentById(Long id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updatePrivilege(Student record) {
        return studentMapper.updatePrivilege(record);
    }

    @Override
    public int addStudent(Student student) {
        SnowFlake worker = new SnowFlake(1,1,2);
        student.setUid(worker.nextId()+"");
        String password = student.getPassword()+MD5Utils.SALT;
        student.setPassword(MD5Utils.toMD5(password));
        return studentMapper.addStudent(student);
    }

    @Override
    public int delStudent(Student student) {
        int i = studentMapper.deleteByPrimaryKey(student.getId());
        return i;
    }

    @Override
    public int updateStudentPass(Student record) {
        if(record.getPassword().length() != 0 && record.getPassword() != null) {
            record.setPassword(MD5Utils.toMD5(record.getPassword()+MD5Utils.SALT));
            return studentMapper.updateStudentPass(record);
        } else {
            return studentMapper.updateStudent(record);
        }

    }

    @Override
    public Student selectStudentByUId(String uid) {
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        List<Student> students = studentMapper.selectByExample(example);
        return students.get(0);
    }
}
