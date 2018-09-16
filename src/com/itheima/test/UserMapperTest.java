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

	
	//1.�ع�����Ķ���
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
		User user = (User)sqlSession.selectOne("findById",1);
		//5.������
		System.out.println(user);
	}
	
	//2.ѧϰparameterType�д���pojo��װ����
	@Test
	public void test1() throws IOException{
		//1.����sqlSessionFactoryBuilder
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.����sqlSessionFactory
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		//3.����sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//4.����sqlSession�ķ�����ɲ���
		List<User> users = sqlSession.selectList("findByQueryVo", "��");
		//5.�鿴���
		for (User user : users) {
			System.out.println(user);
		}
		
	}
	
	//3.ѧϰresultType(�����):���������
	@Test
	public void test2() throws IOException{
		//1.����sqlSessionFactoryBuilder
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.����sqlSessionFactory
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		//3.����sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//4.����sqlSession�еķ���
		Integer count = sqlSession.selectOne("totalCount");
		//5.��֤���
		System.out.println(count);
	}
	
	//4.ѧϰresultMap(�����Ժ��ֶβ�һ��ʱʹ��)
	@Test
	public void test4() throws IOException{
		//1.����sqlSessionFactoryBuilder
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.����sqlSessionFactory
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		//3.����sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//4.���ò�ѯ����
		List<Orders> orders = sqlSession.selectList("findAll");
		//5.���Բ�ѯ���
		for (Orders order : orders) {
			System.out.println(order);
		}
	}

}
