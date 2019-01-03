package com.example.springboot.gentry;

import com.example.springboot.gentry.DnChannel;
import java.util.List;

public interface DnChannelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DnChannel record);

    DnChannel selectByPrimaryKey(Integer id);

    List<DnChannel> selectAll();

    int updateByPrimaryKey(DnChannel record);
}