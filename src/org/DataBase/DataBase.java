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
	//å®šä¹‰å˜é‡	
	private static Connection ct =null;
	//ä½¿ç”¨preparedstatementæ•ˆç‡æ›´é«˜
	private static PreparedStatement ps=null;
	private static ResultSet rs = null;
	private static Statement st=null;
	
	
	
	private static CallableStatement cs= null;
	public static CallableStatement getCs(){
		return cs;
	}
	//å»ºç«‹è¿æ¥
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
	//****callProå­˜å‚¨è¿‡ç¨‹å‡½æ•°****
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
					// i+i i+1æ³¨æ„çœ‹æ¸… 
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
	//å…ˆå†™ä¸?¸ªupdateã€deleteã€insert  
    //sqlæ ¼å¼ï¼šupdate è¡¨å set å­—æ®µå?=ï¼Ÿwhere å­—æ®µ=ï¼? 
    //parameterç¥åº”è¯¥æ˜¯ï¼ˆâ?abcâ€?23ï¼? 
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
			e.printStackTrace();//å¼?‘é˜¶æ®µ
			//æŠ›å‡ºå¼‚å¸¸
			//å¯ä»¥å¤„ç†ï¼Œä¹Ÿå¯ä»¥ä¸å¤„ç?
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
			e.printStackTrace();//å¼?‘é˜¶æ®µ
			//æŠ›å‡ºå¼‚å¸¸
			//å¯ä»¥å¤„ç†ï¼Œä¹Ÿå¯ä»¥ä¸å¤„ç?
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
			e.printStackTrace();//å¼?‘é˜¶æ®µ
			//æŠ›å‡ºå¼‚å¸¸
			//å¯ä»¥å¤„ç†ï¼Œä¹Ÿå¯ä»¥ä¸å¤„ç?
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
			e.printStackTrace();//å¼?‘é˜¶æ®µ
			//æŠ›å‡ºå¼‚å¸¸
			//å¯ä»¥å¤„ç†ï¼Œä¹Ÿå¯ä»¥ä¸å¤„ç?
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
			ex.printStackTrace();//å¼?‘é˜¶æ®µ
			//æŠ›å‡ºå¼‚å¸¸
			//å¯ä»¥å¤„ç†ï¼Œä¹Ÿå¯ä»¥ä¸å¤„ç?
			throw new RuntimeException(ex.getMessage());
		}
		return ps;
	}
	
	
	//è¿”å›count
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
			e.printStackTrace();//å¼?‘é˜¶æ®µ
			//æŠ›å‡ºå¼‚å¸¸
			//å¯ä»¥å¤„ç†ï¼Œä¹Ÿå¯ä»¥ä¸å¤„ç?
			throw new RuntimeException(e.getMessage());
		}
		return count;
	}
	
	
	
	
	public static void close(ResultSet rs,Statement ps,Connection ct)  
	{  	    //å…³é—­èµ„æº(å…ˆå¼€åå…³)  
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

	 

	           List<DataRow> row = new ArrayList<DataRow>();// è¡¨æ‰€æœ‰è¡Œé›†åˆ

	           List<DataColumn> col = null;// è¡Œæ‰€æœ‰åˆ—é›†åˆ

	           DataRow r = null; // å•ç‹¬ä¸?¡Œ

	           DataColumn c = null;// å•ç‹¬ä¸?ˆ—

	           // æ­¤å¤„å¼?§‹å¾ªç¯è¯»æ•°æ®ï¼Œæ¯æ¬¡å¾?¡¨æ ¼ä¸­æ’å…¥ä¸?¡Œè®°å½•

	           while (rs.next()) {

	              // åˆå§‹åŒ–è¡Œé›†åˆï¼?

	 

	              // åˆå§‹åŒ–åˆ—é›†åˆ

	              col = new ArrayList<DataColumn>();

	              // æ­¤å¤„å¼?§‹åˆ—å¾ªç¯ï¼Œæ¯æ¬¡å‘ä¸€è¡Œå¯¹è±¡æ’å…¥ä¸€åˆ?

	              for (int i = 1; i <= rsmd.getColumnCount(); i++) {

	                  String columnName = rsmd.getColumnName(i);

	                  Object value = rs.getObject(columnName);

	                  // åˆå§‹åŒ–å•å…ƒåˆ—

	                  c = new DataColumn(columnName, value);

	                  // å°†åˆ—ä¿¡æ¯åŠ å…¥åˆ—é›†å?

	                  col.add(c);

	              }

	              // åˆå§‹åŒ–å•å…ƒè¡Œ

	              r = new DataRow(col);

	 

	              // å°†è¡Œä¿¡æ¯é™å…¥è¡Œç»“å?

	              row.add(r);

	 

	           }

	 

	           // å¾—åˆ°æ•°æ®è¡?

	           t = new DataTable(row);

	       } catch (SQLException e) {

	           e.printStackTrace();

	       } finally {

	          

	       }

	       return t;

	    }
	public DataTable QueryDataTable(String sql)
    {
       this.getConnection();//½¨Á¢ßB¾€
       DataTable dt = new DataTable();
       try
       {
            
            this.st = this.ct.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            this.rs  = this.st.executeQuery(sql);//®aÉúResultSetÎï¼ş(îËÆ.netµÄDataReader)
             
             
           //<editor-fold defaultstate="collapsed" desc="DataTable¼ÓÈë™ÚÎ»˜Ëî}">
           ResultSetMetaData rsmd = this.rs.getMetaData();
           for (int i = 0; i < rsmd.getColumnCount(); i++) {
                
               dt.Columns.Add(rsmd.getColumnName(i+1));
           }
           //</editor-fold>
            
           //<editor-fold defaultstate="collapsed" desc="DataTable¼ÓÈëÙYÁÏ">
            while(this.rs.next())
           {
               DataRow dr = dt.NewRow();//®aÉúÒ»ÁĞDataRow
               for (int i = 0; i < dt.Columns.size(); i++)
               {
                   dr.setValue(i, this.rs.getObject(i+1));//DataRowÒ»™ÚÒ»™ÚÌîÈëÙYÁÏ
               }
               dt.Rows.add(dr);//DataTable¼ÓÈë´ËDataRow
                
           }
           //</editor-fold>
           
            
       }catch(Exception ex)
       {
        
//          this.errorMsg += ex.toString() + "<br /> DBUtilÎï¼şµÄQueryDataTable·½·¨°lÉúÀıÍâ¡£<br/>";
       }
       finally
       {
//           this.closeconnection(); 
       }
        
       return dt;
    }
	
}
