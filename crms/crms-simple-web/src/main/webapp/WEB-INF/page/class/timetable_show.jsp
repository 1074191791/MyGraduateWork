<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2019/3/22
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <script type="text/javascript">
        $(document).ready(function () {
           /* var sss = $("#seasonChoice").val();
            $("#timeTableSeasonImage").attr("src",sss)*/
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/season/selectSeason",
                success: function(msg){
                    $("#timeTableSeasonImage").attr("src",'${pageContext.request.contextPath}/images/'+msg+'.jpg')
                }
            });
        })
    </script>

    <input type="hidden" id="seasonChoice" value="${pageContext.request.contextPath}/images/winter.jpg">
    <%--<img id="timeTableSeasonImage" src="${pageContext.request.contextPath}/images/autumn.jpg">--%>
    <img id="timeTableSeasonImage">

</body>
</html>
