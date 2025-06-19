<%@ page import="model.Usr" %>
<%@ page import="model.Cart" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Usr loginUsr = (Usr) session.getAttribute("loginUsr");
List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
String errorMsg = (String)request.getAttribute("errorMsg");

boolean isOrdered = (Boolean)request.getAttribute("isOrdered");
Integer po_id = (Integer)request.getAttribute("po_id");

Integer amount=0;
Integer total=0;

  if(cartList !=null){
    for(Cart cart : cartList){
    total=total+(cart.getPrice()*cart.getCount());
    amount=amount+cart.getCount();
    }
   }

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
		<h2 class="clear">カート</h2>
      <HR>
<% if(loginUsr !=null){ %>
      <span class="left">送付先：<%=loginUsr.getL_name() %> <%=loginUsr.getF_name() %> 様(<%=loginUsr.getL_name_kana() %> <%=loginUsr.getF_name_kana() %> さま)</br>
      住所：<%=loginUsr.getPrefecture() %>　<%=loginUsr.getCity() %><%=loginUsr.getO_address() %><br>
      電話：<%=loginUsr.getTel() %><br>
      支払：代引き
      </span>
      <hr>
<% } %>


<!-- 注文完了時非表示開始 -->
<% if(!isOrdered){ %>

    <table class="items">
    <tr>
     <td><span class="center"><img src="images/cart.png"></span></td>
      <td><span class="center">購入点数：<%=amount %>点<br>支払合計金額:<%=total %>円<br><br>

<% if(total > 0 && loginUsr !=null){ %>
      <form action="Pay">
      <input type="submit" name="order" value="　　　　　発注　　　　　">
      </form>

      </td></tr></table>
<% } %>
<% if(total > 0 && loginUsr ==null){ %>
      <form action="Login">
      <input type="submit" name="payLogin" value="　　　注文前にログインしてください　　　">
      </form>
<% } %>

      </span></td>
    </tr>
    </table>
<br>


		<table class="items" align="center">

<% if(cartList !=null){ %>
<% for(Cart cart : cartList){ %>
            <tr>
			<td><span class="center"><img src="images/item.png"><br><%=cart.getP_name() %></spn></td>
			<td>単価：<%=cart.getPrice().toString() %>円<br>購入数: <%=cart.getCount().toString() %><br>小計: <%=cart.getPrice()*cart.getCount() %>円</td>
			<td>
              <form method="POST" action="Pay"><span class="center">
                <input type="hidden" name="p_id" value="<%= cart.getP_id() %>">
                <input type="hidden" name="p_name" value="<%= cart.getP_name() %>">
                <input type="hidden" name="price" value="<%= cart.getPrice() %>">
                <input type="hidden" name="count" value="<%= cart.getCount()%>">
              <input type="submit" name="rem2cart" value="　　削除　　"></span></form></td>
            </tr>
<% } %>
<% } %>

		</table>
		<br>
<!-- 注文完了時非表示終 -->
<% } %>

<% if(isOrdered){ %>
      <table class="login" align="center">
      <tr>
        <td colspan="2">下記の注文番号で発注が完了いたしました</td>
      </tr>
      <tr>
        <th>注文番号</th>
        <td><%=loginUsr.getUser_id()%>-<%=po_id%></td>
      </tr>
      <tr>
        <td colspan="2"><span class="center">
          <br>
          <a href="History">==注文確認を行う方はこちらをクリックしてください==</a><br><br>
          <br>
                </span></td>
      </tr>
      </table>
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