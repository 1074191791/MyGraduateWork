<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2019/3/23
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="equipment_add_form"
        method="post">
    <input type="hidden" name="status" value="0">

    <table>

        <thead>
        <tr>
            <td colspan="4">
                <b>设备管理 </b>
            </td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                设备名称
            </td>
            <td>
                <input name="equipmentName" type="text"/>

            </td>
            <td>
                登记日期
            </td>
            <td>
                <input class="easyui-datetimebox" name="logdate" id="equipment_add_logtime"
                       data-options="required:true,showSeconds:true" value="3/4/2010 2:3" style="width:150px">
            </td>
        </tr>
        <tr>
            <td>
                所在机房
            </td>
            <td>
                <input name="computerRoom" type="text"/>

            </td>
            <td>
                是否正常
            </td>
            <td>
                <select class="easyui-combobox" name="isNormal" style="width:200px;">
                    <option value="true">正常</option>
                    <option value="false">损坏</option>
                </select>

            </td>
        </tr>
        <tr>
            <td>
                报修人
            </td>
            <td>
                <input name="repairMan" value="${login.username }" readonly="readonly" type="text"/>

            </td>
            <td>
                联系电话
            </td>
            <td>
                <input name="phone" value="${login.phone }" type="text"/>
            </td>
        </tr>
        <tr>
            <td width="15%">
                备注
            </td>
            <td width="500" colspan="3" height="">
                <textarea name="remark" style="width: 95%" rows="4" cols="5"></textarea>
            </td>
        </tr>
        </tbody>
        <tfoot>
        <tr>
            <td>
                &nbsp;
            </td>
            <td colspan="3">
                <input id="equipment_add_submit" type="button"
                       value="保存"/>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" value="取消"/>
            </td>
        </tr>
        </tfoot>
    </table>
</form>

<script type="text/javascript" >
    $(document).ready(function () {
        var time = CurentTime();
        //获取当前时间
        $("#equipment_add_logtime").val(time);



        $("#equipment_add_submit").click(function () {
            $('#equipment_add_form').form('submit', {
                url:"${pageContext.request.contextPath}/equipment/equipmentAddOne",
                onSubmit: function(){
                    // do some check
                    // return false to prevent submit;
                },
                success:function(data){
                    if(data==1) {
                        //插入成功
                        $.messager.alert("系统提示","插入数据成功")
                    } else {
                        $.messager.alert("系统提示","插入数据失败，请重试")
                    }
                }
            });
        })

    })




       /* $('#equipment_add_form').form('submit', {
            url:"/equipment/equipmentAddOne",
            onSubmit: function(){
                // do some check
                // return false to prevent submit;
            },
            success:function(data){
                alert(data)
            }
        });

        $('#equipment_add_form').submit();
*/



    //获取当前时间
    function CurentTime()
    {
        var now = new Date();

        var year = now.getFullYear();       //年
        var month = now.getMonth() + 1;     //月
        var day = now.getDate();            //日

        var hh = now.getHours();            //时
        var mm = now.getMinutes();          //分
        var ss = now.getSeconds();           //秒

        var clock = year + "-";

        if(month < 10)
            clock += "0";

        clock += month + "-";

        if(day < 10)
            clock += "0";

        clock += day + " ";

        if(hh < 10)
            clock += "0";

        clock += hh + ":";
        if (mm < 10) clock += '0';
        clock += mm + ":";

        if (ss < 10) clock += '0';
        clock += ss;
        return(clock);
    }

</script>

</body>
</html>
