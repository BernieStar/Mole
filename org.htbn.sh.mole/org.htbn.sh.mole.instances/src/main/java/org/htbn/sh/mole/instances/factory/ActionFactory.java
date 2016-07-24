package org.htbn.sh.mole.instances.factory;

import org.htbn.sh.mole.analyzer.Analyzer;
import org.htbn.sh.mole.analyzer.impl.SimpleActionAnalyzerImpl;
import org.htbn.sh.mole.common.bean.MoleActionInstance;
import org.htbn.sh.mole.common.bean.MoleActionTemplate;
import org.htbn.sh.mole.common.bean.MoleInstance;
import org.htbn.sh.mole.common.exception.InstanceAnalysisException;
import org.htbn.sh.mole.common.util.BNBeanUtil;
import org.htbn.sh.mole.common.util.BNIdUtil;
import org.htbn.sh.mole.common.util.RedisUtils;
import org.htbn.sh.mole.instances.operation.InstancesDataOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



/**
 * @param <BizType>
 * @param <Result>
 * @param <BizBean>
 * @param <BizId>
 * <li><b>ClassName :</b> ActionFactory</li>
 * <li><b>Author :   </b> Bernie</li>
 * <li><b>Date :     </b> 2016年7月19日 上午12:03:53</li>
 * <li><b>Description :</b> ActionFactory </li>
 * <style>*{color:#145b7d;}li{color:#00a6ac;list-style-type:square;}li b{color:#2585a6;}</style>
 */
@Component
public class ActionFactory<BizType,Result,BizBean,BizId> {
	
	private static final Logger logger = LoggerFactory.getLogger(ActionFactory.class);
	
	/**
	 * 不同的业务节点采用不用的分析器，所以不自动注入，需通过代码操作来set一个实现。
	 */
	private Analyzer<MoleActionInstance<BizType,Result,BizBean>> analyzer;
	
	@Value("#{propertiesReader['action.expireTime']}")
	private String expireTime;
	
	@Autowired
	private RedisUtils redisUtil;
	
	@Autowired
	private InstancesDataOperator<BizType,Result,BizId> instancesDataOperator;
	/**
	 * @param bizBean
	 * @param bizId
	 * @param actionTemplate
	 * @return
	 * @Description： 
	 */
	public  MoleActionInstance<BizType,Result,BizBean>  generateActionInstance(
			BizBean bizBean,String bizId,MoleActionTemplate<BizType,Result,BizBean> actionTemplate){
		
		MoleActionInstance<BizType,Result,BizBean> action = new MoleActionInstance<BizType,Result,BizBean>();
		
		BNBeanUtil.fieldCopy(MoleActionTemplate.class, actionTemplate, MoleActionInstance.class, action);
		
		String instanceActionId = BNIdUtil.createUUIDByDATE("IA-");
		
		action.setInstanceActionId(instanceActionId);
		
		action.setStatus(actionTemplate.getDefaultStatus());
		
		action.setResult(actionTemplate.getDefaultResult());
		
		action.setBizId(bizId);
		
		action.setBizBean(bizBean);
		
		logger.debug("generate action instance success : "+instanceActionId);
		
		return action;
	}
	
	public boolean analyseActionInstance(MoleInstance<BizType,Result,BizBean> instance,MoleActionInstance<BizType,Result,BizBean> actionInstance) throws InstanceAnalysisException{
		
		if(analyzer ==null){
			analyzer = new SimpleActionAnalyzerImpl<BizType, Result, BizBean>();
		}
		try{
			actionInstance  = analyzer.analyseForExecute(actionInstance);
		}catch(Exception e){
			throw new InstanceAnalysisException(e);
		}
		return true;
	}
	
	
	
	public boolean storeActionInstance(MoleActionInstance<BizType,Result,BizBean> actionInstance){
		Long expireTime = actionInstance.getExpireTime();
		expireTime = expireTime==null? Long.valueOf(this.expireTime) :expireTime;
		logger.debug("Instance expireTime is "+expireTime);
		redisUtil.setValueCache(actionInstance.getInstanceActionId(), actionInstance,expireTime );
		return true;
	}
	
	/**
	 * @param instance
	 * @param actionInstance
	 * @return
	 */
	public boolean installActionInstance(MoleInstance<BizType,Result,BizId> instance,MoleActionInstance<BizType,Result,BizBean> actionInstance){
		
		instancesDataOperator.addActionId(instance,actionInstance.getInstanceActionId());
		
		return true;
	}

	
	public Analyzer<MoleActionInstance<BizType, Result, BizBean>> getAnalyzer() {
		return analyzer;
	}

	public void setAnalyzer(Analyzer<MoleActionInstance<BizType, Result, BizBean>> analyzer) {
		this.analyzer = analyzer;
	}

	public String getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}
	
	
}
