require(['jquery', 'eui'], function($, eui){
	$(function(){
		var form = $('#ff');
		form.qform({
			url:'',
			onSubmit: function(){
				if(!form.qform('validate')){
					alert(1);
					return false;
				}
			},
			success:function(data){
				alert(data);
			}
		});
	});
	
	$('input[type="button"]').click(function(){
		$('#ff').submit();
	});
});
