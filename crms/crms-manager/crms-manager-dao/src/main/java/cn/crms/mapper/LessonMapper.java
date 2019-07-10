package cn.crms.mapper;

import cn.crms.pojo.Lesson;
import cn.crms.pojo.LessonExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhous
 * @create 2019-03-21 19:15
 */
public interface LessonMapper {
    int countByExample(LessonExample example);

    int deleteByExample(LessonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Lesson record);

    int insertSelective(Lesson record);

    List<Lesson> selectByExample(LessonExample example);

    Lesson selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Lesson record, @Param("example") LessonExample example);

    int updateByExample(@Param("record") Lesson record, @Param("example") LessonExample example);

    int updateByPrimaryKeySelective(Lesson record);

    int updateByPrimaryKey(Lesson record);

    //@Select("select * from lesson limit #{0},#{1}")
    List<Lesson> selectByPage(@Param("start")int start, @Param("rows") int rows);

    @Select("select count(*) from lesson")
    int selectCount();

    /**
     * 通过Lesson模糊查询分页数据
     * @param lesson
     * @return
     */
    int selectCountByLesson(Lesson lesson);

    /**
     * 通过条件进行模糊查询并做数据封装
     * @param
     * @return
     */
    List<?> selectByPageAndLesson(@Param("start1")int i,@Param("rows1") int rows, @Param("lessonName1")String lessonName, @Param("lessonTime1")Double lessonTime, @Param("lessonRemark1")String lessonRemark);

}
