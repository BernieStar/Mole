package org.htbn.sh.mole.engine.thread;

import java.util.concurrent.ThreadFactory;

public class MoleThreadFactory implements ThreadFactory{

	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		Thread thread = new Thread(new MoleThread());
		return thread;
	}

}
