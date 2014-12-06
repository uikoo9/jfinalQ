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
			String userType = user.getStr("user_type");
			String actionKey = ai.getActionKey();

			if(MyContants.USER_TYPE_ADMIN.equals(userType)){
				return true;
			}
			if(MyContants.USER_TYPE_CUSTOM.equals(user) && (actionKey.startsWith("/ac") || actionKey.startsWith("/diary"))){
				return true;
			}
			
			return false;
		}
	}

}
