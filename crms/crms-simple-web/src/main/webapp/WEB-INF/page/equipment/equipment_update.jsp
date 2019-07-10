<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2019/3/24
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="margin: 20px">
    设备情况设置 >> 修改状态
    <hr/>
    <form id="equipment_update_f" method="post">
        <input type="hidden" name="id" id="equipment_update_id">
        <div style="margin-top: 20px">
            设备状态：
            <select class="easyui-combobox" name="isNormal" style="width:200px;">
                <option value="true">正常</option>
                <option value="false">损坏</option>
            </select>
        </div>

        <br/>
        <div style="margin-left: 240px; margin-top: 30px;">
            <a id="equipment_update_submit" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
        </div>
    </form>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        //页面载入放入id
        $("#equipment_update_id").val($("#equipment_sel_dg").datagrid("getSelected").id);

        //点击提交事件
        $("#equipment_update_submit").click(function () {
            //表单提交
            $('#equipment_update_f').form('submit', {
                url:"${pageContext.request.contextPath}/equipment/equipmentUpdateIsNormal",
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
                        $("#equipment_sel_update_dg").dialog("close");
                        $('#equipment_sel_dg').datagrid('reload');
                    } else {
                        $.messager.alert("系统信息","修改失败,请重新操作");
                    }
                }
            });

        })
    })



</script>


</body>
</html>
