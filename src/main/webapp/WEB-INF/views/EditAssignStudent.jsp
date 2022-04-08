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
 <form method="post" action="updateassignstudent">
                        <div class="row"><div class="col-md-6"><span id="message"></span><div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <div class="row">
                                    <div class="col">
                                        <h6 class="m-0 font-weight-bold text-primary">Edit Data</h6>
                                    </div>
                                  
                                </div>
                            </div>
                                   <div class="modal-body">
      
       
        			<span id="form_message">
        			<p style="color:red;">  ${error }</p>
        			</span>
        			
        			<input type="hidden" name="assignStudentId" value="${ast.assignStudentId }" />
        				
                    <div class="form-group">
                        <label>Class Name</label>
                        <select name="classId" id="classId" class="form-control" required >
                         
                                    <option value="${ast.classId }">${ast.className }</option>
                          <option value="">Select Class</option>
                        <c:forEach items="${classes }" var="c">
                            <option value="${c.classId }">${c.className }</option>
                             </c:forEach>
                            </select>

                    </div>
		          	<div class="form-group">
		          		<label>Student Name</label>
		          		<select name="studentId" id="studentId" class="form-control" required>
		       
		          		
		          	<option value="${ast.studentId }">${ast.studentName }</option>
		          		<option value="">Select Subject</option>
		          		<c:forEach items="${student }" var="s">
                           <option value="${s.studentId }">${s.studentName }</option>
                           </c:forEach> 
                        </select>       
		          	</div>
		          	<div class="form-group">
		          		<label>Roll No.</label>
		          		<input type="text" name="rollNo" value="${ast.rollNo}"  class="form-control" />
		          	</div>
        		</div>
      
      <div class="modal-footer">
        <input type="submit" name="submit" id="submit" class="btn btn-success" value="Edit" />
       <a href="assignstudent"> <button type="button" class="btn btn-default">Close</button></a>
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