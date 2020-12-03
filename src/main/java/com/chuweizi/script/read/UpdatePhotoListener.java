package com.chuweizi.script.read;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.chuweizi.script.entity.excel.Person;
import com.chuweizi.script.utils.IdUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 模板的读取类
 *
 * @author Jiaju Zhuang
 */
public class UpdatePhotoListener extends AnalysisEventListener<Person> {
    private static final Logger LOGGER = LoggerFactory.getLogger(UpdatePhotoListener.class);
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 2500;
    List<Person> personList = new ArrayList<Person>();

    int count = 0;

    @Override
    public void invoke(Person data, AnalysisContext context) {
        //LOGGER.info("解析到一条数据:{}", JSON.toJSONString(data));
        personList.add(data);
        if (personList.size() >= BATCH_COUNT) {
            updateName();
            personList.clear();
        }
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        updateName();
        System.out.println(count);
        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 读取excel，修改文件名称
     */
    private void updateName() {
        //LOGGER.info("{}条数据，开始业务数据！", personList.size());

        String path = "C:\\Users\\36536\\Desktop\\鸿发照片";

        File file = new File(path);
        File[] fileList = file.listFiles();

        // 如果目录下文件存在
        if (file.exists() && file.isDirectory() && fileList!=null)
        {
            for (File value : fileList) {
                //取出文件名称
                String name = value.getName();
                int index = name.lastIndexOf("_");
                int indexOf = name.lastIndexOf(".");
                if(index == -1 || indexOf == -1){
                    System.out.println(name);
                    continue;
                }
                //人员姓名
                String newName = name.substring(0, index);
                //人员工号
                String numBer = name.substring(index+1, indexOf);
                //文件后缀
                String s = name.substring(indexOf);
                for (Person person : personList) {
                    if(person.getName().equals(newName) && person.getNumBer().equals(numBer) && person.getCardId() != null && person.getCardId() != ""){
                        //重命名
                        File newFile = new File(path + "\\" + person.getCardId()+s);
                        boolean rename = value.renameTo(newFile);
                        if (rename){
                            LOGGER.info("原始文件路径：{}", value.getPath());
                            LOGGER.info("改名成功的文件路径：{}",newFile.getPath());
                            count++;
                        }
                    }
                }
            }
        }
    }
}
