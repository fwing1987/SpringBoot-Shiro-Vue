package com.example.springboot.gentry;

import com.example.springboot.gentry.DnChannel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DnChannelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DnChannel record);

    DnChannel selectByPrimaryKey(Integer id);

    List<DnChannel> selectAll();

    int updateByPrimaryKey(DnChannel record);

    List<Map> getSummary(Integer channelId);

    List<Map> getUserPromotionByPage(@Param("channelId") Integer channelId,
                                     @Param("startTime") String startTime,
                                     @Param("endTime") String endTime);
}