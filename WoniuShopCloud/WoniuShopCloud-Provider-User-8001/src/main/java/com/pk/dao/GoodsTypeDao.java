package com.pk.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import com.pk.entity.GoodsType;

public interface GoodsTypeDao {

	@Select("select * from goodstype")
	ArrayList<GoodsType> findAll();
}
