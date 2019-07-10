<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2019/3/21
  Time: 8:13
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
        $("#privilege_edit_submit").click(function(){
            $('#privilege_edit_form').form('submit', {
                url:'${pageContext.request.contextPath}/updatePrivilege',
                onSubmit: function(){
                    // do some check
                    // return false to prevent submit;
                },
                success:function(data){
                    if(data==1) {
                        $.messager.show({
                            title:'系统消息',
                            msg:'修改成功',
                            timeout:4000,
                            showType:'slide'
                        });
                        //弹出框关闭
                        $("#privilege_dialog").dialog("close");
                        $('#privilege_table').datagrid('reload');
                    } else {
                        $.messager.alert("系统信息","修改失败,请重新修改");
                    }
                }
            });
        })
    })
</script>

<div  style="padding:10px;">
    系统设置 >> 角色管理
    <hr/>

    <form action="" method="post" id="privilege_edit_form">
        <input type="hidden" name="id"/>
        <table>
            <tr>
                <td>角色名称:</td>
                <td><input type="text" name="username" readonly="readonly" /> </td>
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
                    <a id="privilege_edit_submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">修改</a>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
