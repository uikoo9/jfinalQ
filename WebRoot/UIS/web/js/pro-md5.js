// bind submit
qiao.on('form','submit',submitCode);
function submitCode(){
	var $panel = $('div.panel');
	$panel.hide();
	
	var code = $.trim($('#md5Input').val());
	if(!code){
		$('div.form-group').addClass('has-error');
	}else{
		var res = qiao.ajax({
			url : 'md5/md5',
			data : {code:code}
		});
		
		if(res && res.success){
			$('div.resdiv:eq(0) span').html('<strong>' + code + '</strong>');
			$('div.resdiv:eq(1) span').html('<strong>' + res.msg + '</strong>');
			$panel.show();
		}else{
			alert('ajax fail!');
		}
	}
	
	return false;
}

// bind input focus and reset status
qiao.on('#md5Input','focus',resetStatus);
function resetStatus(){
	$('div.form-group').removeClass('has-error');
}