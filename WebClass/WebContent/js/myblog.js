$(document).ready(function() {
	$('#loginForm').submit(function(event) {
		event.preventDefault();
		var id = $('#id').val();
		var pwd = $('#pwd').val();
		console.log(id, pwd);

		// 서버로 post 전송
		$.post("http://httpbin.org/post", {
			"id" : id,
			"pwd" : pwd
		}, function(data) {
			// alert(data.form.id+ '님 로그인되었습니다.');
			var myModal = $('#myModal');
			myModal.modal();
			myModal.find('.modal-body').text(data.form.id + '님 로그인되었습니다.');
		});
	});
});function menu_over(e) {
	e.setAttribute("class", "nav-item active"); // <li class="nav-item">
}
function menu_out(e) {
	e.setAttribute("class", "nav-item");
}
$(document).ready(function(){
	 $('#signForm').submit(function(event){
		 event.preventDefault();
		 var name1 = $('#name1').val();
		 console.log(name1);
		 
		 //서버로 post 전송
		 $.post("http://httpbin.org/post",
		 	{"name1" : name1},
		 	function(data){
				//alert(data.form.id+ '님 로그인되었습니다.');
				var myModal = $('#myModal');	
				myModal.modal();
				myModal.find('.modal-body').text(data.form.name1 + '님 회원가입 되었습니다.');
		 	});
	 });

 });