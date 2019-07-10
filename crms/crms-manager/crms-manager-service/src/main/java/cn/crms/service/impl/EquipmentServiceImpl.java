package cn.crms.service.impl;

import cn.crms.mapper.MechineMapper;
import cn.crms.pojo.EasyUIDatagrid;
import cn.crms.pojo.Mechine;
import cn.crms.pojo.MechineExample;
import cn.crms.service.EquipmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhous
 * @create 2019-03-23 18:06
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Resource
    MechineMapper mechineMapper;

    @Override
    public int equipmentAdd(Mechine mechine) {
        return mechineMapper.insert(mechine);
    }

    @Override
    public EasyUIDatagrid showEquipments(int rows, int page, Mechine mechine) {
        EasyUIDatagrid datagrid = new EasyUIDatagrid();
        if(mechine.getComputerRoom()==null) {
            //不用条件查询
            datagrid.setRows(mechineMapper.selectByPage(rows*(page-1), rows));
            datagrid.setTotal(mechineMapper.countByExample(new MechineExample()));
        } else {
            //用条件模糊查询
            datagrid.setRows(mechineMapper.selectByPageAndComputerRoom(rows*(page-1), rows, mechine.getComputerRoom()));
            datagrid.setTotal(mechineMapper.selectCountByMechine(mechine));
        }

        return datagrid;
    }

    @Override
    public int delEquipment(int id) {
        return mechineMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int UpdateIsNormal(Mechine mechine) {
        return mechineMapper.updateIsNormal(mechine);
    }
}
