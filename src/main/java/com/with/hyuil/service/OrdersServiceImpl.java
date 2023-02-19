package com.with.hyuil.service;

import com.with.hyuil.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.with.hyuil.dao.OrdersMapper;
import com.with.hyuil.model.OrdersVo;

@Service
public class OrdersServiceImpl implements OrderService {

	@Autowired
	private OrdersMapper mapper;
	
	public void addOrders(OrdersVo ordersvo) {
		mapper.insertOrders(ordersvo);
	}
	
}
