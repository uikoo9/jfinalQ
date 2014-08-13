require(['jquery', 'easyui', 'eui'], function($, easyui, eui){
	$(function(){
		var form = $('#ff');
		form.qform('11', function(data){
			alert(data);
		});
	});
	
	$('input[type="button"]').click(function(){
		$('#ff').submit();
	});
});
