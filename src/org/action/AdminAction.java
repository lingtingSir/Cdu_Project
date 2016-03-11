package org.action;
import java.util.*;

import javax.persistence.Entity;
import org.vo.*;//++
import org.dal.ManagerPagePowerDal;
import org.dao.*;
import org.dao.impl.*;//++

import com.opensymphony.xwork2.*;
@Entity
public class AdminAction extends ActionSupport{
	private String HtmlMenus;
		
	public void selectAllMenu() throws Exception{
		ManagerPagePowerDal  mpp=new ManagerPagePowerDal();
	 	Map session = ActionContext.getContext().getSession();	//获得会话，用来保存当前登录用户的信息								//把获取的对象保存在 Session 中
	 	HtmlMenus=mpp.CreateHTML(session.get("managername").toString());
		System.out.print("str---"+HtmlMenus);
	}
	public String getHtmlMenus() {
		return HtmlMenus;
	}
	public void setHtmlMenus(String htmlMenus) {
		HtmlMenus = htmlMenus;
	}
}
