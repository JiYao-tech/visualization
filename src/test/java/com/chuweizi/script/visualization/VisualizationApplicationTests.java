package com.chuweizi.script.visualization;

import com.chuweizi.script.VisualizationApplication;
import com.chuweizi.script.entity.property.TGridPerson;
import com.chuweizi.script.entity.visualization.NbPersonRoom;
import com.chuweizi.script.mapper.Property.PersonMapper;
import com.chuweizi.script.mapper.visualization.PersonRoomMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= VisualizationApplication.class)
public class VisualizationApplicationTests {

    @Autowired
    PersonRoomMapper personRoomMapper;

    @Autowired
    PersonMapper personMapper;

    //可视化实有人口
    @Test
    public void testFindByDistrictIdVisualization(){
        List<NbPersonRoom> personRoomList = personRoomMapper.findByDistrictId(30L);
        System.out.println(personRoomList);
        System.out.println(personRoomList.size());
    }

    //物业实有人口
    @Test
    public void testFindByDistrictIdProperty(){
        List<TGridPerson> personList = personMapper.findByDistrictId(40L);
        System.out.println(personList);
        System.out.println(personList.size());
    }
}
