package cn.crms.controller;

import cn.crms.pojo.EasyUIDatagrid;
import cn.crms.pojo.Lesson;
import cn.crms.service.LessonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author zhous
 * @create 2019-03-21 19:12
 */
@Controller
@RequestMapping("lesson")
public class LessonController {

    @Resource
    private LessonService lessonService;

    @ResponseBody
    @RequestMapping("addLesson")
    public int addLesson(Lesson lesson) {
        return lessonService.insert(lesson);
    }

    @ResponseBody
    @RequestMapping("showLessons")
    public EasyUIDatagrid showLessons(@RequestParam(defaultValue = "4") int rows, @RequestParam(defaultValue = "1") int page, Lesson lesson) {
        EasyUIDatagrid datagrid = lessonService.showLessons(rows, page, lesson);
        return datagrid;
    }

    @ResponseBody
    @RequestMapping("delLesson")
    public int delLesson(int id) {
        return lessonService.delLesson(id);
    }

}
