package com.huiyi.campus.dao.dto.health;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description:
 * @date: 2021-03-28 20:32
 * @Version V1.0
 */
@Getter
@Setter
@ApiModel("学生健康档案信息Dto")
public class StudentHealthInfoDto {

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
    private String chest;
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
    @ApiModelProperty("辨色力")
    private BigDecimal colorVision;
    @ApiModelProperty("左沙眼")
    private BigDecimal trachLeft;
    @ApiModelProperty("右沙眼")
    private BigDecimal trachRight;
    @ApiModelProperty("眼科医师")
    private String eyesDoctor;
    @ApiModelProperty("耳")
    private String ear;
    @ApiModelProperty("鼻")
    private String nose;
    @ApiModelProperty("咽喉（扁桃体）")
    private String throat;
    @ApiModelProperty("耳鼻科医师")
    private String earNoseDoctor;
    @ApiModelProperty("牙齿")
    private String tooth;
    @ApiModelProperty("牙周")
    private String periodontal;
    @ApiModelProperty("既往病史")
    private String anamnesis;
    @ApiModelProperty("心")
    private String heart;
    @ApiModelProperty("肺")
    private String lung;
    @ApiModelProperty("肝")
    private String liver;
    @ApiModelProperty("脾")
    private String spleen;
    @ApiModelProperty("内科其他")
    private String internalOther;
    @ApiModelProperty("内科医师")
    private String internalDoctor;
    @ApiModelProperty("皮肤")
    private String skin;
    @ApiModelProperty("淋巴腺")
    private String lymph;
    @ApiModelProperty("甲状腺")
    private String thyroid;
    @ApiModelProperty("脊柱")
    private String spine;
    @ApiModelProperty("四肢关节")
    private String limbJoints;
    @ApiModelProperty("扁平足")
    private String flatfoot;
    @ApiModelProperty("外生殖器")
    private String pudendum;
    @ApiModelProperty("肛门")
    private String anus;
    @ApiModelProperty("外科其他")
    private String surgeryOther;
    @ApiModelProperty("外科医师")
    private String surgeryDoctor;
    @ApiModelProperty("胸透医师")
    private String chestDoctor;
    @ApiModelProperty("肝功能")
    private String liverFunction;
    @ApiModelProperty("血常规")
    private String bloodRoutine;
    @ApiModelProperty("结论")
    private String conclusion;
    @ApiModelProperty("医师签名")
    private String phyDoctor;
    @ApiModelProperty("体检结论")
    private String phyConclusion;
    @ApiModelProperty("体检结果建议")
    private String phyResultSuggest;
    @ApiModelProperty("删除标志(0:未删，1:已删)")
    private Byte delFlag;
}
