<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2019/3/20
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人信息管理</title>
</head>
<body>
<script type="text/javascript">


    function checkPass() {
            //alert($("#password").val()==$("#repassword").val())
            //让表单使用ajax提交
            $('#self_message_form').form({
                url:'${pageContext.request.contextPath}/updateStudentForSelf',
                onSubmit: function(){
                    // do some check
                    /*if($("#password").val().length != 0 && $("#repassword").val().length!=0){
                        $.messager.alert('系统信息','更新密码为空');
                        return false;
                    }*/
                    if($("#password").val()!=$("#repassword").val()){
                        $.messager.alert('系统信息','两次输出密码不同，请重新输入');
                        $("#password").val("")
                        $("#repassword").val("")
                        return false;
                    }
                },
                success:function(data){
                    if($("#password").val().length != 0) {
                        alert('系统信息:密码同步更新成功，请重新登录');
                        location.href="${pageContext.request.contextPath}/"
                    }

                }
            });


        $('#self_message_form').submit();


    }


    $(document).ready(function () {

    })


</script>

<div style="height: 600px; width: 800px; margin: auto;">
    <form id="self_message_form" method="post" action="${pageContext.request.contextPath}/updateStudentForSelf">
        <input name="id" value="${login.id }" type="hidden"/>
        <table style="width: 500px;"
               class="table table-striped table-bordered table-condensed list">
            <thead>
            <tr>
                <td colspan="4">
                    <b>个人信息 </b>
                </td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    姓名
                </td>
                <td>
                    <input name="username" value="${login.username }" readonly="readonly" type="text"/>
                </td>
            </tr>
            <tr>
                <td>
                    uid
                </td>
                <td>
                    <input name="uid" value="${login.uid }" readonly="readonly" type="text"/>
                </td>
            </tr>
            <tr>
                <td>
                    联系电话
                </td>
                <td>
                    <input type="text" value="${login.phone}" name="phone">
                </td>
            </tr>
            <tr>
                <td>
                    email
                </td>
                <td>
                    <input name="email" value="${login.email}" class="easyui-validatebox" data-options="required:true,validType:'email'" />
                </td>
            </tr>
            <tr>
                <td>
                    身份类型
                </td>
                <td>
                    <input type="hidden" name="status" value="${login.status}" >
                    <c:if test="${login.status==1}">
                        超级管理员
                    </c:if>
                    <c:if test="${login.status==2}">
                        普通管理员
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>
                    密码
                </td>
                <td>
                    <input name="password" id="password" type="password" />
                </td>
            </tr>
            <tr>
                <td>
                    确认密码
                </td>
                <td>
                    <input name="repassword" id="repassword" type="password" />
                </td>
            </tr>
            </tbody>
            <tfoot>
            <tr>
                <td>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="button" value="保存" onclick="checkPass()"/>
                </td>
            </tr>
            </tfoot>
        </table>


    </form>
</div>


</body>
</html>
