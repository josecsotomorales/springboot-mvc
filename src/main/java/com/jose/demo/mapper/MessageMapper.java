package com.jose.demo.mapper;

import com.jose.demo.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MessageMapper {
    @Select("SELECT * FROM MESSAGES")
    ChatMessage getMessages();

    @Insert("INSERT INTO MESSAGES (username, messagetext) VALUES(#{username}, #{message})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int insert(ChatMessage message);
}