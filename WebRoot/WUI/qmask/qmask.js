// 创建并添加遮罩
var background = document.createElement('div');
background.style.cssText = 'display:none;position:absolute;top:0;left:0;width:100%;height:100%;background-color:white;z-index:1001;-moz-opacity:0.7;opacity:.70;filter:alpha(opacity=70);';
document.body.appendChild(background);

// 创建并添加loading.gif
var loading = document.createElement('img');
loading.src = base + '/WUI/qmask/loading.gif';
loading.style.cssText = 'display:none;position:absolute;top:50%;left:50%;width:200px;height:200px;margin:-100px 0 0 -100px;z-index:1002;overflow:auto;';
document.body.appendChild(loading);

// 开启
qmask();

// 开启方法
function qmask(){
	background.style.display = 'block';
	loading.style.display = 'block';
}

// 隐藏方法
function qhide(){
	background.style.display = 'none';
	loading.style.display = 'none';
}