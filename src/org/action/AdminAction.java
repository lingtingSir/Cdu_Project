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
	 	Map session = ActionContext.getContext().getSession();	//��ûỰ���������浱ǰ��¼�û�����Ϣ								//�ѻ�ȡ�Ķ��󱣴��� Session ��
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
