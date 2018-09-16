package com.itheima.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.itheima.entity.Orders;
import com.itheima.entity.OrdersUser;
import com.itheima.entity.QueryVo;
import com.itheima.entity.User;
import com.itheima.mapper.OrdersMapper;
import com.itheima.mapper.UserMapper;
//��̬sql��ѧϰ
public class UserMapperTest2 {

	//��̬sql����
	@Test
	public void test() throws IOException {
		//1.����builder����
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.����sqlSessionFactory
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		//3.����sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//4.ִ��sqlSession�ķ���
		User user = new User();
		user.setUsername("��");
		user.setSex("��");
		List<User> users = sqlSession.selectList("findByCriteria",user);
		//5.������
		for (User user_ele : users) {
			System.out.println(user_ele);
		}
	}
	
	//��������
	@Test
	public void test2() throws IOException{
		//1.����builder����
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.����sqlSessionFactory
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		//3.����sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//4.ִ��sqlSession�ķ���
		List<User> users = sqlSession.selectList("findByIds", new Integer[]{1,10,16});
		//5.�鿴���
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	
		//��������
		@Test
		public void test3() throws IOException{
			//1.����builder����
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			//2.����sqlSessionFactory
			InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
			//3.����sqlSession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//4.ִ��sqlSession�ķ���
			List<String> list = new LinkedList<String>();
			list.add("1");
			list.add("10");
			list.add("16");
			List<User> users = sqlSession.selectList("findByIds_List", list);
			//5.�鿴���
			for (User user : users) {
				System.out.println(user);
			}
		}
		
		//����QueryVo��ѯ
		@Test
		public void test4() throws IOException{
			//1.����builder����
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			//2.����sqlSessionFactory
			InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
			//3.����sqlSession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//4.ִ��sqlSession�ķ���
			QueryVo queryVo = new QueryVo();
			LinkedList<String> list = new LinkedList<String>();
			list.add("1");
			list.add("10");
			list.add("16");
			queryVo.setIds(list);
			List<User> users = sqlSession.selectList("findByIds_QueryVo", queryVo);
			//5.�鿴���
			for (User user : users) {
				System.out.println(user);
			}
		}
		
		
		//����pojoʵ�ֶ����Ĺ�����ѯ����
		@Test
		public void test5() throws IOException{
			//1.����builder����
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			//2.����sqlSessionFactory
			InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
			//3.����sqlSession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//4.�����������
			OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
			//5.���ô������ķ���
			List<OrdersUser> ordersToUserOne = mapper.ordersToUserOne();
			//6.��֤���
			for (OrdersUser ordersUser : ordersToUserOne) {
				System.out.println(ordersUser);
			}
		}
		
		
		//����resultMapʵ�ֶ����Ĺ�����ѯ����
		@Test
		public void test6() throws IOException	{
			//1.����builder����
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			//2.����sqlSessionFactory����
			InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
			//3.����sqlSession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//4.�����������
			OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
			//5.���ô������ķ���
			List<Orders> ordersToUserTwo = mapper.ordersToUserTwo();
			//6.���в���
			for (Orders order : ordersToUserTwo) {
				System.out.println(order);
			}
		}
		
		//ʵ��1�Զ��ӳ��
		@Test
		public void test7() throws IOException{
			//1.����SqlSessionFactoryBuilder����
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			//2.����SqlSessionFactory����
			InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
			//3.��ȡsqlSession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//4.��ȡ�������
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			//5.����mapper�ķ���
			List<User> users = mapper.userToOrders();
			//6.�������
			for (User user : users) {
				System.out.println(user);
			}
		}
}
