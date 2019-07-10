<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2019/3/22
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<script type="text/javascript">
    $(document).ready(function () {
        $("#timetable_choice_btok").click(function () {
            var options=$("#timetable_choice_choice option:selected");
            //alert(options.val())
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/season/seasonUpdate",
                data: "options="+options.val(),
                success: function(msg){
                    if(msg==1) {
                        $.messager.alert("系统消息","修改成功");
                    } else {
                        $.messager.alert("系统消息","修改失败");
                    }
                }
            });

        })
    })

</script>

    <div style="margin-bottom: 50px; font-size: x-large">
        选择想要显示的课表
    </div>

    <div style="margin-left: 50px;">
        <select id="timetable_choice_choice"  style="width:200px;">
            <option value="spring">春季课表</option>
            <option value="summer">夏季课表</option>
            <option value="autumn">秋季课表</option>
            <option value="winter">冬季课表</option>
        </select>
    </div>
    <div style="margin-top: 20px; margin-left: 80px;">
        <a id="timetable_choice_btok" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确定</a>
    </div>


</body>
<head>
    <title>Title</title>
</head>
</html>
