package com.huiyi.campus.common.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: yzg
 * @time: 2020/12/21 14:24
 * @description: Excel 工具类
 */
public class ExcelUtils {

    private final static Log log = LogFactory.getLog(ExcelUtils.class);

    /**
     * 方法名：importExcel
     * 功能：导入
     */
    public static List<Object[]> importExcel(String fileName) {
        log.info("导入解析开始，fileName:" + fileName);
        try {
            List<Object[]> list = new ArrayList<>();
            InputStream inputStream = new FileInputStream(fileName);
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            //获取sheet的行数
            int rows = sheet.getPhysicalNumberOfRows();
            for (int i = 0; i < rows; i++) {
                //过滤表头行
                if (i == 0) {
                    continue;
                }
                //获取当前行的数据
                Row row = sheet.getRow(i);
                Object[] objects = new Object[row.getPhysicalNumberOfCells()];
                int index = 0;
                for (Cell cell : row) {
                    if (cell.getCellType().equals(CellType.NUMERIC)) {
                        objects[index] = (int) cell.getNumericCellValue();
                    }
                    if (cell.getCellType().equals(CellType.STRING)) {
                        objects[index] = cell.getStringCellValue();
                    }
                    if (cell.getCellType().equals(CellType.BOOLEAN)) {
                        objects[index] = cell.getBooleanCellValue();
                    }
                    if (cell.getCellType().equals(CellType.ERROR)) {
                        objects[index] = cell.getErrorCellValue();
                    }
                    index++;
                }
                list.add(objects);
            }
            log.info("导入文件解析成功！");
            return list;
        }catch (Exception e){
            log.info("导入文件解析失败！");
            e.printStackTrace();
        }
        return null;
    }

}
