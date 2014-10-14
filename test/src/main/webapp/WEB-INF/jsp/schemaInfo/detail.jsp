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
<title>用户详情</title>
<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${ctx}/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container">
<div class="row" style="margin-top:20px;">
<table class="table table-bordered table-hover table-condensed">
<tr>
<td>Schema ID</td>
<td>${model.schemaId}</td>
</tr>
<tr>
<td>Schema名</td>
<td>${model.schemaName}</td>
</tr>
<tr>
<td>Schema描述</td>
<td>${model.schemaDesc}</td>
</tr>
<tr>
<td>数据库类型</td>
<td>${model.dbType}</td>
</tr>
<tr>
<td>IP地址</td>
<td>${model.ip}</td>
</tr>
<tr>
<td>数据库端口</td>
<td>${model.port}</td>
</tr>
<tr>
<td>JDBC URL</td>
<td>${model.jdbcUrl}</td>
</tr>
<tr>
<td>所属应用ID</td>
<td>${model.appId}</td>
</tr>
<tr>
<td>连接池初始化大小</td>
<td>${model.initialSize}</td>
</tr>
<tr>
<td>连接池最小空闲数</td>
<td>${model.minIdle}</td>
</tr>
<tr>
<td>连接池最大连接数</td>
<td>${model.maxActive}</td>
</tr>
<tr>
<td>获取连接的最大等待时间，单位毫秒</td>
<td>${model.maxWait}</td>
</tr>
<tr>
<td>空闲连接检查间隔，单位毫秒</td>
<td>${model.betweenEvictionRuns}</td>
</tr>
<tr>
<td>连接最少生存时间，单位毫秒</td>
<td>${model.minEvictableIdle}</td>
</tr>
<tr>
<td>验证连接SQL</td>
<td>${model.validationQuery}</td>
</tr>
<!-- <tr> -->
<!-- <td>是否清理空闲连接</td> -->
<%-- <td><c:if test="${model.testWhileIdle == 1}">是</c:if><c:if test="${model.testWhileIdle == 0}">否</c:if></td> --%>
<!-- </tr> -->
<!-- <tr> -->
<!-- <td>是否验证获取的连接</td> -->
<%-- <td><c:if test="${model.testOnBorrow == 1}">是</c:if><c:if test="${model.testOnBorrow == 0}">否</c:if></td> --%>
<!-- </tr> -->
<!-- <tr> -->
<!-- <td>是否验证归还的连接</td> -->
<%-- <td><c:if test="${model.testOnReturn == 1}">是</c:if><c:if test="${model.testOnReturn == 0}">否</c:if></td> --%>
<!-- </tr> -->
<!-- <tr> -->
<!-- <td>是否池化预处理语句</td> -->
<%-- <td><c:if test="${model.poolProparedStmt == 1}">是</c:if><c:if test="${model.poolProparedStmt == 0}">否</c:if></td> --%>
<!-- </tr> -->
<tr>
<td>是否清理空闲连接</td>
<td>${model.testWhileIdle}</td>
</tr>
<tr>
<td>是否验证获取的连接</td>
<td>${model.testOnBorrow}</td>
</tr>
<tr>
<td>是否验证归还的连接</td>
<td>${model.testOnReturn}</td>
</tr>
<tr>
<td>是否池化预处理语句</td>
<td>${model.poolProparedStmt}</td>
</tr>
<tr>
<td>每个连接的最大预处理语句数</td>
<td>${model.maxPstmtPerConn}</td>
</tr>
</table>

</div>
<div class="row">
<a class="btn btn-success" href="${ctx}/schemaInfo/initial">返回列表页</a>
</div>
</div>

</body>
</html>