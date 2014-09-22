<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑用户</title>
<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${ctx}/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container">

<div class="row" style="margin-top:20px;">
<form class="form-horizontal" role="form" id="editForm" action="${ctx}/user/update.htm" method="post">
	<input type="hidden" name="id" value="${model.id}">
<input type="hidden" name="createDate" value='<fmt:formatDate value="${model.createTimes}" pattern="yyyy-MM-dd HH:mm:ss"/>'>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="userName" value="${model.userName}" placeholder="用户名">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccount3" class="col-sm-2 control-label">用户账号</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" id="inputAccount3" name="userAccount" value="${model.userAccount}" placeholder="电子邮件">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword3" name="password" value="${model.password}" placeholder="密码">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccount4" class="col-sm-2 control-label">公司名</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputAccount4" name="company" value="${model.company}" placeholder="公司名">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccoun6" class="col-sm-2 control-label">手机号</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputAccoun6" name="mobilePhone" value="${model.mobilePhone}" placeholder="手机号">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccoun7" class="col-sm-2 control-label">电话号码</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputAccoun7" name="telephone" value="${model.telephone}" placeholder="电话号码">
    </div>
  </div>
    <div class="form-group">
    <label for="inputAccoun8" class="col-sm-2 control-label">用户权限</label>
    <div class="col-sm-10">
      <select name="superAdmin" class="form-control">
		<option value="admin" <c:if test="${model.superAdmin eq 'admin'}">selected="selected"</c:if>>管理员</option>
		<option value="user" <c:if test="${model.superAdmin eq 'user'}">selected="selected"</c:if>>普通用户</option>	
	  </select>
    </div>
  </div>
    <div class="form-group">
    <label for="inputAccoun9" class="col-sm-2 control-label">用户状态</label>
    <div class="col-sm-10">
      <select name="state" class="form-control">
		<option value="1" <c:if test="${model.state == 1}">selected="selected"</c:if>>正常</option>	
		<option value="0" <c:if test="${model.state == 0}">selected="selected"</c:if>>禁用</option>
	</select>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">修改用户</button> <a href="${ctx}/user/initial.htm" class="btn btn-info">返回列表页</a>
    </div>
  </div>
</form>

</div>

</div>

</body>
</html>