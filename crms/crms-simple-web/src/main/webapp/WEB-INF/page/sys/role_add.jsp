<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2019/3/21
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript">

    $(document).ready(function () {
        $("#role_add_submit").click(function(){
            $('#role_add_form').form('submit', {
                url:'${pageContext.request.contextPath}/addStudent',
                onSubmit: function(){
                    // do some check
                    // return false to prevent submit;
                },
                success:function(data){
                    if(data==1) {
                        $.messager.show({
                            title:'系统消息',
                            msg:'添加成功',
                            timeout:4000,
                            showType:'slide'
                        });
                        //弹出框关闭
                        $("#role_dialog").dialog("close");
                        $('#role_table').datagrid('reload');
                    } else {
                        $.messager.alert("系统信息","添加失败,请重新添加");
                    }
                }
            });
        })
    })
</script>

<div  style="padding:10px;">
    系统设置 >> 角色添加
    <hr/>

    <form action="" method="post" id="role_add_form">
        <input type="hidden" name="id"/>
        <table>
            <tr>
                <td>角色名称:</td>
                <td><input type="text" name="username"/> </td>
            </tr>
            <tr>
                <td>角色密码:</td>
                <td><input type="password" name="password"/> </td>
            </tr>
            <tr>
                <td>角色电话:</td>
                <td><input type="text" name="phone"/> </td>
            </tr>
            <tr>
                <td>角色备email:</td>
                <td><input type="text" name="email"/> </td>
            </tr>
            <tr>
                <td>角色权限:</td>
                <td>
                    <select class="easyui-combobox" name="status" style="width:200px;">
                        <option value="1">超级管理员</option>
                        <option value="2">普通管理员</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: right">
                    <a id="role_add_submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">添加</a>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
