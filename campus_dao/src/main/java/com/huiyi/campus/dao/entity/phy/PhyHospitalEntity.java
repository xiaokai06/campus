package com.huiyi.campus.dao.entity.phy;

import java.io.Serializable;
import java.util.Date;

public class PhyHospitalEntity implements Serializable {
    private Integer nbxh01;

    private Integer ywxh01;

    private Integer grxh01;

    private String ywbm01;

    private String lxbs01;

    private String sxbh01;

    private Date qsrq01;

    private Date zzrq01;

    private String zyyy01;

    private String yljg01;

    private String yljg02;

    private String bah001;

    private Date zxrq01;

    private String jgdm01;

    private String ysdm01;

    private String ysdm02;

    private String czr001;

    private String czr002;

    private Date czsj01;

    private String gxry01;

    private String gxry02;

    private Date gxsj01;

    private static final long serialVersionUID = 1L;

    public Integer getNbxh01() {
        return nbxh01;
    }

    public void setNbxh01(Integer nbxh01) {
        this.nbxh01 = nbxh01;
    }

    public Integer getYwxh01() {
        return ywxh01;
    }

    public void setYwxh01(Integer ywxh01) {
        this.ywxh01 = ywxh01;
    }

    public Integer getGrxh01() {
        return grxh01;
    }

    public void setGrxh01(Integer grxh01) {
        this.grxh01 = grxh01;
    }

    public String getYwbm01() {
        return ywbm01;
    }

    public void setYwbm01(String ywbm01) {
        this.ywbm01 = ywbm01 == null ? null : ywbm01.trim();
    }

    public String getLxbs01() {
        return lxbs01;
    }

    public void setLxbs01(String lxbs01) {
        this.lxbs01 = lxbs01 == null ? null : lxbs01.trim();
    }

    public String getSxbh01() {
        return sxbh01;
    }

    public void setSxbh01(String sxbh01) {
        this.sxbh01 = sxbh01 == null ? null : sxbh01.trim();
    }

    public Date getQsrq01() {
        return qsrq01;
    }

    public void setQsrq01(Date qsrq01) {
        this.qsrq01 = qsrq01;
    }

    public Date getZzrq01() {
        return zzrq01;
    }

    public void setZzrq01(Date zzrq01) {
        this.zzrq01 = zzrq01;
    }

    public String getZyyy01() {
        return zyyy01;
    }

    public void setZyyy01(String zyyy01) {
        this.zyyy01 = zyyy01 == null ? null : zyyy01.trim();
    }

    public String getYljg01() {
        return yljg01;
    }

    public void setYljg01(String yljg01) {
        this.yljg01 = yljg01 == null ? null : yljg01.trim();
    }

    public String getYljg02() {
        return yljg02;
    }

    public void setYljg02(String yljg02) {
        this.yljg02 = yljg02 == null ? null : yljg02.trim();
    }

    public String getBah001() {
        return bah001;
    }

    public void setBah001(String bah001) {
        this.bah001 = bah001 == null ? null : bah001.trim();
    }

    public Date getZxrq01() {
        return zxrq01;
    }

    public void setZxrq01(Date zxrq01) {
        this.zxrq01 = zxrq01;
    }

    public String getJgdm01() {
        return jgdm01;
    }

    public void setJgdm01(String jgdm01) {
        this.jgdm01 = jgdm01 == null ? null : jgdm01.trim();
    }

    public String getYsdm01() {
        return ysdm01;
    }

    public void setYsdm01(String ysdm01) {
        this.ysdm01 = ysdm01 == null ? null : ysdm01.trim();
    }

    public String getYsdm02() {
        return ysdm02;
    }

    public void setYsdm02(String ysdm02) {
        this.ysdm02 = ysdm02 == null ? null : ysdm02.trim();
    }

    public String getCzr001() {
        return czr001;
    }

    public void setCzr001(String czr001) {
        this.czr001 = czr001 == null ? null : czr001.trim();
    }

    public String getCzr002() {
        return czr002;
    }

    public void setCzr002(String czr002) {
        this.czr002 = czr002 == null ? null : czr002.trim();
    }

    public Date getCzsj01() {
        return czsj01;
    }

    public void setCzsj01(Date czsj01) {
        this.czsj01 = czsj01;
    }

    public String getGxry01() {
        return gxry01;
    }

    public void setGxry01(String gxry01) {
        this.gxry01 = gxry01 == null ? null : gxry01.trim();
    }

    public String getGxry02() {
        return gxry02;
    }

    public void setGxry02(String gxry02) {
        this.gxry02 = gxry02 == null ? null : gxry02.trim();
    }

    public Date getGxsj01() {
        return gxsj01;
    }

