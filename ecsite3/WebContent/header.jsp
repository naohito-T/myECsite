<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="./js/header.js"></script>
<!-- 全てのjspでインクルードするjsp -->
<header>
<div id="header"></div>
<div id="header-title">NAO HAIR</div>
<div id="header-menu">
	<ul>
		<s:form id="form" name="form">
			<li><s:submit value="NEW HAIR" class="submit_btn" onclick="goNewHairAction();"/></li>
			<li><s:submit value="HIT HAIR" class="submit_btn" onclick="goHitHairAction();"/></li>
			<li><s:submit value="SHOP" class="submit_btn" onclick="goShopAction();"/></li>
			<li><s:submit value="PRICE" class="submit_btn" onclick="goPriceAction();"/></li>
			<li><s:submit value="STAFE" class="submit_btn" onclick="goStafeAction();"/></li>
			<li><s:submit value="PRODUCT" class="submit_btn" onclick="goProductAction();"/></li>
			<li><s:submit value="HAIR&MAKE" class="submit_btn" onclick="goHairMakeAction();"/></li>
			<li><s:submit value="INFO" class="submit_btn" onclick="goInfoAction();"/></li>
			<li><s:submit value="RECRUIT" class="submit_btn" onclick="goRecruitAction();"/></li>
		</s:form>
	</ul>
</div>
</header>