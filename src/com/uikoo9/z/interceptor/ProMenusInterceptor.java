package com.uikoo9.z.interceptor;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.uikoo9.manage.pro.model.ProDetailModel;
import com.uikoo9.util.QCacheUtil;
import com.uikoo9.util.contants.QContantsUtil;
import com.uikoo9.z.QContants;
import com.uikoo9.z.dto.ProMenuDTO;

/**
 * 注入项目菜单
 * @author uikoo9
 */
@SuppressWarnings("unchecked")
public class ProMenusInterceptor implements Interceptor{

	@Override
	public void intercept(ActionInvocation ai) {
		List<ProMenuDTO> dtos = null;
		
		Object value = QCacheUtil.getFromEHCache("proMenus");
		if(value == null){
			dtos = findProMenuDTO();
			QCacheUtil.putToEHCache("proMenus", dtos);
		}else{
			dtos = (List<ProMenuDTO>) value;
		}
		
		ai.getController().setAttr("proMenus", dtos);
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
