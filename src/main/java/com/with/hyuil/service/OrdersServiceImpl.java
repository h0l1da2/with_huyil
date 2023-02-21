package com.with.hyuil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.with.hyuil.dao.OrdersMapper;
import com.with.hyuil.model.OrdersVo;
import com.with.hyuil.service.interfaces.OrderService;

@Service
public class OrdersServiceImpl implements OrderService {

	@Autowired
	private OrdersMapper mapper;

	@Override
	public void addOrders(OrdersVo ordersvo) {
		mapper.insertOrders(ordersvo);
	}

}