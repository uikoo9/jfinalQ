// bind submit
qiao.on('form','submit',submitCode);
function submitCode(){
	var $panel = $('div.panel');
	$panel.hide();
	
	var code = $.trim($('#md5Input').val());
	if(!code){
		$('div.form-group').addClass('has-error');
	}else{
		$.ajax({
			url : 'md5/md5',
			data : {code:code},
			type : 'post',
			dataType : 'json'
		}).done(function(json){
			if(json && json.success){
				$('div.resdiv:eq(0) span').html('<strong>' + code + '</strong>');
				$('div.resdiv:eq(1) span').html('<strong>' + json.msg + '</strong>');
				$panel.show();
			}else{
				alert('fail');
			}
		}).fail(function(){
			alert('fail');
		});
	}
	
	return false;
}

// bind input focus and reset status
qiao.on('#md5Input','focus',resetStatus);
function resetStatus(){
	$('div.form-group').removeClass('has-error');
}