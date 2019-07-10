package cn.crms.mapper;

import cn.crms.pojo.Student;
import cn.crms.pojo.StudentExample;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {
    int countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Student selectByStudent(Student record);

    @Select("select * from student limit #{0},#{1}")
    List<Student> selectByPage(int pageStart,int pageSize);

    @Select("select count(*) from student")
    int selectCount();

    @Update("update student set username=#{username}, email=#{email}, phone=#{phone} where id = #{id}")
    int updateStudent(Student record);

    @Update("update student set status=#{status} where id = #{id}")
    int updatePrivilege(Student record);

    @Insert("insert into student values(null, #{uid}, #{username}, #{password}," +
            " #{status}, #{phone}, #{email})")
    int addStudent(Student student);

    @Update("update student set email=#{email}, phone=#{phone}, password=#{password} where id = #{id}")
    int updateStudentPass(Student student);
}