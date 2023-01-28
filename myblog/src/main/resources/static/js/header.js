

var target = document.querySelectorAll('.btn--open');
var btnPopClose = document.querySelectorAll('.popup--wrap .popup--cancel');
var targetID;

// 팝업열기
for (var i = 0; i < target.length; i++) {
	target[i].addEventListener('click', function() {
		targetID = this.getAttribute('href');
		document.querySelector(targetID).style.display = 'block';
		
		// jpg, png 만 등록가능하고 휴지통 이미지, 기능 추가
	$("#customfile").bind('change', function(){
		var fileName = $('#customfile').val().split('\\').pop();
		var idxDot = fileName.lastIndexOf(".") + 1;
		var extFile = fileName.substr(idxDot, fileName.length).toLowerCase();
		if (extFile != 'jpg' && extFile != 'jpeg' && extFile != 'png'){
			console.log(fileName);
			alert('jpg / jpeg / png 만 등록 가능합니다');
		} 
		else {
		$('#filename').val(fileName);
		$('.img--trash')[0].style.display = 'block';
		
		$('.img--trash').bind('click', function(){
			$('#customfile').val(null);
			$('#filename').val("");
			$('.img--trash')[0].style.display = 'none';
		});
		}
	})
	});
}

// 팝업 닫기
for(var i = 0; i < target.length; i++) {
	btnPopClose[i].addEventListener('click', function(){
		this.parentNode.parentNode.parentNode.parentNode.style.display = 'none';
	});
}
