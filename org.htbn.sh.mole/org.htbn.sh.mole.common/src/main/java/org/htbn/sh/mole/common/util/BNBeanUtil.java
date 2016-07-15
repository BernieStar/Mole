package org.htbn.sh.mole.common.util;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * <li><b>ClassName :</b> FMBeanUtil</li>
 * <li><b>Author :   </b> Famen Bernie Chen</li>
 * <li><b>Date :     </b> 2016年3月1日 下午3:01:12</li>
 * <style>*{color:#145b7d;}li{color:#00a6ac;list-style-type:square;}li b{color:#2585a6;}</style>
 */
/**
 * @author Bernie
 *
 */
@SuppressWarnings("serial")
public class BNBeanUtil implements  Serializable {
	
	
	/**
	 * @param clz_Source
	 * @param source
	 * @param clz_Target
	 * @param target
	 * @return
	 */
	public static <S,T> T fieldCopy(Class<S> clz_Source,S source,Class<T> clz_Target,T target){
		
		Method[] methods = clz_Source.getMethods();
		
		Method[] t_methods = clz_Target.getMethods();
		
		for(Method m : methods){
			String mName = m.getName();
			if(mName.length()>3){
				String _mName = mName.toLowerCase().substring(3);
				Method t_get =null;
				Method t_set =null;
				for(Method tm:t_methods){
					if(("set"+_mName).equalsIgnoreCase(tm.getName())){
						t_set=tm;
					}
					if(("get"+_mName).equalsIgnoreCase(tm.getName())){
						t_get=tm;
					}
				}
				try {
					if(t_get!=null&&t_set!=null){
						t_set.invoke(target, m.invoke(source));
					}
				} catch (InvocationTargetException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
					//logger.error(e);
				} 
			}
		}
		
		return target;
	}

	
	/**
	 * @param clz_Source
	 * @param source
	 * @param clz_Target
	 * @param target
	 * @param source_prefix
	 * @param target_prefix
	 * @return
	 */
	public static <S,T> T fieldCopy(Class<S> clz_Source,S source,Class<T> clz_Target,T target,String source_prefix,String target_prefix){
		
		Method[] methods = clz_Source.getMethods();
		
		Method[] t_methods = clz_Target.getMethods();
		
		for(Method m : methods){
			String mName = m.getName();
			if(mName.length()>3){
				String _mName = mName.toLowerCase().substring(3).replace(source_prefix,target_prefix );
				Method t_get =null;
				Method t_set =null;
				for(Method tm:t_methods){
					if(("set"+_mName).equalsIgnoreCase(tm.getName())){
						t_set=tm;
					}
					if(("get"+_mName).equalsIgnoreCase(tm.getName())){
						t_get=tm;
					}
				}
				try {
					if(t_get!=null&&t_set!=null){
						t_set.invoke(target, m.invoke(source));
					}
				} catch (InvocationTargetException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
					//logger.error(e);
				} 
			}
		}
		
		
		return target;
	}
	
	/**
	 * copy the fields of target which are null;
	 * @param clz_Source
	 * @param source
	 * @param clz_Target
	 * @param target
	 * @param source_prefix
	 * @param target_prefix
	 * @return
	 */
	public static <S,T> T fieldCopyForNull(Class<S> clz_Source,S source,Class<T> clz_Target,T target,String source_prefix,String target_prefix){
		
		Method[] methods = clz_Source.getMethods();
		
		Method[] t_methods = clz_Target.getMethods();
		
		for(Method m : methods){
			String mName = m.getName();
			if(mName.length()>3){
				String _mName = mName.toLowerCase().substring(3).replace(source_prefix,target_prefix );
				Method t_get =null;
				Method t_set =null;
				for(Method tm:t_methods){
					if(("set"+_mName).equalsIgnoreCase(tm.getName())){
						t_set=tm;
					}
					if(("get"+_mName).equalsIgnoreCase(tm.getName())){
						t_get=tm;
					}
				}
				try {
					if(t_get!=null&&t_set!=null&t_get.invoke(target)==null){
						t_set.invoke(target, m.invoke(source));
					}
				} catch (InvocationTargetException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
					//logger.error(e);
				} 
			}
		}
		return target;
	}
	
	
	/**
	 * copy the fields of source which are not null;
	 * @param clz_Source
	 * @param source
	 * @param clz_Target
	 * @param target
	 * @param source_prefix
	 * @param target_prefix
	 * @return
	 */
	public static <S,T> T fieldCoverUpdateNotNull(Class<S> clz_Source,S source,Class<T> clz_Target,T target,String source_prefix,String target_prefix){
		
		Method[] methods = clz_Source.getMethods();
		
		Method[] t_methods = clz_Target.getMethods();
		
		for(Method m : methods){
			String mName = m.getName();
			if(mName.length()>3){
				String _mName = mName.toLowerCase().substring(3).replace(source_prefix,target_prefix );
				Method t_get =null;
				Method t_set =null;
				for(Method tm:t_methods){
					if(("set"+_mName).equals(tm.getName().toLowerCase())){
						t_set=tm;
					}
					if(("get"+_mName).equals(tm.getName().toLowerCase())){
						t_get=tm;
					}
				}
				try {
					if(t_get!=null&&t_set!=null&m.invoke(source)!=null){
						t_set.invoke(target, m.invoke(source));
					}
				} catch (InvocationTargetException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
					//logger.error(e);
				} 
			}
		}
		return target;
	}
	
	public static void main(String age[]){
		
	}
}
