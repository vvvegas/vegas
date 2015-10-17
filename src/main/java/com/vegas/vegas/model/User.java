package com.vegas.vegas.model;

import java.io.Serializable;

/**
 * Created by pfctgeorge on 15/10/17.
 */
public class User implements Serializable {

  private static final long serialVersionUID = -8725401386413242769L;

  private Long id;
  private String nickName;
  private String telephone;
  private String loginToken;
  private String password;

  public User() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getLoginToken() {
    return loginToken;
  }

  public void setLoginToken(String loginToken) {
    this.loginToken = loginToken;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
