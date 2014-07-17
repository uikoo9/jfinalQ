$(function(){
	// auto focus
	$('#md5input').focus();
	
	// bind
	$(document).off('focus', '#md5input').on('focus', '#md5input', resetInput);
	$(document).off('keydown', '#md5input').on('keydown', '#md5input', md5keydown);
	$(document).off('click', '#md5btn').on('click', '#md5btn', md5code);
});

// reset input
function resetInput(){
	$('.inputdiv').removeClass('has-error');
}

// key down
function md5keydown(e){
	if(e.keyCode == 13) md5code();
}

// submit code
function md5code(){
	var $panel = $('div.panel');
	$panel.hide();
	
	var code = $.trim($('#md5input').val());
	if(!code){
		$('.inputdiv').addClass('has-error');
	}else{
		resetInput();
		
		var $input 	= $('#md5input');
		var $submit = $('#md5btn');
		
		$input.attr('disabled',	'disabled');
		$submit.attr('disabled','disabled');
		var res = qiao.ajax({
			url : 'md5/md5',
			data : {code:code}
		});
		$input.attr('disabled',	null);
		$submit.attr('disabled',null);
		
		if(res && res.success){
			$('div.resdiv:eq(0) span').html('<strong>' + code + '</strong>');
			$('div.resdiv:eq(1) span').html('<strong>' + res.msg + '</strong>');
			$panel.show();
		}else{
			alert('ajax fail!');
		}
	}
}