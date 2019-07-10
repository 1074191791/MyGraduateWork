package cn.crms.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable {
    private Integer id;

    private String oid;

    private String cid;

    private String cname;

    private String cphone;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date startTime;

    private String serviceType;

    private String serviceAddress;

    private Float payment;

    private String remark;

    private Boolean status;

    private String pid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid == null ? null : oid.trim();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone == null ? null : cphone.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress == null ? null : serviceAddress.trim();
    }

    public Float getPayment() {
        return payment;
    }

    public void setPayment(Float payment) {
        this.payment = payment;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", oid='" + oid + '\'' +
                ", cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", cphone='" + cphone + '\'' +
                ", startTime=" + startTime +
                ", serviceType='" + serviceType + '\'' +
                ", serviceAddress='" + serviceAddress + '\'' +
                ", payment=" + payment +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", pid='" + pid + '\'' +
                '}';
    }
}