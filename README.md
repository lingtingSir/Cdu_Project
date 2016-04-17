# Cdu_Project
java web使用struts结合ExtJS实现管理员页面权限管理 <br/>
数据库文件地址：http://pan.baidu.com/s/1kUjshd9  <br/>
主要思路： <br/>
Manager（管理员登录表） <br/>
ManagerPagePower（管理员页面权限表）设置Manager表和Pages主键  <br/>
Pages（页面信息表）采用树形结构建表方式设置一个子ID和层级顺序ID，通过遍历将页面信息显示到导航菜单 <br/>
实现页面效果如下：<br/>
![alt text](https://github.com/lingtingSir/Cdu_ProjectManager/blob/master/Cdu_ProjectManager1.jpg)  
![alt text](https://github.com/lingtingSir/Cdu_ProjectManager/blob/master/Cdu_ProjectManager2.jpg)
![alt text](https://github.com/lingtingSir/Cdu_ProjectManager/blob/master/Cdu_ProjectManager3.jpg)
![alt text](https://github.com/lingtingSir/Cdu_ProjectManager/blob/master/Cdu_ProjectManager4.jpg)
