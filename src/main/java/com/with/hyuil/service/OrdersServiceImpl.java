package com.with.hyuil.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.with.hyuil.dao.OrdersMapper;
import com.with.hyuil.model.OrdersVo;
import com.with.hyuil.service.interfaces.OrderService;

@Service
public class OrdersServiceImpl implements OrderService {

	@Autowired
	private OrdersMapper mapper;
	
	public void addOrders(OrdersVo ordersvo) {
		mapper.insertOrders(ordersvo);
	}
	
	public List<Map<String, Object>> getOrderList(Long id){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			list = mapper.findByUserId(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<LocalDate> getDatesBetweenTwoDates(LocalDate startDate, LocalDate endDate) {
		return startDate.datesUntil(endDate)
        	.collect(Collectors.toList());
	}
	
	public OrdersVo findByToken(String pgToken) {
		return mapper.findByToken(pgToken);
	}

}