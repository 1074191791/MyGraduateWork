package cn.crms.service;

import cn.crms.pojo.EasyUIDatagrid;
import cn.crms.pojo.Lesson;

/**
 * @author zhous
 * @create 2019-03-21 19:20
 */
public interface LessonService {

    /**
     * 插入新的课程
     * @param record
     * @return
     */
    int insert(Lesson record);

    /**
     * 分页显示课程信息
     * @param rows
     * @param page
     * @return
     */
    EasyUIDatagrid showLessons(int rows, int page, Lesson lesson);

    /**
     * 删除通过Id
     * @param id
     * @return
     */
    int delLesson(int id);
}
