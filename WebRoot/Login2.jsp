<%@ page language="java" pageEncoding="gb2312"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>

    
    <title>��̨����</title>
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
                <font style="color: red;">��ӭ���롶�ɶ���ѧ��Ŀ�걨����ϵͳ��</font><br />
            </div>
        </div>
        <div class="login_left">
            <img class="login_pic" src="images/login_pic.png" />
        </div>
        <div class="login_right">
        
            <dl>
                <table>
                <tr>
                 <td><div align="right"><font size="-1" color="#556B2F">���:</font></div></td>
		    <td><select name="type" style="width:152">
		        <option value="student" selected>ѧ��</option>
		        <option value="manager">����Ա</option>
		      </select></td>
                </tr>
                    <tr>
                        <td>
                            <dt >
                               <!--  class="uesr" -->
                               <label>�˺�</label></dt>
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
                                <label>�� ��</label></dt>
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
                  
                
                    <input type="submit" value=���� class="btn_dl"
                       />
                     <input type="submit" value="" class="btn_cz"/>
                </dd>
                
                  <br>
                <dd>
              
                    <a href='UserRegister.jsp?height=350;width=500' >��Ҫע��...</a>
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
