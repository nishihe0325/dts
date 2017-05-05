package com.youzan.wagon.persistent.dao;

import com.youzan.wagon.persistent.model.Config;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

public interface ConfigDao {

    String COMMON_COLMUNS = "service_id, service_name, content, create_time, modify_time";

    // ==================== insert ====================
    @Insert("INSERT INTO config (" + COMMON_COLMUNS + ") VALUES (#{serviceId}, #{serviceName}, #{content}, now(), now())")
    long insert(Config config);

    // ==================== find ====================
    @Select("SELECT id, " + COMMON_COLMUNS + " FROM config")
    List<Config> findAll();

    @Select("SELECT id, " + COMMON_COLMUNS + " FROM config WHERE id=#{0}")
    Config findById(long id);

    @Select("SELECT id, " + COMMON_COLMUNS + " FROM config WHERE service_Id=#{0}")
    List<Config> findByServiceId(long serviceId);

    @Select("SELECT id, " + COMMON_COLMUNS + " FROM config WHERE service_name=#{0}")
    List<Config> findByServiceName(String serviceName);

    // ==================== update ====================
    @Update("UPDATE config SET content=#{content}, modify_time = now() WHERE service_name=#{serviceName}")
    boolean updateByServiceName(Config config);

    // ==================== delete ====================
    @Delete("DELETE FROM canal_instance WHERE id=#{0}")
    long deleteById(long id);

}
