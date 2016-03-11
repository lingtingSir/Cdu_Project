<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
  <title>注册</title>
	 <link href="css/resource.css" rel="stylesheet" type="text/css" />
    

  </head>
     
	
  <body>
  <form action="servlet/UserRegisterServlet" method="post">
  <table  style="text-align: center;" class="infolist_vt">
        <tr>
            <th colspan="2" class="common">
                <h3 >注册</h3>
            <hr align="left"   style="color: Green;width: 100%;height: 3px;"/></th> 
        </tr>
        <tr>
            <th style="width: 80px; height: 25px;" class="common">
                用户名：
            </th>
            <td class="common">
                <input type="text" id="txtUserName"  Style="width: 200px;" >
               
                
            </td>
        </tr>
        <tr>
            <th class="common">
                用户ID：
            </th>
            <td class="common">
            <input type="text" id="txtUserID" name="txtUserID" Style="width: 200px;" >
                
               
            </td>
        </tr>
        <tr  >
            <th class="common">
                设置密码：
            </th>
            <td class="common">
             <input type="password" id="txtUserPwd" name="txtUserPwd" Style="width: 200px;" >
              
            </td>
        </tr>
        
        <tr>
            <th class="common">
                确认密码：
            </th>
            <td class="common">
            	 <input type="password" id="txtConfirmUserPwd" name="txtConfirmUserPwd"  Style="width: 200px;" >
               
            </td>
        </tr>
        
        <tr>
            <th class="common">
                用户描述：
            </th>
            <td class="common">
            	 <input type="text" id="txtUserDes" name="txtUserDes"  Style="width: 200px;Height:50px" >
                
            </td>
        </tr>
        <tr>
            <th class="common">
            </th>
            <td class="common">
            	<input type="submit" id="btRegister" name="btRegister" value="注册" Style="width: 60px;" >
            	&nbsp;&nbsp;
                
            </td>
        </tr>
    </table>
    </form>
  </body>
</html>
