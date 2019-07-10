package cn.crms.service;

import cn.crms.pojo.EasyUIDatagrid;
import cn.crms.pojo.Mechine;

import java.util.List;

/**
 * @author zhous
 * @create 2019-03-23 18:04
 */
public interface EquipmentService {

    /**
     * 增加新的维修申请
     * @param mechine
     * @return
     */
    int equipmentAdd(Mechine mechine);

    /**
     * 分页查显示数据
     * @param rows
     * @param page
     * @param mechine
     * @return
     */
    EasyUIDatagrid showEquipments(int rows, int page, Mechine mechine);


    /**
     * 通过id删除
     * @param id
     * @return
     */
    int delEquipment(int id);

    /**
     * 通过id修改状态
     * @param mechine
     * @return
     */
    int UpdateIsNormal(Mechine mechine);
}
