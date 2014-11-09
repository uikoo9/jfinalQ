package com.uikoo9.z.interceptor;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
import com.uikoo9.manage.pro.model.ProDetailModel;
import com.uikoo9.util.QCacheUtil;
import com.uikoo9.util.QStringUtil;
import com.uikoo9.util.contants.QContantsUtil;
import com.uikoo9.util.http.QCookieUtil;
import com.uikoo9.util.http.QRequestUtil;
import com.uikoo9.util.jfinal.QJfinalConfig;
import com.uikoo9.z.QContants;
import com.uikoo9.z.dto.ProMenuDTO;

/**
 * 拦截器
 * @author qiaowenbin
 * @version 0.0.7.20141109
 * @history
 * 	0.0.7.20141109
 * 	0.0.6.20140909
 */
@SuppressWarnings("unchecked")
public class QInterceptor implements Interceptor{

	@Override
	public void intercept(ActionInvocation ai) {
		Controller controller = ai.getController();
		init(controller);
		
		// can visit
		if(canVisit(ai) || isLogin(controller)){
			ai.invoke();
		}else{
			controller.redirect("/home");
		}
	}
	
	/**
	 * 判断是否可以访问系统
	 * @param ai
	 * @return
	 */
	private boolean canVisit(ActionInvocation ai){
		String url = ai.getActionKey();
		
		String paths = null;
		Object value = QCacheUtil.getFromEHCache("canVisitPaths");
		if(value == null){
			paths = QJfinalConfig.config.getProperty("canVisitPaths");
		}else{
			paths = (String) value;
		}
		
		if(QStringUtil.notEmpty(paths)){
			String[] ss = paths.split(",");
			for(String path : ss){
				if(url.startsWith(path)) return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 校验用户是否登录
	 * @param controller
	 * @return
	 */
	private boolean isLogin(Controller controller){
		String cookieUserId = QCookieUtil.getValue(controller.getRequest(), "uikoo9userid");
		if(QStringUtil.notEmpty(cookieUserId)){
			Object valueObject = QCacheUtil.getFromEHCache(cookieUserId);
			if(valueObject != null){
				controller.setAttr("user", (Record) valueObject);
				
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 缓存一些变量
	 * @param controller
	 */
	private void init(Controller controller){
		initBasePath(controller);
		initProDetails(controller);
		initProMenus(controller);
	}
	
	/**
	 * 缓存项目根路径
	 * @param controller
	 */
	private void initBasePath(Controller controller){
		String base = null;
		Object baseObject = QCacheUtil.getFromEHCache("base");
		if(baseObject == null){
			base = QRequestUtil.getHttpPath(controller.getRequest());
			QCacheUtil.putToEHCache("base", base);
		}else{
			base = (String) baseObject;
		}
		controller.setAttr("base", base);
		
		String baseUrl = QJfinalConfig.config.getProperty("baseUrl");
		if(QStringUtil.notEmpty(baseUrl)){
			controller.setAttr("baseurl", baseUrl);
		}
	}
	
	/**
	 * 缓存项目明细列表
	 * @param controller
	 */
	private void initProDetails(Controller controller){
		List<ProDetailModel> proDetails = null;
		
		Object value = QCacheUtil.getFromEHCache("proDetails");
		if(value == null){
			proDetails = ProDetailModel.dao.findAll("order by pro_sn");
			QCacheUtil.putToEHCache("proDetails", proDetails);
		}else{
			proDetails = (List<ProDetailModel>) value;
		}
		
		controller.setAttr("proDetails", proDetails);
	}
	
	/**
	 * 缓存管理菜单
	 * @param controller
	 */
	private void initProMenus(Controller controller){
		List<ProMenuDTO> dtos = null;
		
		Object value = QCacheUtil.getFromEHCache("proMenus");
		if(value == null){
			dtos = findProMenuDTO();
			QCacheUtil.putToEHCache("proMenus", dtos);
		}else{
			dtos = (List<ProMenuDTO>) value;
		}
		
		controller.setAttr("proMenus", dtos);
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
