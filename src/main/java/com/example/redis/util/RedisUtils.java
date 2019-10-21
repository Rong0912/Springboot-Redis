package com.example.redis.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

/**
 * @author EDZ
 * @date 2019/10/16
 */

@Component
public class RedisUtils {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private static final ObjectMapper mapper=new ObjectMapper();
    /*
    * 保存字符串
    * */

   public void saveString(String key,String value){
       stringRedisTemplate.opsForValue().set(key,value);
   }
    /*
    * 根据key获取字符串
    * */
   public String getString(String key){
       return stringRedisTemplate.opsForValue().get(key);
   }
   /*
   * 保存对象
   * */
   public void saveBean(String key,Object obj) throws JsonProcessingException {
       saveString(key,mapper.writeValueAsString(obj));
   }
   /*
   * 根据key获取对象
   * */

   public <T> T getBean(String key,Class<T> clazz) throws IOException {
       String value=getString(key);
       if(value==null){
           return null;
       }
       return mapper.readValue(value,clazz);
   }

   /*
   * 从redis中删除
   * */

   public void delete(String key){
       stringRedisTemplate.delete(key);
   }

   /*
   * 从redis中批量删除
   * */

   public void delete(Collection<String> keys){
       stringRedisTemplate.delete(keys);
       /*前后端分离*/
   }
}
