/**
 * 
 */


$(document).ready(function(){

$('.form').find('input, textarea').on('keyup blur focus', function (e) {
  
  var $this = $(this),
      label = $this.prev('label');

	  if (e.type === 'keyup') {
			if ($this.val() === '') {
          label.removeClass('active highlight');
        } else {
          label.addClass('active highlight');
        }
    } else if (e.type === 'blur') {
    	if( $this.val() === '' ) {
    		label.removeClass('active highlight'); 
			} else {
		    label.removeClass('highlight');   
			}   
    } else if (e.type === 'focus') {
      
      if( $this.val() === '' ) {
    		label.removeClass('highlight'); 
			} 
      else if( $this.val() !== '' ) {
		    label.addClass('highlight');
			}
    }

});

$('.tab a').on('click', function (e) {
  
  e.preventDefault();
  
  $(this).parent().addClass('active');
  $(this).parent().siblings().removeClass('active');
  
  target = $(this).attr('href');

  $('.tab-content > div').not(target).hide();
  
  $(target).fadeIn(600);
  
});



$('#emailcheck').on('click', function () {

	alert($('#l_uEmail').val());
	if ($('#uEmail').val() == null) {
		alert("아이디를 써주세요");
		$('#uEmail').focus();
	};
	if (document.frm.uPassword.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.uPassword.focus();
		return false;
	}
});

}); // 다큐먼트 종료




$('#uEmail').on('click', function (e) {
	  
	if (this)
	if (this.value.length == 0) {
		alert("아이디를 써주세요");
		frm.uEmail.focus();
		return false;
	}
	if (document.frm.uPassword.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.uPassword.focus();
		return false;
	}
});


function loginCheck() {
	alert("실행중");
	if (document.form.tab.login.frm.field.uEmail.value.length == 0) {
		alert("아이디를 써주세요");
		document.form.tab.login.frm.field.uEmail.focus();
		return false;
	}
	if (document.form.tab.login.frm.field.uPassword.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		document.form.tab.login.frm.field.uPassword.focus();
		return false;
	}
	return true;
}

function emailCheck() {
	if (document.frm.uEmail.value == "") {
		alert("이메일 주소를 입력하여 주십시오.");
		document.frm.uEmail.focus();
		return;
	}
	var url = "emailCheck.do?uEmail=" + document.frm.uEmail.value;
	window.open(url, "_blank_1","toolbar=no, menubar=no,scrollbars=yes,resizable=no,width=450,height=200");
}

function emailok(){
	opener.frm.uEmail.value=document.frm.uEmail.value;
	opener.frm.re_uEmail.value=document.frm.uEmail.value;
	self.close();
}


function joinCheck(){
	if(document.frm.uName.value.length == 0){
		alert("이름을 써주세요.");
		frm.uName.focus();
		return false;
	}
	if(document.frm.uEmail.value.length == 0){
		alert("이메일 주소를 써주세요");
		frm.uEmail.focus();
		return false;
	}
	
	if(document.frm.uPassword.value ==""){
		alert("암호는 반드시 입력해야 합니다.");
		frm.uPassword.focus();
		return false;
	}
	if(document.frm.uPassword.value != document.frm.uPassword_check.value){
		alert("암호가 일치하지 않습니다.");
		frm.uPassword.focus();
		return false;
	}
	if(document.frm.re_uEmail.value.length ==0){
		alert("중복 체크를 하지 않았습니다.");
		frm.uEmail.focus();
		return false;
	}
	return true;
}