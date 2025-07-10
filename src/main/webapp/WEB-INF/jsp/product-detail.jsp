<%@ page import="model.Product" %>
<%@ page import="model.Usr" %>
<%@ page import="model.Cart" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Usr loginUsr = (Usr) session.getAttribute("loginUsr");
List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
Product product = (Product)request.getAttribute("product");
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
    <title>Office BASE - すべてのオフィスに、最高の効率を。</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrapper">
	<!-- ヘッダー -->
	<header class="header">
		<h1 class="logo"><a href="index.html">Office BASE</a></h1>
		<nav class="nav">
			<ul>
<jsp:include page="/WEB-INF/jsp/_inc_navi.jsp"></jsp:include>
			</ul>
		</nav>
	</header>
	<!-- ヘッダー ここまで -->
	<!-- メイン -->
	<main>
		<% if(product != null) { %>
		<h2 class="clear">商品詳細</h2>
		
		<!-- 商品詳細情報 -->
		<div class="product-detail" style="max-width: 800px; margin: 0 auto; padding: 20px;">
			<div class="product-info" style="display: flex; gap: 40px; align-items: flex-start;">
				<div class="product-image" style="flex: 1;">
					<img src="images/item.png" alt="<%= product.getP_name() %>" style="width: 100%; max-width: 400px; border: 1px solid #ddd; border-radius: 8px;">
				</div>
				<div class="product-details" style="flex: 1;">
					<h3 style="color: #3c454d; margin-bottom: 20px; font-size: 24px;"><%= product.getP_name() %></h3>
					<p class="price" style="font-size: 28px; color: #d32f2f; font-weight: bold; margin-bottom: 20px;">¥<%= product.getPrice() %></p>
					
					<!-- 商品説明 (固定値 - 将来的にはDBから取得) -->
					<div class="product-description" style="margin-bottom: 30px;">
						<h4 style="color: #3c454d; margin-bottom: 10px;">商品説明</h4>
						<p style="line-height: 1.6; color: #666;">
							高品質な<%= product.getP_name() %>です。丁寧に作られた製品で、長くお使いいただけます。
							お部屋に合わせやすいデザインで、機能性も抜群です。
						</p>
					</div>
					
					<!-- 購入フォーム -->
					<div class="purchase-form" style="background: #f5f5f5; padding: 20px; border-radius: 8px;">
						<form method="POST" action="Items">
							<div style="margin-bottom: 15px;">
								<label for="count" style="display: block; margin-bottom: 5px; font-weight: bold;">購入数:</label>
								<input type="number" id="count" name="count" min="1" max="10" value="1" style="padding: 8px; width: 80px; border: 1px solid #ccc; border-radius: 4px;">
							</div>
							<input type="hidden" name="p_id" value="<%= product.getP_id() %>">
							<input type="hidden" name="p_name" value="<%= product.getP_name() %>">
							<input type="hidden" name="price" value="<%= product.getPrice() %>">
							<input type="submit" name="add2cart" value="カートに追加" style="background: #3c454d; color: white; padding: 12px 24px; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; width: 100%;">
						</form>
					</div>
				</div>
			</div>
		</div>
		
		<!-- ナビゲーション -->
		<div style="text-align: center; margin: 40px 0;">
			<a href="Items" style="color: #3c454d; text-decoration: none; background: #f0f0f0; padding: 12px 24px; border-radius: 4px; display: inline-block;">← 商品一覧に戻る</a>
		</div>
		
		<% } else { %>
		<h2 class="clear">商品が見つかりません</h2>
		<div style="text-align: center; margin: 40px 0;">
			<p>指定された商品が見つかりません。</p>
			<a href="Items" style="color: #3c454d; text-decoration: none; background: #f0f0f0; padding: 12px 24px; border-radius: 4px; display: inline-block;">商品一覧に戻る</a>
		</div>
		<% } %>

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