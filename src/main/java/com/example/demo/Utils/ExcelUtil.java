package com.example.demo.Utils;

import com.example.demo.domain.ExcelData;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

//导出excel工具类
public class ExcelUtil {
    /*****
     *
     * @param response
     * @param fileName 输出时文件的名字
     * @param excelData 传进来的对象
     *  输出文件的后缀名 .xls   'xls'        => 'application/vnd.ms-excel',
     *   API  XSSF是指2007年版本以上的(XSSFWorkbook)
     */
    public  static void exportExcel(HttpServletResponse response, String fileName, ExcelData excelData) throws Exception {

            response.setHeader("content-Type", "application/vnd.ms-excel");
            //下载文件
            response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName+".xlsx", "utf-8"));
            exportExcel(excelData, response.getOutputStream());
    }

    public static void exportExcel(ExcelData data, OutputStream out) throws Exception {
        //创建一个excel
        XSSFWorkbook xsf = new XSSFWorkbook();
        String name = data.getName();
        name = name.trim();
        if(name==null || name ==""){
            name = "数据1";
        }
        //创建一个标签
        XSSFSheet sheet = xsf.createSheet(name);
        writeExcel(xsf,sheet , data);
        try {
            xsf.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            out.close();
        }
    }

    /***
     *
     * @param xsf excel对象
     * @param sheet 标签
     * @param data 数据
     */
    //写进excel
    public static void writeExcel(XSSFWorkbook xsf, Sheet sheet, ExcelData data){
        int rowIndex = 0;
            //写标题(第一行====包含样式)
            rowIndex = writeTitlesToExcel(xsf, sheet, data.getTitles());
            //写内容(中间的=====包含表的样式)
            writeRowsToExcel(xsf, sheet,data.getRows(), rowIndex);
            //单元格大小
            autoSizeColumns(sheet, data.getTitles().size() + 1);
    }

    private static int writeTitlesToExcel(XSSFWorkbook xsf, Sheet sheet, List<String> titles){
        int rowIndex = 0;
        int colIndex = 0;
        Font titleFont = xsf.createFont();
        //字体
        titleFont.setFontName("华文琥珀");
        titleFont.setColor(IndexedColors.BLACK.index);

        //样式
        XSSFCellStyle titleStyle = xsf.createCellStyle();
        titleStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
        titleStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(135,206,250)));
        titleStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        titleStyle.setFont(titleFont);
        titleStyle.setBorderTop(BorderStyle.THICK);//上边框
        titleStyle.setBorderBottom(BorderStyle.THICK);//下边框
        titleStyle.setBorderLeft(BorderStyle.THICK);//左
        titleStyle.setBorderRight(BorderStyle.THICK);//右

        //rowIndex=0创建首行(title)
        Row titleRow = sheet.createRow(rowIndex);
        //首行的内容
        for (String field : titles) {
            //设置行中单元格内容
            Cell cell = titleRow.createCell(colIndex);
            cell.setCellValue(field);
            cell.setCellStyle(titleStyle);
            colIndex++;
        }
        rowIndex++;//下一行

        return rowIndex;
    }

    /***
     *
     * @param xsf  excel对象
     * @param sheet 标签名
     * @param rows  数据
     * @param rowIndex 行
     * @return
     */
    private static int writeRowsToExcel(XSSFWorkbook xsf, Sheet sheet, List<List<Object>> rows, int rowIndex) {
        int colIndex = 0;

        Font dataFont = xsf.createFont();
        //字体
        dataFont.setFontName("黑体");
        dataFont.setColor(IndexedColors.BLACK.index);

        //样式
        XSSFCellStyle dataStyle = xsf.createCellStyle();
        dataStyle.setAlignment(HorizontalAlignment.LEFT);//偏左
        dataStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
        dataStyle.setFont(dataFont);
        dataStyle.setBorderTop(BorderStyle.THIN);//上边框
        dataStyle.setBorderBottom(BorderStyle.THIN);//下边框
        dataStyle.setBorderLeft(BorderStyle.THIN);//左
        dataStyle.setBorderRight(BorderStyle.THIN);//右

        for (List<Object> rowData : rows) {
            //创建一行
            Row dataRow = sheet.createRow(rowIndex);
            //列从零开始
            colIndex = 0;

            for (Object cellData : rowData) {
                Cell cell = dataRow.createCell(colIndex);
                if (cellData != null) {
                    cell.setCellValue(cellData.toString());
                } else {
                    //无数据就""
                    cell.setCellValue("");
                }

                cell.setCellStyle(dataStyle);
                colIndex++;
            }
            rowIndex++;
        }
        return rowIndex;
    }

    private static void autoSizeColumns(Sheet sheet, int columnNumber) {

        for (int i = 0; i < columnNumber; i++) {
            int orgWidth = sheet.getColumnWidth(i);
            sheet.autoSizeColumn(i, true);
            int newWidth = (int) (sheet.getColumnWidth(i) + 100);
            if (newWidth > orgWidth) {
                sheet.setColumnWidth(i, newWidth);
            } else {
                sheet.setColumnWidth(i, orgWidth);
            }
        }
    }








}
