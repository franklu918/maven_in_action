<%--
  Created by IntelliJ IDEA.
  User: keer
  Date: 13-4-9
  Time: 下午9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>注册</h2>

<form name="signup" action="signup" method="post">
    <label>账户ID:</label>
    <input type="text" name="id"/><br/>
    <label>Email:</label><input type="text" name="email"/><br/>
    <img src="<%=request.getContextPath()%>/captcha_image?%>"/><br/>
    <button>确认提交</button>
</form>
</body>
</html>