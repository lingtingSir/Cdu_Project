package org.dao.impl;
import javax.persistence.Entity;
import org.dao.*;
import org.util.HibernateSessionFactory;
import org.util.MD5;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.HibernateSessionFactory;

import org.vo.Manager;

import System.Data.DataTable;

@Entity
public class ManagerDaoImpl implements ManagerDao {
	
	public boolean Add(Manager en){
		Session session=null;
		Transaction tx=null;
		int flag = 0;
		try{
			session=HibernateSessionFactory.getSession();
			tx=session.beginTransaction();
			session.save(en);
			tx.commit();
			flag = 1;
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return flag > 0;
//		Manager manager=new Manager();
//		manager.setManagerId(en.getManagerId());
//		manager.setDepartment(en.getDepartment());
//		manager.setPowers(en.getPowers());
//		manager.setManagerName(en.getManagerName());
//		manager.setManagerPwd(en.getManagerPwd());
//		manager.setManagerDes(en.getManagerDes());
//		if(this.getPhoto()!=null){
//			FileInputStream fis=new FileInputStream(this.getPhoto());
//			byte[] buffer=new byte[fis.available()];
//			fis.read(buffer);
//			b.setPhoto(buffer);
//		}
//		bookDao.addBook(b);
//		this.setMessage("添加成功！");
//		return SUCCESS;
	}
	public boolean Update(Manager en){
		Session session=null;
		Transaction tx=null;
		int flag = 0;
		try{
			session=HibernateSessionFactory.getSession();
			tx=session.beginTransaction();
			session.update(en);
			flag = 1;
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return flag > 0;
	}
	public boolean Update_Pwd(Manager en){
		Session session=null;
		Transaction tx=null;
		int flag = 0;
		try{
			session=HibernateSessionFactory.getSession();
			tx=session.beginTransaction();
			session.update(en);
			flag = 1;
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return flag > 0;
	}
//	public boolean Validate_Login1(Manager en){
//		
//	}
	public boolean Validate_Login(Manager en){
		
		Session session=null;
		Transaction tx=null;
		int flag = 0;
//		Manager manager=null;
		try{
			
			session=HibernateSessionFactory.getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery(" from Manager where ManagerId=? and ManagerPwd=?");
			query.setParameter(0, en.getManagerId());
			query.setParameter(1,MD5.getDigest(en.getManagerPwd()));
//			query.setMaxResults(1);
			flag = query.list().size();
//			flag = (Integer)query.uniqueResult();
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}
		return flag > 0;
	}
//	}
	public boolean Delete(Manager en){
		Session session=null;
		Transaction tx=null;
		int flag = 0;
		try{
			Manager manager=this.GetByID(en);
			session=HibernateSessionFactory.getSession();
			tx=session.beginTransaction();
			session.delete(manager);
			flag = 1;
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return flag > 0;
	}
//	public String DeleteProc(Manager en){
//		
//	}
	public Manager GetByID(Manager en){
		Session session=null;
		Transaction tx=null;
		Manager manager=null;
		try{
			session=HibernateSessionFactory.getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("from Manager where ManagerID=?");
			query.setParameter(0, en.getManagerId());
			query.setMaxResults(1);
			manager=(Manager) query.uniqueResult();
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return manager;
	}
	
	public DataTable GetAll(int pageNow,int pageSize) {
		Session session=null;
		Transaction tx=null;
		DataTable dataTable=null;
		try{
			session=HibernateSessionFactory.getSession();
			tx=session.beginTransaction();
			//查询指定的列的信息
			Query query=session.createQuery("with ManagerInfo as(select Manager.ManagerID,Manager.DepartmentID,Manager.PowerID,ManagerName,ManagerPwd,ManagerImage,ManagerDes ,Powers.PowerName,Department.DepartmentName,Row_Number() over(order by ManagerID) as row_number from Manager ,Powers,Department where Manager.PowerID=powers.PowerID and Manager.DepartmentID=Department.DepartmentID)select * from ManagerInfo");
			//分页
			query.setFirstResult(pageSize*(pageNow-1));
			query.setMaxResults(pageSize);
			dataTable=(DataTable)query.list();
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return dataTable;
	}
	
	


}
