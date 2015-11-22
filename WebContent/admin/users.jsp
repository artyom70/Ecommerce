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
              <a href="${base_url }/users/add" style="float:right;margin:2px 5px;" class="btn btn-info" role="button">Add User</a>
				<div class="col-lg-14">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-user"></i> Users List</h3>
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered table-hover table-striped">
                                        <thead>
                                            <tr>
                                                <th>User Id</th>
                                                <th>First Name</th>
                                                <th>Last Name</th>
                                                <th>Email</th>
                                                <th>Role</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                   			<c:forEach items="${requestScope.users }" var="user">
	                                            <tr>	
	                                            	<td>${user.getId()}</td>
                                            	    <td>${user.getFirstName()}</td>
	                                                <td>${user.getLastName()}</td>
	                                                <td>${user.getEmail()}</td>
	                                                <td>${user.getGroup().getGroupName()}</td>
	                                            </tr>
                                     		</c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="text-right">
                                    <a href="#">View All Transactions <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->
<c:import url="../WEB-INF/adminTemplate/footer.jsp">
</c:import>
