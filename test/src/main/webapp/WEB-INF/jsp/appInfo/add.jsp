<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增应用</title>
<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${ctx}/bootstrap/css/bootstrap.min.css">
</head>
<body>

<div class="container">

<div class="row" style="margin-top:20px;">
<form class="form-horizontal" role="form" action="${ctx}/appInfo/doAdd" method="post">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">应用名</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="appName" placeholder="应用名">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccount3" class="col-sm-2 control-label">应用描述</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputAccount3" name="appDesc" placeholder="应用描述">
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">新增应用</button> <a href="${ctx}/appInfo/initial.htm" class="btn btn-info">返回列表页</a>
    </div>
  </div>
</form>

</div>

</div>


</body>
</html>