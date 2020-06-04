package com.chuweizi.visualization.entity;


import lombok.Data;

import java.util.List;

@Data
public class NbRoom {

  private long id;
  private long districtId;
  private String districtName;
  private long buildingId;
  private String buildingName;
  private String serial;
  private String name;
  private String address;
  private long level;
  private String appid;
  private long useType;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;
  private java.sql.Timestamp deletedAt;
  private long status;
  private String code;

  List<NbPerson> personList;
}
