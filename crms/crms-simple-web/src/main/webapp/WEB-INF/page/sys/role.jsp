<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2019/3/15
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!--由于使用了easyUI,所以只会引入body中的标签 -->
<body>



    <script type="text/javascript">

        function aaa(obj) {
            if($('#role_table').datagrid('getSelections').length==1) {
                //弹出窗口
                $('#role_message').dialog({
                    title: '角色详情',
                    width: 600,
                    height: 300,
                    closed: false,
                    cache: false,
                    href: '${pageContext.request.contextPath}/getStudentById?id='+$(obj).parent().parent().siblings("[field='id']").children().eq(0).html(),
                    modal: true
                    //数据回显
                    /*onLoad:function () {
                        $("#role_message_f :text:eq(0)").val($(obj).parent().parent().parent().siblings("[field='id']").children().eq(0).html());
                        $("#role_message_f :text:eq(1)").val($("#role_table").datagrid("getSelected").email);
                        $("#role_message_f :text:eq(2)").val($("#role_table").datagrid("getSelected").phone);
                        $("#role_message_f :hidden:eq(0)").val($("#role_table").datagrid("getSelected").id);
                    }*/
                });
            } else {
                $.messager.alert('系统信息','请选择<b style="color: red;">一行</b>');
            }
        }


        $(document).ready(function() {

            $('#role_table').datagrid({
                url:'${pageContext.request.contextPath}/showRole',
                columns:[[
                    {field:'id',width:100,hidden:true},
                    {field:'uid',title:'编号',width:100},
                    {field:'username',title:'角色名称',width:100},
                    {field:'phone',title:'电话',width:100},
                    {field:'email',title:'email',width:100},
                    {field:'remark',title:'操作',width:100,align:'right',formatter:function (val) {
                            return "<a onclick=aaa(this) href='javascript:void(0)'>查看详情" +
                                " </a> "
                        }}
                ]],
                pagination:true,
                pageList:['2','4','6'],
                fitColumns:true,
                striped:true,
                rownumbers:true,
                singleSelect:true,
                toolbar: [{
                    iconCls: 'icon-add',
                    text:'增加',
                    handler: function(){
                        //弹出窗口
                        $('#role_dialog').dialog({
                            title: '增加角色',
                            width: 500,
                            height: 300,
                            closed: false,
                            cache: false,
                            href: 'sys/role_add',
                            modal: true
                        });
                    }
                },'-',{
                    iconCls: 'icon-remove',
                    text:'删除',
                    handler: function(){
                        $.messager.confirm('确认','您确认想要删除记录吗？',function(r){
                            if (r){
                                //id号获取
                                //alert("id"+$("#role_table").datagrid("getSelected").id);
                                $.ajax({
                                    type: "POST",
                                    url: "${pageContext.request.contextPath}/delStudent",
                                    data: "id="+$("#role_table").datagrid("getSelected").id,
                                    success: function(msg){
                                        if(msg==1) {
                                            $('#role_table').datagrid('reload');
                                            $.messager.alert('系统信息','删除成功');
                                        } else {
                                            $.messager.alert('系统信息','删除失败，请重新选中删除');
                                        }
                                    }
                                });
                            }
                        });
                    }
                },'-',{
                    iconCls: 'icon-edit',
                    text:'修改',
                    handler: function(){
                        //如果直选中一个，则可以修改
                        if($('#role_table').datagrid('getSelections').length==1) {
                            //弹出窗口
                            $('#role_dialog').dialog({
                                title: '修改角色',
                                width: 400,
                                height: 200,
                                closed: false,
                                cache: false,
                                href: 'sys/role_edit',
                                modal: true,
                                //数据回显
                                onLoad:function () {
                                    $("#role_edit_form :text:eq(0)").val($("#role_table").datagrid("getSelected").username);
                                    $("#role_edit_form :text:eq(1)").val($("#role_table").datagrid("getSelected").email);
                                    $("#role_edit_form :text:eq(2)").val($("#role_table").datagrid("getSelected").phone);
                                    $("#role_edit_form :hidden:eq(0)").val($("#role_table").datagrid("getSelected").id);

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
    <table id="role_table"></table>

    <div id="role_dialog"></div>
    <div id="role_message"></div>

</body>
</html>
