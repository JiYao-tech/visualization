package com.chuweizi.script.service.impl;

import com.alibaba.excel.EasyExcel;
import com.chuweizi.script.entity.excel.Person;
import com.chuweizi.script.read.UpdatePhotoListener;
import com.chuweizi.script.read.VerifyIdCardListener;
import com.chuweizi.script.service.ReadExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author 36536
 */

@Service
public class ReadExcelServiceImpl implements ReadExcelService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdatePhotoListener.class);


    @Override
    public void updatePhotoName(String path) {

        File file = new File(path);
        File[] list = file.listFiles();

        int count = 0;

        // 如果目录下文件存在
        if (file.exists() && file.isDirectory() && list!=null)
        {
            for (File value : list) {
                //取出文件名称
                String name = value.getName();
                //截取需要的文件名
                String updateName = name.substring(name.lastIndexOf("_") + 1);
                //重命名
                File newFile = new File(path + updateName);
                boolean rename = value.renameTo(newFile);
                if (rename){
                    LOGGER.info("原始文件路径：{}", value.getPath());
                    LOGGER.info("改名成功的文件路径：{}",newFile.getPath());
                    count++;
                }
                System.out.println(newFile.getName());
            }
        }
    }

    @Override
    public void readExcelUpdatePhotoName(String path) {
        // 这里默认读取第一个sheet
        EasyExcel.read(path, Person.class, new UpdatePhotoListener()).sheet().doRead();

    }

    @Override
    public void verifyIdCard(String path) {
        // 这里默认读取第一个sheet
        EasyExcel.read(path, Person.class, new VerifyIdCardListener()).sheet().doRead();
    }
}
