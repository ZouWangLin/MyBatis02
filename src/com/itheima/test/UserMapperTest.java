package com.itheima.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.itheima.entity.Orders;
import com.itheima.entity.User;

public class UserMapperTest {

	
	//1.回顾昨天的东西
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
		User user = (User)sqlSession.selectOne("findById",1);
		//5.检验结果
		System.out.println(user);
	}
	
	//2.学习parameterType中传递pojo包装对象
	@Test
	public void test1() throws IOException{
		//1.创建sqlSessionFactoryBuilder
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.创建sqlSessionFactory
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		//3.创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//4.调用sqlSession的方法完成查找
		List<User> users = sqlSession.selectList("findByQueryVo", "王");
		//5.查看结果
		for (User user : users) {
			System.out.println(user);
		}
		
	}
	
	//3.学习resultType(结果集):输出简单类型
	@Test
	public void test2() throws IOException{
		//1.创建sqlSessionFactoryBuilder
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.创建sqlSessionFactory
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		//3.创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//4.调用sqlSession中的方法
		Integer count = sqlSession.selectOne("totalCount");
		//5.验证结果
		System.out.println(count);
	}
	
	//4.学习resultMap(当属性和字段不一致时使用)
	@Test
	public void test4() throws IOException{
		//1.创建sqlSessionFactoryBuilder
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.创建sqlSessionFactory
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		//3.创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//4.调用查询方法
		List<Orders> orders = sqlSession.selectList("findAll");
		//5.测试查询结果
		for (Orders order : orders) {
			System.out.println(order);
		}
	}

}
