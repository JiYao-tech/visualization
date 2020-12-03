package com.chuweizi.script.service;

import java.util.List;

/**
 * 修改照片名称
 * @author 36536
 */
public interface ReadExcelService {

    /**
     * 根据特定文件格式修改照片名称
     */
    void updatePhotoName();

    /**
     *读取excel文件，修改照片名称
     */
    void readExcelUpdatePhotoName();

    /**
     * 效验身份证号
     */
    void verifyIdCard();
}
