require(['jquery', 'easyui', 'easyuizh', 'qiao'], function($, easyui, easyuizh, qiao){
	$(function(){
		$.parser.auto = false;
		$.parser.onComplete = function(ctx){spinner.stop();};
		$.parser.parse();
	});
});
