package com.chuweizi.script.read;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.chuweizi.script.entity.excel.Person;
import com.chuweizi.script.utils.IdUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 模板的读取类
 *
 * @author Jiaju Zhuang
 */
public class VerifyIdCardListener extends AnalysisEventListener<Person> {
    private static final Logger LOGGER = LoggerFactory.getLogger(VerifyIdCardListener.class);
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
            VerifyIdCard();
            personList.clear();
        }
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        VerifyIdCard();
        System.out.println(count);
        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 效验身份证号
     */
    private void VerifyIdCard(){
        for (Person person : personList) {
            if(!IdUtils.isIDNumber(person.getCardId())){
                LOGGER.info("身份证不合法的人员信息:{}",person);
            }
        }
    }
}
