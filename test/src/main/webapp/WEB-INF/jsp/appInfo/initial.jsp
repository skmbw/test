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
<title>应用列表</title>
<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/bootstrap/js/modal.js"></script>
<link rel="stylesheet" href="${ctx}/bootstrap/css/bootstrap.min.css">
<script type="text/javascript">

	function deleteUser(id) {
		var del = confirm('你确定要删除该应用？');
		if (del) {
			$.ajax({
	            type:"post",
	            dataType:"text",
	            url: '${ctx}/appInfo/delete?id=' + id,
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
			window.location.href="${ctx}/appInfo/add";
		});
	});
</script>
</head>
<body>
<div class="container">
<div class="row" style="margin-top:20px; margin-bottom:20px;">
	<button type="button" id="add_user" class="btn btn-primary">新增应用</button>
</div>
<div class="row">
<table class="table table-bordered table-hover table-condensed" >
<tr>
<td>应用ID</td>
<td>应用名</td>
<td>应用描述</td>
<td>创建时间</td>
<td>更新时间</td>
<td>操作</td>
</tr>
<c:forEach items="${list}" var="app" varStatus="i">
<tr style="${i.count%2==0?'background:#f3f3f3':''}">
<td>${app.appId}</td>
<td>${app.appName}</td>
<td>${app.appDesc}</td>
<td><fmt:formatDate value="${app.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
<td><fmt:formatDate value="${app.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
<td><a href="${ctx}/appInfo/detail.htm?appId=${app.appId}">详情</a> <a href="${ctx}/appInfo/edit?appId=${app.appId}">编辑</a> <a href="javascript:void(0);" onclick="javascript:deleteUser('${app.appId}');">删除</a></td>
</tr>

</c:forEach>
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