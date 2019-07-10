<%@ page import="cn.crms.pojo.Student" %><%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2019/3/3
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理界面</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/locale/easyui-lang-zh_CN.js"></script>--%>
    
    <script type="text/javascript">
        $(document).ready(function () {
            $('#main_tree').tree({
                url:'${pageContext.request.contextPath}/showMenu?status='+${login.status},
                onClick:function (node) {
                    /*
                    对选项卡进行选中控制
                     */
                    if($('#main_tabs').tabs('getTab',node.text) == null) {
                        $('#main_tabs').tabs('add',{
                            title: node.text,
                            fit:true,
                            selected: true,
                            closable:true,
                            href:'${pageContext.request.contextPath}/'+node.attributes.filename
                            //...
                        });
                    } else {
                        $('#main_tabs').tabs('select',node.text);
                    }
                }
            });


            //日历
            $('#calendar').calendar({
                current:new Date()
            });

        })


    </script>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',title:'博达机房管理系统'" style="height:130px;">
        <div style="width: 400px; height: 100px; float: left;line-height: 100px; padding-left: 30px" >
            <img style="height: 100px" src="${pageContext.request.contextPath}/images/jlsfdxbdxy.jpg">
        </div>
        <div style="width: 350px; height: 100px; float: right; line-height: 100px" >
            <span style="font-size: 15px;font-weight: bold">您好：${login.username} ,您的权限是:
                <c:if test="${login.status==1}" >
                    超级管理员
                </c:if>
                 <c:if test="${login.status==2}" >
                     管理员
                 </c:if>
                <c:if test="${login.status==3}" >
                    学生
                </c:if>
                |&nbsp; <a href="${pageContext.request.contextPath}/logOut ">注销</a></span>
        </div>
    </div>
    <div data-options="region:'south',title:'底部声明'" style="height:100px;">
        <div style="height: 70px;line-height: 70px;text-align: center; color: gray;">
            Copyright &copy; &nbsp;&nbsp;2019吉林师范大学博达学院
        </div>
    </div>
    <div data-options="region:'west',title:'菜单'" style="width:300px;">
        <ul id="main_tree"></ul>
        <div id="calendar" style="width:295px;height:260px; margin-top: 70px"></div>
    </div>
    <div data-options="region:'center',title:'内容'" style="padding:5px;background:#eee;">
        <div id="main_tabs" class="easyui-tabs" style="width:500px;height:250px;" data-options="fit:true">
            <div title="欢迎界面" style="padding:20px;">
                欢迎使用，如有问题请联系管理员：周先生 = =。。。
                电话：17696542240
            </div>
        </div>
    </div>

</body>

</html>
