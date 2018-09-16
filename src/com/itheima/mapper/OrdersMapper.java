package com.itheima.mapper;

import java.util.List;

import com.itheima.entity.Orders;
import com.itheima.entity.OrdersUser;

public interface OrdersMapper {
	/**
	 * ��ѯorder�����е�����
	 * @return
	 */
	public List<Orders> findAll();
	/**
	 * ���ö������й�����ѯ�ĵ�һ�ַ�ʽ�����ü̳�pojo��
	 * @return
	 */
	public List<OrdersUser> ordersToUserOne();
	/**
	 * ���ö������й��������ѯ�ĵڶ��ַ�ʽ�����ø�������
	 * @return
	 */
	public List<Orders> ordersToUserTwo();
}
