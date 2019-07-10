package cn.crms.service.impl;

import cn.crms.mapper.LessonMapper;
import cn.crms.mapper.StudentMapper;
import cn.crms.pojo.EasyUIDatagrid;
import cn.crms.pojo.Lesson;
import cn.crms.pojo.Student;
import cn.crms.pojo.StudentExample;
import cn.crms.sendmail.SendMail;
import cn.crms.service.LessonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.InternetAddress;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhous
 * @create 2019-03-21 19:21
 */
@Service
public class LessonServiceImpl implements LessonService {

    @Resource
    private LessonMapper lessonMapper;

    @Resource
    private StudentMapper studentMapper;

    @Override
    public int insert(Lesson record) {
        int count = lessonMapper.insert(record);
        if(count > 0) {
            //发个邮件提醒一下，因为dubbo延迟处理的原因，很慢，会访问三次，后期考虑使用消息队列发送
            /*SendMail send = new SendMail();
            StudentExample example = new StudentExample();
            StudentExample.Criteria criteria = example.createCriteria();
            criteria.andStatusEqualTo(2);
            List<Student> students = studentMapper.selectByExample(example);
            InternetAddress[] list = new InternetAddress[students.size()];
            for (int i = 0; i <students.size() ; i++) {
                try {
                    list[i] = new InternetAddress(students.get(i).getEmail(),"机房二师兄");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            send.setAddr(list);
            send.setMess(record.toString());
            send.send();*/

        }
        return count;
    }

    @Override
    public EasyUIDatagrid showLessons(int rows, int page, Lesson lesson) {
        EasyUIDatagrid datagrid = new EasyUIDatagrid();
        if(lesson.getLessonName() == null && lesson.getLessonRemark() == null && lesson.getLessonTime() == null) {
            datagrid.setRows(lessonMapper.selectByPage(rows*(page-1), rows));
            datagrid.setTotal(lessonMapper.selectCount());
        } else {
            datagrid.setRows(lessonMapper.selectByPageAndLesson(rows*(page-1), rows, lesson.getLessonName(),lesson.getLessonTime(),lesson.getLessonRemark()));
            datagrid.setTotal(lessonMapper.selectCountByLesson(lesson));
        }
        return datagrid;
    }

    @Override
    public int delLesson(int id) {
        return lessonMapper.deleteByPrimaryKey(id);
    }
}
