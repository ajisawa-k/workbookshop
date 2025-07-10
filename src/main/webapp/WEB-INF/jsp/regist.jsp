<%@ page import="model.Usr" %>
<%@ page import="model.GenPrefectureSel" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Usr loginUsr = (Usr) session.getAttribute("loginUsr");
if(loginUsr!=null){response.sendRedirect("Login");}
int status=(int)request.getAttribute("status");


Usr registUsr = (Usr) session.getAttribute("registUsr");
String errorMsg = (String)request.getAttribute("errorMsg");
if(errorMsg==null){
    errorMsg="";
}


GenPrefectureSel genPrefectureSel= new GenPrefectureSel();


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
		<h2 class="clear">新規会員登録</h2>
<%if(status==0){ %>
       <FORM action="Regist" method="post" >
		<table class="info" align="center">
    <%if(errorMsg!=""){ %>
        <tr>
          <th>入力エラー</th>
          <td><pre><%=errorMsg %></pre></td>
        </tr>
    <%} %>
        <tr>
			<th>ユーザーID</th>
			<td>自動で設定されます　　　　　　　　　　　　　　　　　　　　　</td>
		</tr>
		<tr>
			<th>パスワード</th>
			<td><input type="text" name="password" size="40" value="<%=registUsr.getPassword() %>"></td>
		</tr>
		<tr>
			<th>お名前</th>
			<td>(氏：)<input type="text" name="l_name" size="20" value="<%=registUsr.getL_name() %>">　(名：)<input type="text" name="f_name"  size="20"  value="<%=registUsr.getF_name() %>"></td>
		</tr>
		<tr>
			<th>おなまえ(フリガナ)</th>
			<td>(シ)：<input type="text" name="l_name_kana" size="20"  value="<%=registUsr.getL_name_kana() %>">　(メイ)：<input type="text" name="f_name_kana" size="20"  value="<%=registUsr.getF_name_kana() %>"></td>
		</tr>
		<tr>
			<th>住所</th>
			<td><%=genPrefectureSel.GenPrefectureSelTag(registUsr.getPrefecture()) %>

			<br>市区町村：<input type="text" name="city" size="20" value="<%=registUsr.getCity() %>"><br>番地・建物・号室：<input type="text" name="o_address" size="30"  value="<%=registUsr.getO_address() %>"></td>
		</tr>
		<tr>
			<th>電話番号</th>
			<td><input type="text" name="tel" size="40" value="<%=registUsr.getTel() %>"></td>
		</tr>
		<tr>
			<th>e-mail</th>
			<td><input type="email" name="email" size="50" value="<%=registUsr.getEmail() %>"></td>
		</tr>

		<tr>
			<td class="center" colspan="2" ><input type="submit" name="regist1" value="　　登録確認　　">　　　　　<input type="submit" name="clear" value="　入力クリア　"></td>
		</tr>
		</table>
        </FORM>
<% } %>
<%if(status==1){ %>
    <FORM method="POST" action="Regist">
    <table class="info" align="center">
    <tr>
      <th>ユーザーID</th>
	  <td>自動で設定されます　　　　　　　　　　　　　　　　　　　　　</td>
    </tr>
    <tr>
      <th>パスワード</th>
      <td><%=registUsr.getPassword() %></td>
    </tr>
    <tr>
      <th>お名前</th>
      <td>(氏)：<%=registUsr.getL_name() %>　(名)：<%=registUsr.getF_name() %></td>
    </tr>
    <tr>
      <th>おなまえ(フリガナ)</th>
      <td>(シ)：<%=registUsr.getL_name_kana() %>　(メイ)：<%=registUsr.getF_name_kana() %></td>
    </tr>
    <tr>
      <th>住所</th>
      <td>都道府県：<%=registUsr.getPrefecture() %>      <br>市区町村：<%=registUsr.getCity() %><br>番地・建物・号室：<%=registUsr.getO_address() %></td>
    </tr>
    <tr>
      <th>電話番号</th>
      <td><%=registUsr.getTel() %></td>
    </tr>
    <tr>
      <th>e-mail</th>
      <td><%=registUsr.getEmail() %></td>
    </tr>

    <tr>
      <td class="center" colspan="2" ><input type="submit" name="regist2" value="　　登録　　">　　　　　<input type="submit" name="regist0" value="　　修正　　"></td>
    </tr>
    </table>
    </FORM>
<% } %>
<%if(status==2){ %>
<%  Usr doneUsr=(Usr)request.getAttribute("registUsr"); %>
    <table class="login" align="center">
    <tr>
      <th colspan="2">登録完了</th>
    </tr>
    <tr>
      <th>氏名:</th>
      <td><%=doneUsr.getL_name() %>　<%=doneUsr.getF_name() %>　さん</td>
    </tr>
    <tr>
      <th>ユーザーID:</th>
      <td><%=doneUsr.getUser_id() %></td>
    </tr>
    <tr>
      <th>パスワード:</th>
      <td><%=doneUsr.getPassword() %></td>
    </tr>
    <tr>
      <td colspan="2"><span class="center"><br><br><form metohd="POST" action="Login"><input type="submit" name="history" value="　　　　　　こちらからログインし直してください　　　　　　"></form><br><br></span></td>
    </tr>
    </table>

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