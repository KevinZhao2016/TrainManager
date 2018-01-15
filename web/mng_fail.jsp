<%--
  Created by IntelliJ IDEA.
  User: lipen
  Date: 2018/1/13
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>操作失败</title>
</head>
<body>
<a href="manage.jsp" id="jump">操作失败，3秒未自动跳转请点击</a>
<script>
    function make_click() {
        jump = document.getElementById('jump');
        jump.click();
    }
    setTimeout("make_click()", 3000);
</script>
</body>
</html>
