<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<!-- meta 要素に http-equiv 属性が指定されると、その meta 要素はプラグマ指示子となります。プラグマ指示子はプラグマ
（ユーザエージェントへの指示） を指定するための名前のことです。 該当文書の処理の仕方や扱いを指定することができます。
... 文書の記述言語を指定のために使用します。 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<!-- "imagetoolbar" →meta要素で、イメージツールバーを無効にすることができます。
 イメージツールバーとは、文書内の画像（200×200ピクセル以上）にマウスポインタを合わせると、小さなツールバーが出てくるというものです。 -->
<meta http-equiv="imagetoolbar" content="no"/>
<!-- meta descriptionは、検索エンジンと検索ユーザーへ、ページの概要を伝えるためのタグです。 -->
<!-- 検索エンジンと検索ユーザーへ、ページの概要を伝えるためのタグ -->
<meta name="description" content=""/>
<!-- <meta name=”keywords” content=”キーワードA,キーワードB,キーワードC”>と設定 -->
<meta name="keywords" content=""/>
<!-- まだ検索エンジンの精度が低かった頃、そのページがどういったキーワードと親和性が高いかをクローラーに知らせるために活用されていた。 -->
<!-- ページ内で重要となる単語や、どのようなニーズの検索ユーザーに対して有益かを考え逆算してキーワードを設定するイメージです。 -->

<title>BuyItem画面</title>
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

#text-center{
	display: inline-block;
	text-align: center;
}
</style>
</head>
<body>
  <!-- <div>タグ→名称：division 範囲の指定（ブロックレベル）-->
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>BuyItem</p>
		</div>
		<div>
			<s:form action="BuyItemAction">
			<table>
				<!-- <tr>タグ→table row 表の行を作る -->
				<!-- <td>タグ→table data cell データ用のセルを作る -->
				<tr>
				    <td>
						<span>商品名</span>
					</td>
					<td>
						<!-- s:property→値の埋め込み。value属性にはActionクラスのプロパティを指定可能。 -->
						<s:property value="session.buyItem_name"/><br>
					</td>
				</tr>
				<tr>
					<td>
						<span>値段</span>
					</td>
					<td>
					<!-- s:property→値の埋め込み。value属性にはActionクラスのプロパティを指定可能。 -->
						<s:property value="session.buyItem_price"/><span>円</span>
					</td>
				</tr>
				<tr>
					<td>
						<span>購入個数</span>
					</td>
					<%-- <select>タグはセレクトボックスを作る --%>
					<!-- <option>タグは選択肢を作る -->
					<td>
						<select name="count">
							<option value="1" selected="selected">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<span>支払い方法</span>
					</td>
					<!-- <input>タグのtype属性でtype="radio"を指定すると、ラジオボタンが作成されます。
					ラジオボタンとは複数用意された選択肢の中からひとつを選択できるボタンのことです。 -->
					<td>
						<input type="radio" name="pay" value="1" checked="checked">現金払い
						<input type="radio" name="pay" value="2" >クレジッドカード
					</td>
	<!-- checked属性を指定すると、あらかじめその選択肢が選択された状態になります。 HTMLでは単にcheckedと記述することもできますが、
	XHTMLの場合には、checked="checked"と略さずに記述しなければならないので、 できるだけchecked="checked"と記述した方が良いでしょう -->
				</tr>
				<tr>
					<td>
					<!-- 送信ボタンの宣言。value属性はinputタグと同様の意味を持つ -->
						<s:submit value="購入"/>
					</td>
				</tr>
			</table>
			</s:form>
				<div>
					<%-- <s:url>→URLを生成する --%>
					<p>前画面に戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
					<p>マイページは<a href='<s:url action="MyPageAction"/>'>こちら</a></p>
				</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>

</body>
</html>