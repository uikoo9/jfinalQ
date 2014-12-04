package com.uikoo9.z;

import com.jfinal.core.ActionInvocation;
import com.jfinal.plugin.activerecord.Record;
import com.uikoo9.util.jfinal.QInterceptor;

public class MyInterceptor extends QInterceptor{

	@Override
	public boolean authVisit(ActionInvocation ai) {
		Record user = ai.getController().getAttr("user");
		
		if(user == null){
			return false;
		}else{
			String type = user.getStr("user_type");
			String url = ai.getActionKey();

			if(type.equals(MyContants.USER_TYPE_ADMIN)){
				return true;
			}
			if(type.equals(MyContants.USER_TYPE_CUSTOM) && (url.startsWith("/ac") || url.startsWith("/diary") || url.startsWith("/blog"))){
				return true;
			}
			
			return false;
		}

	}

}
