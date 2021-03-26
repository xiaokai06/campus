package com.huiyi.campus.dao.entity.phy;

import java.io.Serializable;
import java.util.Date;

public class PhyVaccHistoryEntity implements Serializable {
    private Integer nbxh01;

    private Integer ywxh01;

    private Integer grxh01;

    private String ywbm01;

    private String sxbh01;

    private String jzmc01;

    private Date jzrq01;

    private String jzjg01;

    private String jzjg02;

    private Date zxrq01;

    private String jgdm01;

    private String ysdm01;

    private String ysdm02;

    private Integer ywjl01;

    private Integer ywsytj;

    private String ymph01;

    private Integer yjzym;

    private String czr001;

    private String czr002;

    private Date czsj01;

    private String gxry01;

    private String gxry02;

    private Date gxsj01;

    private Byte ymbz01;

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

    public String getSxbh01() {
        return sxbh01;
    }

    public void setSxbh01(String sxbh01) {
        this.sxbh01 = sxbh01 == null ? null : sxbh01.trim();
    }

    public String getJzmc01() {
        return jzmc01;
    }

    public void setJzmc01(String jzmc01) {
        this.jzmc01 = jzmc01 == null ? null : jzmc01.trim();
    }

    public Date getJzrq01() {
        return jzrq01;
    }

    public void setJzrq01(Date jzrq01) {
        this.jzrq01 = jzrq01;
    }

    public String getJzjg01() {
        return jzjg01;
    }

    public void setJzjg01(String jzjg01) {
        this.jzjg01 = jzjg01 == null ? null : jzjg01.trim();
    }

    public String getJzjg02() {
        return jzjg02;
    }

