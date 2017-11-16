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


// 이메일 체크
$('#l_emailcheck').on('click', function () {

	if ($('#l_uEmail').val() == "") {
		alert("이메일을 입력하셔야죠");
		$('#l_uEmail').focus();
		return false;
	};
	if ($('#l_uPassword').val() == "") {
		alert("암호는 빼먹으셨나요?");
		$('#l_uPassword').focus();
		return false;
	};
	return true;
});


// 이메일 중복체크


	
	$('#s_emailcheck').on('click', function () {
		

	if ($('#s_uEmail').val() == "") {
		alert("이메일을 입력하셔야죠");
		$('#s_uEmail').focus();
		return;
	};
	var url = "emailCheck.do?uEmail=" + $('#s_uEmail').val();
	window.open(url, "_blank_1","toolbar=no, menubar=no,scrollbars=yes," +
			"resizable=no,width=450,height=200");

});

	$('#emailok').on('click', function () {
		$("#c_uEmail",opener.document).val($('#c_uEmail').val());
		$("#re_uEmail",opener.document).val($('#c_uEmail').val());
		self.close();

	});


// singup joincheck
	
	$('#signup_c').on('click', function () {

		if ($('#s_uName').val() == "") {
			alert("이름을 써주세요");
			$('#s_uName').focus();
			return false;
		};
		if ($('#s_uEmail').val() == "") {
			alert("이메일을 입력하셔야죠");
			$('#s_uEmail').focus();
			return false;
		};
		
		
		if ($('#s_uPassword').val() == "") {
			alert("암호는 반드시 입력해야 하죠");
			$('#s_uPassword').focus();
			return false;
		};
		
		if ($('#s_uPassword').val() != $('#s_uPassword_check').val()) {
			alert("암호가 일치하지 않습니다.");
			$('#s_uPassword').focus();
			return false;
		};
		
		if ($('#s_re_uEmail').val() == "") {
			alert("중복 체크를 하지 않았습니다.");
			$('#s_uEmail').focus();
			return false;
		};
		
		
		
		return true;
	});



}); // 다큐먼트 종료
