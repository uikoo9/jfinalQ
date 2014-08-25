require(['jquery', 'bootstrap', 'qiao', 'qiaocrud'], function($, bs, qiao, crud){
	$(function(){
		crud.crud();
		qmask.qhide();
	});
});