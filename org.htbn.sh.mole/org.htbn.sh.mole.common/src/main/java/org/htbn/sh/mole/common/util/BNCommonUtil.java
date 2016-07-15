package org.htbn.sh.mole.common.util;

public class BNCommonUtil {
	/**
	 * @desc 字符串为null或是空字符串，返回true
	 * 
	 * */
	public static boolean isNull(String str){
		if(str == null || str.length() == 0){
			return true;
		}else{
			return false;
		}
	}
}
