<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="base_url" value="http://localhost:8080/Ecommerce"></c:set>
<c:import url="../templates/header.jsp">
    <c:param name="base_url" value="${base_url}"></c:param>
</c:import>
<div id="content">
    <div class="latestProductTitle">
        <h1>LATEST PRODUCTS</h1>
    </div>
    <div class="contentWrapper">
        <div class="product">
            <div class="productPic">
                <img src="${base_url}/images/product.png" alt="product" />
            </div>
            <h1 class="title">Sunt Officia sed deserunt.</h1>
            <span class="price">&#36;100<sup>.00</sup></span>

        </div>
        <div class="product">
            <div class="productPic">
                <img src="${base_url}/images/product.png" alt="product" />
            </div>
            <h1 class="title">Sunt Officia sed deserunt.</h1>
            <span class="price">&#36;100<sup>.00</sup></span>
        </div>
        <div class="product">
            <div class="productPic">
                <img src="${base_url}/images/product.png" alt="product" />
            </div>
            <h1 class="title">Sunt Officia sed deserunt.</h1>
            <span class="price">&#36;100<sup>.00</sup></span>
        </div>
        <div class="clear"></div>
    </div>
    <div class="latestProductTitle">
        <h1>POPULAR PRODUCTS</h1>
    </div>
    <div class="contentWrapper">
        <div class="product">
            <div class="productPic">
                <img src="${base_url}/images/product.png" alt="product" />
            </div>
            <h1 class="title">Sunt Officia sed deserunt.</h1>
            <span class="price">&#36;100<sup>.00</sup></span>

        </div>
        <div class="product">
            <div class="productPic">
                <img src="${base_url}/images/product.png" alt="product" />
            </div>
            <h1 class="title">Sunt Officia sed deserunt.</h1>
            <span class="price">&#36;100<sup>.00</sup></span>
        </div>
        <div class="product">
            <div class="productPic">
                <img src="${base_url}/images/product.png" alt="product" />
            </div>
            <h1 class="title">Sunt Officia sed deserunt.</h1>
            <span class="price">&#36;100<sup>.00</sup></span>
        </div>
        <div class="clear"></div>
    </div>
</div>
<c:import url="../templates/footer.jsp">
    <c:param name="base_url" value="${base_url}"></c:param>
</c:import>