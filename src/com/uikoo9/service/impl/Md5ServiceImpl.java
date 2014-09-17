package com.uikoo9.service.impl;

import org.springframework.stereotype.Service;

import com.uikoo9.service.Md5ServiceI;
import com.uikoo9.util.QEncodeUtil;
import com.uikoo9.util.QStringUtil;

@Service
public class Md5ServiceImpl implements Md5ServiceI{
	
	/* (non-Javadoc)
	 * @see com.uikoo9.service.Md5ServiceI#encode(java.lang.String)
	 */
	public String encode(String code){
		if(QStringUtil.notEmpty(code)){
			try {
				return QEncodeUtil.md5Encrypt(code);
			} catch (Exception e) {
				e.printStackTrace();
				return "md5 encode fail！";
			}
		}
		
		return "please enter sth.";
	}
	
}
