package org.DataBase;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import System.Data.DataColumn;
import System.Data.DataRow;
import System.Data.DataTable;
import System.Data.SqlParameter;
import javax.persistence.Entity;
@Entity
public class DataBase {
	//定义变量	
	private static Connection ct =null;
	//使用preparedstatement效率更高
	private static PreparedStatement ps=null;
	private static ResultSet rs = null;
	private static Statement st=null;
	
	
	
	private static CallableStatement cs= null;
	public static CallableStatement getCs(){
		return cs;
	}
	//建立连接
	public static Connection getConnection(){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Cdu_ProjectManager;user=sa;password=cduyas@163.com");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ct;
	}
	//****callPro存储过程函数****
	public static CallableStatement callPro(String sql,String[] parameters)
	{
		try{
			ct = getConnection();
			cs=ct.prepareCall(sql);
			if(parameters!=null){
				for(int i=0;i<parameters.length;i++){
					cs.setObject(i+1,parameters[i]);
				
				}
			
			}
			cs.execute();
		}
		catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		
		}
		finally
		{
			close(rs,cs,ct);
			
		}
		return cs;
	}
	public static ResultSet executeQuery(String sql,String[] parameters)
	{
		try{
			ct=getConnection();
			ps=ct.prepareStatement(sql);
			if(parameters!=null){
				for(int i = 0;i<parameters.length;i++)
				{
					// i+i i+1注意看清 
					ps.setString(i+1, parameters[i]);
				}
			}
			rs=ps.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		finally{
		//	close(rs,ps,ct);
		}
		return rs;
	}
	
	public static ResultSet executeQuery(String sql,String managerID)
	{
		try{
			ct=getConnection();
			ps=ct.prepareStatement(sql);
			
					ps.setString(1, managerID);
			
			rs=ps.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		finally{
		//	close(rs,ps,ct);
		}
		return rs;
	}
	
	
	
	
	public static ResultSet executeQuery(String sql)
	{
		try{
			ct=getConnection();
			Statement stat = ct.createStatement();
			rs=stat.executeQuery(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		finally{
			//close(rs,ps,ct);
		}
		return rs;
	}
	
	
	
	 public static PreparedStatement getPs()  
	 {  
	        return ps;  
	 } 
	public static ResultSet getRs()  
	 {  
	        return rs;  
	 }  
	//先写�?��update、delete、insert  
    //sql格式：update 表名 set 字段�?=？where 字段=�? 
    //parameter神应该是（�?abc�?23�? 
	public static void executeUpdate(String sql,String[] parameters)
	{
		try
		{
			ct=getConnection();
			ps = ct.prepareStatement(sql);
			if(parameters!=null)
			{
				for(int i=0;i<parameters.length;i++){
					ps.setString(i+1,parameters[i]);
				}
			}
			ps.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();//�?��阶段
			//抛出异常
			//可以处理，也可以不处�?
			throw new RuntimeException(e.getMessage());
			
		}
		finally
		{
			close(rs,ps,ct);
		}
	}
	public int ExecuteSql(String sql,String[] parameters)
	{
		int result;
		try
		{
			ct=getConnection();
			ps = ct.prepareStatement(sql);
			if(parameters!=null)
			{
				for(int i=0;i<parameters.length;i++){
					ps.setString(i+1,parameters[i]);
				}
			}
			result=1;
			ps.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace();//�?��阶段
			//抛出异常
			//可以处理，也可以不处�?
			throw new RuntimeException(e.getMessage());
			
		}
		finally
		{
			close(rs,ps,ct);
		}
		return result;
	}
	
	
	public int ExecuteSql(String sql)
	{
		int result;
		try
		{
			ct=getConnection();
			ps = ct.prepareStatement(sql);
			
			result=1;
			ps.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace();//�?��阶段
			//抛出异常
			//可以处理，也可以不处�?
			throw new RuntimeException(e.getMessage());
			
		}
		finally
		{
			close(rs,ps,ct);
		}
		return result;
	}
	
	
	public int ExecuteSql(String sql,ArrayList<Object> parameters)
	{
		int result;
		try
		{
			ct=getConnection();
			ps = ct.prepareStatement(sql);
			if(parameters!=null)
			{
				for(int i=0;i<parameters.size();i++){
					ps.setObject(i+1, parameters.get(i));			
					//ps.setString(i+1,parameters.indexOf(i));
				}
			}
			result=1;
			ps.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace();//�?��阶段
			//抛出异常
			//可以处理，也可以不处�?
			throw new RuntimeException(e.getMessage());
			
		}
		finally
		{
			close(rs,ps,ct);
		}
		return result;
	}
	
	public static void executeUpdate2(String[] sql,String[][] parameters){
		try{
			ct = getConnection();
			ct.setAutoCommit(false);
			
			for(int i =0; i<sql.length;i++){
				if(null!=parameters[i]){
					ps=ct.prepareStatement(sql[i]);
					for(int j=0;j<parameters[i].length;j++)
					{
						ps.setString(j+1,parameters[i][j]);
					}
					ps.executeUpdate();
				}
			}
			ct.commit();
		}
		catch(Exception e){
			e.printStackTrace();
			try{
				ct.rollback();
			}
			catch(SQLException el){
				el.printStackTrace();
			}
			throw new RuntimeException(e.getMessage());
		}
		finally{
			close(rs,ps,ct);
		}
	}
	
	public PreparedStatement prepare(Connection ct,String sql) throws SQLException
	{
		try{
		//ct =getConnection();
		ps = ct.prepareStatement(sql);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();//�?��阶段
			//抛出异常
			//可以处理，也可以不处�?
			throw new RuntimeException(ex.getMessage());
		}
		return ps;
	}
	
	
	//返回count
	public  String ExecuteValue(String sql,String[] parameters)
	{
		String count=null;
		try{
			
			ct=getConnection();
			ps = ct.prepareStatement(sql);
			System.out.print(parameters[1]+"---Executevalue\n");
			if(parameters!=null)
			{
				for(int i=0;i<parameters.length;i++){
					ps.setString(i+1,parameters[i]);
					//test
					
				}
			}
			rs =ps.executeQuery();
			//count = rs.getString("Count");
		//	System.out.print(ps.);
			if(rs.next()){
			     count = rs.getString("Count");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();//�?��阶段
			//抛出异常
			//可以处理，也可以不处�?
			throw new RuntimeException(e.getMessage());
		}
		return count;
	}
	
	
	
	
	public static void close(ResultSet rs,Statement ps,Connection ct)  
	{  	    //关闭资源(先开后关)  
	    if(rs!=null)  
	    {  
	        try  
	        {  
	            rs.close();  
	        }  
	        catch(SQLException e)  
	        {  
	            e.printStackTrace();  
	        }  
	        rs=null;  
	    }  
	    if(ps!=null)  
	    {  
	        try  
	        {  
	            ps.close();  
	        }  
	        catch(SQLException e)  
	        {  
	            e.printStackTrace();  
	        }  
	        ps=null;  
	    }  
	    if(null!=ct)  
	    {  
	        try  
	        {  
	            ct.close();  
	        }  
	        catch(SQLException e)  
	        {  
	            e.printStackTrace();  
	        }  
	        ct=null;  
	    }  
	}  
	
	public DataTable GetDataTable(String sql, SqlParameter[] p) {
			
			
	       List<List<HashMap<String, Object>>> table = new ArrayList<List<HashMap<String, Object>>>();

	       DataTable t = null;

	       try {
	    	   ct=getConnection();
				
		       PreparedStatement ps = prepare(ct, sql);

	    	   
	           for (int j = 0; j < p.length; j++) {

	              // wl(p[j].getValue() + "--" + p[j].getType() + "--" + j);

	              if (p[j].getType().equals("int")) {

	                  ps.setInt(j + 1, Integer.parseInt(p[j].getValue()));

	 

	              }

	              if (p[j].getType().equals("String")) {

	                  ps.setString(j + 1, p[j].getValue());

	              }

	              if (p[j].getType().equals("Date")) {

	                  ps.setDate(j + 1, Date.valueOf(p[j].getValue()));

	              }

	           }

	 

	           ResultSet rs = ps.executeQuery();

	           ResultSetMetaData rsmd = rs.getMetaData();

	 

	           List<DataRow> row = new ArrayList<DataRow>();// 表所有行集合

	           List<DataColumn> col = null;// 行所有列集合

	           DataRow r = null; // 单独�?��

	           DataColumn c = null;// 单独�?��

	           // 此处�?��循环读数据，每次�?��格中插入�?��记录

	           while (rs.next()) {

	              // 初始化行集合�?

	 

	              // 初始化列集合

	              col = new ArrayList<DataColumn>();

	              // 此处�?��列循环，每次向一行对象插入一�?

	              for (int i = 1; i <= rsmd.getColumnCount(); i++) {

	                  String columnName = rsmd.getColumnName(i);

	                  Object value = rs.getObject(columnName);

	                  // 初始化单元列

	                  c = new DataColumn(columnName, value);

	                  // 将列信息加入列集�?

	                  col.add(c);

	              }

	              // 初始化单元行

	              r = new DataRow(col);

	 

	              // 将行信息降入行结�?

	              row.add(r);

	 

	           }

	 

	           // 得到数据�?

	           t = new DataTable(row);

	       } catch (SQLException e) {

	           e.printStackTrace();

	       } finally {

	          

	       }

	       return t;

	    }
	public DataTable QueryDataTable(String sql)
    {
       this.getConnection();//�����B��
       DataTable dt = new DataTable();
       try
       {
            
            this.st = this.ct.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            this.rs  = this.st.executeQuery(sql);//�a��ResultSet���(���.net��DataReader)
             
             
           //<editor-fold defaultstate="collapsed" desc="DataTable�����λ���}">
           ResultSetMetaData rsmd = this.rs.getMetaData();
           for (int i = 0; i < rsmd.getColumnCount(); i++) {
                
               dt.Columns.Add(rsmd.getColumnName(i+1));
           }
           //</editor-fold>
            
           //<editor-fold defaultstate="collapsed" desc="DataTable�����Y��">
            while(this.rs.next())
           {
               DataRow dr = dt.NewRow();//�a��һ��DataRow
               for (int i = 0; i < dt.Columns.size(); i++)
               {
                   dr.setValue(i, this.rs.getObject(i+1));//DataRowһ��һ�������Y��
               }
               dt.Rows.add(dr);//DataTable�����DataRow
                
           }
           //</editor-fold>
           
            
       }catch(Exception ex)
       {
        
//          this.errorMsg += ex.toString() + "<br /> DBUtil�����QueryDataTable�����l�����⡣<br/>";
       }
       finally
       {
//           this.closeconnection(); 
       }
        
       return dt;
    }
	
}
