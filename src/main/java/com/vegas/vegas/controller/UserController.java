package com.vegas.vegas.controller;

import com.vegas.vegas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pfctgeorge on 15/10/17.
 */
@Controller
@RequestMapping("/v1/users")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping("register")
  @ResponseBody
  public Map<String, Object> register(String telephone, String nickname, String password) {
    Map<String, Object> response = new HashMap<>();
    response.put("loginToken", userService.register(telephone, nickname, password));
    return response;
  }

  @RequestMapping("login")
  @ResponseBody
  public Map<String, Object> login(String telephone, String password) {
    Map<String, Object> response = new HashMap<>();
    response.put("loginToken", userService.login(telephone, password));
    return response;
  }

}
