package cn.crms.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Mechine implements Serializable {
    private Integer id;

    private String equipmentName;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date logdate;

    private String computerRoom;

    private Boolean isNormal;

    private String repairMan;

    private String phone;

    private String remark;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName == null ? null : equipmentName.trim();
    }

    public Date getLogdate() {
        return logdate;
    }

    public void setLogdate(Date logdate) {
        this.logdate = logdate;
    }

    public String getComputerRoom() {
        return computerRoom;
    }

    public void setComputerRoom(String computerRoom) {
        this.computerRoom = computerRoom == null ? null : computerRoom.trim();
    }

    public Boolean getIsNormal() {
        return isNormal;
    }

    public void setIsNormal(Boolean isNormal) {
        this.isNormal = isNormal;
    }

    public String getRepairMan() {
        return repairMan;
    }

    public void setRepairMan(String repairMan) {
        this.repairMan = repairMan == null ? null : repairMan.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Mechine{" +
                "id=" + id +
                ", equipmentName='" + equipmentName + '\'' +
                ", logdate=" + logdate +
                ", computerRoom='" + computerRoom + '\'' +
                ", isNormal=" + isNormal +
                ", repairMan='" + repairMan + '\'' +
                ", phone='" + phone + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                '}';
    }
}