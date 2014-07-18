// pro-md5.js
$(function(){
	$input 	= $('#md5input');
	$submit = $('#md5btn');
	$panel 	= $('div.panel');
	
	// auto focus
	$input.focus();
	
	// bind
	$(document).off('focus', '#md5input').on('focus', '#md5input', resetInput);
	$(document).off('keydown', '#md5input').on('keydown', '#md5input', md5keydown);
	$(document).off('click', '#md5btn').on('click', '#md5btn', md5code);
	
	// tooltip
	$input.tooltip({
		title : 'please enter code!',
		trigger : 'manual',
		container : 'body',
		placement : 'top'
	});
	
	// ajax status
	$(document).ajaxStart(function(){
		$input.attr('disabled',	'disabled');
		$submit.text('MD5...').attr('disabled','disabled');
		uikoo9.bs.dialog('loading...');
	});
	$(document).ajaxStop(function(){
		$input.attr('disabled',	null);
		$submit.text('MD5').attr('disabled',null);
		$('#bsmodal').modal('hide');
	});
});

// reset input
function resetInput(){
	$('.inputdiv').removeClass('has-error');
	$input.tooltip('hide');
}

// key down
function md5keydown(e){
	if(e.keyCode == 13) md5code();
}

// submit code
function md5code(){
	$panel.hide();
	
	var code = $.trim($input.val());
	if(!code){
		$('.inputdiv').addClass('has-error');
		$input.tooltip('show');
	}else{
		resetInput();
		
		var res = uikoo9.ajax({
			url : 'md5/md5',
			data : {code:code}
		});
		
		if(res && res.success){
			$('p.resp:eq(0) span').html('<strong>' + code + '</strong>');
			$('p.resp:eq(1) span').html('<strong>' + res.msg + '</strong>');
			$panel.slideDown();
		}else{
			alert('ajax fail!');
		}
	}
}