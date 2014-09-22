<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="shardsTableService">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增用户</title>
<script type="text/javascript" src="${ctx}/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${ctx}/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${ctx}/js/angular.js"></script>
<script type="text/javascript" src="${ctx}/js/angular-resource.js"></script>
<script type="text/javascript" src="${ctx}/js/angular-shards-table.js"></script>
</head>
<body ng-controller="shardsTableController">

<div class="container">

<div class="row" style="margin-top:20px;">
<form class="form-horizontal" role="form" action="${ctx}/shardsTable/doAdd" method="post">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">表名</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="tableName" ng-model="saveData.tableName" placeholder="表名">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccount3" class="col-sm-2 control-label">数据库</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputAccount3" name="dbschema" ng-model="saveData.dbschema" placeholder="schema">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">使用中表</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" name="currentTable" ng-model="saveData.currentTable" placeholder="使用中数据库表">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccount4" class="col-sm-2 control-label">分区策略</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputAccount4" name="strategy" ng-model="saveData.strategy" placeholder="分区策略">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccoun6" class="col-sm-2 control-label">手机号</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputAccoun6" name="mobilePhone" placeholder="手机号">
    </div>
  </div>
<!--   <div class="form-group"> -->
<!--     <label for="inputAccoun7" class="col-sm-2 control-label">电话号码</label> -->
<!--     <div class="col-sm-10"> -->
<!--       <input type="text" class="form-control" id="inputAccoun7" name="telephone" placeholder="电话号码"> -->
<!--     </div> -->
<!--   </div> -->
<!--     <div class="form-group"> -->
<!--     <label for="inputAccoun8" class="col-sm-2 control-label">用户权限</label> -->
<!--     <div class="col-sm-10"> -->
<!--       <select name="superAdmin" class="form-control"> -->
<!-- 		<option value="admin">管理员</option> -->
<!-- 		<option value="user">普通用户</option>	 -->
<!-- 	  </select> -->
<!--     </div> -->
<!--   </div> -->
<!--     <div class="form-group"> -->
<!--     <label for="inputAccoun9" class="col-sm-2 control-label">用户状态</label> -->
<!--     <div class="col-sm-10"> -->
<!--       <select name="state" class="form-control"> -->
<!-- 		<option value="1">正常</option>	 -->
<!-- 		<option value="0">禁用</option> -->
<!-- 	</select> -->
<!--     </div> -->
<!--   </div> -->
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="button" class="btn btn-primary" ng-click="addShardsTable()">添加分区表</button> <a href="${ctx}/shardsTable/initial" class="btn btn-info">返回列表页</a>
    </div>
  </div>
</form>

</div>

</div>


</body>
</html>