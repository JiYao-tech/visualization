package com.chuweizi.script.visualization;

import com.chuweizi.script.SmartCommunityApplication;
import com.chuweizi.script.mapper.master.DistrictMepper;
import com.chuweizi.script.mapper.master.PersonRoomMapper;
import com.chuweizi.script.mapper.third.UserMepper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= SmartCommunityApplication.class)
public class SmartCommunityApplicationTests {

    @Autowired
    PersonRoomMapper personRoomMapper;

    @Autowired
    DistrictMepper districtMepper;

    @Autowired
    CustomerMepper customerMepper;

    @Autowired
    UserMepper userMepper;

}
