package com.vegas.vegas.mapper;

import com.vegas.vegas.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

  @Insert("INSERT INTO user (`telephone`, `loginToken`, `nickName`, `password`) VALUES (#{telephone}, #{loginToken}, #{nickName}, #{password})")
  int insert(@Param("telephone")String telephone, @Param("loginToken")String loginToken, @Param("nickName")String nickName, @Param("password")String password);

  @Select("SELECT id, telephone, loginToken, nickName, password FROM user WHERE loginToken = #{loginToken}")
  User selectWithLoginToken(String loginToken);

  @Select("SELECT id, telephone, loginToken, nickName, password FROM user WHERE telephone = #{telephone}")
  User selectWithTelephone(String telephone);

  @Select("SELECT id, telephone, loginToken, nickName, password FROM user WHERE nickName = #{nickName}")
  User selectWithNickName(String nickName);

  @Update("UPDATE user SET loginToken = #{loginToken} WHERE id = #{id}")
  void updateLoginToken(Long id, String loginToken);
}
