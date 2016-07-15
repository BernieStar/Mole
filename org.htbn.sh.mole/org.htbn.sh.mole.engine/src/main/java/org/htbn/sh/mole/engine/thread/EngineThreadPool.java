package org.htbn.sh.mole.engine.thread;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class EngineThreadPool {
	
	private static ExecutorService exeSrvice;
	
	public static ExecutorService initPool(){
		
		ThreadFactory threadfactory = new MoleThreadFactory();
		
		exeSrvice = Executors.newFixedThreadPool(100,threadfactory);
		
		return exeSrvice;
	}

	public static void execute(Runnable command) {
		// TODO Auto-generated method stub
		
	}

	public static void shutdown() {
		// TODO Auto-generated method stub
		
	}

	public static List<Runnable> shutdownNow() {
		// TODO Auto-generated method stub
		return exeSrvice.shutdownNow();
	}

	public static boolean isShutdown() {
		// TODO Auto-generated method stub
		return exeSrvice.isShutdown();
	}

	public boolean isTerminated() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean awaitTermination(long timeout, TimeUnit unit)
			throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	public <T> Future<T> submit(Callable<T> task) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> Future<T> submit(Runnable task, T result) {
		// TODO Auto-generated method stub
		return null;
	}

	public Future<?> submit(Runnable task) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
			throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<Future<T>> invokeAll(
			Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
			throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T invokeAny(Collection<? extends Callable<T>> tasks)
			throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
			long timeout, TimeUnit unit) throws InterruptedException,
			ExecutionException, TimeoutException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
