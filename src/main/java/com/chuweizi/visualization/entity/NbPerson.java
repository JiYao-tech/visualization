package com.chuweizi.visualization.entity;

import lombok.Data;

import java.util.List;

@Data
public class NbPerson {

  private long id;
  private String name;
  private String mobile;
  private String email;
  private String idCode;
  private String idTypeDict;
  private long gender;
  private String ethnicDict;
  private java.sql.Timestamp birthday;
  private String educationDict;
  private String domAddress;
  private String domDict;
  private String residentDict;
  private String reasonDict;
  private String birthplaceDict;
  private String occupationDict;
  private String marriageDict;
  private String nationalityDict;
  private String photoUrl;
  private java.sql.Timestamp photoDate;
  private String address;
  private String company;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;
  private java.sql.Timestamp deletedAt;

  private List<NbRoom> roomList;
}
