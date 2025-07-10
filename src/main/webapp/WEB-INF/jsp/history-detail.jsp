<%@ page import="model.Usr" %>
<%@ page import="model.OrderMain" %>
<%@ page import="model.OrderDesc" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

Usr loginUsr = (Usr) session.getAttribute("loginUsr");
//if(loginUsr==null){response.sendRedirect("Login");}

//if(loginUsr==null){response.sendRedirect("Login");}

//boolean toRedirect = (boolean)request.getAttribute("toRedirect");
//if(toRedirect){response.sendRedirect("Login");}


List<OrderMain> orderMainList=(List<OrderMain>)request.getAttribute("orderMainList");
List<OrderDesc> orderDescList=(List<OrderDesc>)request.getAttribute("orderDescList");

String errorMsg = (String)request.getAttribute("errorMsg");

//Integer po_id = (Integer)request.getAttribute("po_id");
Integer total=(Integer)request.getAttribute("total");
Integer counter=1;


%><!doctype html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Office BASE - すべてのオフィスに、最高の効率を。</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrapper">
	<!-- ヘッダー -->
	<header class="header">
		<h1 class="logo"><a href="index.html"><img src="images/logo.png" alt="Office BASE"></a></h1>
		<nav class="nav">
			<ul>
<jsp:include page="/WEB-INF/jsp/_inc_navi.jsp"></jsp:include>
			</ul>
		</nav>
	</header>
	<!-- ヘッダー ここまで -->
	<!-- メイン -->
	<main>
		<h2 class="clear">購入履歴詳細</h2>

		<table class="items">
		<tr>
			<td>注文番号</td>
			<td>注文日</td>
			<td>発送日</td>
			<td>合計金額</td>
		</tr>
<% for(OrderMain orderMain : orderMainList){ %>
		<tr>
			<td><%= loginUsr.getUser_id()%>-<%= orderMain.getPo_id() %></td>
			<td><%=orderMain.getOrder_date() %></td>
			<td><%=orderMain.getDelivery_date()%></td>
			<td><%=total %></td>
		</tr>
<% } %>
		</table>

		<br>

		<table class="items" align="center">
<% for(OrderDesc orderDesc : orderDescList){ %>
		<tr>
			<td><span class="center"><%=counter %></span></td>
			<td><span class="center"><img src="images/item.png"><br><%=orderDesc.getHist_p_name() %></span></td>
			<td>単価：<%=orderDesc.getHist_price() %>円<br>購入数:<%=orderDesc.getQuantity() %><br>小計:<%=orderDesc.getHist_price()*orderDesc.getQuantity() %>円</td>
		</tr>
<% counter++; %>
<% } %>
		</table>
		<br>
		<table class="items">
		<tr>
			<td><span class="center"><br><form method="POST" action="History"><input type="submit" name="back2history" value="　　　　　戻る　　　　　"></form></span></td>
		</tr>
		</table>

	</main>
	<!-- メイン ここまで -->
	<!-- フッター -->
	<footer class="footer">
        <p>&copy;Copyright Office BASE. All rights reserved.</p>
	</footer>
	<!-- フッター ここまで -->
</div>
</body>
</html>