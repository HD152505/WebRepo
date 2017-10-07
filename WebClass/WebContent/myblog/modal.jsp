<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class = "container">
<div class="modal" id = "myModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Result</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
<div class="modal-body">
        <p></p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" ></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
  <script>
  $(document).ready(function(){
	 $('#loginForm').submit(function(event){
		 //submitì´ ìëì¼ë¡ ëë ê¸°ë¥ì ë§ê¸°
		 event.preventDefault();
		 var id = $('#id').val();
		 var pwd = $('#pwd').val();
		 console.log(id,pwd);
		 
		 //ìë²ë¡ post ì ì¡
		 $.post("http://httpbin.org/post",
		 	{"id" : id,"pwd" : pwd},
		 	function(data){
				//alert(data.form.id+ 'ë ë¡ê·¸ì¸ëììµëë¤.');
				var myModal = $('#myModal');
				myModal.modal();
				myModal.find('.modal-body').text(data.form.id + '님 로그인 되었습니다.');
		 	});
	 });
  });
  $(function(){
	  
	  
  });