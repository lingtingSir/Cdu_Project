package org.dao;
import org.vo.*;
import System.Data.*;
public interface ManagerDao {
	public boolean Add(Manager en);
	public boolean Update(Manager en);
	public boolean Update_Pwd(Manager en);
//	public boolean Validate_Login1(Manager en);
	public boolean Validate_Login(Manager en);
	public boolean Delete(Manager en);
//	public String DeleteProc(Manager en);
	public Manager GetByID(Manager en);
	public DataTable GetAll(int pageNow,int pageSize);
}
