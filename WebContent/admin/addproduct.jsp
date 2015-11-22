<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="base_url" value="http://localhost:8080/Ecommerce/admin"></c:set>
<c:import url="../WEB-INF/adminTemplate/header.jsp">
	<c:param name="base_url" value="${base_url }"></c:param>
</c:import>
<c:import url="../WEB-INF/adminTemplate/sidebar.jsp">
	<c:param name="base_url" value="${base_url }"></c:param>
</c:import>
<div id="page-wrapper">
            <div class="container-fluid">
            <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Products
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="glyphicon glyphicon-shopping-cart"></i>  <a href="${base_url }/products">Products</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> Add Product
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
            	<div class="row">
                    <div class="col-lg-6">

                        <form role="form" action="${base_url }/products/add" method="post" enctype="multipart/form-data">
                        	<div class="form-group">
                                <label>Categories</label>
                                <c:forEach items="${requestScope.categories }" var="category">
	                                <div class="radio">
	                                    <label>
	                                        <input type="radio" name="category" id="optionsRadios1" value="${category.getId() }" checked>${category.getCategoryName()}
	                                    </label>
	                                </div>
                                </c:forEach>                                             
                            </div>
                            <div class="form-group">
                                <label>Product Name</label>
                                <input class="form-control" name="productName" required="required">
                            </div>
                            <div class="form-group">
                                <label>Product Descrption</label>
                                <textarea class="form-control" name="productDesc" rows="3" required="required"></textarea>
                            </div>
                            <div id="productImages">
	                            <div class="form-group">
	                                <label>General Image</label>
	                                <i id="customImage" class="glyphicon glyphicon-plus"></i>
	                                <input type="file" name="image" required="required">
	                            </div>
                            </div>
                            <div class="form-group">
                                <label>Product Price</label>
                                <div class="form-group input-group">
	                                <span class="input-group-addon">$</span>
	                                <input type="text" class="form-control" name="price">
	                                <span class="input-group-addon">.00</span>
                           		 </div>
                            </div>
                            <div class="form-group">
                                <label>Product Size</label>
                                	<p class="help-block">Product size separate with ,</p>                              
                                <input class="form-control" name="productSize">
                            </div>
                            <button type="submit" class="btn btn-default">Add Product</button>
            			</form>
          			</div>
         		</div>
            </div>
<c:import url="../WEB-INF/adminTemplate/footer.jsp">
</c:import>