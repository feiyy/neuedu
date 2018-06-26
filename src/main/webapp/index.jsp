<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">myBatis--ORMapping映射</h1>

<hr>
<h3>1.<a href="<%=request.getContextPath()%>/test/EmpHandler_findAll.action">查询Emp表</a></h3>
<h3>2.<a href="<%=request.getContextPath()%>/test/EmpHandler_findAll2.action">查询EmpDeptVO</a></h3>
<h3>3.<a href="<%=request.getContextPath()%>/test/EmpHandler_findAll3.action">查询EmpDept多对一映射</a></h3>
<h3>4.<a href="<%=request.getContextPath()%>/test/EmpHandler_findDeptByDeptno.action?deptno=20">查询DeptEmp一对多映射</a></h3>
<h1 align="center">myBatis--动态SQL</h1>
<form action="test/EmpHandler_findEmpByOther.action" method="post">
id:<input name="empno" type="text"/><br><br>
name:<input name="ename" type="text"/><br><br>
sal:<input name="sal" type="text"/><br><br>
deptno:<input name="deptno" type="text"/><br><br>
<input name="submit" type="submit" value="查询"/>
</form>
</body>
</html>