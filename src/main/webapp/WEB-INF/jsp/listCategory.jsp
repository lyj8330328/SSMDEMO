<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'listCategory.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
<div style="width:500px;margin:20px auto;text-align: center">
	<table align='center' border='1' cellspacing='0'>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>编辑</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${pageInfo.list}" var="c" varStatus="st">
			<tr>
				<td>${c.id}</td>
				<td>${c.name}</td>
				<td><a href="category/${pageInfo.pageNum }/${c.id }">编辑</a></td>
				<td>
					<form  action="category/${c.id }" method="post">
                        <input type="hidden" name="_method" value="DELETE"/>
                        <button type="submit">删除</button>
                    </form>
                </td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<div style="text-align:center">
		<a href="category?start=1">首  页</a>
        <a href="category?start=${pageInfo.pageNum-1}">上一页</a>
        <a href="category?start=${pageInfo.pageNum+1}">下一页</a>
        <a href="category?start=${pageInfo.pages}">末  页</a>
	</div>
	<form action="category" method="post">
            <!--修改提交方式为PUT-->
            <input type="hidden" name="_method" value="PUT"/>
            name:<input name="name"/><br/>
            <button type="submit">提交</button>
     </form>
</div>
</body>
</html>
