<%@ page import="model.Product" %>
<%@ page import="model.Usr" %>
<%@ page import="model.Cart" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Usr loginUsr = (Usr) session.getAttribute("loginUsr");
List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
List<Product> productList = (List<Product>)request.getAttribute("productList");
String errorMsg = (String)request.getAttribute("errorMsg");
Integer amount=0;
Integer total=0;

  if(cartList !=null){
    for(Cart cart : cartList){
    total=total+(cart.getPrice()*cart.getCount());
    amount=amount+cart.getCount();
    }
   }

%>

<!doctype html>
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
		<h1 class="logo"><a href="index.html"><img src="images/logo.png" alt="WORKBOOK SHOP"></a></h1>
		<nav class="nav">
			<ul>
<jsp:include page="/WEB-INF/jsp/_inc_navi.jsp"></jsp:include>
			</ul>
		</nav>
	</header>
	<!-- ヘッダー ここまで -->
	<!-- メイン -->
	<main>
		<h2 class="clear">商品一覧</h2>


    <table class="items" align="center">
    <tr><td><span class="center"><img src="images/cart.png"></span></td>
    <td><span class="center">カート：<%=amount %>点</span></td>
    <td><span class="center">合計金額：<%=total %>円</span></td>
    <td><form method="POST" action="Pay"><input type="submit" name="edit" value="カート編集・購入手続へ"></form></td>
    </tr>
    </table>
    <br>

		<table class="items" align="center">
<% if(productList !=null){ %>
<% for(Product product : productList){ %>
		<tr>
			<td><span class="center"><img src="images/item.png"><br><%= product.getP_name() %></spans></td>
			<td>単価：<%= product.getPrice() %>円</td>
			<td><form method="POST" action="Items" >
                <span class="center">購入数:<br><input type="number" name="count" min="1" max="10" value="0">
                <input type="hidden" name="p_id" value="<%= product.getP_id() %>">
                <input type="hidden" name="p_name" value="<%= product.getP_name() %>">
                <input type="hidden" name="price" value="<%= product.getPrice() %>">
                <input type="submit" name="add2cart" value="カート追加">
                </span></form></td>
		</tr>
<% }%>
<% }%>
		</table>

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