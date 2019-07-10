package cn.crms.service.impl;

import cn.crms.mapper.OrdersMapper;
import cn.crms.pojo.EasyUIDatagrid;
import cn.crms.pojo.Orders;
import cn.crms.pojo.OrdersExample;
import cn.crms.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author zhous
 * @create 2019-03-25 11:22
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public int ordersAdd(Orders orders) {
        orders.setOid(UUID.randomUUID().toString().replace("-",""));
        //System.out.println("order = " + orders);
        return ordersMapper.insert(orders);
        //return 1;
    }

    @Override
    public EasyUIDatagrid ordersSel(int rows, int page, Orders orders, float moneyBegin, float moneyEnd) {
        EasyUIDatagrid datagrid = new EasyUIDatagrid();
        if(moneyBegin == 0 && moneyEnd == 0) {
            datagrid.setTotal(ordersMapper.selectCount(orders));
            datagrid.setRows(ordersMapper.selectByPage(rows*(page-1), rows, orders.getPid(), orders.getStatus()));
            System.out.println("datagrid = " + datagrid);
        } else {
            datagrid.setTotal(ordersMapper.selectCountByMoneyBetween(moneyBegin,moneyEnd));
            datagrid.setRows(ordersMapper.selectByPageAndMoneyBetween(rows*(page-1), rows,moneyBegin,moneyEnd));
        }

        return datagrid;
    }

    @Override
    public int updateStatusByOid(String oid, String pid) {
        return ordersMapper.updateStatusByOid(oid, pid);
    }

    @Override
    public EasyUIDatagrid ordersSelMine(int rows, int page, String cid) {
        EasyUIDatagrid datagrid = new EasyUIDatagrid();
        datagrid.setRows(ordersMapper.selectByPageAndCid(rows*(page-1), rows, cid));
        datagrid.setTotal(ordersMapper.selectCountByPageAndCid(cid));
        return datagrid;
    }

    @Override
    public int delOrdersByOid(String oid) {

        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        criteria.andOidEqualTo(oid);
        return ordersMapper.deleteByExample(example);

    }

}
