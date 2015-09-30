package com.uikoo9.z.jfinal;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.uikoo9.manage.ucenter.model.UcenterUserModel;
import com.uikoo9.util.core.data.QStringUtil;
import com.uikoo9.util.core.file.QDocumentUtil;
import com.uikoo9.util.core.file.QPropertiesUtil;
import com.uikoo9.util.core.http.QRequestUtil;
import com.uikoo9.util.external.QFreemarkerUtil;
import com.uikoo9.util.function.QCacheUtil;

/**
 * 拦截器
 * @author qiaowenbin
 * @version 0.0.6.20140909
 */
public class QInterceptor implements Interceptor{
	
	private static final Logger logger = LoggerFactory.getLogger(QInterceptor.class);

	@Override
	public void intercept(Invocation ai) {
		// init sth
		init(ai.getController());
		
		// visit auth
		if(normalVisit(ai)){// 公开的地址
			ai.invoke();
		}else{// 私有的地址,只有登录且有权限的用户可以访问
			String res = authVisit(ai);
			if(res == null){
				ai.invoke();
			}else{
				ai.getController().redirect(res);
			}
		}
	}
	
	/**
	 * 缓存一些变量
	 * @param controller
	 */
	public void init(Controller controller){
		controller.setAttr("dev", QPropertiesUtil.getBoolean("jfinal.dev_mode"));
		controller.setAttr("title", QPropertiesUtil.get("web.html.title"));

		controller.setAttr("static", QFreemarkerUtil.getStaticClass("com.uikoo9.util.external.QStaticUtil"));
		
		controller.setAttr("base", QRequestUtil.getHttpPath(controller.getRequest()));
		controller.setAttr("user", QJfinalUtil.user(controller.getRequest()));
	}
	
	/**
	 * 是否可以访问正常路径
	 * @param ai
	 * @return
	 */
	private boolean normalVisit(Invocation ai){
		String actionKey = ai.getActionKey();
		String urlPara = ai.getController().getPara();
		
		if("/".equals(actionKey) && QStringUtil.isEmpty(urlPara)){
			return true;
		}else{
	        for(String path : getPaths()){
	        	if(actionKey.equals(path)) return true;
	        }
			
			return false;
		}
	}
	@SuppressWarnings("unchecked")
	private List<String> getPaths(){
		List<String> paths = new ArrayList<String>();
		
		try {
			Object pathsObject = QCacheUtil.getFromEHCache("paths");
			if(pathsObject == null){
				paths = QDocumentUtil.getTagValue("jfinal-auth.xml", "url");
				QCacheUtil.putToEHCache("paths", paths);
			}else{
				paths = (List<String>) pathsObject;
			}
		} catch (Exception e) {
			logger.error(QStringUtil.fromException(e));
		}
		
		return paths;
	}
	
	/**
	 * 是否有权限访问
	 * @param ai
	 * @return
	 */
	public String authVisit(Invocation ai) {
		try {
			UcenterUserModel user = ai.getController().getAttr("user");
			if(user != null){
				String urls = user.role().urls();
				String actionKey = ai.getActionKey();
				for(String url : urls.split(",")){
					if(actionKey.equals(url)){
						return null;
					}
				}
				
				return user.role().getStr("ucenter_role_login_url");
			}
		} catch (Exception e) {
			logger.error(QStringUtil.fromException(e));
		}
		
		return "/error/auth";
	}
	
}
