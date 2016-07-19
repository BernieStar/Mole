package org.htbn.sh.mole.instances.factory;

import static org.junit.Assert.*;

import org.htbn.sh.mole.common.bean.MoleInstance;
import org.htbn.sh.mole.common.bean.MoleTemplate;
import org.htbn.sh.mole.common.enums.InstanceStatus;
import org.htbn.sh.mole.common.util.BNIdUtil;
import org.htbn.sh.mole.instances.redis.RedisUtils;
import org.htbn.sh.mole.instances.test.SpringTestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class InstancesFactoryTest extends SpringTestCase{

	@Autowired
	InstancesFactory <String,String,String,String> instancesFactory;
	
	@Autowired
	private RedisUtils redisUtil;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testGenerateInsstanceBizTypeResultBizIdMoleTemplateOfBizTypeResultInstanceStatus() {
		MoleTemplate<String,String> mole =  new MoleTemplate<String,String>();
		String templateId  = BNIdUtil.createUUIDByJDK();
		mole.setTemplateId(templateId);
		mole.setBizType("bizType");
		MoleInstance<String, String, String> instance = instancesFactory.generateInsstance("bizType", "insResult", "bizId", mole, InstanceStatus.ACTIVE);
	}

	@Test
	public void testGenerateInsstanceBizTypeResultBizIdMoleTemplateOfBizTypeResultInstanceStatusListOfString() {
		fail("Not yet implemented");
	}

	@Test
	public void testAnalyseInstance() {
		fail("Not yet implemented");
	}

	@Test
	public void testStoreInstance() {
		MoleTemplate<String,String> mole =  new MoleTemplate<String,String>();
		String templateId  = BNIdUtil.createUUIDByJDK();
		mole.setTemplateId(templateId);
		mole.setBizType("bizType");
		MoleInstance<String, String, String> instance = instancesFactory.generateInsstance("bizType", "insResult", "bizId", mole, InstanceStatus.ACTIVE);
		instancesFactory.storeInstance(instance);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MoleInstance<String, String, String> instance1 = (MoleInstance<String, String, String>) redisUtil.getValueCache(instance.getInstanceId());
		System.out.println(instance1.getInstanceId());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MoleInstance<String, String, String> instance2 = (MoleInstance<String, String, String>) redisUtil.getValueCache(instance.getInstanceId());
		System.out.println(instance2.getInstanceId());
	}

}
