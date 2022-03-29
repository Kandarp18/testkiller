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
 <form method="post" action="updatequestion">
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
        			<input type="hidden" name="questionId" value="${q.questionId }" />
		          	<div class="form-group">
		          		<label>Exam Name</label>
		          		 <select name="examId" class="form-control" readonly required>
                         <option value="${q.examId }">${q.examName }</option>
                         </select>
		          	</div>
		          	<div class="form-group">
		          		<label>Subject Name</label>
		          		 <select name="subjectId" class="form-control" readonly required>
                         <option value="${q.subjectId }">${q.subjectName }</option>
                         </select>
		          	</div>
		          	<div class="form-group row">
                        <label class="col-sm-3 col-form-label">Question Title</label>
                        <div class="col-sm-9">
                            <input type="text" name="question" value="${q.question }" id="question" class="form-control datepicker" required data-parsley-trigger="keyup" />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">Option 1</label>
                        <div class="col-sm-9">
                            <input type="text" name="option1" value="${q.option1 }" id="option1" autocomplete="off" class="form-control" required />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">Option 2</label>
                        <div class="col-sm-9">
                            <input type="text" name="option2" value="${q.option2 }" id="option2" autocomplete="off" class="form-control" required />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">Option 3</label>
                        <div class="col-sm-9">
                            <input type="text" name="option3" value="${q.option3 }" id="option3" autocomplete="off" class="form-control" required />
                        </div>
                    </div>
		          	 <div class="form-group row">
                        <label class="col-sm-3 col-form-label">Option 4</label>
                        <div class="col-sm-9">
                            <input type="text" name="option4" value="${q.option4 }" id="option4" autocomplete="off" class="form-control" required />
                        </div>
                    </div>
                    
		          	
		                  <div class="form-group row">
                        <label class="col-sm-3 col-form-label">Answer</label>
                        <div class="col-sm-9">
                            <select name="answer" id="answer" class="form-control" required>
                            <option value="${q.answer }">${q.answer }</option>
                                <option value="">Select</option>
                                <option value="option1">1 Option</option>
                                <option value="option2">2 Option</option>
                                <option value="option3">3 Option</option>
                                <option value="option4">4 Option</option>
                            </select>
                        </div>
                    </div>
        		</div>
		         
        		
      
      <div class="modal-footer">
        <input type="submit" name="submit" id="submit" class="btn btn-success" value="Edit" />
       <a href="examsubjectquestion"> <button type="button" class="btn btn-default">Close</button></a>
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
</html>>