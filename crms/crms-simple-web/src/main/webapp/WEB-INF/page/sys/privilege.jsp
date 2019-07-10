<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2019/3/21
  Time: 8:00
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


    $(document).ready(function() {

        $('#privilege_table').datagrid({
            url:'${pageContext.request.contextPath}/showPrivilege',
            columns:[[
                {field:'id',width:100,hidden:true},
                {field:'uid',title:'编号',width:100},
                {field:'username',title:'角色名称',width:100},
                {field:'status',title:'权限',width:100,formatter:function(value,row,index){
                        if(value==1) {
                            return "超管"
                        } else {
                            return "管理员"
                        }
                    }}
            ]],
            pagination:true,
            pageList:['2','4','6'],
            fitColumns:true,
            striped:true,
            rownumbers:true,
            singleSelect:true,
            toolbar: [{
                iconCls: 'icon-edit',
                text:'修改',
                handler: function(){
                    //如果直选中一个，则可以修改
                    if($('#privilege_table').datagrid('getSelections').length==1) {
                        //弹出窗口
                        $('#privilege_dialog').dialog({
                            title: '修改权限',
                            width: 400,
                            height: 200,
                            closed: false,
                            cache: false,
                            href: 'sys/privilege_edit',
                            modal: true,
                            //数据回显
                            onLoad:function () {
                                $("#privilege_edit_form :text:eq(0)").val($("#privilege_table").datagrid("getSelected").username);
                                $("#privilege_edit_form :text:eq(1)").val($("#privilege_table").datagrid("getSelected").status);
                                $("#privilege_edit_form :hidden:eq(0)").val($("#privilege_table").datagrid("getSelected").id);
                            }
                        });
                    } else {
                        $.messager.alert('系统信息','请选择<b style="color: red;">一行</b>');
                    }

                }
            }]

        });
    })



</script>
<table id="privilege_table"></table>

<div id="privilege_dialog"></div>


</body>
</html>
