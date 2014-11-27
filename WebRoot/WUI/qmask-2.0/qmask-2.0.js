/**
 * qmask遮罩<br>
 * @version 0.0.2.20141127
 * @history
 * 	0.0.2.20141127<br>
 * 	0.0.1.20141020<br>
 */
function Qmask(){
	var o = new Object();
	
	o.background = document.createElement('div');
	o.background.style.cssText = 'display:none;position:absolute;top:0;left:0;width:100%;height:100%;background-color:white;z-index:2001;';
	
	o.loading = document.createElement('div');
	o.loading.id = 'qmask';
	
	o.show = function(){
		this.background.style.display = 'block';
		this.loading.style.display = 'block';
	};
	o.hide = function(){
		this.background.style.display = 'none';
		this.loading.style.display = 'none';
	};
	
	document.body.appendChild(o.background);
	document.body.appendChild(o.loading);
	
	return o;
}
var qmask = new Qmask(); 
qmask.show();