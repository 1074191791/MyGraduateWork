<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2019/3/21
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form
        id="lesson_add_form"
        action="${pageContext.request.contextPath}/lesson/addLesson"
        method="post">
   <%-- <input name="util.id" value="${util.id }" type="hidden"/>--%>
    <table
            class="table table-striped table-bordered table-condensed list">
        <thead>
        <tr>
            <td colspan="4">
                <b>课程管理 </b>
            </td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                课程名称
            </td>
            <td>
                <input name="lessonName" type="text"/>

            </td>
            <td>
                添加上课日期
            </td>
            <td>
                <input class="easyui-datetimebox" name="addDate"
                       data-options="required:true,showSeconds:false" value="3/4/2010 2:3" style="width:150px">
            </td>
        </tr>
        <tr>
            <td>
                课时
            </td>
            <td>
                <input name="lessonTime" type="text"/>

            </td>
            <td>
                学分
            </td>
            <td>
                <input name="lessonScore" type="text"/>
            </td>
        </tr>
        <tr>
            <td width="15%">
                备注
            </td>
            <td width="500" colspan="3" height="">
                <textarea name="lessonRemark" style="width: 95%" rows="4" cols="5"></textarea>
            </td>
        </tr>
        </tbody>
        <tfoot>
        <tr>
            <td>
                &nbsp;
            </td>
            <td colspan="3">
                <input class="btn btn-inverse" id="find" type="submit"
                       value="保存"/>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="btn btn-inverse" type="reset" value="取消"/>
            </td>
        </tr>
        </tfoot>
    </table>
</form>

<script type="text/javascript">
    $(document).ready(function() {

        $('#lesson_add_form').form({
            url:"${pageContext.request.contextPath}/lesson/addLesson",
            onSubmit: function(){
                // do some check
                // return false to prevent submit;
            },
            success:function(data){
                if(data==1) {
                    $.messager.alert('系统信息','课程添加成功，请继续添加');
                    $('#lesson_add_form')[0].reset();
                } else {
                    $.messager.alert('系统信息','课程添加失败，请重新添加');
                }
            }
        });

    })

</script>

</body>
</html>
