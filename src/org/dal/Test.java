package org.dal;
import java.util.Map;

import System.Data.*;

import javax.persistence.Entity;
import org.DataBase.*;
import org.dao.ManagerDao;
import org.dao.impl.ManagerDaoImpl;
import org.util.MD5;
import org.vo.Manager;

import com.opensymphony.xwork2.ActionContext;
@Entity
public class Test {
	 public static  DataTable select(String comstr)
     {
         DataBase db = new DataBase();
         
      //   String comstr = "select ManagerName from Manager where  ManagerID='linmingjun'";
         return db.QueryDataTable(comstr);
     }
	
	 public static void main(String[] args) throws Exception {
		 ManagerDao managerDao = new ManagerDaoImpl();//++
		Manager manager = new Manager();
		manager.setManagerId("linmingjun");
		manager.setManagerPwd(MD5.getDigest("123"));
		if(managerDao.Validate_Login(manager)){												//如果登录成功
			System.out.print("1111---");
		}
//		 String str = MD5.getDigest("123");
//		
//		 System.out.print(str);
//		 String comstr = "select ManagerName from Manager ";
//		 DataTable dt = select(comstr);
//		 System.out.print(dt.getValue(3,"ManagerName"));
	 }
}
