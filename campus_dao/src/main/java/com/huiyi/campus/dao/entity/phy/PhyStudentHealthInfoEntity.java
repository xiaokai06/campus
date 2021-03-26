package com.huiyi.campus.dao.entity.phy;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PhyStudentHealthInfoEntity implements Serializable {
    private String id;

    private String phyStudentId;

    private BigDecimal height;

    private BigDecimal weight;

    private String blood;

    private String pulse;

    private String chest;

    private String vitalCapacity;

    private String formDoctor;

    private BigDecimal nakedLeft;

    private BigDecimal nakedRight;

    private BigDecimal correctLeft;

    private BigDecimal correctRight;

    private BigDecimal colorVision;

    private BigDecimal trachLeft;

    private BigDecimal trachRight;

    private String eyesDoctor;

    private String ear;

    private String nose;

    private String throat;

    private String earNoseDoctor;

    private String tooth;

    private String periodontal;

    private String anamnesis;

    private String heart;

    private String lung;

    private String liver;

    private String spleen;

    private String internalOther;

    private String internalDoctor;

    private String skin;

    private String lymph;

    private String thyroid;

    private String spine;

    private String limbJoints;

    private String flatfoot;

    private String pudendum;

    private String anus;

    private String surgeryOther;

    private String surgeryDoctor;

    private String chestDoctor;

    private String liverFunction;

    private String bloodRoutine;

    private String conclusion;

    private String phyDoctor;

    private String phyConclusion;

    private String phyResultSuggest;

    private Byte delFlag;

    private Date createTime;

    private String extend1;

    private Date updateTime;

    private String extend2;

    private String extend3;

    private String extend4;

    private String extend5;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPhyStudentId() {
        return phyStudentId;
    }

    public void setPhyStudentId(String phyStudentId) {
        this.phyStudentId = phyStudentId == null ? null : phyStudentId.trim();
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood == null ? null : blood.trim();
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse == null ? null : pulse.trim();
    }

    public String getChest() {
        return chest;
    }

    public void setChest(String chest) {
        this.chest = chest == null ? null : chest.trim();
    }

    public String getVitalCapacity() {
        return vitalCapacity;
    }

    public void setVitalCapacity(String vitalCapacity) {
        this.vitalCapacity = vitalCapacity == null ? null : vitalCapacity.trim();
    }

    public String getFormDoctor() {
        return formDoctor;
    }

    public void setFormDoctor(String formDoctor) {
        this.formDoctor = formDoctor == null ? null : formDoctor.trim();
    }

    public BigDecimal getNakedLeft() {
        return nakedLeft;
    }

    public void setNakedLeft(BigDecimal nakedLeft) {
        this.nakedLeft = nakedLeft;
    }

    public BigDecimal getNakedRight() {
        return nakedRight;
    }

    public void setNakedRight(BigDecimal nakedRight) {
        this.nakedRight = nakedRight;
    }

    public BigDecimal getCorrectLeft() {
        return correctLeft;
    }

    public void setCorrectLeft(BigDecimal correctLeft) {
        this.correctLeft = correctLeft;
    }

    public BigDecimal getCorrectRight() {
        return correctRight;
    }

    public void setCorrectRight(BigDecimal correctRight) {
        this.correctRight = correctRight;
    }

    public BigDecimal getColorVision() {
        return colorVision;
    }

    public void setColorVision(BigDecimal colorVision) {
        this.colorVision = colorVision;
    }

    public BigDecimal getTrachLeft() {
        return trachLeft;
    }

    public void setTrachLeft(BigDecimal trachLeft) {
        this.trachLeft = trachLeft;
    }

    public BigDecimal getTrachRight() {
        return trachRight;
    }

    public void setTrachRight(BigDecimal trachRight) {
        this.trachRight = trachRight;
    }

    public String getEyesDoctor() {
        return eyesDoctor;
    }

    public void setEyesDoctor(String eyesDoctor) {
        this.eyesDoctor = eyesDoctor == null ? null : eyesDoctor.trim();
    }

    public String getEar() {
        return ear;
    }

    public void setEar(String ear) {
        this.ear = ear == null ? null : ear.trim();
    }

    public String getNose() {
        return nose;
    }

    public void setNose(String nose) {
        this.nose = nose == null ? null : nose.trim();
    }

    public String getThroat() {
        return throat;
    }

    public void setThroat(String throat) {
        this.throat = throat == null ? null : throat.trim();
    }

    public String getEarNoseDoctor() {
        return earNoseDoctor;
    }

    public void setEarNoseDoctor(String earNoseDoctor) {
        this.earNoseDoctor = earNoseDoctor == null ? null : earNoseDoctor.trim();
    }

    public String getTooth() {
        return tooth;
    }

    public void setTooth(String tooth) {
        this.tooth = tooth == null ? null : tooth.trim();
    }

    public String getPeriodontal() {
        return periodontal;
    }

    public void setPeriodontal(String periodontal) {
        this.periodontal = periodontal == null ? null : periodontal.trim();
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis == null ? null : anamnesis.trim();
    }

    public String getHeart() {
        return heart;
    }

    public void setHeart(String heart) {
        this.heart = heart == null ? null : heart.trim();
    }

    public String getLung() {
        return lung;
    }

    public void setLung(String lung) {
        this.lung = lung == null ? null : lung.trim();
    }

    public String getLiver() {
        return liver;
    }

    public void setLiver(String liver) {
        this.liver = liver == null ? null : liver.trim();
    }

    public String getSpleen() {
        return spleen;
    }

    public void setSpleen(String spleen) {
        this.spleen = spleen == null ? null : spleen.trim();
    }

    public String getInternalOther() {
        return internalOther;
    }

    public void setInternalOther(String internalOther) {
        this.internalOther = internalOther == null ? null : internalOther.trim();
    }

    public String getInternalDoctor() {
        return internalDoctor;
    }

    public void setInternalDoctor(String internalDoctor) {
        this.internalDoctor = internalDoctor == null ? null : internalDoctor.trim();
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin == null ? null : skin.trim();
    }

    public String getLymph() {
        return lymph;
    }

    public void setLymph(String lymph) {
        this.lymph = lymph == null ? null : lymph.trim();
    }

    public String getThyroid() {
        return thyroid;
    }

    public void setThyroid(String thyroid) {
        this.thyroid = thyroid == null ? null : thyroid.trim();
    }

    public String getSpine() {
        return spine;
    }

    public void setSpine(String spine) {
        this.spine = spine == null ? null : spine.trim();
    }

    public String getLimbJoints() {
        return limbJoints;
    }

    public void setLimbJoints(String limbJoints) {
        this.limbJoints = limbJoints == null ? null : limbJoints.trim();
    }

    public String getFlatfoot() {
        return flatfoot;
    }

    public void setFlatfoot(String flatfoot) {
        this.flatfoot = flatfoot == null ? null : flatfoot.trim();
    }

    public String getPudendum() {
        return pudendum;
    }

    public void setPudendum(String pudendum) {
        this.pudendum = pudendum == null ? null : pudendum.trim();
    }

    public String getAnus() {
        return anus;
    }

    public void setAnus(String anus) {
        this.anus = anus == null ? null : anus.trim();
    }

    public String getSurgeryOther() {
        return surgeryOther;
    }

    public void setSurgeryOther(String surgeryOther) {
        this.surgeryOther = surgeryOther == null ? null : surgeryOther.trim();
    }

    public String getSurgeryDoctor() {
        return surgeryDoctor;
    }

    public void setSurgeryDoctor(String surgeryDoctor) {
        this.surgeryDoctor = surgeryDoctor == null ? null : surgeryDoctor.trim();
    }

    public String getChestDoctor() {
        return chestDoctor;
    }

    public void setChestDoctor(String chestDoctor) {
        this.chestDoctor = chestDoctor == null ? null : chestDoctor.trim();
    }

    public String getLiverFunction() {
        return liverFunction;
    }

    public void setLiverFunction(String liverFunction) {
        this.liverFunction = liverFunction == null ? null : liverFunction.trim();
    }

    public String getBloodRoutine() {
        return bloodRoutine;
    }

    public void setBloodRoutine(String bloodRoutine) {
        this.bloodRoutine = bloodRoutine == null ? null : bloodRoutine.trim();
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion == null ? null : conclusion.trim();
    }

    public String getPhyDoctor() {
        return phyDoctor;
    }

    public void setPhyDoctor(String phyDoctor) {
        this.phyDoctor = phyDoctor == null ? null : phyDoctor.trim();
    }

    public String getPhyConclusion() {
        return phyConclusion;
    }

    public void setPhyConclusion(String phyConclusion) {
        this.phyConclusion = phyConclusion == null ? null : phyConclusion.trim();
    }

    public String getPhyResultSuggest() {
        return phyResultSuggest;
    }

    public void setPhyResultSuggest(String phyResultSuggest) {
        this.phyResultSuggest = phyResultSuggest == null ? null : phyResultSuggest.trim();
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getExtend1() {
        return extend1;
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1 == null ? null : extend1.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getExtend2() {
        return extend2;
    }

    public void setExtend2(String extend2) {
        this.extend2 = extend2 == null ? null : extend2.trim();
    }

    public String getExtend3() {
        return extend3;
    }

    public void setExtend3(String extend3) {
        this.extend3 = extend3 == null ? null : extend3.trim();
    }

    public String getExtend4() {
        return extend4;
    }

    public void setExtend4(String extend4) {
        this.extend4 = extend4 == null ? null : extend4.trim();
    }

    public String getExtend5() {
        return extend5;
    }

    public void setExtend5(String extend5) {
        this.extend5 = extend5 == null ? null : extend5.trim();
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
        PhyStudentHealthInfoEntity other = (PhyStudentHealthInfoEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPhyStudentId() == null ? other.getPhyStudentId() == null : this.getPhyStudentId().equals(other.getPhyStudentId()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getBlood() == null ? other.getBlood() == null : this.getBlood().equals(other.getBlood()))
            && (this.getPulse() == null ? other.getPulse() == null : this.getPulse().equals(other.getPulse()))
            && (this.getChest() == null ? other.getChest() == null : this.getChest().equals(other.getChest()))
            && (this.getVitalCapacity() == null ? other.getVitalCapacity() == null : this.getVitalCapacity().equals(other.getVitalCapacity()))
            && (this.getFormDoctor() == null ? other.getFormDoctor() == null : this.getFormDoctor().equals(other.getFormDoctor()))
            && (this.getNakedLeft() == null ? other.getNakedLeft() == null : this.getNakedLeft().equals(other.getNakedLeft()))
            && (this.getNakedRight() == null ? other.getNakedRight() == null : this.getNakedRight().equals(other.getNakedRight()))
            && (this.getCorrectLeft() == null ? other.getCorrectLeft() == null : this.getCorrectLeft().equals(other.getCorrectLeft()))
            && (this.getCorrectRight() == null ? other.getCorrectRight() == null : this.getCorrectRight().equals(other.getCorrectRight()))
            && (this.getColorVision() == null ? other.getColorVision() == null : this.getColorVision().equals(other.getColorVision()))
            && (this.getTrachLeft() == null ? other.getTrachLeft() == null : this.getTrachLeft().equals(other.getTrachLeft()))
            && (this.getTrachRight() == null ? other.getTrachRight() == null : this.getTrachRight().equals(other.getTrachRight()))
            && (this.getEyesDoctor() == null ? other.getEyesDoctor() == null : this.getEyesDoctor().equals(other.getEyesDoctor()))
            && (this.getEar() == null ? other.getEar() == null : this.getEar().equals(other.getEar()))
            && (this.getNose() == null ? other.getNose() == null : this.getNose().equals(other.getNose()))
            && (this.getThroat() == null ? other.getThroat() == null : this.getThroat().equals(other.getThroat()))
            && (this.getEarNoseDoctor() == null ? other.getEarNoseDoctor() == null : this.getEarNoseDoctor().equals(other.getEarNoseDoctor()))
            && (this.getTooth() == null ? other.getTooth() == null : this.getTooth().equals(other.getTooth()))
            && (this.getPeriodontal() == null ? other.getPeriodontal() == null : this.getPeriodontal().equals(other.getPeriodontal()))
            && (this.getAnamnesis() == null ? other.getAnamnesis() == null : this.getAnamnesis().equals(other.getAnamnesis()))
            && (this.getHeart() == null ? other.getHeart() == null : this.getHeart().equals(other.getHeart()))
            && (this.getLung() == null ? other.getLung() == null : this.getLung().equals(other.getLung()))
            && (this.getLiver() == null ? other.getLiver() == null : this.getLiver().equals(other.getLiver()))
            && (this.getSpleen() == null ? other.getSpleen() == null : this.getSpleen().equals(other.getSpleen()))
            && (this.getInternalOther() == null ? other.getInternalOther() == null : this.getInternalOther().equals(other.getInternalOther()))
            && (this.getInternalDoctor() == null ? other.getInternalDoctor() == null : this.getInternalDoctor().equals(other.getInternalDoctor()))
            && (this.getSkin() == null ? other.getSkin() == null : this.getSkin().equals(other.getSkin()))
            && (this.getLymph() == null ? other.getLymph() == null : this.getLymph().equals(other.getLymph()))
            && (this.getThyroid() == null ? other.getThyroid() == null : this.getThyroid().equals(other.getThyroid()))
            && (this.getSpine() == null ? other.getSpine() == null : this.getSpine().equals(other.getSpine()))
            && (this.getLimbJoints() == null ? other.getLimbJoints() == null : this.getLimbJoints().equals(other.getLimbJoints()))
            && (this.getFlatfoot() == null ? other.getFlatfoot() == null : this.getFlatfoot().equals(other.getFlatfoot()))
            && (this.getPudendum() == null ? other.getPudendum() == null : this.getPudendum().equals(other.getPudendum()))
            && (this.getAnus() == null ? other.getAnus() == null : this.getAnus().equals(other.getAnus()))
            && (this.getSurgeryOther() == null ? other.getSurgeryOther() == null : this.getSurgeryOther().equals(other.getSurgeryOther()))
            && (this.getSurgeryDoctor() == null ? other.getSurgeryDoctor() == null : this.getSurgeryDoctor().equals(other.getSurgeryDoctor()))
            && (this.getChestDoctor() == null ? other.getChestDoctor() == null : this.getChestDoctor().equals(other.getChestDoctor()))
            && (this.getLiverFunction() == null ? other.getLiverFunction() == null : this.getLiverFunction().equals(other.getLiverFunction()))
            && (this.getBloodRoutine() == null ? other.getBloodRoutine() == null : this.getBloodRoutine().equals(other.getBloodRoutine()))
            && (this.getConclusion() == null ? other.getConclusion() == null : this.getConclusion().equals(other.getConclusion()))
            && (this.getPhyDoctor() == null ? other.getPhyDoctor() == null : this.getPhyDoctor().equals(other.getPhyDoctor()))
            && (this.getPhyConclusion() == null ? other.getPhyConclusion() == null : this.getPhyConclusion().equals(other.getPhyConclusion()))
            && (this.getPhyResultSuggest() == null ? other.getPhyResultSuggest() == null : this.getPhyResultSuggest().equals(other.getPhyResultSuggest()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getExtend1() == null ? other.getExtend1() == null : this.getExtend1().equals(other.getExtend1()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getExtend2() == null ? other.getExtend2() == null : this.getExtend2().equals(other.getExtend2()))
            && (this.getExtend3() == null ? other.getExtend3() == null : this.getExtend3().equals(other.getExtend3()))
            && (this.getExtend4() == null ? other.getExtend4() == null : this.getExtend4().equals(other.getExtend4()))
            && (this.getExtend5() == null ? other.getExtend5() == null : this.getExtend5().equals(other.getExtend5()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPhyStudentId() == null) ? 0 : getPhyStudentId().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getBlood() == null) ? 0 : getBlood().hashCode());
        result = prime * result + ((getPulse() == null) ? 0 : getPulse().hashCode());
        result = prime * result + ((getChest() == null) ? 0 : getChest().hashCode());
        result = prime * result + ((getVitalCapacity() == null) ? 0 : getVitalCapacity().hashCode());
        result = prime * result + ((getFormDoctor() == null) ? 0 : getFormDoctor().hashCode());
        result = prime * result + ((getNakedLeft() == null) ? 0 : getNakedLeft().hashCode());
        result = prime * result + ((getNakedRight() == null) ? 0 : getNakedRight().hashCode());
        result = prime * result + ((getCorrectLeft() == null) ? 0 : getCorrectLeft().hashCode());
        result = prime * result + ((getCorrectRight() == null) ? 0 : getCorrectRight().hashCode());
        result = prime * result + ((getColorVision() == null) ? 0 : getColorVision().hashCode());
        result = prime * result + ((getTrachLeft() == null) ? 0 : getTrachLeft().hashCode());
        result = prime * result + ((getTrachRight() == null) ? 0 : getTrachRight().hashCode());
        result = prime * result + ((getEyesDoctor() == null) ? 0 : getEyesDoctor().hashCode());
        result = prime * result + ((getEar() == null) ? 0 : getEar().hashCode());
        result = prime * result + ((getNose() == null) ? 0 : getNose().hashCode());
        result = prime * result + ((getThroat() == null) ? 0 : getThroat().hashCode());
        result = prime * result + ((getEarNoseDoctor() == null) ? 0 : getEarNoseDoctor().hashCode());
        result = prime * result + ((getTooth() == null) ? 0 : getTooth().hashCode());
        result = prime * result + ((getPeriodontal() == null) ? 0 : getPeriodontal().hashCode());
        result = prime * result + ((getAnamnesis() == null) ? 0 : getAnamnesis().hashCode());
        result = prime * result + ((getHeart() == null) ? 0 : getHeart().hashCode());
        result = prime * result + ((getLung() == null) ? 0 : getLung().hashCode());
        result = prime * result + ((getLiver() == null) ? 0 : getLiver().hashCode());
        result = prime * result + ((getSpleen() == null) ? 0 : getSpleen().hashCode());
        result = prime * result + ((getInternalOther() == null) ? 0 : getInternalOther().hashCode());
        result = prime * result + ((getInternalDoctor() == null) ? 0 : getInternalDoctor().hashCode());
        result = prime * result + ((getSkin() == null) ? 0 : getSkin().hashCode());
        result = prime * result + ((getLymph() == null) ? 0 : getLymph().hashCode());
        result = prime * result + ((getThyroid() == null) ? 0 : getThyroid().hashCode());
        result = prime * result + ((getSpine() == null) ? 0 : getSpine().hashCode());
        result = prime * result + ((getLimbJoints() == null) ? 0 : getLimbJoints().hashCode());
        result = prime * result + ((getFlatfoot() == null) ? 0 : getFlatfoot().hashCode());
        result = prime * result + ((getPudendum() == null) ? 0 : getPudendum().hashCode());
        result = prime * result + ((getAnus() == null) ? 0 : getAnus().hashCode());
        result = prime * result + ((getSurgeryOther() == null) ? 0 : getSurgeryOther().hashCode());
        result = prime * result + ((getSurgeryDoctor() == null) ? 0 : getSurgeryDoctor().hashCode());
        result = prime * result + ((getChestDoctor() == null) ? 0 : getChestDoctor().hashCode());
        result = prime * result + ((getLiverFunction() == null) ? 0 : getLiverFunction().hashCode());
        result = prime * result + ((getBloodRoutine() == null) ? 0 : getBloodRoutine().hashCode());
        result = prime * result + ((getConclusion() == null) ? 0 : getConclusion().hashCode());
        result = prime * result + ((getPhyDoctor() == null) ? 0 : getPhyDoctor().hashCode());
        result = prime * result + ((getPhyConclusion() == null) ? 0 : getPhyConclusion().hashCode());
        result = prime * result + ((getPhyResultSuggest() == null) ? 0 : getPhyResultSuggest().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getExtend1() == null) ? 0 : getExtend1().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getExtend2() == null) ? 0 : getExtend2().hashCode());
        result = prime * result + ((getExtend3() == null) ? 0 : getExtend3().hashCode());
        result = prime * result + ((getExtend4() == null) ? 0 : getExtend4().hashCode());
        result = prime * result + ((getExtend5() == null) ? 0 : getExtend5().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", phyStudentId=").append(phyStudentId);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", blood=").append(blood);
        sb.append(", pulse=").append(pulse);
        sb.append(", chest=").append(chest);
        sb.append(", vitalCapacity=").append(vitalCapacity);
        sb.append(", formDoctor=").append(formDoctor);
        sb.append(", nakedLeft=").append(nakedLeft);
        sb.append(", nakedRight=").append(nakedRight);
        sb.append(", correctLeft=").append(correctLeft);
        sb.append(", correctRight=").append(correctRight);
        sb.append(", colorVision=").append(colorVision);
        sb.append(", trachLeft=").append(trachLeft);
        sb.append(", trachRight=").append(trachRight);
        sb.append(", eyesDoctor=").append(eyesDoctor);
        sb.append(", ear=").append(ear);
        sb.append(", nose=").append(nose);
        sb.append(", throat=").append(throat);
        sb.append(", earNoseDoctor=").append(earNoseDoctor);
        sb.append(", tooth=").append(tooth);
        sb.append(", periodontal=").append(periodontal);
        sb.append(", anamnesis=").append(anamnesis);
        sb.append(", heart=").append(heart);
        sb.append(", lung=").append(lung);
        sb.append(", liver=").append(liver);
        sb.append(", spleen=").append(spleen);
        sb.append(", internalOther=").append(internalOther);
        sb.append(", internalDoctor=").append(internalDoctor);
        sb.append(", skin=").append(skin);
        sb.append(", lymph=").append(lymph);
        sb.append(", thyroid=").append(thyroid);
        sb.append(", spine=").append(spine);
        sb.append(", limbJoints=").append(limbJoints);
        sb.append(", flatfoot=").append(flatfoot);
        sb.append(", pudendum=").append(pudendum);
        sb.append(", anus=").append(anus);
        sb.append(", surgeryOther=").append(surgeryOther);
        sb.append(", surgeryDoctor=").append(surgeryDoctor);
        sb.append(", chestDoctor=").append(chestDoctor);
        sb.append(", liverFunction=").append(liverFunction);
        sb.append(", bloodRoutine=").append(bloodRoutine);
        sb.append(", conclusion=").append(conclusion);
        sb.append(", phyDoctor=").append(phyDoctor);
        sb.append(", phyConclusion=").append(phyConclusion);
        sb.append(", phyResultSuggest=").append(phyResultSuggest);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", createTime=").append(createTime);
        sb.append(", extend1=").append(extend1);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", extend2=").append(extend2);
        sb.append(", extend3=").append(extend3);
        sb.append(", extend4=").append(extend4);
        sb.append(", extend5=").append(extend5);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}