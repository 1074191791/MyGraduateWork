package cn.crms.mapper;

import cn.crms.pojo.Mechine;
import cn.crms.pojo.MechineExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MechineMapper {
    int countByExample(MechineExample example);

    int deleteByExample(MechineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mechine record);

    int insertSelective(Mechine record);

    List<Mechine> selectByExample(MechineExample example);

    Mechine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mechine record, @Param("example") MechineExample example);

    int updateByExample(@Param("record") Mechine record, @Param("example") MechineExample example);

    int updateByPrimaryKeySelective(Mechine record);

    int updateByPrimaryKey(Mechine record);

    List<Mechine> selectByPage(@Param("start")int start, @Param("rows") int rows);

    int selectCountByMechine(Mechine mechine);

    List<Mechine> selectByPageAndComputerRoom(@Param("start2")int i,@Param("rows2") int rows, @Param("computerRoom1")String computerRoom);

    @Update("update mechine set is_normal = #{isNormal} where id = #{id}")
    int updateIsNormal(Mechine mechine);
}