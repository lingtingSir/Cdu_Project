<%@ page language="java" pageEncoding="gb2312"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>

    
    <title>后台管理</title>
    <link rel="stylesheet" href="style/base/jw.css" type="text/css" media="all" />
    <link rel="stylesheet" href="style/standard/jw.css" type="text/css" media="all" />
    
    <!--//  -->
   
	 <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/thickbox_plus.js"></script>
    <link rel="stylesheet" type="text/css" href="css/thickbox.css" />
    
    
 <style type="text/css">
        .fangshua
        {
            font-weight: bold;
            font-size: 14px;
            color: red;
        }
        .boder1
        {
            border: none;
            border-bottom-style: none;
            border-left: none;
            border-left-style: none;
        }
    </style>

  </head>
  
  <body>
      <form action="login2" method="post" >
      <div class="login_main">
        <div class="login_logo">
            <div style="font-size: large;">
                <font style="color: red;">欢迎进入《成都大学项目申报管理系统》</font><br />
            </div>
        </div>
        <div class="login_left">
            <img class="login_pic" src="images/login_pic.png" />
        </div>
        <div class="login_right">
        
            <dl>
                <table>
                <tr>
                 <td><div align="right"><font size="-1" color="#556B2F">身份:</font></div></td>
		    <td><select name="type" style="width:152">
		        <option value="student" selected>学生</option>
		        <option value="manager">管理员</option>
		      </select></td>
                </tr>
                    <tr>
                        <td>
                            <dt >
                               <!--  class="uesr" -->
                               <label>账号</label></dt>
                        </td>
                       
                        <td>
                            <dd>
                       
                                <input  id="manager.managerId" name="manager.managerId" Style="margin-bottom: 0px" Width="90px">
                                
                            </dd>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>
                            <dt >
                            <!--  <dt class="passw"> -->
                                <label>密 码</label></dt>
                        </td>
                        <td>
                            <dd >
                                <input id="manager.managerPwd" type="password" name="manager.managerPwd"  Width="90px">
                               
                            </dd>
                        </td>
                    </tr>
                </table>
                <dt></dt>
                <dd>
                    <table id="RadioButtonList1" border="0">
                        <tr>
                            
                        </tr>
                    </table>
                </dd>
                <dt></dt>
                <dd>
                  
                
                    <input type="submit" value=”“ class="btn_dl"
                       />
                     <input type="submit" value="" class="btn_cz"/>
                </dd>
                
                  <br>
                <dd>
              
                    <a href='UserRegister.jsp?height=350;width=500' >我要注册...</a>
                </dd>    
                 <tr>
		  			  <td colspan="2"><div align="center"><font size="-1" color="red"><b>${msg1}</b></font></div></td>
		  			</tr>
            </dl>
        </div>
        <div class="login_copyright">
        </div>
    </div>
    <script type="text/javascript">
        $("#mLogindialog").show();
    </script>
      </form>
  </body>
</html>
