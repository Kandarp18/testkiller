  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Modal -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
  	<form method="post" action="updateclass">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="editModalLabel">Edit Class</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
       <div class="modal-body">
      
       
        			<span id="form_message"></span>
        			
        			<input type="hidden" name="classId" value="${c.classId }" />
		          	<div class="form-group">
		          		<label>Class Name</label>
		          		<input type="text" name="className" value="${c.className }"  class="form-control" />
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
        <input type="submit" name="submit" id="submit_button" class="btn btn-success" value="Edit" />
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
   
    </form>
  </div>
</div>
