package org.htbn.sh.mole.instances.test;

import org.htbn.sh.mole.common.bean.MoleTemplate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisTestServiceImplTest extends SpringTestCase{
	
	@Autowired
	private RedisTestService redisTestService;
	

	@Test
	public void test()  {
		try{
			MoleTemplate<String, String> m =	redisTestService.getTest("aaa");
		System.out.println("Test:["+redisTestService.getTest("aaa").getTemplateId()+"]");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test:["+redisTestService.getTest("aaa").getTemplateId()+"]");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test:["+redisTestService.getTest("aaa").getTemplateId()+"]");
		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test:["+redisTestService.getTest("aaa").getTemplateId()+"]");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test1()  {
		System.out.println("Test:["+redisTestService.getStringTest("aaa")+"]");
	}
	
	@Test
	public void testClear()  {
		redisTestService.clearTest("aaa");
	}

}
