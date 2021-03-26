package com.huiyi.campus.dao.entity.home;

import java.io.Serializable;
import java.util.Date;

public class HomeRecordEntity implements Serializable {
    private Integer nbxh01;

    private String hkbh01;

    private String hklb01;

    private String hzxm01;

    private Integer grxh01;

    private String hjdz01;

    private String xzjg01;

    private String xzdm01;

    private String cjdm01;

    private String zjdm01;

    private String czr001;

    private String czr002;

    private Date czsj01;

    private String gxr001;

    private String gxr002;

    private Date gxsj01;

    private String sczt01;

    private String ytjxh1;

    private String ytjbm1;

    private String sjqyxh;

    private static final long serialVersionUID = 1L;

    public Integer getNbxh01() {
        return nbxh01;
    }

    public void setNbxh01(Integer nbxh01) {
        this.nbxh01 = nbxh01;
    }

    public String getHkbh01() {
        return hkbh01;
    }

    public void setHkbh01(String hkbh01) {
        this.hkbh01 = hkbh01 == null ? null : hkbh01.trim();
    }

    public String getHklb01() {
        return hklb01;
    }

    public void setHklb01(String hklb01) {
        this.hklb01 = hklb01 == null ? null : hklb01.trim();
    }

    public String getHzxm01() {
        return hzxm01;
    }

    public void setHzxm01(String hzxm01) {
        this.hzxm01 = hzxm01 == null ? null : hzxm01.trim();
    }

    public Integer getGrxh01() {
        return grxh01;
    }

    public void setGrxh01(Integer grxh01) {
        this.grxh01 = grxh01;
    }

    public String getHjdz01() {
        return hjdz01;
    }

    public void setHjdz01(String hjdz01) {
        this.hjdz01 = hjdz01 == null ? null : hjdz01.trim();
    }

    public String getXzjg01() {
        return xzjg01;
    }

    public void setXzjg01(String xzjg01) {
        this.xzjg01 = xzjg01 == null ? null : xzjg01.trim();
    }

    public String getXzdm01() {
        return xzdm01;
    }

    public void setXzdm01(String xzdm01) {
        this.xzdm01 = xzdm01 == null ? null : xzdm01.trim();
    }

    public String getCjdm01() {
        return cjdm01;
    }

    public void setCjdm01(String cjdm01) {
        this.cjdm01 = cjdm01 == null ? null : cjdm01.trim();
    }

    public String getZjdm01() {
        return zjdm01;
    }

