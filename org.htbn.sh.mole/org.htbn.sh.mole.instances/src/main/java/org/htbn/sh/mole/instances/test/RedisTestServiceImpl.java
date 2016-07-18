package org.htbn.sh.mole.instances.test;

import org.htbn.sh.mole.common.bean.MoleTemplate;
import org.htbn.sh.mole.common.util.BNIdUtil;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("RedisTestServiceImpl")
public class RedisTestServiceImpl implements RedisTestService {

	@Override
	@Cacheable(value="default",key="#para")
	public MoleTemplate<String,String> getTest(String para) {
		MoleTemplate<String,String> mole =  new MoleTemplate<String,String>();
		String templateId  = BNIdUtil.createUUIDByJDK();
		mole.setTemplateId(templateId);
		mole.setBizType("aadadsdsd");
		return mole;
	}

	@Override
	@CacheEvict(value = "default",key="#para")
	public void clearTest(String para) {
		System.out.println("clear ok !");
	}

	@Override
	public String getStringTest(String para) {
		Long t = System.currentTimeMillis();
		return para + t;
	}

}
