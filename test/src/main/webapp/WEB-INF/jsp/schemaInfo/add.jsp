<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增schema配置信息</title>
<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${ctx}/bootstrap/css/bootstrap.min.css">
</head>
<body>

<div class="container">

<div class="row" style="margin-top:20px;">
<form class="form-horizontal" role="form" action="${ctx}/schemaInfo/doAdd" method="post">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">Schema名</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="schemaName" placeholder="Schema名">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccount3" class="col-sm-2 control-label">Schema描述</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputAccount3" name="schemaDesc" placeholder="Schema描述">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccoun22" class="col-sm-2 control-label">数据库类型</label>
    <div class="col-sm-10">
      <select name="dbType" class="form-control">
		<option value="MySQL">MySQL</option>	
		<option value="Oracle">Oracle</option>
	  </select>
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccount4" class="col-sm-2 control-label">IP地址</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputAccount4" name="ip" placeholder="IP地址">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccoun6" class="col-sm-2 control-label">数据库端口</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputAccoun6" name="port" placeholder="数据库端口">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccoun7" class="col-sm-2 control-label">JDBC URL</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputAccoun7" name="jdbcUrl" placeholder="JDBC URL">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccoun8" class="col-sm-2 control-label">数据库密码</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputAccoun8" name="passwords" placeholder="数据库密码">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccoun9" class="col-sm-2 control-label">所属应用ID</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputAccoun9" name="appId" placeholder="所属应用ID">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccoun9" class="col-sm-2 control-label">连接池初始化大小</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputAccoun9" name="initialSize" placeholder="连接池初始化大小">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccoun9" class="col-sm-2 control-label">连接池最小空闲数</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputAccoun9" name="minIdle" placeholder="连接池最小空闲数">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccoun9" class="col-sm-2 control-label">连接池最大连接数</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputAccoun9" name="maxActive" placeholder="连接池最大连接数">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccoun9" class="col-sm-2 control-label">获取连接的最大等待时间，单位毫秒</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputAccoun9" name="maxWait" placeholder="获取连接的最大等待时间，单位毫秒">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccoun9" class="col-sm-2 control-label">空闲连接检查间隔，单位毫秒</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputAccoun9" name="betweenEvictionRuns" placeholder="空闲连接检查间隔，单位毫秒">
    </div>
  </div>
    <div class="form-group">
    <label for="inputAccoun9" class="col-sm-2 control-label">连接最少生存时间，单位毫秒</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputAccoun9" name="minEvictableIdle" placeholder="连接最少生存时间，单位毫秒">
    </div>
  </div>
    <div class="form-group">
    <label for="inputAccoun9" class="col-sm-2 control-label">验证连接SQL</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputAccoun9" name="validationQuery" placeholder="验证连接SQL">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccoun22" class="col-sm-2 control-label">是否清理空闲连接</label>
    <div class="col-sm-10">
      <select name="testWhileIdle" class="form-control">
		<option value="1">是</option>
		<option value="0">否</option>	
	  </select>
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccoun22" class="col-sm-2 control-label">是否验证获取的连接</label>
    <div class="col-sm-10">
      <select name="testOnBorrow" class="form-control">
		<option value="0">否</option>	
		<option value="1">是</option>
	  </select>
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccoun22" class="col-sm-2 control-label">是否验证归还的连接</label>
    <div class="col-sm-10">
      <select name="testOnReturn" class="form-control">
		<option value="0">否</option>	
		<option value="1">是</option>
	  </select>
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccoun22" class="col-sm-2 control-label">是否池化预处理语句</label>
    <div class="col-sm-10">
      <select name="poolProparedStmt" class="form-control">
		<option value="1">是</option>
		<option value="0">否</option>	
	  </select>
    </div>
  </div>
  <div class="form-group">
    <label for="inputAccoun22" class="col-sm-2 control-label">每个连接的最大预处理语句数</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputAccoun9" name="maxPstmtPerConn" placeholder="每个连接的最大预处理语句数">
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">添加用户</button> <a href="${ctx}/schemaInfo/initial" class="btn btn-info">返回列表页</a>
    </div>
  </div>
</form>

</div>

</div>


</body>
</html>