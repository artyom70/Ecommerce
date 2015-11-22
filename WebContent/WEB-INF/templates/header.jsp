<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Ecommerce</title>
  <meta charset="utf-8">
  <meta name="keywords" content="ecommerce,online,shop" >
  <meta name="description" content="My First Ecommerce project with java" >
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/custom.js" ></script>
</head>
<body>
  <div id="headerTop">
    <div id="headerTopWrapper">
      <div class="language">
        <span>English &rarr;</span>
      </div>
      <div class="account">
        <span>My Account</span>
      </div>
      <div class="clear"></div>
    </div>
  </div>
  <div id="header">
    <div id="headerWrapper">
      <div id="logo">
        <a href="${param.base_url}"><img src="${param.base_url}/images/logo.png" alt="logo" /></a>
      </div>
      <div id="topMenu">
        <ul>
          <li><a href="">Men</a></li>
          <li><a href="">Women</a></li>
          <li><a href="">About</a></li>
          <li><a href="">Blog</a></li>
          <li><a href="">Support</a></li>
        </ul>
      </div>
      <div id="basket">
        <img src="${param.base_url}/images/card.png" alt="card" />
        <span id="cardPrice">500$</span>
      </div>
      <div class="clear"></div>
    </div>
  </div>
<div id="slide">
  <div id="slideWrapper">
    <h1>New Season Arrivals.</h1>
    <h3>Check out all the new trends</h3>
    <a href="#">SHOP NOW</a>
  </div>
</div>


