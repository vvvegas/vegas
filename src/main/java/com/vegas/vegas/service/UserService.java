package com.vegas.vegas.service;

import com.vegas.vegas.exception.BizException;
import com.vegas.vegas.mapper.UserMapper;
import com.vegas.vegas.model.Error;
import com.vegas.vegas.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.apache.commons.codec.digest.DigestUtils.md5Hex;

/**
 * Created by pfctgeorge on 15/10/17.
 */
@Service
public class UserService {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

  @Autowired
  private UserMapper userMapper;

  @Transactional
  public String register(String telephone, String nickName, String password) {
    if (userMapper.selectWithTelephone(telephone) != null) {
      throw new BizException(Error.TELEPHONE_EXISTED);
    }
    if (userMapper.selectWithNickName(nickName) != null) {
      throw new BizException(Error.NICKNAME_EXISTED);
    }
    String loginToken = generateLoginToken();
    userMapper.insert(telephone, nickName, loginToken, md5Hex(password));
    return loginToken;
  }

  @Transactional
  public String login(String telephone, String password) {
    User user = userMapper.selectWithTelephone(telephone);
    if (StringUtils.isEmpty(password) || !md5Hex(password).equals(user.getPassword())) {
      throw new BizException(Error.PASSWORD_WRONG);
    }
    String loginToken = generateLoginToken();
    userMapper.updateLoginToken(user.getId(), loginToken);
    return loginToken;
  }

  @Transactional
  private String generateLoginToken() {
    while (true) {
      String candidate = RandomStringUtils.randomAlphanumeric(32);
      if (userMapper.selectWithLoginToken(candidate) == null) {
        return candidate;
      }
    }
  }

}
