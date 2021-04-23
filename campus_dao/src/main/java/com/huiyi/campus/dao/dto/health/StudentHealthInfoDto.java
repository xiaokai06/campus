package com.huiyi.campus.dao.dto.health;

import com.huiyi.campus.dao.entity.phy.PhyItemResultEntity;
import com.huiyi.campus.dao.vo.health.PhyItemResultBloodVo;
import com.huiyi.campus.dao.vo.health.PhyItemResultLiverVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: 学生健康档案信息Dto
 * @date: 2021-03-28 20:32
 * @Version V1.0
 */
@Getter
@Setter
@ApiModel("学生健康档案信息Dto")
public class StudentHealthInfoDto {
    @ApiModelProperty("学校机构id")
    private String schoolId;
    @ApiModelProperty("体检id")
    private String id;
    @ApiModelProperty("学生id")
    private String phyStudentId;
    @ApiModelProperty("身高")
    private BigDecimal height;
    @ApiModelProperty("体重")
    private BigDecimal weight;
    @ApiModelProperty("血压")
    private String blood;
    @ApiModelProperty("脉搏")
    private String pulse;
    @ApiModelProperty("胸围")
    private String bust;
    @ApiModelProperty("肺活量")
    private String vitalCapacity;
    @ApiModelProperty("形态机能医师")
    private String formDoctor;
    @ApiModelProperty("左裸眼")
    private BigDecimal nakedLeft;
    @ApiModelProperty("右裸眼")
    private BigDecimal nakedRight;
    @ApiModelProperty("左矫正")
    private BigDecimal correctLeft;
    @ApiModelProperty("右矫正")
    private BigDecimal correctRight;
    @ApiModelProperty("辨色力 0正常 1异常")
    private Integer colorVision;
    @ApiModelProperty("辨色力异常备注")
    private String colorVisionErrorText;
    @ApiModelProperty("左沙眼")
    private BigDecimal trachLeft;
    @ApiModelProperty("右沙眼")
    private BigDecimal trachRight;
    @ApiModelProperty("眼科医师")
    private String eyesDoctor;
    @ApiModelProperty("耳 0正常 1异常")
    private Integer ear;
    @ApiModelProperty("鼻 0正常 1异常")
    private Integer nose;
    @ApiModelProperty("咽喉（扁桃体）0无充血 1充血 2淋巴滤泡增生")
    private Integer throat;
    @ApiModelProperty("鼻异常备注")
    private String noseErrorText;
    @ApiModelProperty("耳异常备注")
    private String earErrorText;
    @ApiModelProperty("耳鼻科医师")
    private String earNoseDoctor;
    @ApiModelProperty("牙齿 0 正常 1缺齿 2 龋齿 3 义齿（假牙）")
    private Integer tooth;
    @ApiModelProperty("牙周 0正常 1异常")
    private Integer periodontal;
    @ApiModelProperty("口腔医师签名")
    private String OralCavityDoctor;
    @ApiModelProperty("既往病史 0 无 1有")
    private Integer anamnesis;
    @ApiModelProperty("脾 0正常 1异常")
    private Integer spleen;
    @ApiModelProperty("心 0正常 1异常")
    private Integer heart;
    @ApiModelProperty("肺 0 正常 1异常")
    private Integer lung;
    @ApiModelProperty("肺异常备注")
    private String lungErrorText;
    @ApiModelProperty("肝 0正常 1异常")
    private Integer liver;
    @ApiModelProperty("内科其他")
    private String internalOther;
    @ApiModelProperty("肝异常备注")
    private String liverErrorText;
    @ApiModelProperty("桶状胸 0否 1是")
    private Integer barrelChest;
    @ApiModelProperty("桶状胸备注")
    private String barrelChestText;
    @ApiModelProperty("呼吸音 0 正常 1 异常")
    private Integer breathSounds;
    @ApiModelProperty("呼吸音异常备注")
    private String breathSoundsErrorText;
    @ApiModelProperty("罗音 0 无 1 干罗音 2 湿罗音 3 其他")
    private Integer rae;
    @ApiModelProperty("罗音备注")
    private String raeText;
    @ApiModelProperty("心异常备注")
    private String heartErrorText;
    @ApiModelProperty("心率")
    private String heartRate;
    @ApiModelProperty("心率 0齐 1不齐 2绝对不齐")
    private Integer heartRhythm;
    @ApiModelProperty("杂音 0 无 1有")
    private Integer murmur;
    @ApiModelProperty("杂音异常备注")
    private String murmurErrorText;
    @ApiModelProperty("脾异常备注")
    private String spleenErrorText;
    @ApiModelProperty("既往病史备注")
    private String anamnesisText;
    @ApiModelProperty("牙周异常备注")
    private String periodontalErrorText;
    @ApiModelProperty("内科医师")
    private String internalDoctor;
    @ApiModelProperty("皮肤 0 正常 1潮红 2苍白 3发绀 4黄染 5色素沉着 6其他")
    private Integer skin;
    @ApiModelProperty("淋巴腺 0正常 1未触及 2锁骨上 3腋窝 4其他")
    private Integer lymph;
    @ApiModelProperty("甲状腺 0正常 1肿大 2其他")
    private Integer thyroid;
    @ApiModelProperty("脊柱 0正常 1异常")
    private Integer spine;
    @ApiModelProperty("四肢关节 0正常 1异常")
    private Integer limbJoints;
    @ApiModelProperty("扁平足 0无 1有")
    private Integer flatfoot;
    @ApiModelProperty("外生殖器 0正常 1异常")
    private Integer pudendum;
    @ApiModelProperty("肛门 0未及异常 1触痛 2包块 3前列腺异常 4其他")
    private Integer anus;
    @ApiModelProperty("肛门备注")
    private String anusText;
    @ApiModelProperty("外生殖器异常备注")
    private String pudendumErrorText;
    @ApiModelProperty("扁平足备注")
    private String flatfootText;
    @ApiModelProperty("四肢关节异常备注")
    private String limbJointsErrorText;
    @ApiModelProperty("脊柱异常备注")
    private String spineErrorText;
    @ApiModelProperty("甲状腺备注")
    private String thyroidText;
    @ApiModelProperty("淋巴腺备注")
    private String lymphText;
    @ApiModelProperty("皮肤备注")
    private String skinText;
    @ApiModelProperty("外科其他")
    private String surgeryOther;
    @ApiModelProperty("外科医师")
    private String surgeryDoctor;
    @ApiModelProperty("胸透 0正常 1异常")
    private Integer chest;
    @ApiModelProperty("胸透异常备注")
    private String chestErrorText;
    @ApiModelProperty("胸透医师")
    private String chestDoctor;
    @ApiModelProperty("肝功能 0正常 1异常")
    private String liverFunction;
    @ApiModelProperty("血常规 0正常 1异常")
    private String bloodRoutine;
    @ApiModelProperty("血常规异常备注")
    private String bloodRoutineErrorText;
    @ApiModelProperty("肝功能异常备注")
    private String liverFunctionErrorText;
    @ApiModelProperty("体检健康评价 0体检无异常 1有异常")
    private Integer phyConclusion;
    @ApiModelProperty("健康评价异常备注")
    private String phyConclusionErrorText;
    @ApiModelProperty("建议复查 0是 1否")
    private Integer review;
    @ApiModelProperty("建议转诊 0是 1否")
    private Integer referral;
    @ApiModelProperty("定期体检 0是 1否")
    private Integer regularCensor;
    @ApiModelProperty("个性化健康教育 0是 1否")
    private Integer healthEducation;
    @ApiModelProperty("饮食 0是 1否")
    private Integer diet;
    @ApiModelProperty("锻炼 0是 1否")
    private Integer forging;
    @ApiModelProperty("建议疫苗接种 0是 1否")
    private Integer vaccination;
    @ApiModelProperty("健康指导备注")
    private String phyGuideText;
    @ApiModelProperty("医师签名")
    private String phyDoctor;
    @ApiModelProperty("删除标志(0:未删，1:已删)")
    private Integer delFlag;
    @ApiModelProperty("体检日期")
    private String phyDate;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("创建人")
    private String createUser;
    @ApiModelProperty("更新时间")
    private Date updateTime;
    @ApiModelProperty("更新人")
    private String updateUser;
    @ApiModelProperty("合格标志 0合格 1未合格")
    private Integer qualifiedStatus;

    @ApiModelProperty("肝功能检验项目结果数据")
    private List<PhyItemResultLiverVo> liverFunctionItemList;
    @ApiModelProperty("血常规检验项目结果数据")
    private List<PhyItemResultBloodVo> bloodRoutineItemList;

}
