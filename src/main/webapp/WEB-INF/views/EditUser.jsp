<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testkiller</title>
<jsp:include page="AllCss.jsp"></jsp:include>
</head>
<body>
 <div id="wrapper">
<jsp:include page="AdminSideBar.jsp"></jsp:include>&nbsp;&nbsp;&nbsp;&nbsp;
               <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">


                   <jsp:include page="AdminHeader.jsp"></jsp:include>
 <form method="post" action="updateuser">
                        <div class="row"><div class="col-md-6"><span id="message"></span><div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <div class="row">
                                    <div class="col">
                                        <h6 class="m-0 font-weight-bold text-primary">Edit User</h6>
                                    </div>
                                  
                                </div>
                            </div>
                                   <div class="modal-body">
      
       
        			<span id="form_message"></span>
        			        <p style="color:red;">  ${error }</p>
        			       <input type="hidden" name="userId" value="${user.userId }" />
        			
		          	<div class="form-group">
		          		<label>User Name</label>
		          		<input type="text" name="userName" value="${user.userName }"  class="form-control" />
		          	</div>
		          	<div class="form-group">
		          		<label>Email Address</label>
		          		<input type="email" name="email" value="${user.email }"  class="form-control" />
		          	</div>
		          	<div class="form-group">
		          		<label>Gender</label>
		          		<select name="gender" id="gender" class="form-control">
		          	 <option value="${user.gender }">${user.gender }</option>
		          		
                          <option value="">Select Gender</option>
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                        </select>
		          	</div>
		          	<div class="form-group">
		          		<label>Contact No.</label>
		         <input type="text" name="contactNo" id="contactNo" value="${user.contactNo }" class="form-control datepicker"  required data-parsley-trigger="keyup" />
		          		
		          	</div>
		          	<div class="form-group">
                       <label >Role Name</label>
                   <select name="roleId" id="role" class="form-control" required>
                   <option value="${user.roleId }">${user.roleName }</option>
                         <option>Select Role</option>
                         <c:forEach items="${role }" var="role">
                              <option value="${role.roleId }">${role.roleName }</option>
                         </c:forEach>
                   </select>
                  </div>
		          	<div class="form-group">
		          		<label>Status</label>
		          		<select name="status" id="status" class="form-control" required>
		          		   <option value="Active">Active</option>
		          		   <option value="InActive">InActive</option>
		          		</select>
		          		 
		          	</div>
		         
        		</div>
      
      <div class="modal-footer">
        <input type="submit" name="submit" id="submit" class="btn btn-success" value="Edit" />
       <a href="users"> <button type="button" class="btn btn-default">Close</button></a>
      </div>
    </div>
     </div>
     </div>
     </form> 
     </div>
     </div>
     </div>        
<jsp:include page="AllJs.jsp"></jsp:include>                                  
</body>
</html>