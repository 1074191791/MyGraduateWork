<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2019/3/24
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<div style="margin: 20px">
    课程情况 >> 课程备注详情
    <hr/>
        <div style="margin-top: 20px">
            <textarea id="lesson_sel_remark_ta" style="width: 300px; height: 500px;">
            </textarea>
        </div>
        <br/>
</div>

    <script type="text/javascript">
        $(document).ready(function () {
            $("#lesson_sel_remark_ta").val( $("#lesson_sel_dg").datagrid("getSelected").lessonRemark);
        })

    </script>

</body>
</html>
