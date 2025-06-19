<%@ page import="model.Usr" %>
<%@ page import="model.OrderMain" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Usr loginUsr = (Usr) session.getAttribute("loginUsr");
List<OrderMain> orderMainList=(List<OrderMain>)request.getAttribute("orderMainList");
String errorMsg = (String)request.getAttribute("errorMsg");

Integer po_id = (Integer)request.getAttribute("po_id");

Integer amount=0;
Integer total=0;



%><html lang="ja">
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
		<h1 class="logo"><a href="index.html"><img src="images/logo.png" alt="Workbook shop"></a></h1>
		<nav class="nav">
			<ul>
<jsp:include page="/WEB-INF/jsp/_inc_navi.jsp"></jsp:include>
			</ul>
		</nav>
	</header>
	<!-- ヘッダー ここまで -->
	<!-- メイン -->
	<main>
		<h2 class="clear">購買履歴</h2>

<% if(loginUsr !=null){ %>

		<table class="items">
		<tr>
			<td>注文番号</td>
			<td>注文日</td>
			<td>発送日</td>
			<td class="shortcut">注文詳細</td>
		</tr>
<% if(orderMainList !=null){ %>
<% for(OrderMain orderMain : orderMainList){ %>
		<tr>
			<td><%= loginUsr.getUser_id()%>-<%= orderMain.getPo_id() %></td>
			<td><%=orderMain.getOrder_date() %></td>
			<td><%=orderMain.getDelivery_date()%></td>
			<td class="shortcut"><span class="center"><form method="POST" action="HistoryDetail"><input type="hidden" name="po_id" value="<%= orderMain.getPo_id() %>"><input type="submit" name="HystoryDetail" value="詳細確認"></form></span></td>
		</tr>
<% } %>
<% } %>
		</table>
<% } %>

<% if(loginUsr ==null){ %>

    <table class="login" align="center">
    <tr>
      <th>購入履歴</th>
    </tr>
    <tr>
      <td><span class="center"><br><br><form metohd="POST" action="Login"><input type="submit" name="history" value="　　　購入履歴の確認にはこちらからログインしてください　　　"></form><br><br></span></td>
    </tr>
    </table>
    <br><br><br><br><br><br><br><br><br><br><br><br><br>
<% } %>



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