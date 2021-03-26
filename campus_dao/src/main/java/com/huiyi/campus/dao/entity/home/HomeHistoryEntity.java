package com.huiyi.campus.dao.entity.home;

import java.io.Serializable;

public class HomeHistoryEntity implements Serializable {
    private Integer nbxh01;

    private String sxbm01;

    private Integer grxh01;

    private String gxlx01;

    private String jbs001;

    private String jbs002;

    private String jbs003;

    private static final long serialVersionUID = 1L;

    public Integer getNbxh01() {
        return nbxh01;
    }

    public void setNbxh01(Integer nbxh01) {
        this.nbxh01 = nbxh01;
    }

    public String getSxbm01() {
        return sxbm01;
    }

    public void setSxbm01(String sxbm01) {
        this.sxbm01 = sxbm01 == null ? null : sxbm01.trim();
    }

    public Integer getGrxh01() {
        return grxh01;
    }

    public void setGrxh01(Integer grxh01) {
        this.grxh01 = grxh01;
    }

    public String getGxlx01() {
        return gxlx01;
    }

    public void setGxlx01(String gxlx01) {
        this.gxlx01 = gxlx01 == null ? null : gxlx01.trim();
    }

    public String getJbs001() {
        return jbs001;
    }

    public void setJbs001(String jbs001) {
        this.jbs001 = jbs001 == null ? null : jbs001.trim();
    }

    public String getJbs002() {
        return jbs002;
    }

    public void setJbs002(String jbs002) {
        this.jbs002 = jbs002 == null ? null : jbs002.trim();
    }

    public String getJbs003() {
        return jbs003;
    }

    public void setJbs003(String jbs003) {
        this.jbs003 = jbs003 == null ? null : jbs003.trim();
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
        HomeHistoryEntity other = (HomeHistoryEntity) that;
        return (this.getNbxh01() == null ? other.getNbxh01() == null : this.getNbxh01().equals(other.getNbxh01()))
            && (this.getSxbm01() == null ? other.getSxbm01() == null : this.getSxbm01().equals(other.getSxbm01()))
            && (this.getGrxh01() == null ? other.getGrxh01() == null : this.getGrxh01().equals(other.getGrxh01()))
            && (this.getGxlx01() == null ? other.getGxlx01() == null : this.getGxlx01().equals(other.getGxlx01()))
            && (this.getJbs001() == null ? other.getJbs001() == null : this.getJbs001().equals(other.getJbs001()))
            && (this.getJbs002() == null ? other.getJbs002() == null : this.getJbs002().equals(other.getJbs002()))
            && (this.getJbs003() == null ? other.getJbs003() == null : this.getJbs003().equals(other.getJbs003()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNbxh01() == null) ? 0 : getNbxh01().hashCode());
        result = prime * result + ((getSxbm01() == null) ? 0 : getSxbm01().hashCode());
        result = prime * result + ((getGrxh01() == null) ? 0 : getGrxh01().hashCode());
        result = prime * result + ((getGxlx01() == null) ? 0 : getGxlx01().hashCode());
        result = prime * result + ((getJbs001() == null) ? 0 : getJbs001().hashCode());
        result = prime * result + ((getJbs002() == null) ? 0 : getJbs002().hashCode());
        result = prime * result + ((getJbs003() == null) ? 0 : getJbs003().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nbxh01=").append(nbxh01);
        sb.append(", sxbm01=").append(sxbm01);
        sb.append(", grxh01=").append(grxh01);
        sb.append(", gxlx01=").append(gxlx01);
        sb.append(", jbs001=").append(jbs001);
        sb.append(", jbs002=").append(jbs002);
        sb.append(", jbs003=").append(jbs003);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}