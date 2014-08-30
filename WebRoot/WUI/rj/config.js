/**
 * 非AMDjs文件引入
 */
requirejs.config({
	baseUrl : 'WUI',
    paths : {
    	jquery 		: 'http://cdn.staticfile.org/jquery/1.11.1/jquery.min',
      	bootstrap 	: 'http://cdn.staticfile.org/twitter-bootstrap/3.2.0/js/bootstrap.min',
//    	jquery 		: 'jquery/jquery-1.11.1.min',
//      bootstrap 	: 'bootstrap-3.2.0/bootstrap.min
        qiao		: 'qiao/qiao',
        qiaobs		: 'qiao/qiao.bs',
    	qiaocrud	: 'qiao/qiao.crud'
    },
    shim : {
	    bootstrap : {
            deps : ['jquery'],
            exports :'bs'
        }
    }
});