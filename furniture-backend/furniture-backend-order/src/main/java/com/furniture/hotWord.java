package com.furniture;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class hotWord {
    public static void main(String[] args) {


        String strArray = "优美,方便,便宜,爽,靠谱,服务,累,麻烦,排队,延迟,独特," +
                "免费,服务,神奇,干净,风景,丰盛,繁华,星级,情怀,无异味,异味,温泉,环境,脏,A03,A01,ABC,收费,学生,吓,路线,景点,轻松,美,广东,刺激,惊险,贵,亲子,喜欢,可爱,剧场";

        try {

            String[] split = strArray.split(",");
            //拿到所有的热门词
            List<String> strings = Arrays.asList(split);
            HashMap<String,Integer> map = new HashMap();
            for (String string : strings) {
                map.put(string,0);
            }


            //    Map<Integer, Apple> appleMap = appleList.stream().collect(Collectors.toMap(Apple::getId, a -> a,(k1,k2)->k1));

            XSSFWorkbook workbook=new XSSFWorkbook("C:\\bicc\\untitled\\src\\景区评论（样例数据）.xlsx");
            XSSFWorkbook workbook2=new XSSFWorkbook("/酒店评论（样例数据）.xlsx");



            getMap(workbook,map);
            getMap(workbook2,map);





      /*      for (Map.Entry<String, Integer> ent : map.entrySet()) {
                System.out.println(ent.getKey()+":"+ent.getValue());


            }*/

            System.out.println("序号、热门词:出现次数");

            List<Map.Entry<String,Integer>> lstEntry=new ArrayList<>(map.entrySet());
            Collections.sort(lstEntry,((o1, o2) -> {

                return o2.getValue()-(o1.getValue());
            }));


            for (int i = 0; i < lstEntry.size(); i++) {
                System.out.println((i+1)+"、"+lstEntry.get(i).getKey()+":"+lstEntry.get(i).getValue());

            }
            createExcel(lstEntry);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static void getMap(XSSFWorkbook workbook,  HashMap<String,Integer> map){
        //获取工作表，既可以根据工作表的顺序获取，也可以根据工作表的名称获取
        XSSFSheet sheet=workbook.getSheetAt(0);
        //获取当前工作表最后一行的行号，行号从0开始
        int lastRowNum=sheet.getLastRowNum();

        for(int i=0;i<=lastRowNum;i++){
            //根据行号获取行对象
            XSSFRow row=sheet.getRow(i);
            short lastCellNum=row.getLastCellNum();

            for(short j=0;j<lastCellNum;j++){

                if (j==2){
                    String value=row.getCell(j).getStringCellValue();

                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        String key = entry.getKey();
                        int i1 = countStr(value, key);
                        Integer count = entry.getValue();
                        count += i1;
                        entry.setValue(count);

                    }

                }

            }
        }

    }



    public static void createExcel(List<Map.Entry<String,Integer>> list){

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("印象词云表");

        for (int i = 0; i < list.size(); i++) {

            XSSFRow row = sheet.createRow(i);

            Map.Entry<String, Integer> map = list.get(i);

            row.createCell(0).setCellValue(i);;
            row.createCell(1).setCellValue(map.getKey());
            row.createCell(2).setCellValue(map.getValue());

        }
        try {
            FileOutputStream outputStream = new FileOutputStream("/印象词云表.xls");


            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    /**
     * 判断str1中包含str2的个数
     * @param str1
     * @param str2
     * @return counter
     */
    public static int countStr(String str1, String str2) {
        int counter =0;
        if (str1.indexOf(str2) == -1) {
            return 0;
        } else if (str1.indexOf(str2) != -1) {
            counter++;
            countStr(str1.substring(str1.indexOf(str2) +
                    str2.length()), str2);
            return counter;
        }
        return 0;
    }

}
