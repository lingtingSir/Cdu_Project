package org.dal;
import java.sql.ResultSet;

import javax.persistence.Entity;
import org.DataBase.DataBase;


import System.Data.*;
@Entity
public class ManagerPagePowerDal {
	private static String managerID=null;
	private   DataTable GetAllMenus(int parentid)
	{
		String temp = String.valueOf(parentid);
		DataTable allMenus = GetAllMenus();
		DataTable dataTable = new DataTable();
		for (DataRow dataRow : allMenus.Rows)
		{
			System.out.print("----111---"+dataRow.getValue("parentid")+"\n");
			System.out.print("----222---"+parentid);
			System.out.print("\n+cGetAllMenus------"+"\n");
			
			if (dataRow.getValue("ParentID").toString().equals(temp))
			
		//	if (Integer.parseInt(dataRow.getValue("ParentID").toString) == String.valueOf(parentid))
			{
				System.out.print("aGetAllMenus------"+"\n");
				
				dataTable.Rows.add(dataRow);
			}
		}
		System.out.print("\n+bGetAllMenus------"+"\n");
		return dataTable;
	}
	public  DataTable GetAllMenus()
	{
		DataBase db = new DataBase();
		String comstr = "select pagesort as id,pagename as title  ,pageurl as url,pid as ParentID from Managerpagepower tpp,pages p  where p.id=tpp.id   and tpp.Managerid='"+managerID+"' order by p.pagesort  ";
		return db.QueryDataTable(comstr);
	}
	
	
	public String CreateHTML(String tid)
	{
		managerID = tid;
		StringBuilder stringBuilder = new StringBuilder();
		DataTable allMenus = GetAllMenus(0);
		for (DataRow dataRow : allMenus.Rows)
		{										
			stringBuilder.append("{title:'" + String.valueOf(dataRow.getValue("title")) + "',autoScroll:true,border:false,iconCls:'nav',");
			DataTable allMenus2 = GetAllMenus(Integer.parseInt(String.valueOf(dataRow.getValue("id"))));
			if(allMenus2.Rows.size()>0)
			{
				String text = "<ul class=\"LeftNav\">";
				for (DataRow dataRow2 : allMenus2.Rows)
				{	
					String text2=text;
					text=text2+"<li><a target=\"main\" href=\""+dataRow2.getValue("url").toString()+"\"> "+dataRow2.getValue("title").toString()+"</a></li>";
					
//					text = string.Concat(new string[]
//							{
//								text2,
//								"<li><a target=\"main\" href=\"",
//								dataRow2["url"].ToString(),
//								"\"> ",
//								dataRow2["title"].ToString(),
//								"</a></li>"
//							});
//					
					
//					
//					text = String.format(text2, "<li><a target=\"main\" href=\"",
//							String.valueOf(dataRow2.getValue("url")),
//							"\"> ",
//							String.valueOf(dataRow2.getValue("title")),
//							"</a></li>");
					//System.out.print("text------"+text);
					//System.out.print("-dataRow2--"+dataRow2.getValue("url").toString());
					//System.out.print("CreateHTML------"+"\n");
					
				}
				if (text != "<ul>")
				{
					text += "</ul>";
					stringBuilder.append("html:'" + text + "'}");
					//System.out.print("CreateHTML-text------"+"\n");
				}
				else
				{
					stringBuilder.append("html:''}");
				}
			}
			else
			{
				stringBuilder.append("html:''}");
			}
			stringBuilder.append(",");
		}
		
		//stringBuilder.substring(0,stringBuilder.length()-2);
		//System.out.print("Create------"+stringBuilder);
		return stringBuilder.substring(0,stringBuilder.length()-1);
		
	}

}
