package com.pk.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pk.entity.GoodsType;
import com.pk.service.GoodsTypeService;
@RestController
@RequestMapping(value="/goodstype")
public class GoodsTypeController {
	@Autowired
	private GoodsTypeService goodsTypeService;
	@RequestMapping(value="/type")
	public ArrayList<GoodsType> goodsType() {
		ArrayList<GoodsType> list = goodsTypeService.findAll();
		return list;
	}
}
