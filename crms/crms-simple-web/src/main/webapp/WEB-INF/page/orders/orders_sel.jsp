<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2019/3/25
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table id="orders_sel_dg"></table>
<div id="orders_sel_tb">
    <%--<input type="hidden" id="orders_sel_uid">--%>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

    <c:if test="${login.status==1}">
        价格区间<input type="text" name="moneyBegin" id="orders_sel_moneyBegin" style="width: 70px;"/> --
        <input type="text" name="moneyEnd" id="orders_sel_moneyEnd" style="width: 70px;">
        &nbsp;
        <a id="orders_sel_search" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a id="orders_sel_receiveOrder" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">接收订单</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a id="orders_sel_unReceived" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">仅显示未接收的订单</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a id="orders_sel_myReceived" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">仅显示我接收的订单</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a id="orders_sel_myDel" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除我接收的订单</a>
    </c:if>
</div>
<input type="hidden" id="orders_sel_MineUid" value="${login.uid}">


<script type="text/javascript">
    $(document).ready(function () {
        /*$("#orders_sel_uid").val();*/

        $('#orders_sel_dg').datagrid({
            toolbar:"#orders_sel_tb",
            url:'${pageContext.request.contextPath}/orders/ordersSel',
            columns:[[
                {field:'id',hidden:true},
                {field:'pid',hidden:true},
                {field:'oid',title:'订单号',width:100},
                {field:'cname',title:'用户名',width:100},
                {field:'cphone',title:'电话',width:100},
                {field:'startTime',title:'预约时间',width:100},
                {field:'serviceAddress',title:'地址',width:100},
                {field:'payment',title:'赏金额度',width:100},
                {field:'remark',title:'备注',width:100},
                {field:'status',title:'接单装态',width:100, formatter:function (value,row,index) {
                        if(row.status==true) {
                            return "已接单"
                        } else {
                            return "未接单"
                        }
                    }}
            ]],
            fit:false,
            border:true,
            singleSelect:true,
            fitColumns:true,
            striped:true,
            rownumbers:true,
            pagination:true,
            pageNumber:1,
            pageSize:3,
            pageList:[3,6,9]
        });

    })

    /**
     * 搜索
     */
    $("#orders_sel_search").click(function () {
        if(parseFloat($("#orders_sel_moneyBegin").val()) > parseFloat($("#orders_sel_moneyEnd").val())) {
            $.messager.alert("系统信息","输入搜索数值有误，请检查重新输入")
        } else {
            $("#orders_sel_dg").datagrid("load",{
                "moneyBegin": $("#orders_sel_moneyBegin").val(),
                "moneyEnd":$("#orders_sel_moneyEnd").val(),
            });
        }
    })

    //仅显示未接收的订单
    $("#orders_sel_unReceived").click(function () {
        $("#orders_sel_dg").datagrid("load",{
            "status":0,
        });
    })

    //仅显示我接收的订单
    $("#orders_sel_myReceived").click(function () {
        $("#orders_sel_dg").datagrid("load",{
            "pid":$("#orders_sel_MineUid").val(),
        });
    })


    
    //接收订单
    $("#orders_sel_receiveOrder").click(function () {
        if($('#orders_sel_dg').datagrid("getSelected") != null) {
            //alert($('#orders_sel_dg').datagrid("getSelected").oid)

            if($('#orders_sel_dg').datagrid("getSelected").status==true) {
                //已经接单
                $.messager.alert("系统提示","该订单已被接受，请选择其他订单");
            } else {
                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/orders/updateStatusByOid",
                    data: "oid="+$('#orders_sel_dg').datagrid("getSelected").oid+"&pid="+$("#orders_sel_MineUid").val(),
                    success: function(msg){
                        if(msg==1) {
                            $.messager.alert("系统提示","订单已成功接收");
                        } else {
                            $.messager.alert("系统提示","订单接收失败，请重试");
                        }
                        $('#orders_sel_dg').datagrid("reload");
                    }
                });
            }
        } else {
            $.messager.alert("系统提示","请选择一行");
        }
    })


    //删除
    $("#orders_sel_myDel").click(function () {
        if($('#orders_sel_dg').datagrid("getSelected")!= null) {
            if($('#orders_sel_dg').datagrid("getSelected").pid==$("#orders_sel_MineUid").val()) {
                //是自己接的单子
                $.messager.confirm('确认','您确认想要删除记录吗？',function(r){
                    if (r){
                        $.ajax({
                            type: "POST",
                            url: "${pageContext.request.contextPath}/orders/delOrders",
                            data: "oid="+$('#orders_sel_dg').datagrid("getSelected").oid,
                            success: function(msg){
                                if(msg==1) {
                                    $.messager.alert("系统信息","删除成功");
                                    $('#orders_sel_dg').datagrid("reload");
                                } else {
                                    $.messager.alert("系统信息","删除失败");
                                }
                            }
                        });


                    }
                });

            } else {
                $.messager.alert("系统提示","该订单不是您接收的，您无权删除");
            }
        } else{
            $.messager.alert("系统信息","请选择一行进行删除");
        }

    })


</script>



</body>
</html>
