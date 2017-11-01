function RestaurantCheck() {
	if (document.frm.rName.value.length == 0) {
		alert("이름을 입력하세요.");
		return false;
	}
	if (document.frm.rAddress.value.length == 0) {
		alert("주소를 입력하세요.");
		return false;
	}
	if (document.frm.rTel.value.length == 0) {
		alert("전화번호를 입력하세요.");
		return false;
	}
	return true;
}
function open_win(url, name) {
	window.open(url, name, "width=500, height=230");
}
function passCheck() {
	if (document.frm.pass.value.length == 0) {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	return true;
}