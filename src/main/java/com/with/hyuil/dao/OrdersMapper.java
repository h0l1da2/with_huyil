package com.with.hyuil.dao;

import org.apache.ibatis.annotations.Mapper;

import com.with.hyuil.model.OrdersVo;

@Mapper
public interface OrdersMapper {

	void insertOrders(OrdersVo ordersvo);
	
}
