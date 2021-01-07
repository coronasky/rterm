package com.roiding.rterm.bean;

import android.content.ContentValues;
import java.io.Serializable;

public class FunctionButton implements Serializable {
  private static final long serialVersionUID = 1L;
  
  private long id;
  
  private String keys;
  
  private String name;
  
  private long sortNumber;
  
  public long getId() {
    return this.id;
  }
  
  public String getKeys() {
    return this.keys;
  }
  
  public String getName() {
    return this.name;
  }
  
  public long getSortNumber() {
    return this.sortNumber;
  }
  
  public ContentValues getValues() {
    ContentValues contentValues = new ContentValues();
    contentValues.put("name", this.name);
    contentValues.put("keys", this.keys);
    contentValues.put("sortnumber", Long.valueOf(this.sortNumber));
    return contentValues;
  }
  
  public void setId(long paramLong) {
    this.id = paramLong;
  }
  
  public void setKeys(String paramString) {
    this.keys = paramString;
  }
  
  public void setName(String paramString) {
    this.name = paramString;
  }
  
  public void setSortNumber(long paramLong) {
    this.sortNumber = paramLong;
  }
}
