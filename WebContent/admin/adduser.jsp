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
                            Users
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-user"></i>  <a href="${base_url }/users">Users</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> Add User
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
            	<div class="row">
                    <div class="col-lg-6">

                        <form role="form" action="${base_url }/users/add" method="post">

                            <div class="form-group">
                                <label>First Name</label>
                                <input class="form-control" type="text" name="firstName">
                            </div>
                            <div class="form-group">
                                <label>Last Name</label>
                                <input class="form-control" type="text" name="lastName">
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input class="form-control" type="email" name="email">
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input class="form-control" type="password" name="password">
                            </div>
                            <div class="form-group">
                                <label>Role</label>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="role" id="optionsRadios1" value="1" checked>Admin
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="role" id="optionsRadios1" value="2" checked>User
                                    </label>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-default">Add User</button>
            			</form>
          			</div>
         		</div>
            </div>
<c:import url="../WEB-INF/adminTemplate/footer.jsp">
</c:import>