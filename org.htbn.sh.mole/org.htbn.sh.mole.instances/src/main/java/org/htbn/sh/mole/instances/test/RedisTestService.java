package org.htbn.sh.mole.instances.test;

import org.htbn.sh.mole.common.bean.MoleTemplate;

public interface RedisTestService {
	
	public MoleTemplate<String, String> getTest(String para);
	
	public String getStringTest(String para);
	
	public void clearTest(String para);
}
