package com.huiyi.campus.dao.entity.home;

import java.io.Serializable;

public class HomeMemberEntity implements Serializable {
    private String nbxh01;

    private String jtbh01;

    private Integer grxh01;

    private String grxm01;

    private String sxbm01;

    private Integer grxh02;

    private String grxm02;

    private Byte gxlx01;

    private String gxlx02;

    private Byte sczt01;

    private String sjqyxh;

    private static final long serialVersionUID = 1L;

    public String getNbxh01() {
        return nbxh01;
    }

    public void setNbxh01(String nbxh01) {
        this.nbxh01 = nbxh01 == null ? null : nbxh01.trim();
    }

    public String getJtbh01() {
        return jtbh01;
    }

    public void setJtbh01(String jtbh01) {
        this.jtbh01 = jtbh01 == null ? null : jtbh01.trim();
    }

    public Integer getGrxh01() {
        return grxh01;
    }

    public void setGrxh01(Integer grxh01) {
        this.grxh01 = grxh01;
    }

    public String getGrxm01() {
        return grxm01;
    }

    public void setGrxm01(String grxm01) {
        this.grxm01 = grxm01 == null ? null : grxm01.trim();
    }

    public String getSxbm01() {
        return sxbm01;
    }

    public void setSxbm01(String sxbm01) {
        this.sxbm01 = sxbm01 == null ? null : sxbm01.trim();
    }

    public Integer getGrxh02() {
        return grxh02;
    }

    public void setGrxh02(Integer grxh02) {
        this.grxh02 = grxh02;
    }

    public String getGrxm02() {
        return grxm02;
    }

    public void setGrxm02(String grxm02) {
        this.grxm02 = grxm02 == null ? null : grxm02.trim();
    }

    public Byte getGxlx01() {
        return gxlx01;
    }

    public void setGxlx01(Byte gxlx01) {
        this.gxlx01 = gxlx01;
    }

    public String getGxlx02() {
        return gxlx02;
    }

    public void setGxlx02(String gxlx02) {
        this.gxlx02 = gxlx02 == null ? null : gxlx02.trim();
    }

    public Byte getSczt01() {
        return sczt01;
    }

    public void setSczt01(Byte sczt01) {
        this.sczt01 = sczt01;
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
        HomeMemberEntity other = (HomeMemberEntity) that;
        return (this.getNbxh01() == null ? other.getNbxh01() == null : this.getNbxh01().equals(other.getNbxh01()))
            && (this.getJtbh01() == null ? other.getJtbh01() == null : this.getJtbh01().equals(other.getJtbh01()))
            && (this.getGrxh01() == null ? other.getGrxh01() == null : this.getGrxh01().equals(other.getGrxh01()))
            && (this.getGrxm01() == null ? other.getGrxm01() == null : this.getGrxm01().equals(other.getGrxm01()))
            && (this.getSxbm01() == null ? other.getSxbm01() == null : this.getSxbm01().equals(other.getSxbm01()))
            && (this.getGrxh02() == null ? other.getGrxh02() == null : this.getGrxh02().equals(other.getGrxh02()))
            && (this.getGrxm02() == null ? other.getGrxm02() == null : this.getGrxm02().equals(other.getGrxm02()))
            && (this.getGxlx01() == null ? other.getGxlx01() == null : this.getGxlx01().equals(other.getGxlx01()))
            && (this.getGxlx02() == null ? other.getGxlx02() == null : this.getGxlx02().equals(other.getGxlx02()))
            && (this.getSczt01() == null ? other.getSczt01() == null : this.getSczt01().equals(other.getSczt01()))
            && (this.getSjqyxh() == null ? other.getSjqyxh() == null : this.getSjqyxh().equals(other.getSjqyxh()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNbxh01() == null) ? 0 : getNbxh01().hashCode());
        result = prime * result + ((getJtbh01() == null) ? 0 : getJtbh01().hashCode());
        result = prime * result + ((getGrxh01() == null) ? 0 : getGrxh01().hashCode());
        result = prime * result + ((getGrxm01() == null) ? 0 : getGrxm01().hashCode());
        result = prime * result + ((getSxbm01() == null) ? 0 : getSxbm01().hashCode());
        result = prime * result + ((getGrxh02() == null) ? 0 : getGrxh02().hashCode());
        result = prime * result + ((getGrxm02() == null) ? 0 : getGrxm02().hashCode());
        result = prime * result + ((getGxlx01() == null) ? 0 : getGxlx01().hashCode());
        result = prime * result + ((getGxlx02() == null) ? 0 : getGxlx02().hashCode());
        result = prime * result + ((getSczt01() == null) ? 0 : getSczt01().hashCode());
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
        sb.append(", jtbh01=").append(jtbh01);
        sb.append(", grxh01=").append(grxh01);
        sb.append(", grxm01=").append(grxm01);
        sb.append(", sxbm01=").append(sxbm01);
        sb.append(", grxh02=").append(grxh02);
        sb.append(", grxm02=").append(grxm02);
        sb.append(", gxlx01=").append(gxlx01);
        sb.append(", gxlx02=").append(gxlx02);
        sb.append(", sczt01=").append(sczt01);
        sb.append(", sjqyxh=").append(sjqyxh);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}