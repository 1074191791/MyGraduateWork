<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2019/3/16
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript">

    $(document).ready(function () {

    })
</script>

<div  style="padding:10px;">
    系统设置 >> 角色信息
    <hr/>
    <form action="" method="post" id="role_message_f">
        <input type="hidden" name="id"/>
        <table>
            <tr>
                <td>角色ID:</td>
                <td>${selected.id}</td>
            </tr>
            <tr>
                <td>角色名称:</td>
                <td>${selected.username}</td>
            </tr>
            <tr>
                <td>角色电话:</td>
                <td>${selected.phone}</td>
            </tr>
            <tr>
                <td>角色email:</td>
                <td>${selected.email}</td>
            </tr>
            <tr>
                <td>角色权限:</td>
                <td>
                    <c:if test="${selected.status==1}" >
                        超级管理员
                    </c:if>
                    <c:if test="${selected.status==2}" >
                        管理员
                    </c:if>
                    <c:if test="${selected.status==3}" >
                        学生
                    </c:if>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
