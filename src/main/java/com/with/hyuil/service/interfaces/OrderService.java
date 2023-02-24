package com.with.hyuil.service.interfaces;

import java.util.List;
import java.util.Map;

import com.with.hyuil.model.OrdersVo;

public interface OrderService {
	
	void addOrders(OrdersVo ordersvo);
	List<Map<String, Object>> getOrderList(Long id);
	OrdersVo findByToken(String pgToken);
}