    public void setJzjg02(String jzjg02) {
        this.jzjg02 = jzjg02 == null ? null : jzjg02.trim();
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

    public Integer getYwjl01() {
        return ywjl01;
    }

    public void setYwjl01(Integer ywjl01) {
        this.ywjl01 = ywjl01;
    }

    public Integer getYwsytj() {
        return ywsytj;
    }

    public void setYwsytj(Integer ywsytj) {
        this.ywsytj = ywsytj;
    }

    public String getYmph01() {
        return ymph01;
    }

    public void setYmph01(String ymph01) {
        this.ymph01 = ymph01 == null ? null : ymph01.trim();
    }

    public Integer getYjzym() {
        return yjzym;
    }

    public void setYjzym(Integer yjzym) {
        this.yjzym = yjzym;
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

    public Byte getYmbz01() {
        return ymbz01;
    }

    public void setYmbz01(Byte ymbz01) {
        this.ymbz01 = ymbz01;
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
        PhyVaccHistoryEntity other = (PhyVaccHistoryEntity) that;
        return (this.getNbxh01() == null ? other.getNbxh01() == null : this.getNbxh01().equals(other.getNbxh01()))
            && (this.getYwxh01() == null ? other.getYwxh01() == null : this.getYwxh01().equals(other.getYwxh01()))
            && (this.getGrxh01() == null ? other.getGrxh01() == null : this.getGrxh01().equals(other.getGrxh01()))
            && (this.getYwbm01() == null ? other.getYwbm01() == null : this.getYwbm01().equals(other.getYwbm01()))
            && (this.getSxbh01() == null ? other.getSxbh01() == null : this.getSxbh01().equals(other.getSxbh01()))
            && (this.getJzmc01() == null ? other.getJzmc01() == null : this.getJzmc01().equals(other.getJzmc01()))
            && (this.getJzrq01() == null ? other.getJzrq01() == null : this.getJzrq01().equals(other.getJzrq01()))
            && (this.getJzjg01() == null ? other.getJzjg01() == null : this.getJzjg01().equals(other.getJzjg01()))
            && (this.getJzjg02() == null ? other.getJzjg02() == null : this.getJzjg02().equals(other.getJzjg02()))
            && (this.getZxrq01() == null ? other.getZxrq01() == null : this.getZxrq01().equals(other.getZxrq01()))
            && (this.getJgdm01() == null ? other.getJgdm01() == null : this.getJgdm01().equals(other.getJgdm01()))
            && (this.getYsdm01() == null ? other.getYsdm01() == null : this.getYsdm01().equals(other.getYsdm01()))
            && (this.getYsdm02() == null ? other.getYsdm02() == null : this.getYsdm02().equals(other.getYsdm02()))
            && (this.getYwjl01() == null ? other.getYwjl01() == null : this.getYwjl01().equals(other.getYwjl01()))
            && (this.getYwsytj() == null ? other.getYwsytj() == null : this.getYwsytj().equals(other.getYwsytj()))
            && (this.getYmph01() == null ? other.getYmph01() == null : this.getYmph01().equals(other.getYmph01()))
            && (this.getYjzym() == null ? other.getYjzym() == null : this.getYjzym().equals(other.getYjzym()))
            && (this.getCzr001() == null ? other.getCzr001() == null : this.getCzr001().equals(other.getCzr001()))
            && (this.getCzr002() == null ? other.getCzr002() == null : this.getCzr002().equals(other.getCzr002()))
            && (this.getCzsj01() == null ? other.getCzsj01() == null : this.getCzsj01().equals(other.getCzsj01()))
            && (this.getGxry01() == null ? other.getGxry01() == null : this.getGxry01().equals(other.getGxry01()))
            && (this.getGxry02() == null ? other.getGxry02() == null : this.getGxry02().equals(other.getGxry02()))
            && (this.getGxsj01() == null ? other.getGxsj01() == null : this.getGxsj01().equals(other.getGxsj01()))
            && (this.getYmbz01() == null ? other.getYmbz01() == null : this.getYmbz01().equals(other.getYmbz01()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNbxh01() == null) ? 0 : getNbxh01().hashCode());
        result = prime * result + ((getYwxh01() == null) ? 0 : getYwxh01().hashCode());
        result = prime * result + ((getGrxh01() == null) ? 0 : getGrxh01().hashCode());
        result = prime * result + ((getYwbm01() == null) ? 0 : getYwbm01().hashCode());
        result = prime * result + ((getSxbh01() == null) ? 0 : getSxbh01().hashCode());
        result = prime * result + ((getJzmc01() == null) ? 0 : getJzmc01().hashCode());
        result = prime * result + ((getJzrq01() == null) ? 0 : getJzrq01().hashCode());
        result = prime * result + ((getJzjg01() == null) ? 0 : getJzjg01().hashCode());
        result = prime * result + ((getJzjg02() == null) ? 0 : getJzjg02().hashCode());
        result = prime * result + ((getZxrq01() == null) ? 0 : getZxrq01().hashCode());
        result = prime * result + ((getJgdm01() == null) ? 0 : getJgdm01().hashCode());
        result = prime * result + ((getYsdm01() == null) ? 0 : getYsdm01().hashCode());
        result = prime * result + ((getYsdm02() == null) ? 0 : getYsdm02().hashCode());
        result = prime * result + ((getYwjl01() == null) ? 0 : getYwjl01().hashCode());
        result = prime * result + ((getYwsytj() == null) ? 0 : getYwsytj().hashCode());
        result = prime * result + ((getYmph01() == null) ? 0 : getYmph01().hashCode());
        result = prime * result + ((getYjzym() == null) ? 0 : getYjzym().hashCode());
        result = prime * result + ((getCzr001() == null) ? 0 : getCzr001().hashCode());
        result = prime * result + ((getCzr002() == null) ? 0 : getCzr002().hashCode());
        result = prime * result + ((getCzsj01() == null) ? 0 : getCzsj01().hashCode());
        result = prime * result + ((getGxry01() == null) ? 0 : getGxry01().hashCode());
        result = prime * result + ((getGxry02() == null) ? 0 : getGxry02().hashCode());
        result = prime * result + ((getGxsj01() == null) ? 0 : getGxsj01().hashCode());
        result = prime * result + ((getYmbz01() == null) ? 0 : getYmbz01().hashCode());
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
        sb.append(", sxbh01=").append(sxbh01);
        sb.append(", jzmc01=").append(jzmc01);
        sb.append(", jzrq01=").append(jzrq01);
        sb.append(", jzjg01=").append(jzjg01);
        sb.append(", jzjg02=").append(jzjg02);
        sb.append(", zxrq01=").append(zxrq01);
        sb.append(", jgdm01=").append(jgdm01);
        sb.append(", ysdm01=").append(ysdm01);
        sb.append(", ysdm02=").append(ysdm02);
        sb.append(", ywjl01=").append(ywjl01);
        sb.append(", ywsytj=").append(ywsytj);
        sb.append(", ymph01=").append(ymph01);
        sb.append(", yjzym=").append(yjzym);
        sb.append(", czr001=").append(czr001);
        sb.append(", czr002=").append(czr002);
        sb.append(", czsj01=").append(czsj01);
        sb.append(", gxry01=").append(gxry01);
        sb.append(", gxry02=").append(gxry02);
        sb.append(", gxsj01=").append(gxsj01);
        sb.append(", ymbz01=").append(ymbz01);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}