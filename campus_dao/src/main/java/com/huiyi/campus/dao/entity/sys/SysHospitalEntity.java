package com.huiyi.campus.dao.entity.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel("医院管理")
public class SysHospitalEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("医院名称")
    private String hospitalName;

    @ApiModelProperty("医院代码")
    private String hospitalCode;

    @ApiModelProperty("医院地址")
    private String hospitalAddress;

    @ApiModelProperty("医院电话")
    private String hospitalPhone;

    @ApiModelProperty("医院负责人")
    private String hospitalLeader;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName == null ? null : hospitalName.trim();
    }

    public String getHospitalCode() {
        return hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode == null ? null : hospitalCode.trim();
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress == null ? null : hospitalAddress.trim();
    }

    public String getHospitalPhone() {
        return hospitalPhone;
    }

    public void setHospitalPhone(String hospitalPhone) {
        this.hospitalPhone = hospitalPhone == null ? null : hospitalPhone.trim();
    }

    public String getHospitalLeader() {
        return hospitalLeader;
    }

    public void setHospitalLeader(String hospitalLeader) {
        this.hospitalLeader = hospitalLeader == null ? null : hospitalLeader.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysHospitalEntity other = (SysHospitalEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHospitalName() == null ? other.getHospitalName() == null : this.getHospitalName().equals(other.getHospitalName()))
            && (this.getHospitalCode() == null ? other.getHospitalCode() == null : this.getHospitalCode().equals(other.getHospitalCode()))
            && (this.getHospitalAddress() == null ? other.getHospitalAddress() == null : this.getHospitalAddress().equals(other.getHospitalAddress()))
            && (this.getHospitalPhone() == null ? other.getHospitalPhone() == null : this.getHospitalPhone().equals(other.getHospitalPhone()))
            && (this.getHospitalLeader() == null ? other.getHospitalLeader() == null : this.getHospitalLeader().equals(other.getHospitalLeader()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHospitalName() == null) ? 0 : getHospitalName().hashCode());
        result = prime * result + ((getHospitalCode() == null) ? 0 : getHospitalCode().hashCode());
        result = prime * result + ((getHospitalAddress() == null) ? 0 : getHospitalAddress().hashCode());
        result = prime * result + ((getHospitalPhone() == null) ? 0 : getHospitalPhone().hashCode());
        result = prime * result + ((getHospitalLeader() == null) ? 0 : getHospitalLeader().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", hospitalName=").append(hospitalName);
        sb.append(", hospitalCode=").append(hospitalCode);
        sb.append(", hospitalAddress=").append(hospitalAddress);
        sb.append(", hospitalPhone=").append(hospitalPhone);
        sb.append(", hospitalLeader=").append(hospitalLeader);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}