//package com.huiyi.campus.common.utils.area;
//
//import com.alibaba.fastjson.JSONObject;
////import com.huiyi.campus.dao.entity.systil.SysAreasEntity;
//import com.huiyi.campus.dao.mapper.web.sys.SysAreasMapper;
//import org.apache.commons.lang3.StringUtils;
//import org.jsoup.Jsoup;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @author: liyukai
// * @Email: 2919529566@qq.com
// * @Description:
// * @date: 2021-04-06 16:01
// * @Version V1.0
// */
//public class AreaSpider {
//    // 爬取目标
//    private static final String TARGET = "http://preview.www.mca.gov.cn/article/sj/xzqh/2020/2020/202101041104.html";
//
//    @Test
//    public void test() throws IOException {
//        SysAreasEntity sysAreasEntity = new SysAreasEntity();
//        // 请求网页
//        List<Area> areaList = Jsoup.connect(TARGET).timeout(10000).get()
//                // 筛选出 tr 标签
//                .select("tr")
//                // 筛选出 tr 下的 td 标签
//                .stream().map(tr -> tr.select("td")
//                        // 过滤 值为空的 td 标签，并转换为 td 列表
//                        .stream().filter(td -> StringUtils.isNotBlank(td.text())).collect(Collectors.toList()))
//                // 前面提到，区域码和区域名称分别存储在 第一和第二个td，所以过滤掉不符合规范的数据行。
//                .filter(e -> e.size() == 2)
//                // 转换为 area 对象
//                .map(e -> new Area(e.get(0).text(), e.get(1).text(), calcParent(e.get(0).text()))).collect(Collectors.toList());
//
//        // 去除 第一行 "行政区划代码|单位名称"
//        areaList.remove(0);
//
//
//        areaList.forEach(area -> {
//            sysAreasEntity.setId(Integer.valueOf(area.getCode()));
//            sysAreasEntity.setName(area.getName());
//            sysAreasEntity.setPid(area.getParent());
//        });
//
//    }
//
//    private static String calcParent(String areaCode){
//        // 省 - 针对第一行特殊处理
//        if(areaCode.contains("0000") || areaCode.equals("行政区划代码")){
//            return "0";
//            // 市
//        }else if (areaCode.contains("00")) {
//            return String.valueOf(Integer.parseInt(areaCode) / 10000 * 10000);
//            // 区
//        }else {
//            return String.valueOf(Integer.parseInt(areaCode) / 100 * 100);
//        }
//    }
//}
