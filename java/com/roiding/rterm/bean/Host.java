package com.roiding.rterm.bean;

import android.content.ContentValues;
import java.io.Serializable;

public class Host implements Serializable {
  private static final long serialVersionUID = 1L;
  
  private String encoding;
  
  private String host;
  
  private long id;
  
  private String name;
  
  private String pass;
  
  private int port;
  
  private String protocal;
  
  private String user;
  
  public String getEncoding() {
    return this.encoding;
  }
  
  public String getHost() {
    return this.host;
  }
  
  public long getId() {
    return this.id;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getPass() {
    return this.pass;
  }
  
  public int getPort() {
    return this.port;
  }
  
  public String getProtocal() {
    return this.protocal;
  }
  
  public String getUser() {
    return this.user;
  }
  
  public ContentValues getValues() {
    ContentValues contentValues = new ContentValues();
    contentValues.put("name", this.name);
    contentValues.put("protocal", this.protocal);
    contentValues.put("encoding", this.encoding);
    contentValues.put("user", this.user);
    contentValues.put("pass", this.pass);
    contentValues.put("host", this.host);
    contentValues.put("port", Integer.valueOf(this.port));
    return contentValues;
  }
  
  public void setEncoding(String paramString) {
    this.encoding = paramString;
  }
  
  public void setHost(String paramString) {
    this.host = paramString;
  }
  
  public void setId(long paramLong) {
    this.id = paramLong;
  }
  
  public void setName(String paramString) {
    this.name = paramString;
  }
  
  public void setPass(String paramString) {
    this.pass = paramString;
  }
  
  public void setPort(int paramInt) {
    this.port = paramInt;
  }
  
  public void setProtocal(String paramString) {
    this.protocal = paramString;
  }
  
  public void setUser(String paramString) {
    this.user = paramString;
  }
}
