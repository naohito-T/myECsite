<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Hair</title>
</head>
<body>

<P>new hairページ</P>
<div id="hairlist">
<s:iterator value="hairInfoDTOList">
	<div class="hairlistbox">
	<ul>
		<li>
		<a href='<s:url action="StylistDetailsAction">
		</s:url>'><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="item-image-box"/><br>
		<s:property value="hairdiscription"/><br>   <%-- 値の埋め込み。value属性にはActionクラスのプロパティを指定可能。${変数名}の形式でも埋め込み可能。 --%>
		</a>
	  </li>
	</ul>
	</div>
</s:iterator>
</div>
</body>
</html>