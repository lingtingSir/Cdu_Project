package org.action;
import java.util.*;
import javax.persistence.Entity;
import org.vo.*;//++
import org.dao.*;
import org.dao.impl.*;//++
import com.opensymphony.xwork2.*;
@Entity
public class LoginAction extends ActionSupport{
	private Manager manager;
	private String message;//?
	private String type;
	//处理用户请求的 execute 方法
	public String execute() throws Exception{
		//该类为项目与数据的接口（DAO接口），用于处理数据与数据库表的一些操作
		ManagerDao managerDao = new ManagerDaoImpl();//++
		if(type.equals("manager")){ 
			if(managerDao.Validate_Login(manager)){												//如果登录成功
				Map session = ActionContext.getContext().getSession();	//获得会话，用来保存当前登录用户的信息
				session.put("ManagerID", manager.getManagerId());								//把获取的对象保存在 Session 中
				System.out.print("admin---");
				return "admin";
			}
		} else if (type.equals("student")) {
			return "client";	
		}
		return ERROR;
	}
	
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	//属性 message 的 get/set 方法
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
