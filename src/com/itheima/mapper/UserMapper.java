package com.itheima.mapper;

import java.util.List;

import com.itheima.entity.QueryVo;
import com.itheima.entity.User;

public interface UserMapper {
	/**
	 * 根据id获取user对象
	 * @param id
	 * @return
	 */
	public User findById(Integer id);
	/**
	 * 根据包装对象查询
	 * @param queryVo
	 * @return
	 */
	public List<User> findByQueryVo(QueryVo queryVo);
	/**
	 * 查询表中数据的总条数
	 * @return
	 */
	public Integer totalCount();
	/**
	 * 根据多个条件查询用户
	 * @return
	 */
	public List<User> findByCriteria();
	/**
	 * 根据数组条件查询用户
	 * @param ids
	 * @return
	 */
	public List<User> findByIds_Array(Integer[] ids);
	/**
	 * 根据list集合条件查询用户
	 * @param ids
	 * @return
	 */
	public List<User> findByIds_List(List<User> ids);
	/**
	 * 根据queryVo查询
	 * @param queryVo
	 * @return
	 */
	public List<User> findByIds_QueryVo(QueryVo queryVo);
	
	/**
	 * 左外连接订单（用户连接订单）
	 * @return
	 */
	public List<User> userToOrders();
}
