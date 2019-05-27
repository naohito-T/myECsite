<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>Admin画面</title>
<style type="text/css">

body {
	margin: 0;
	padding: 0;
	line-height: 1.6;
	letter-spacing: 1px;
	font-family: Verdana,Helvetica,sans-serif;
	font-size: 12px;
	color: #333;
	background: #fff;
}

table {
	text-align: center;
	margin: 0 auto;
}
#top {
	width: 780px;
	margin: 30px auto;
	border: 1px solid #333;
}
#header {
	width: 100%;
	height: 80px;
	background-color: black;
}
#main {
	width: 100%;
	height: 500px;
	text-align: center;
}
#footer {
	width: 100%;
	height: 80px;
	background-color: black;
	clear: both;
}
.box {
	height: 300px;
	text-align: center;
	border: 2px solid black;
}
.box_x {
	width:35%;
	height: 150px;
	margin-top: 45px;
}
.left {
	display: inline-block;
	border: 2px solid black;
}
.right {
	display: inline-block;
	border: 2px solid black;
}
</style>
</head>
<body>

	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>管理者画面</p>
		</div>
		<div class="box">
			<div class="left box_x">
			<p>商品</p>
				<div>
					<div>
						<s:form action="ItemCreateAction">
							<td><s:submit value="新規登録"/></td>
						</s:form>
						<s:form action="ItemListAction">
							<td><s:submit value="一覧"/></td>
						</s:form><s:form action="ItemListDeleteConfirmAction">
							<input type="hidden" name="deleteFlg" value="1">
							<s:submit value="削除"/>
						</s:form>

					</div>
				</div>
			</div>
			<div class="right box_x">
			<p>ユーザー</p>
				<div>
					<div>
						<s:form action="UserCreateAction">
							<td><s:submit value="新規登録"/></td>
						</s:form>
						<s:form action="UserListAction">
							<td><s:submit value="一覧"/></td>
						</s:form>
						<s:form action="UserListDeleteConfirmAction">
							<input type="hidden" name="deleteFlg" value="1">
							<s:submit value="削除"/>
						</s:form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>