package com.uikoo9.common.interceptor;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;
import com.uikoo9.QContants;
import com.uikoo9.common.dto.ProMenuDTO;
import com.uikoo9.manage.pro.model.ProDetailModel;
import com.uikoo9.util.contants.QContantsUtil;

public class IndexInterceptor implements Interceptor{

	@Override
	public void intercept(ActionInvocation ai) {
		Controller controller = ai.getController();
		
		// protypes
		controller.setAttr("promenus", findProMenuDTO());
		
		ai.invoke();
	}
	private List<ProMenuDTO> findProMenuDTO(){
		List<ProMenuDTO> dtos = new ArrayList<ProMenuDTO>();
		
		for(String value : QContants.C_PRO_TYPE){
			ProMenuDTO dto = new ProMenuDTO();
			dto.setValue(value);
			dto.setText(QContantsUtil.get(value));
			dto.setPros(ProDetailModel.dao.find("select * from t_pro_detail where pro_type=?", value));
			
			dtos.add(dto);
		}
		
		return dtos;
	}

}
