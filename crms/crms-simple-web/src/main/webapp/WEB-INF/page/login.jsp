<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2019/2/26
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录界面</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
    <style type="text/css">
        .myicon-login {
            background: url('${pageContext.request.contextPath}/images/login.png') no-repeat center center;
        }
    </style>

    <script type="text/javascript">

        function flushCode(){
            document.getElementById("codeimg").src = "imageServlet?;random=" + Math.random()
        }

        $(document).ready(function () {

            //提交按钮
            $("#login_submit").click(function () {
                $('#login_form').form('submit', {
                    url:'${pageContext.request.contextPath}/login/studentLogin',
                    onSubmit: function(){
                        //非空验证等
                        if($(":text:eq(0)").val()==""){
                            $.messager.alert('系统信息','用户名不能为空');
                            return false;
                        }
                        else if($(":password:eq(0)").val()==""){
                            $.messager.alert('系统信息','密码不能为空');
                            return false;
                        }
                    },
                    success:function(data){
                        if(data == 1) {
                            //超管界面
                            alert("登录成功！");
                            location.href = '${pageContext.request.contextPath}/supermanager';
                        }
                        /*if(data == 2) {
                            //管理员界面
                            alert("登录成功！");
                            location.href = 'page/manager.jsp';
                        }
                        if(data == 3) {
                            //学生登录界面
                            alert("登录成功！");
                            location.href = 'page/student.jsp';
                        }*/
                        if(data == 0) {
                            $.messager.alert('系统信息','验证码有误，请新试');
                            flushCode();
                        }

                    }
                });
            })

            //登录重置
            $("#login_reset").click(function () {
                document.getElementById("login_form").reset();
            })

            //验证码生成
            
        })
    </script>

</head>
<body style="background-color: #FAFAFA">

<div style="width: 500px; margin: 200px auto; ">
    <img src="${pageContext.request.contextPath}/images/jlsfdxbdxy.jpg">
    <div id="p" class="easyui-panel" title="登录"
         style="width:550px;height:300px;padding:10px;background:#fafafa;"
         data-options="iconCls:'myicon-login' ">
        <form action="${pageContext.request.contextPath}/login/studentLogin" method="post" id="login_form">
            <table width="480px" align="center">
                <tr>
                    <td colspan="2" style="text-align: center; font-size: 20px; font-weight: bold;">吉林师范大学博达学院机房管理系统
                    </td>
                </tr>
                <tr style="height: 20px;">
                    <td>用户名</td>
                    <td>
                        <input type="text" name="username" style="margin-left: 5px"/>
                    </td>
                    <td rowspan="2">
                        <img src="${pageContext.request.contextPath}/images/xh.jpg" width="140" />
                    </td>
                </tr>
                <tr style="height: 20px;">
                    <td>密码</td>
                    <td>
                        <input type="password" name="password" style="margin-left: 5px"/>
                    </td>
                </tr>
                <tr style="height: 20px;" >
                    <td colspan="2">
                        效验码：
                        <input type="text" name="checkcode" style="margin-left: 5px; width: 100px"/>
                        <img id="codeimg" src="imageServlet" onClick="flushCode()" />
                    </td>
                </tr>
                <tr align="right">
                    <td></td>
                    <td>
                        <a id="login_submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="margin-right: 50px">登录</a>
                        <a id="login_reset" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">重置</a>
                    </td>
                </tr>
            </table>
        </form>

    </div>

</div>
</body>
</html>
