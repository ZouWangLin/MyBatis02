package com.itheima.mapper;

import java.util.List;

import com.itheima.entity.QueryVo;
import com.itheima.entity.User;

public interface UserMapper {
	/**
	 * ����id��ȡuser����
	 * @param id
	 * @return
	 */
	public User findById(Integer id);
	/**
	 * ���ݰ�װ�����ѯ
	 * @param queryVo
	 * @return
	 */
	public List<User> findByQueryVo(QueryVo queryVo);
	/**
	 * ��ѯ�������ݵ�������
	 * @return
	 */
	public Integer totalCount();
	/**
	 * ���ݶ��������ѯ�û�
	 * @return
	 */
	public List<User> findByCriteria();
	/**
	 * ��������������ѯ�û�
	 * @param ids
	 * @return
	 */
	public List<User> findByIds_Array(Integer[] ids);
	/**
	 * ����list����������ѯ�û�
	 * @param ids
	 * @return
	 */
	public List<User> findByIds_List(List<User> ids);
	/**
	 * ����queryVo��ѯ
	 * @param queryVo
	 * @return
	 */
	public List<User> findByIds_QueryVo(QueryVo queryVo);
	
	/**
	 * �������Ӷ������û����Ӷ�����
	 * @return
	 */
	public List<User> userToOrders();
}
