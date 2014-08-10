requirejs.config({
    baseUrl: 'WUI',
    paths:{
        jquery : 'http://cdn.staticfile.org/jquery/2.1.1-rc2/jquery.min',
        bootstrap : 'http://cdn.staticfile.org/twitter-bootstrap/3.2.0/js/bootstrap.min',
        uikoo9 : 'uikoo9/uikoo9'
    },
    shim:{
	    bootstrap: {
            deps: ['jquery'],
            exports:'bs'
        }
    }
});