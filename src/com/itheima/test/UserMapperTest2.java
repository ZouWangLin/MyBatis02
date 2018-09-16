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
//动态sql的学习
public class UserMapperTest2 {

	//动态sql测试
	@Test
	public void test() throws IOException {
		//1.创建builder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.创建sqlSessionFactory
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		//3.创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//4.执行sqlSession的方法
		User user = new User();
		user.setUsername("王");
		user.setSex("男");
		List<User> users = sqlSession.selectList("findByCriteria",user);
		//5.检验结果
		for (User user_ele : users) {
			System.out.println(user_ele);
		}
	}
	
	//遍历数组
	@Test
	public void test2() throws IOException{
		//1.创建builder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.创建sqlSessionFactory
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		//3.创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//4.执行sqlSession的方法
		List<User> users = sqlSession.selectList("findByIds", new Integer[]{1,10,16});
		//5.查看结果
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	
		//遍历集合
		@Test
		public void test3() throws IOException{
			//1.创建builder对象
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			//2.创建sqlSessionFactory
			InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
			//3.创建sqlSession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//4.执行sqlSession的方法
			List<String> list = new LinkedList<String>();
			list.add("1");
			list.add("10");
			list.add("16");
			List<User> users = sqlSession.selectList("findByIds_List", list);
			//5.查看结果
			for (User user : users) {
				System.out.println(user);
			}
		}
		
		//根据QueryVo查询
		@Test
		public void test4() throws IOException{
			//1.创建builder对象
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			//2.创建sqlSessionFactory
			InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
			//3.创建sqlSession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//4.执行sqlSession的方法
			QueryVo queryVo = new QueryVo();
			LinkedList<String> list = new LinkedList<String>();
			list.add("1");
			list.add("10");
			list.add("16");
			queryVo.setIds(list);
			List<User> users = sqlSession.selectList("findByIds_QueryVo", queryVo);
			//5.查看结果
			for (User user : users) {
				System.out.println(user);
			}
		}
		
		
		//利用pojo实现订单的关联查询对象
		@Test
		public void test5() throws IOException{
			//1.创建builder对象
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			//2.创建sqlSessionFactory
			InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
			//3.创建sqlSession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//4.创建代理对象
			OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
			//5.调用代理对象的方法
			List<OrdersUser> ordersToUserOne = mapper.ordersToUserOne();
			//6.验证结果
			for (OrdersUser ordersUser : ordersToUserOne) {
				System.out.println(ordersUser);
			}
		}
		
		
		//利用resultMap实现订单的关联查询对象
		@Test
		public void test6() throws IOException	{
			//1.创建builder对象
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			//2.创建sqlSessionFactory对象
			InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
			//3.创建sqlSession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//4.创建代理对象
			OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
			//5.调用代理对象的方法
			List<Orders> ordersToUserTwo = mapper.ordersToUserTwo();
			//6.进行测试
			for (Orders order : ordersToUserTwo) {
				System.out.println(order);
			}
		}
		
		//实现1对多的映射
		@Test
		public void test7() throws IOException{
			//1.创建SqlSessionFactoryBuilder对象
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			//2.创建SqlSessionFactory对象
			InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
			//3.获取sqlSession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//4.获取代理对象
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			//5.调用mapper的方法
			List<User> users = mapper.userToOrders();
			//6.遍历结果
			for (User user : users) {
				System.out.println(user);
			}
		}
}
