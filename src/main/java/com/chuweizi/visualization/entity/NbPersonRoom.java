package com.chuweizi.visualization.entity;

import lombok.Data;

@Data
public class NbPersonRoom {

  /*private long id;
  private long districtId;
  private long buildingId;
  private long roomId;
  private String roomName;
  private long personId;
  private long level;
  private long category;
  private String relation;
  private java.sql.Timestamp startedAt;
  private java.sql.Timestamp endedAt;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;
  private java.sql.Timestamp deletedAt;
  private long resident;*/

  private String name;
  private String idCode;
  private Long buildingId;
  private String address;
  private Long personId;
  private String roomName;

}
