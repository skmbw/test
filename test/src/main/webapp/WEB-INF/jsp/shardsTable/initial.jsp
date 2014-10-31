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
<title>用户列表</title>
<script type="text/javascript" src="${ctx}/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/bootstrap/js/modal.js"></script>
<%-- <script type="text/javascript" src="${ctx}/js/angular.js"></script> --%>
<%-- <script type="text/javascript" src="${ctx}/js/angular-resource.js"></script> --%>
<%-- <script type="text/javascript" src="${ctx}/js/angular-shards-table.js"></script> --%>
<link rel="stylesheet" href="${ctx}/bootstrap/css/bootstrap.min.css">
<script type="text/javascript">

	function deleteUser(id) {
		var del = confirm('你确定要删除该用户？');
		if (del) {
			$.ajax({
	            type:"post",
	            dataType:"text",
	            url: '${ctx}/user/delete?id=' + id,
	            success: function(msg){
	            	//$('#myModal').modal('show');
	            	window.location.reload();
	            },
	            error: function (msg) {
	                alert(msg.responseText);
	            }
	        });
		}
	}
	$(document).ready(function(){
		$('#add_user').click(function(){
			window.location.href="${ctx}/shardsTable/add";
		});
	});
</script>
</head>
<body>
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
      <input type="text" class="form-control" id="inputAccount3" name="schemaName" ng-model="saveData.schemaName" placeholder="schema">
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
    <label for="inputAccoun6" class="col-sm-2 control-label">创建表sql语句</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputAccoun6" name="createSql" ng-model="saveData.createSql" placeholder="SQL语句">
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

<div class="row" style="margin-top:20px; margin-bottom:20px;">
	<button type="button" id="add_user" class="btn btn-primary">新增分区表</button>
</div>
<div class="row">
<table class="table table-bordered table-hover table-condensed" >
<tr>
<td>分区表ID</td>
<td>表名</td>
<td>使用中表名</td>
<td>数据库schema</td>
<td>分区策略</td>
<td>操作</td>
</tr>

<tr ng-repeat="table in mydata">
<td>{{table.id}}</td>
<td>{{table.tableName}}</td>
<td>{{table.currentTable}}</td>
<td>{{table.schemaName}}</td>
<td>{{table.strategy}}</td>
<td><a href="${ctx}/shardsTable/detail?id=${user.id}">详情</a> <a href="" ng-click="updateShardsTable(table)">编辑</a> <a href="javascript:void(0);" onclick="javascript:deleteUser('${user.id}');">删除</a></td>
</tr>

</table>
</div>

</div>

<div class="modal fade" id="delModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">温馨提醒您：</h4>
      </div>
      <div class="modal-body">
        	你确定要删除该用户？
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
        <button type="button" id="confirmDel" class="btn btn-primary">确认删除</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">温馨提醒您：</h4>
      </div>
      <div class="modal-body">
        	删除用户成功。
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="closeDelModal" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>