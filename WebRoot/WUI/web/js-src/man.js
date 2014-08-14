require(['jquery', 'easyui', 'eui'], function($, easyui, eui){
	$(function(){
	    $('#tb').qtxt({
	        buttonText:'Search',
	        iconCls:'icon-man',
	        iconAlign:'left',
	        icons: [{
	    		iconCls:'icon-add',
	    		handler: function(e){
	    			$(e.data.target).textbox('setValue', 'Something added!');
	    		}
	    	},{
	    		iconCls:'icon-remove',
	    		handler: function(e){
	    			$(e.data.target).textbox('clear');
	    		}
	    	}]
	    });
	});
});
