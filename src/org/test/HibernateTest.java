package org.test;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.vo.Powers;
import org.util.HibernateSessionFactory;
public class HibernateTest {

	public Session session;
	public static void main(String[] args) {
		HibernateTest ht=new HibernateTest();		//创建类对象
		ht.getCurrentSession();						//获得session对象
		ht.queryUser();								//插入一条记录
		System.out.println("增加一条记录后结果======");
		            				//查看数据库结果
		
	}
	
	//获得session方法
	public void getCurrentSession(){
		//调用 HibernateSessionFactory 的 getSession 方法创建 Session 对象
		session = HibernateSessionFactory.getSession();
	}
	//关闭session方法
	public void closeSession(){
		if(session!=null){
			HibernateSessionFactory.closeSession();	// 关闭Session
		}
	}
	
	//插入一条记录方法
	public void saveUser(){
		Transaction t1 = session.beginTransaction();// 创建事务对象
		Powers powerss = new Powers();
		powerss.setPowerId(123);
		powerss.setPowerName("123456");
		powerss.setPowerDes("123456");
		session.save(powerss);
		t1.commit();								// 提交事务
	}
	//查询数据库结果方法
	public void queryUser(){
		try{
			Query query = session.createQuery("from Powers");
			List list=query.list();
			for(int i=0;i<list.size();i++){
				Powers user = (Powers)list.get(i);
				System.out.println("selec----" + user.getPowerId());
			
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
