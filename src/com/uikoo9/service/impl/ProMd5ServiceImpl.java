package com.uikoo9.service.impl;

import org.springframework.stereotype.Service;

import com.uikoo9.QContants;
import com.uikoo9.service.ProMd5ServiceI;
import com.uikoo9.util.QEncodeUtil;
import com.uikoo9.util.QStringUtil;

@Service
public class ProMd5ServiceImpl implements ProMd5ServiceI{
	
	/* (non-Javadoc)
	 * @see com.uikoo9.service.ProMd5ServiceI#encode(java.lang.String)
	 */
	public String encode(String code){
		if(QStringUtil.notEmpty(code)){
			try {
				return QEncodeUtil.md5Encrypt(code);
			} catch (Exception e) {
				e.printStackTrace();
				return QContants.T_MD5_FAIL;
			}
		}
		
		return QContants.T_MD5_REQ;
	}
	
}
