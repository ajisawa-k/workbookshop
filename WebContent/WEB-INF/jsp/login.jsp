<%@ page import="model.Usr" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Usr loginUsr = (Usr) session.getAttribute("loginUsr");
String errorMsg = (String)request.getAttribute("errorMsg");
%><!doctype html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Workbook shopへようこそ</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrapper">
	<!-- ヘッダー -->
	<header class="header">
		<h1 class="logo"><a href="index.html"><img src="images/logo.png" alt="KUJIRA Cafe"></a></h1>
		<nav class="nav">
			<ul>
<jsp:include page="/WEB-INF/jsp/_inc_navi.jsp"></jsp:include>
			</ul>
		</nav>
	</header>
	<!-- ヘッダー ここまで -->
	<!-- メイン -->
	<main>
		<h2 class="clear">会員ログイン</h2>
        <% if(loginUsr ==null){ %>
		<form method="POST" action="/WorkbookShop/Login">

			<table class="login" align="center">
			<tr>
				<th>ユーザーID(A200401)</th>
				<td><input type="text" name="user_id" value="" size="30"></td>
			</tr>
			<tr>
				<th>パスワード(pass200401)</th>
				<td><input type="password" name="password" size="30"></td>
			</tr>
			<tr>
				<td colspan="2"><span class="center">
                    <% if(errorMsg !=null){ %><%= errorMsg %><br><% } %>
                    <input type="submit" name="login" value="ログイン">
                </span></td>
			</tr>
			</table>
		</form>
        <% } %>
        <% if(loginUsr !=null){ %>
		<form method="POST" action="Login">

			<table class="login" align="center">
			<tr>
				<td colspan="2">下記の方でログインしています</td>
			</tr>
			<tr>
				<th>氏名</th>
				<td><%= loginUsr.getL_name() %> <%= loginUsr.getF_name() %>さん</td>
			</tr>
			<tr>
				<td colspan="2"><span class="center">

          <a href="Pay">==引き続き注文処理を行う方はこちらをクリックしてください==</a><br><br>

                    <input type="submit" name="logout" value="ログアウトします">
                </span></td>
			</tr>
			</table>
		</form>
        <% } %>
        <br><br><br><br><br><br>
	</main>
	<!-- メイン ここまで -->
	<!-- フッター -->
	<footer class="footer">
        <p>&copy;Copyright Workbook Shop. All rights reserved.</p>
	</footer>
	<!-- フッター ここまで -->
</div>
</body>
</html>