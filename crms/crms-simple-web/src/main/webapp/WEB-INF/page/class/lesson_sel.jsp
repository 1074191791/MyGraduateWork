<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2019/3/21
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <table id="lesson_sel_dg"></table>
    <div id="lesson_sel_tb">
        课程名<input type="text" name="lessonName"  id="qName" /> 
        课时<input type="text" name="lessonTime" id="qTime"/> 
        备注<input type="text" name="lessonRemark" id="qRemark"/> 
        <a id="standardQueryBtn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

        <c:if test="${login.status==1}">
            <a id="lesson_del" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">选中后删除</a>
        </c:if>

        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a id="lesson_remark" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">备注详情</a>
    </div>


    <script type="text/javascript">

        $(function(){

            $('#lesson_sel_dg').datagrid({
                fit:false,
                border:true,
                singleSelect:true,
                fitColumns:true,
                url : "${pageContext.request.contextPath}/lesson/showLessons",
                columns : [ [
                    {
                        field : 'id',
                        title : '编号',
                        width : 100
                    },
                    {
                        field : 'lessonName',
                        title : '课程名',
                        width : 200
                    },
                    {
                        field : 'addDate',
                        title : '开始时间',
                        width : 200
                    },
                    {
                        field : 'lessonTime',
                        title : '课时',
                        width : 200
                    },
                    {
                        field : 'lessonScore',
                        title : '学分',
                        width : 200
                    },
                    {
                        field : 'lessonRemark',
                        title : '备注',
                        width : 200
                    }

                ] ],
                toolbar:"#lesson_sel_tb",
                striped:true,
                rownumbers:true,
                pagination:true,
                pageNumber:1,
                pageSize:3,
                pageList:[3,6,9]
            });


            $("#standardQueryBtn").click(function(){
                $("#lesson_sel_dg").datagrid("load",{
                    "lessonName": $("#qName").val(),
                    "lessonTime": $("#qTime").val(),
                    "lessonRemark": $("#qRemark").val()
                });
            });


            //删除按钮
            $("#lesson_del").click(function () {

                if($("#lesson_sel_dg").datagrid("getSelected")!=null) {
                    $.messager.confirm('确认','您确认想要删除记录吗？',function(r){
                        if (r){
                            $.ajax({
                                type: "POST",
                                url: "${pageContext.request.contextPath}/lesson/delLesson",
                                data: "id="+$("#lesson_sel_dg").datagrid("getSelected").id,
                                success: function(msg){
                                    if(msg==1) {
                                        $.messager.alert("系统信息","删除成功");
                                        $("#lesson_sel_dg").datagrid("reload");
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

            //备注详情
            $("#lesson_remark").click(function(){
                $('#lesson_sel_remark').dialog({
                    title: '备注详情',
                    width: 500,
                    height: 700,
                    closed: false,
                    cache: false,
                    href: '${pageContext.request.contextPath}/class/lesson_sel_remark',
                    modal: true
                });
            })

        });
    </script>

    <div id="lesson_sel_remark"></div>

</body>
</html>
