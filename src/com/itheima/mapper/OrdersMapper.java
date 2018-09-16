package com.itheima.mapper;

import java.util.List;

import com.itheima.entity.Orders;
import com.itheima.entity.OrdersUser;

public interface OrdersMapper {
	/**
	 * 查询order表所有的数据
	 * @return
	 */
	public List<Orders> findAll();
	/**
	 * 利用订单进行关联查询的第一种方式（利用继承pojo）
	 * @return
	 */
	public List<OrdersUser> ordersToUserOne();
	/**
	 * 利用订单进行关联对象查询的第二种方式（利用附件对象）
	 * @return
	 */
	public List<Orders> ordersToUserTwo();
}
