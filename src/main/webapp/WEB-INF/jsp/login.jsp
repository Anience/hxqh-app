<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
	<meta charset='utf-8'>
	<title>登录页面</title>
	<meta name="keywords" content="">
	<link rel="stylesheet" href="${ctx}/css/reset.css">
	<link rel="stylesheet" href="${ctx}css/login.css">
	<script src="${ctx}/js/login.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div class="login-layout">
	<div class="login-div">
		<div class="login-left-bg"></div>
		<div class="login-form">
			<div class="form-layout">
				<h4>TelKom Dashboard</h4>
				<div class="login-item">
					<label>UserName:</label>
					<input type="text" id="userName"/>
					<p class="msg-user"></p>
				</div>
				<div class="login-item">
					<label>Passsword:</label>
					<input type="password" id="pwd"/>
					<p class="msg-pwd"></p>
				</div>
				<div class="login-item">
					<label>Language:</label>
					<select name="_Language">
						<option value="en">EN</option>
						<option value="zh_CN">CH</option>
					</select>
				</div>
				<div>
					<input type="checkbox" name=""/>Remember
					<a href="" class="forgot">Forgot Password</a>
				</div>
				<div class="login-btn">
					<a href="javasript:void(0);">Sign in</a>
				</div>
			</div>
		</div>
	</div>
	<div class="login-footer">© Copyright CCSI Corp. 2017. All rights reserved. Please refer to the product license for details</div>
</div>
</body>
</html>
