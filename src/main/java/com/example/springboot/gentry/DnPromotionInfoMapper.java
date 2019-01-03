package com.example.springboot.gentry;

import com.example.springboot.gentry.DnPromotionInfo;
import java.util.List;

public interface DnPromotionInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DnPromotionInfo record);

    DnPromotionInfo selectByPrimaryKey(Integer id);

    List<DnPromotionInfo> selectAll();

    int updateByPrimaryKey(DnPromotionInfo record);
}