package com.with.hyuil.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.with.hyuil.model.OrdersVo;

@Mapper
public interface OrdersMapper {

	void insertOrders(OrdersVo ordersvo);
	List<Map<String, Object>> findByHostId(Long id);
	OrdersVo findByToken(String pgToken);
	Integer selectAllPrice();
}
