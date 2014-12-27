package com.uikoo9.fore.controller;

import com.jfinal.core.Controller;
import com.uikoo9.util.jfinal.QControllerUrl;

@QControllerUrl("/bootstrapQ")
public class BootstrapQController extends Controller{
	
	public void index(){
		render("/WEB-INF/view/fore/bill/bill-index.ftl");
	}
}
