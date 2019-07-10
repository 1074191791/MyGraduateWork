package cn.crms.controller;

import cn.crms.pojo.EasyUIDatagrid;
import cn.crms.pojo.Orders;
import cn.crms.service.OrdersService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author zhous
 * @create 2019-03-25 11:24
 */
@Controller
@RequestMapping("orders")
public class OrdersController {

    @Resource
    private OrdersService ordersService;

    @ResponseBody
    @RequestMapping("ordersAdd")
    public int ordersAdd(Orders orders) {
        return ordersService.ordersAdd(orders);
    }


    @ResponseBody
    @RequestMapping("ordersSel")
    public EasyUIDatagrid ordersSel(@RequestParam(defaultValue = "4") int rows, @RequestParam(defaultValue = "1") int page, Orders orders,@RequestParam(defaultValue = "0")float moneyBegin,@RequestParam(defaultValue = "0")float moneyEnd) {
        return ordersService.ordersSel(rows,page,orders,moneyBegin,moneyEnd);
    }

    @ResponseBody
    @RequestMapping("updateStatusByOid")
    public int updateStatusByOid(String oid, String pid) {
        return ordersService.updateStatusByOid(oid, pid);
    }


    @ResponseBody
    @RequestMapping("ordersSelMine")
    public EasyUIDatagrid ordersSelMine(@RequestParam(defaultValue = "4") int rows, @RequestParam(defaultValue = "1") int page,String cid) {
        //System.out.println("cid = " + cid);
        return ordersService.ordersSelMine(rows, page, cid);
    }


    @ResponseBody
    @RequestMapping("delOrders")
    public int delOrdersByOid(String oid) {
        return ordersService.delOrdersByOid(oid);
    }

}
