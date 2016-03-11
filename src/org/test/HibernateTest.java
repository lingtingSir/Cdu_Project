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
		HibernateTest ht=new HibernateTest();		//���������
		ht.getCurrentSession();						//���session����
		ht.queryUser();								//����һ����¼
		System.out.println("����һ����¼����======");
		            				//�鿴���ݿ���
		
	}
	
	//���session����
	public void getCurrentSession(){
		//���� HibernateSessionFactory �� getSession �������� Session ����
		session = HibernateSessionFactory.getSession();
	}
	//�ر�session����
	public void closeSession(){
		if(session!=null){
			HibernateSessionFactory.closeSession();	// �ر�Session
		}
	}
	
	//����һ����¼����
	public void saveUser(){
		Transaction t1 = session.beginTransaction();// �����������
		Powers powerss = new Powers();
		powerss.setPowerId(123);
		powerss.setPowerName("123456");
		powerss.setPowerDes("123456");
		session.save(powerss);
		t1.commit();								// �ύ����
	}
	//��ѯ���ݿ�������
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
