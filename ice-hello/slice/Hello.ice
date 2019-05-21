[["java:package:cn.segema.learn.ice.hello"]]  //父包结构
module service{     //包名        具体生成的包为: 父包结构 + 包名      

    interface HelloService{ //接口名  不能用Ice作为接口名的开头

        string sayHello(string s);  //类型都是小写开头,常用的有string,int,long

    };

};