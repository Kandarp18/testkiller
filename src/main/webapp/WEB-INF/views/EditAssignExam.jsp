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
 <form method="post" action="updateassignexam">
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
        			<input type="hidden" name="assignExamId" value="${ae.assignExamId }" />
		          	<div class="form-group">
		          		<label>Exam Name</label>
		          		 <select name="examId" class="form-control" readonly required>
                         <option value="${ae.examId }">${ae.examName }</option>
                         </select>
		          	</div>
		          	<div class="form-group">
		          		<label>Subject Name</label>
		          		 <select name="subjectId" class="form-control" readonly required>
                         <option value="${ae.subjectId }">${ae.subjectName }</option>
                         </select>
		          	</div>
		          	<div class="form-group">
                        <label>Exam Date</label>
                        <input type="date" name="examDate" value="${ae.examDate }" id="examDate" class="form-control datepicker"  required data-parsley-trigger="keyup" />
                    </div>
                    <div class="form-group">
                        <label>Total Question</label>
                   <input type="text" name="totalQuestion" id="totalQuestion" value="${ae.totalQuestion }"  class="form-control" required data-parsley-pattern="/^[a-zA-Z0-9 \s]+$/" data-parsley-trigger="keyup" />
                        
                    </div>
		           <div class="form-group">
                        <label>Marks for Correct Answer</label>
                        <select name="rightMark" id="marks_per_right_answer" class="form-control">
                            <option value="${ae.rightMark }">${ae.rightMark }</option>
                            <option value="">Select</option>
                            <option value="1">+1 Mark</option>
                            <option value="2">+2 Mark</option>
                            <option value="3">+3 Mark</option>
                            <option value="4">+4 Mark</option>
                            <option value="5">+5 Mark</option>
                        </select>
                    </div>
		         
        		</div>
      
      <div class="modal-footer">
        <input type="submit" name="submit" id="submit" class="btn btn-success" value="Edit" />
       <a href="examsubject"> <button type="button" class="btn btn-default">Close</button></a>
      </div>
    </div>
     </div>
     </div>
     </form> 
     </div>
     </div>
     </div>        
<jsp:include page="AllJs.jsp"></jsp:include>  
<!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">?</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="logout">Logout</a>
                </div>
            </div>
        </div>
    </div>
                                
</body>
</html>