package cn.segema.learn.ice.hello.service.impl;

import java.util.logging.Logger;

import Ice.Current;
import cn.segema.learn.ice.hello.service._HelloServiceDisp;

public class HelloServiceImpl extends _HelloServiceDisp {
	
	private Logger log = Logger.getLogger(this.getClass().getSimpleName());

	/**
	 * 实现具体的服务接口中的方法
	 * 
	 * @param str
	 * @param __current
	 * @return
	 */
	@Override
	public String sayHello(String str, Current __current) {
		log.info("具体的服务接口实现类中的sayHello方法被调用了。。。");
		log.info("消息：" + str);
		return "Hello world :" + str;
	}
}
