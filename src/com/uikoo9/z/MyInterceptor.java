package com.uikoo9.z;

import com.jfinal.core.ActionInvocation;
import com.uikoo9.util.jfinal.QInterceptor;

public class MyInterceptor extends QInterceptor{

	@Override
	public boolean authVisit(ActionInvocation ai) {
//		Record user = ai.getController().getAttr("user");
		
		return true;
//		if(user == null){
//			return false;
//		}else{
//			String type = user.getStr("user_type");
//			if(type.equals(MyContants.USER_TYPE_CUSTOM) && !ai.getActionKey().startsWith("/ac")){
//				return false;
//			}else{
//				return true;
//			}
//		}

	}

}
