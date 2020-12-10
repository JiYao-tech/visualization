package com.chuweizi.script.service;


/**
 * 修改照片名称
 * @author 36536
 */
public interface ReadExcelService {

    /**
     * 根据特定文件格式修改照片名称
     */
    void updatePhotoName(String path);

    /**
     *读取excel文件，修改照片名称
     *path excel文件路径
     */
    void readExcelUpdatePhotoName(String path);

    /**
     * 效验身份证号
     */
    void verifyIdCard(String path);
}
