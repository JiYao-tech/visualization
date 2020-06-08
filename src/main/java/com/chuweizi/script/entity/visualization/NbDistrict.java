package com.chuweizi.script.entity.visualization;


import lombok.Data;

@Data
public class NbDistrict {

  private long id;
  private String serial;
  private String name;
  private long regionId;
  private String community;
  private String address;
  private String street;
  private String streetNo;
  private String postalCode;
  private String bureau;
  private String dutyZoneSerial;
  private String bureauSerial;
  private String estateManager;
  private String estateManagerIdcode;
  private String estateManagerMobile;
  private long lonlat;
  private String scope;
  private String developer;
  private String area;
  private java.sql.Timestamp devTime;
  private String estateCompany;
  private String estatePhone;
  private String points;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;
  private java.sql.Timestamp deletedAt;
  private long status;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getSerial() {
    return serial;
  }

  public void setSerial(String serial) {
    this.serial = serial;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getRegionId() {
    return regionId;
  }

  public void setRegionId(long regionId) {
    this.regionId = regionId;
  }


  public String getCommunity() {
    return community;
  }

  public void setCommunity(String community) {
    this.community = community;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }


  public String getStreetNo() {
    return streetNo;
  }

  public void setStreetNo(String streetNo) {
    this.streetNo = streetNo;
  }


  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }


  public String getBureau() {
    return bureau;
  }

  public void setBureau(String bureau) {
    this.bureau = bureau;
  }


  public String getDutyZoneSerial() {
    return dutyZoneSerial;
  }

  public void setDutyZoneSerial(String dutyZoneSerial) {
    this.dutyZoneSerial = dutyZoneSerial;
  }


  public String getBureauSerial() {
    return bureauSerial;
  }

  public void setBureauSerial(String bureauSerial) {
    this.bureauSerial = bureauSerial;
  }


  public String getEstateManager() {
    return estateManager;
  }

  public void setEstateManager(String estateManager) {
    this.estateManager = estateManager;
  }


  public String getEstateManagerIdcode() {
    return estateManagerIdcode;
  }

  public void setEstateManagerIdcode(String estateManagerIdcode) {
    this.estateManagerIdcode = estateManagerIdcode;
  }


  public String getEstateManagerMobile() {
    return estateManagerMobile;
  }

  public void setEstateManagerMobile(String estateManagerMobile) {
    this.estateManagerMobile = estateManagerMobile;
  }


  public long getLonlat() {
    return lonlat;
  }

  public void setLonlat(long lonlat) {
    this.lonlat = lonlat;
  }


  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }


  public String getDeveloper() {
    return developer;
  }

  public void setDeveloper(String developer) {
    this.developer = developer;
  }


  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }


  public java.sql.Timestamp getDevTime() {
    return devTime;
  }

  public void setDevTime(java.sql.Timestamp devTime) {
    this.devTime = devTime;
  }


  public String getEstateCompany() {
    return estateCompany;
  }

  public void setEstateCompany(String estateCompany) {
    this.estateCompany = estateCompany;
  }


  public String getEstatePhone() {
    return estatePhone;
  }

  public void setEstatePhone(String estatePhone) {
    this.estatePhone = estatePhone;
  }


  public String getPoints() {
    return points;
  }

  public void setPoints(String points) {
    this.points = points;
  }


  public java.sql.Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(java.sql.Timestamp createdAt) {
    this.createdAt = createdAt;
  }


  public java.sql.Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(java.sql.Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }


  public java.sql.Timestamp getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(java.sql.Timestamp deletedAt) {
    this.deletedAt = deletedAt;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }

}