    public void setGxsj01(Date gxsj01) {
        this.gxsj01 = gxsj01;
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
        PhyHospitalEntity other = (PhyHospitalEntity) that;
        return (this.getNbxh01() == null ? other.getNbxh01() == null : this.getNbxh01().equals(other.getNbxh01()))
            && (this.getYwxh01() == null ? other.getYwxh01() == null : this.getYwxh01().equals(other.getYwxh01()))
            && (this.getGrxh01() == null ? other.getGrxh01() == null : this.getGrxh01().equals(other.getGrxh01()))
            && (this.getYwbm01() == null ? other.getYwbm01() == null : this.getYwbm01().equals(other.getYwbm01()))
            && (this.getLxbs01() == null ? other.getLxbs01() == null : this.getLxbs01().equals(other.getLxbs01()))
            && (this.getSxbh01() == null ? other.getSxbh01() == null : this.getSxbh01().equals(other.getSxbh01()))
            && (this.getQsrq01() == null ? other.getQsrq01() == null : this.getQsrq01().equals(other.getQsrq01()))
            && (this.getZzrq01() == null ? other.getZzrq01() == null : this.getZzrq01().equals(other.getZzrq01()))
            && (this.getZyyy01() == null ? other.getZyyy01() == null : this.getZyyy01().equals(other.getZyyy01()))
            && (this.getYljg01() == null ? other.getYljg01() == null : this.getYljg01().equals(other.getYljg01()))
            && (this.getYljg02() == null ? other.getYljg02() == null : this.getYljg02().equals(other.getYljg02()))
            && (this.getBah001() == null ? other.getBah001() == null : this.getBah001().equals(other.getBah001()))
            && (this.getZxrq01() == null ? other.getZxrq01() == null : this.getZxrq01().equals(other.getZxrq01()))
            && (this.getJgdm01() == null ? other.getJgdm01() == null : this.getJgdm01().equals(other.getJgdm01()))
            && (this.getYsdm01() == null ? other.getYsdm01() == null : this.getYsdm01().equals(other.getYsdm01()))
            && (this.getYsdm02() == null ? other.getYsdm02() == null : this.getYsdm02().equals(other.getYsdm02()))
            && (this.getCzr001() == null ? other.getCzr001() == null : this.getCzr001().equals(other.getCzr001()))
            && (this.getCzr002() == null ? other.getCzr002() == null : this.getCzr002().equals(other.getCzr002()))
            && (this.getCzsj01() == null ? other.getCzsj01() == null : this.getCzsj01().equals(other.getCzsj01()))
            && (this.getGxry01() == null ? other.getGxry01() == null : this.getGxry01().equals(other.getGxry01()))
            && (this.getGxry02() == null ? other.getGxry02() == null : this.getGxry02().equals(other.getGxry02()))
            && (this.getGxsj01() == null ? other.getGxsj01() == null : this.getGxsj01().equals(other.getGxsj01()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNbxh01() == null) ? 0 : getNbxh01().hashCode());
        result = prime * result + ((getYwxh01() == null) ? 0 : getYwxh01().hashCode());
        result = prime * result + ((getGrxh01() == null) ? 0 : getGrxh01().hashCode());
        result = prime * result + ((getYwbm01() == null) ? 0 : getYwbm01().hashCode());
        result = prime * result + ((getLxbs01() == null) ? 0 : getLxbs01().hashCode());
        result = prime * result + ((getSxbh01() == null) ? 0 : getSxbh01().hashCode());
        result = prime * result + ((getQsrq01() == null) ? 0 : getQsrq01().hashCode());
        result = prime * result + ((getZzrq01() == null) ? 0 : getZzrq01().hashCode());
        result = prime * result + ((getZyyy01() == null) ? 0 : getZyyy01().hashCode());
        result = prime * result + ((getYljg01() == null) ? 0 : getYljg01().hashCode());
        result = prime * result + ((getYljg02() == null) ? 0 : getYljg02().hashCode());
        result = prime * result + ((getBah001() == null) ? 0 : getBah001().hashCode());
        result = prime * result + ((getZxrq01() == null) ? 0 : getZxrq01().hashCode());
        result = prime * result + ((getJgdm01() == null) ? 0 : getJgdm01().hashCode());
        result = prime * result + ((getYsdm01() == null) ? 0 : getYsdm01().hashCode());
        result = prime * result + ((getYsdm02() == null) ? 0 : getYsdm02().hashCode());
        result = prime * result + ((getCzr001() == null) ? 0 : getCzr001().hashCode());
        result = prime * result + ((getCzr002() == null) ? 0 : getCzr002().hashCode());
        result = prime * result + ((getCzsj01() == null) ? 0 : getCzsj01().hashCode());
        result = prime * result + ((getGxry01() == null) ? 0 : getGxry01().hashCode());
        result = prime * result + ((getGxry02() == null) ? 0 : getGxry02().hashCode());
        result = prime * result + ((getGxsj01() == null) ? 0 : getGxsj01().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nbxh01=").append(nbxh01);
        sb.append(", ywxh01=").append(ywxh01);
        sb.append(", grxh01=").append(grxh01);
        sb.append(", ywbm01=").append(ywbm01);
        sb.append(", lxbs01=").append(lxbs01);
        sb.append(", sxbh01=").append(sxbh01);
        sb.append(", qsrq01=").append(qsrq01);
        sb.append(", zzrq01=").append(zzrq01);
        sb.append(", zyyy01=").append(zyyy01);
        sb.append(", yljg01=").append(yljg01);
        sb.append(", yljg02=").append(yljg02);
        sb.append(", bah001=").append(bah001);
        sb.append(", zxrq01=").append(zxrq01);
        sb.append(", jgdm01=").append(jgdm01);
        sb.append(", ysdm01=").append(ysdm01);
        sb.append(", ysdm02=").append(ysdm02);
        sb.append(", czr001=").append(czr001);
        sb.append(", czr002=").append(czr002);
        sb.append(", czsj01=").append(czsj01);
        sb.append(", gxry01=").append(gxry01);
        sb.append(", gxry02=").append(gxry02);
        sb.append(", gxsj01=").append(gxsj01);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}