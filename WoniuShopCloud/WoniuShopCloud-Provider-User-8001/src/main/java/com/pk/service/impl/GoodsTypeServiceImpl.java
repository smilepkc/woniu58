package com.pk.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.dao.GoodsTypeDao;
import com.pk.entity.GoodsType;
import com.pk.service.GoodsTypeService;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService{
	@Autowired
	private GoodsTypeDao dao;
	public ArrayList<GoodsType> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
}
