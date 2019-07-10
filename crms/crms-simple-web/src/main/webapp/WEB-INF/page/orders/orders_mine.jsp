<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2019/3/25
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<table id="orders_mine_dg"></table>
<div id="orders_mine_tb">
    <input type="hidden" id="orders_mine_uid" value="${login.uid}">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a id="orders_mine_message" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">订单接收人详情</a>
</div>
<!--服务方详细信息 -->
<div id="orders_mine_pMessage"></div>


<script type="text/javascript">


    $(document).ready(function () {


        $('#orders_mine_dg').datagrid({
            toolbar:"#orders_mine_tb",
            url:'${pageContext.request.contextPath}/orders/ordersSelMine?cid='+$("#orders_mine_uid").val(),
            columns:[[
                {field:'id',hidden:true},
                {field:'oid',title:'订单号',width:100},
                {field:'payment',title:'悬赏金',width:100},
                {field:'pid',title:'接收人id',width:100, formatter:function (value,row,index) {
                        if(row.pid==0) {
                            return "未接单，无";
                        } else {
                            return row.pid;
                        }
                    }},
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
        
        
        //订单详情页
        $("#orders_mine_message").click(function () {

            if($('#orders_mine_dg').datagrid('getSelections').length==1 ) {

                if($('#orders_mine_dg').datagrid("getSelected").pid!=0) {
                    //弹出窗口
                    $('#orders_mine_pMessage').dialog({
                        title: '角色详情',
                        width: 600,
                        height: 300,
                        closed: false,
                        cache: false,
                        href: '${pageContext.request.contextPath}/getStudentByUId?uid='+$('#orders_mine_dg').datagrid("getSelected").pid,
                        modal: true
                    });
                } else {
                    $.messager.alert('系统信息','该订单未被接收');
                }

            } else {
                $.messager.alert('系统信息','请选择<b style="color: red;">一行</b>');
            }
            
        })

    })
</script>

</body>
</html>
