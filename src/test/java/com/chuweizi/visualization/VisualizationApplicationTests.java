package com.chuweizi.visualization;

import com.chuweizi.visualization.entity.NbPerson;
import com.chuweizi.visualization.entity.NbPersonRoom;
import com.chuweizi.visualization.entity.NbRoom;
import com.chuweizi.visualization.mapper.PersonMapper;
import com.chuweizi.visualization.mapper.PersonRoomMapper;
import com.chuweizi.visualization.mapper.RoomMapper;
import io.swagger.annotations.ApiImplicitParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=VisualizationApplication.class)
public class VisualizationApplicationTests {

    @Autowired
    PersonRoomMapper personRoomMapper;

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    PersonMapper personMapper;

    @Test
    public void testFindAll(){
        List<NbPersonRoom> personRoomList = personRoomMapper.findAll(30L);
        System.out.println(personRoomList);
        System.out.println(personRoomList.size());
    }

    /*@Test
    public void testFindBydistrictId(){
        List<NbRoom> roomList = roomMapper.findBydistrictId(30L);
        System.out.println(roomList);
        System.out.println(roomList.size());
    }*/

    @Test
    public void testFindBydistrictId(){
        List<NbPerson> personList = personMapper.findBydistrictId(30L);
        System.out.println(personList);
        System.out.println(personList.size());
    }
}
