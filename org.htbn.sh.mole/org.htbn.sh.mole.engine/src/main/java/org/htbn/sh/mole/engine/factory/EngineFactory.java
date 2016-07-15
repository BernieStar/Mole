package org.htbn.sh.mole.engine.factory;

import java.util.List;

import org.htbn.sh.mole.engine.thread.EngineThreadPool;

public class EngineFactory <I>{
	
	//Generate thread pool
	public boolean initEngine(){
		EngineThreadPool.initPool();
		return true;
	}
	
	public boolean shutdownEngine(){
		return false;
	}
	
	
	
	
	
	
	
	
	
	public List<I> executeTask(List<I> tasks){
		
		return tasks;
	}
	
}
