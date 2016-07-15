package org.htbn.sh.mole.common.util;

import java.util.Date;
import java.util.Random;
import java.util.UUID;


public class BNIdUtil {

	public static synchronized String createUUIDByJDK(){
		//字段长度为36
		return UUID.randomUUID().toString();
	}
	
	public synchronized static String createUUIDByDATE(){        
	    //字段长度为20
		int a=0;
	    return BNDateUtil.getDateStyle1FromID().format(new Date()) + String.valueOf((a = new Random().nextInt(999))<100?a+100:a);
	}
	
	public static String createUUIDByDATE(String flag) {
		//字段长度为flag+20
	    return flag + createUUIDByDATE();
	}
	
}
