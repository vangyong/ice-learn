package cn.segema.learn.ice.client;

import java.util.logging.Logger;

import Ice.Communicator;
import Ice.ObjectPrx;
import Ice.Util;
import cn.segema.learn.ice.hello.service.HelloServicePrx;
import cn.segema.learn.ice.hello.service.HelloServicePrxHelper;

/**
 * @category hello客户端
 * @author wangyong
 */
public class HelloClient {

	private static Logger log = Logger.getLogger(HelloClient.class.getSimpleName());

	public static void main(String[] args) {

		log.info("客户端启动...");

		// 通信器
		Communicator ic = null;
		// 初始化这个通信器
		ic = Util.initialize(args);
		// 根据地址生成一个服务代理对象
		// HelloIce -- 服务端那边自己定义的名字
		ObjectPrx proxy = ic.stringToProxy("HelloIce:default -p 1888");
		// 转换成HelloService类型的代理服务
		HelloServicePrx helloServicePrx = HelloServicePrxHelper.checkedCast(proxy);
		// 调用方法
		String str = helloServicePrx.sayHello("wangyong");
		System.out.println(str);

	}
}
