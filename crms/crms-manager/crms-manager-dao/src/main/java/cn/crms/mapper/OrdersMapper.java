package cn.crms.mapper;

import cn.crms.pojo.Orders;
import cn.crms.pojo.OrdersExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OrdersMapper {
    int countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample(OrdersExample example);

    Orders selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    int selectCount(Orders orders);

    List<Orders> selectByPage(@Param("start")int i, @Param("rows")int rows, @Param("pid")String pid, @Param("status")Boolean status);

    //通过money区间查询
    @Select("select count(1) from orders where payment between #{0} and #{1}")
    int selectCountByMoneyBetween(float moneyBegin, float moneyEnd);

    List<Orders> selectByPageAndMoneyBetween(int i, int rows, float moneyBegin, float moneyEnd);

    @Update("update orders set status=true , pid=#{1} where oid=#{0}")
    int updateStatusByOid(String oid, String pid);

    //通过cid分页查数据
    List<Orders> selectByPageAndCid(int rows, int page, String cid);

    //通过cid查总数
    @Select("select count(1) from orders where cid = #{0}")
    int selectCountByPageAndCid(String cid);
}