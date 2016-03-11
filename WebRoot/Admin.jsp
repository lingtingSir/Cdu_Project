<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head runat="server">
    <title>欢迎项目申报管理系统！ </title>
    <link href="css/StyleSheet.css" rel="stylesheet" type="text/css" />
    <link href="Ext/resources/css/ext-all.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="Ext/adapter/ext/ext-base.js"></script>
    <script type="text/javascript" src="Ext/ext-all.js"></script>
    
    <script type="text/javascript">
        Ext.onReady(function () {
            Ext.BLANK_IMAGE_URL = "Ext/resources/images/default/s.gif";
            var Tree = Ext.tree;
            var tree = new Tree.TreePanel({
                el: 'west_content',
                useArrows: true,
                autoHeight: true,
                split: true,
                lines: true,
                autoScroll: true,
                animate: true,
                enableDD: true,
                border: false,
                containerScroll: true,
                loader: new Tree.TreeLoader({
                    dataUrl: 'ext_tree_json.aspx' //生成 ext 2.0 所需要的树型格式
                })
            });

          

            var viewport = new Ext.Viewport({
                layout:'border',
                items:[ {
                    region:'west',
                    id:'west',
                    //el:'panelWest',
                    title:'菜单导航',
                    split:true,
                    width: 200,
                    minSize: 200,
                    maxSize: 400,
                    collapsible: true,
                    margins:'60 0 2 2',
                    cmargins:'60 5 2 2',
                    layout:'fit',
                    layoutConfig:{ activeontop:true},
                    defaults: { bodyStyle: 'margin:0;padding:0;'},
                    //iconCls:'nav',
                    items:
                        new Ext.TabPanel({
                            border: false,
                            activeTab: 0,
                            tabPosition: 'bottom',
                            items: [
                                {
                                    layout: 'accordion',
                                    layoutConfig: { animate: true },
                                    title: '后台管理',
                                    autoScroll: true,
                                    border: false,
                                  
                                    items: [
                                    {
                                        title: '用户管理',
                                        autoScroll: true,
                                        border: false,
                                        iconCls: 'nav',
                                        html: '<ul class="LeftNav"><li><a target="main" href="admin/ManagerList.jsp">管理员管理</a></li><li><a target="main" href="admin/UserList.jsp">用户管理</a></li></ul>'
                                    }, {
                                        title: '项目管理',
                                        autoScroll: true,
                                        border: false,
                                        iconCls: 'nav',
                                        html: '<ul class="LeftNav"><li><a target="main" href="admin/ProjectList.jsp">项目组管理</a></li><li><a target="main" href="admin/ProjectInternetion.jsp">项目信息列表</a></li></ul>'
                                    },  {
                                        title: '事务管理',
                                        autoScroll: true,
                                        border: false,
                                        iconCls: 'nav',
                                        html: '<ul class="LeftNav"><li><a target="main" href="admin/UserHoliday.jsp">请假列表</a></li><li><a target="main" href="admin/Lib3List.aspx">请假奖惩管理</a></li></li><li><a target="main" href="admin/AllUserHoliday.jsp">请假奖惩详情管理</a></li></ul>'
                                    }, {
                                        title: '组员管理',
                                        autoScroll: true,
                                        border: false,
                                        iconCls: 'nav',
                                        html: '<ul class="LeftNav"><li><a target="main" href="admin/UserManager.jsp">组员信息</a></li></ul>'
                                    }, {
                                        title: '发包管理',
                                        autoScroll: true,
                                        border: false,
                                        iconCls: 'nav',
                                        html: '<ul class="LeftNav"><li><a target="main" href="admin/Employer.jsp">发包方 管理</a></li></ul>'
                                    }, {
                                        title: '角色权限管理',
                                        autoScroll: true,
                                        border: false,
                                        iconCls: 'nav',
                                        html: '<ul class="LeftNav"><li><a target="main" href="admin/PowerManager.jsp">角色管理</a></li></ul>'
                                    }, {
                                        title: '用户积分管理',
                                        autoScroll: true,
                                        border: false,
                                        iconCls: 'nav',
                                        html: '<ul class="LeftNav"><li><a target="main" href="admin/UserIntegraManager.jsp">组员积分管理</a></li><li><a target="main" href="admin/UserRewardManager.jsp">组员奖惩管理</a></li><li><a target="main" href="admin/UserAllRewardManager.jsp">组员奖惩详细管理</a></li></ul>'
                                    }, {
                                        title: '个人信息维护',
                                        autoScroll: true,
                                        border: false,
                                        iconCls: 'nav',
                                        html: '<ul class="LeftNav"><li><a target="main" href="admin/ManagerUpdatePwd.jsp">修改密码</a></li><li><a target="main" href="admin/ManagerUpdateDes.jsp">修改资料</a></li></ul>'
                                    }
                                    ]
                                }]
                        })
                }, {
                    region: 'center',
                    el: 'center',
                    deferredRender: false,
                    margins: '60 0 2 0',
                    html: '<iframe id="center-iframe" width="100%" height=100% name="main"  frameborder="0" scrolling="auto" style="border:0px none; background-color:#BBBBBB; "></iframe>',
                    autoScroll: true
                },
            {
                region: 'south',
                margins: '0 0 0 2',
                border: false,
                html: '<div class="menu south">项目申报管理系统 </div>'
            }
                ]
            });

            setTimeout(function () {
                Ext.get('loading').remove();
                Ext.get('loading-mask').fadeOut({ remove: true });
            }, 250)
        });
    </script>
    <base target="_self" />
</head>
<body>
    <form id="form1" runat="server">
        <div id="loading-mask" style=""></div>
        <div id="loading">
            <div class="loading-indicator"><img src="Ext/resources/extanim32.gif" width="32" height="32" style="margin-right:8px;" align="absmiddle" />Loading...</div>
        </div>
        <div id="header"><h1></h1></div>
        <div class="menu">
            <span style="float: left">
                欢迎&nbsp;&nbsp;<b>管理员</b>&nbsp;&nbsp
                &nbsp;&nbsp;<a href="login.jsp">返回首页</a>
            </span>
            <span id="aLoginOut" runat="server" style="float: right">
                <a onclick="if (!window.confirm('您确认要注消当前登录用户吗？')){return false;}"
                   href="Login.aspx">
                    <asp:LinkButton ID="LinkButton2" runat="server" onclick="LinkButton2_Click">注销</asp:LinkButton>
                </a>
            </span>
        </div>
        <div id="west">

        </div>
        <div id="center">

        </div>
        <div id="west_content" style="height:300px; ">

        </div>
    </form>
</body>
</html>
