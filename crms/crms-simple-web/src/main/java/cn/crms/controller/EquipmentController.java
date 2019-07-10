package cn.crms.controller;

import cn.crms.pojo.EasyUIDatagrid;
import cn.crms.pojo.Lesson;
import cn.crms.pojo.Mechine;
import cn.crms.service.EquipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhous
 * @create 2019-03-23 16:56
 */
@Controller
@RequestMapping("equipment")
public class EquipmentController {

    @Resource
    private EquipmentService equipmentService;

    @ResponseBody
    @RequestMapping("equipmentAddOne")
    public int equipmentAdd(Mechine mechine) {
        return equipmentService.equipmentAdd(mechine);
    }


    @ResponseBody
    @RequestMapping("showEquipments")
    public EasyUIDatagrid showEquipments(@RequestParam(defaultValue = "4") int rows, @RequestParam(defaultValue = "1") int page, Mechine mechine) {
        return equipmentService.showEquipments(rows,page,mechine);
    }

    @ResponseBody
    @RequestMapping("equipmentDel")
    public int delEquipment(int id) {
        return equipmentService.delEquipment(id);
    }


    @ResponseBody
    @RequestMapping(" equipmentUpdateIsNormal")
    public int equipmentUpdateIsNormal(Mechine mechine) {
        return equipmentService.UpdateIsNormal(mechine);
    }
}
