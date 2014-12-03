package com.uikoo9.z;

import com.uikoo9.util.contants.QContants;

/**
 * 常量
 * @author uikoo9
 */
public class MyContants extends QContants{
	
	// 项目类型
	public static final String PRO_TYPE_JAVASE		= "020101";
	public static final String PRO_TYPE_JAVAEE		= "020102";
	public static final String[] PRO_TYPE 			= new String[]{PRO_TYPE_JAVASE,PRO_TYPE_JAVAEE};
	
	// 支出分类
	public static final String ZHICHU_TYPE_EMPTY	= "030101";
	public static final String ZHICHU_TYPE_FANGZU	= "030102";
	public static final String ZHICHU_TYPE_HOME		= "030103";
	public static final String ZHICHU_TYPE_YIFU		= "030104";
	public static final String ZHICHU_TYPE_PHONE	= "030105";
	public static final String ZHICHU_TYPE_BUS		= "030106";
	public static final String ZHICHU_TYPE_FCARD	= "030107";
	public static final String ZHICHU_TYPE_FAN		= "030108";
	public static final String ZHICHU_TYPE_LINGSHI	= "030109";
	public static final String ZHICHU_TYPE_YAN		= "030110";
	public static final String ZHICHU_TYPE_OTHER	= "030111";
	public static final String[] ZHICHU_TYPE 		= new String[]{
		ZHICHU_TYPE_EMPTY,ZHICHU_TYPE_FANGZU,ZHICHU_TYPE_HOME,ZHICHU_TYPE_YIFU,
		ZHICHU_TYPE_PHONE,ZHICHU_TYPE_BUS,ZHICHU_TYPE_FCARD,ZHICHU_TYPE_FAN,
		ZHICHU_TYPE_LINGSHI,ZHICHU_TYPE_YAN,ZHICHU_TYPE_OTHER
	};

}
