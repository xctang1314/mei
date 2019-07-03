<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="../jquery-easyui-1.7.0/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="../jquery-easyui-1.7.0/themes/icon.css" />
	<link rel="stylesheet" type="text/css"
	href="../css/login.css" />
<script src="../jquery-easyui-1.7.0/jquery.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="../jquery-easyui-1.7.0/jquery.easyui.min.js"
	type="text/javascript" charset="utf-8"></script>
<script src="../js/login.js"
	type="text/javascript" charset="utf-8"></script>	
	
</head>
<body>
<div id='head'>
<div id='headlogo'><img alt="" src="../image/head.png"></div>
	
</div>

<div id='bg'>

	<div id='login'>
		<div id='formhead'>
			<div id='formhead1'><div style="font-size: 20px">邮箱账号登入&nbsp;&nbsp;&nbsp;</div></div>
			<div id='formhead2'><div style="font-size: 20px">&nbsp;&nbsp;&nbsp;手机号登入</div></div>
		</div>
		<div id='form'>
			<!--form-->
				<form id="ff" method="post">

					<div>
					&nbsp;&nbsp;&nbsp;&nbsp;
						<label style="width: 50px; left: 10px">Name:</label> <a
							class="easyui-linkbutton" iconCls="icon-man"></a> <input id="vv"
							class="easyui-validatebox" data-options="required:true"
							style="height: 30px">
					</div>
					<br>
					<div>
						<label style="width: 50px">Password:</label> <a
							class="easyui-linkbutton" iconCls="icon-lock"></a> <input
							class="easyui-passwordbox" data-options="required:true"
							style="height: 30px">
					</div>
					<br>
					<div>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="easyui-linkbutton" iconCls="icon-ok"
							onclick="javascript:window.location.href='http://localhost:8080/mei/jsp/index.jsp'">login</a>
						&nbsp;&nbsp;&nbsp;
						<a class="easyui-linkbutton" iconCls="icon-reload">Refresh</a>

					</div>
				</form>

			</div>
			<hr style="height:1px;border:none;border-top:1px solid #555555;" />
			
		<div id='formbutton'>
			<div id='formbutton1'><img src="../image/p1.png"/></div>
			<div id='formbutton2'><img src="../image/p2.png"/></div>
			<div id='formbutton3'><img src="../image/p3.png"/></div>
			
			<div id='formbutton4'>I Forgot My Password</div>
			
			<div id='formbutton5'>I Want to Register</div>
		</div>
	</div>


</div>



</body>
</html>

