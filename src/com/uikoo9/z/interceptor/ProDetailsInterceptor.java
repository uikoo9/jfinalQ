package com.uikoo9.z.interceptor;

import java.util.List;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.uikoo9.manage.pro.model.ProDetailModel;
import com.uikoo9.util.QCacheUtil;

/**
 * 注入项目列表
 * @author uikoo9
 */
@SuppressWarnings("unchecked")
public class ProDetailsInterceptor implements Interceptor{
	
	@Override
	public void intercept(ActionInvocation ai) {
		List<ProDetailModel> proDetails = null;
		
		Object value = QCacheUtil.getFromEHCache("proDetails");
		if(value == null){
			proDetails = ProDetailModel.dao.findAll("order by pro_sn");
			QCacheUtil.putToEHCache("proDetails", proDetails);
		}else{
			proDetails = (List<ProDetailModel>) value;
		}
		
		ai.getController().setAttr("proDetails", proDetails);
		ai.invoke();
	}
	
}
