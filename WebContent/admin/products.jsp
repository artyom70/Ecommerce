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
                            Forms
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> Forms
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                <c:forEach items="${requestScope.products }" var="product">
				<div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                            <div class="productImage" style="overflow: hidden;">
                            	<img alt="product" src="${pageContext.request.contextPath}/uploads/resize/${product.getProductImage()}">
                            </div>
                                ${product.getProductName() }sdssds
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>	
            	</div>
            	</c:forEach>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->
                <c:import url="../WEB-INF/adminTemplate/footer.jsp">
</c:import>