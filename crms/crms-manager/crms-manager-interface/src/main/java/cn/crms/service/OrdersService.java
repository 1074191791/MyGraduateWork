package cn.crms.service;

import cn.crms.pojo.EasyUIDatagrid;
import cn.crms.pojo.Orders;

/**
 * @author zhous
 * @create 2019-03-25 11:21
 */
public interface OrdersService {

    /**
     * 添加新的订单
     * @param orders
     * @return
     */
    int ordersAdd(Orders orders);

    /**
     * 分页显示数据
     * @param rows
     * @param page
     * @param orders
     * @param moneyBegin
     * @param moneyEnd
     * @return
     */
    EasyUIDatagrid ordersSel(int rows, int page, Orders orders, float moneyBegin, float moneyEnd);

    /**
     * 通过oid更新订单状态
     * @param oid
     * @param pid
     * @return
     */
    int updateStatusByOid(String oid, String pid);

    /**
     * 通过cid获取个人的订单
     * @param cid
     * @return
     */
    EasyUIDatagrid ordersSelMine(int rows, int page, String cid);

    /**
     * 通过oid删除订单
     * @param oid
     * @return
     */
    int delOrdersByOid(String oid);
}
