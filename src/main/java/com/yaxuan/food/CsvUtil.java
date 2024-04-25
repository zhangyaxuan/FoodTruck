package com.yaxuan.food;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


public class CsvUtil {
    /**
     * 解析csv文件并转成bean
     *
     * @param file  csv文件
     * @param clazz 类
     * @param <T>   泛型
     * @return 泛型bean集合
     */
    public static <T> List<T> getCsvData(String fileName, Class<T> clazz) {
        try {
            String classpath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            String filePath = classpath + fileName;
            FileReader reader = new FileReader(filePath);
            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                    .withType(clazz)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<T> dataList = csvToBean.parse();
            reader.close();
            return dataList;
        } catch (FileNotFoundException e){
            System.out.println("文件不存在");
        } catch (Exception e) {
            System.out.println("数据解析错误");
        }
        return null;
    }
}