    public void setZjdm01(String zjdm01) {
        this.zjdm01 = zjdm01 == null ? null : zjdm01.trim();
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

    public String getGxr001() {
        return gxr001;
    }

    public void setGxr001(String gxr001) {
        this.gxr001 = gxr001 == null ? null : gxr001.trim();
    }

    public String getGxr002() {
        return gxr002;
    }

    public void setGxr002(String gxr002) {
        this.gxr002 = gxr002 == null ? null : gxr002.trim();
    }

    public Date getGxsj01() {
        return gxsj01;
    }

    public void setGxsj01(Date gxsj01) {
        this.gxsj01 = gxsj01;
    }

    public String getSczt01() {
        return sczt01;
    }

    public void setSczt01(String sczt01) {
        this.sczt01 = sczt01 == null ? null : sczt01.trim();
    }

    public String getYtjxh1() {
        return ytjxh1;
    }

    public void setYtjxh1(String ytjxh1) {
        this.ytjxh1 = ytjxh1 == null ? null : ytjxh1.trim();
    }

    public String getYtjbm1() {
        return ytjbm1;
    }

    public void setYtjbm1(String ytjbm1) {
        this.ytjbm1 = ytjbm1 == null ? null : ytjbm1.trim();
    }

    public String getSjqyxh() {
        return sjqyxh;
    }

    public void setSjqyxh(String sjqyxh) {
        this.sjqyxh = sjqyxh == null ? null : sjqyxh.trim();
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
        HomeRecordEntity other = (HomeRecordEntity) that;
        return (this.getNbxh01() == null ? other.getNbxh01() == null : this.getNbxh01().equals(other.getNbxh01()))
            && (this.getHkbh01() == null ? other.getHkbh01() == null : this.getHkbh01().equals(other.getHkbh01()))
            && (this.getHklb01() == null ? other.getHklb01() == null : this.getHklb01().equals(other.getHklb01()))
            && (this.getHzxm01() == null ? other.getHzxm01() == null : this.getHzxm01().equals(other.getHzxm01()))
            && (this.getGrxh01() == null ? other.getGrxh01() == null : this.getGrxh01().equals(other.getGrxh01()))
            && (this.getHjdz01() == null ? other.getHjdz01() == null : this.getHjdz01().equals(other.getHjdz01()))
            && (this.getXzjg01() == null ? other.getXzjg01() == null : this.getXzjg01().equals(other.getXzjg01()))
            && (this.getXzdm01() == null ? other.getXzdm01() == null : this.getXzdm01().equals(other.getXzdm01()))
            && (this.getCjdm01() == null ? other.getCjdm01() == null : this.getCjdm01().equals(other.getCjdm01()))
            && (this.getZjdm01() == null ? other.getZjdm01() == null : this.getZjdm01().equals(other.getZjdm01()))
            && (this.getCzr001() == null ? other.getCzr001() == null : this.getCzr001().equals(other.getCzr001()))
            && (this.getCzr002() == null ? other.getCzr002() == null : this.getCzr002().equals(other.getCzr002()))
            && (this.getCzsj01() == null ? other.getCzsj01() == null : this.getCzsj01().equals(other.getCzsj01()))
            && (this.getGxr001() == null ? other.getGxr001() == null : this.getGxr001().equals(other.getGxr001()))
            && (this.getGxr002() == null ? other.getGxr002() == null : this.getGxr002().equals(other.getGxr002()))
            && (this.getGxsj01() == null ? other.getGxsj01() == null : this.getGxsj01().equals(other.getGxsj01()))
            && (this.getSczt01() == null ? other.getSczt01() == null : this.getSczt01().equals(other.getSczt01()))
            && (this.getYtjxh1() == null ? other.getYtjxh1() == null : this.getYtjxh1().equals(other.getYtjxh1()))
            && (this.getYtjbm1() == null ? other.getYtjbm1() == null : this.getYtjbm1().equals(other.getYtjbm1()))
            && (this.getSjqyxh() == null ? other.getSjqyxh() == null : this.getSjqyxh().equals(other.getSjqyxh()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNbxh01() == null) ? 0 : getNbxh01().hashCode());
        result = prime * result + ((getHkbh01() == null) ? 0 : getHkbh01().hashCode());
        result = prime * result + ((getHklb01() == null) ? 0 : getHklb01().hashCode());
        result = prime * result + ((getHzxm01() == null) ? 0 : getHzxm01().hashCode());
        result = prime * result + ((getGrxh01() == null) ? 0 : getGrxh01().hashCode());
        result = prime * result + ((getHjdz01() == null) ? 0 : getHjdz01().hashCode());
        result = prime * result + ((getXzjg01() == null) ? 0 : getXzjg01().hashCode());
        result = prime * result + ((getXzdm01() == null) ? 0 : getXzdm01().hashCode());
        result = prime * result + ((getCjdm01() == null) ? 0 : getCjdm01().hashCode());
        result = prime * result + ((getZjdm01() == null) ? 0 : getZjdm01().hashCode());
        result = prime * result + ((getCzr001() == null) ? 0 : getCzr001().hashCode());
        result = prime * result + ((getCzr002() == null) ? 0 : getCzr002().hashCode());
        result = prime * result + ((getCzsj01() == null) ? 0 : getCzsj01().hashCode());
        result = prime * result + ((getGxr001() == null) ? 0 : getGxr001().hashCode());
        result = prime * result + ((getGxr002() == null) ? 0 : getGxr002().hashCode());
        result = prime * result + ((getGxsj01() == null) ? 0 : getGxsj01().hashCode());
        result = prime * result + ((getSczt01() == null) ? 0 : getSczt01().hashCode());
        result = prime * result + ((getYtjxh1() == null) ? 0 : getYtjxh1().hashCode());
        result = prime * result + ((getYtjbm1() == null) ? 0 : getYtjbm1().hashCode());
        result = prime * result + ((getSjqyxh() == null) ? 0 : getSjqyxh().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nbxh01=").append(nbxh01);
        sb.append(", hkbh01=").append(hkbh01);
        sb.append(", hklb01=").append(hklb01);
        sb.append(", hzxm01=").append(hzxm01);
        sb.append(", grxh01=").append(grxh01);
        sb.append(", hjdz01=").append(hjdz01);
        sb.append(", xzjg01=").append(xzjg01);
        sb.append(", xzdm01=").append(xzdm01);
        sb.append(", cjdm01=").append(cjdm01);
        sb.append(", zjdm01=").append(zjdm01);
        sb.append(", czr001=").append(czr001);
        sb.append(", czr002=").append(czr002);
        sb.append(", czsj01=").append(czsj01);
        sb.append(", gxr001=").append(gxr001);
        sb.append(", gxr002=").append(gxr002);
        sb.append(", gxsj01=").append(gxsj01);
        sb.append(", sczt01=").append(sczt01);
        sb.append(", ytjxh1=").append(ytjxh1);
        sb.append(", ytjbm1=").append(ytjbm1);
        sb.append(", sjqyxh=").append(sjqyxh);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}