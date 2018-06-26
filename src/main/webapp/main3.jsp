<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">myBatis--ORMapping映射--多对一的映射关系</h1>
<h1 align="center">myBatis--查询所有Emp_Dept记录</h1>
<hr>
<h3>1.<a href="<%=request.getContextPath()%>/test/EmpHandler_findAll.action">查询Emp表</a></h3>
<hr>
<c:forEach items="${requestScope.list }" var="e">
<h3>empno:${e.empno }</h3>
<h3>ename:${e.ename }</h3>
<h3>msgr:${e.mgr }</h3>
<h3>deptno:${e.deptno }</h3>
<h3>e.dept.deptno:${e.dept.deptno }</h3>
<h3>dname:${e.dept.dname }</h3>
<h3>loc:${e.dept.loc }</h3>
<hr>
</c:forEach>
</body>

</html>