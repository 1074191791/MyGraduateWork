<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2019/3/24
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table id="equipment_sel_dg"></table>
<div id="equipment_sel_tb">
    机房名<input type="text" name="computerRoom"  id="qComputerRoom" /> 
    <a id="equipment_sel_q" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

    <c:if test="${login.status==1}">
        <a id="equipment_del" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">选中后删除</a>
        <a id="equipment_update" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">选中后修改状态</a>
    </c:if>
</div>

<div id="equipment_sel_update_dg"></div>


<script type="text/javascript">

    $(function(){

        $('#equipment_sel_dg').datagrid({
            fit:false,
            border:true,
            singleSelect:true,
            fitColumns:true,
            url : "${pageContext.request.contextPath}/equipment/showEquipments",
            columns : [ [
                {
                    field : 'id',
                    title : '编号',
                    width : 100
                },
                {
                    field : 'equipmentName',
                    title : '配件名',
                    width : 200
                },
                {
                    field : 'logdate',
                    title : '登记日期',
                    width : 200
                },
                {
                    field : 'computerRoom',
                    title : '机房位置',
                    width : 200
                },
                {
                    field : 'repairMan',
                    title : '上报人',
                    width : 200
                },
                {
                    field : 'phone',
                    title : '电话',
                    width : 200
                },
                {
                    field : 'remark',
                    title : '备注',
                    width : 200
                },
                {
                    field : 'isNormal',
                    title : '维修状态',
                    width : 200,
                    formatter:function(value,row,index){
                        if(value==true) {
                            return "已维修"
                        } else {
                            return "待维修"
                        }
                    }
                }

            ] ],
            toolbar:"#equipment_sel_tb",
            striped:true,
            rownumbers:true,
            pagination:true,
            pageNumber:1,
            pageSize:3,
            pageList:[3,6,9]
        });


        $("#equipment_sel_q").click(function(){
            $("#equipment_sel_dg").datagrid("load",{
                "computerRoom": $("#qComputerRoom").val()
            });
        });


        //删除按钮
        $("#equipment_del").click(function () {

            if($("#equipment_sel_dg").datagrid("getSelected")!=null) {
                $.messager.confirm('确认','您确认想要删除记录吗？',function(r){
                    if (r){
                        $.ajax({
                            type: "POST",
                            url: "${pageContext.request.contextPath}/equipment/equipmentDel",
                            data: "id="+$("#equipment_sel_dg").datagrid("getSelected").id,
                            success: function(msg){
                                if(msg==1) {
                                    $.messager.alert("系统信息","删除成功");
                                    $("#equipment_sel_dg").datagrid("reload");
                                } else {
                                    $.messager.alert("系统信息","删除失败");
                                }
                            }
                        });
                    }
                });
            } else {
                $.messager.alert("系统信息","请选择一行进行删除");
            }
        })


        //修改按钮equipment_update
        $("#equipment_update").click(function () {

            if($("#equipment_sel_dg").datagrid("getSelected")!=null) {
                $('#equipment_sel_update_dg').dialog({
                    title: '修改权限',
                    width: 400,
                    height: 300,
                    closed: false,
                    cache: false,
                    href: '${pageContext.request.contextPath}/equipment/equipment_update',
                    modal: true
                });

            } else {
                $.messager.alert("系统信息","请选择一行进行修改");
            }
        })

    });
</script>

</body>
</html>
