package cn.segema.learn.ice.client;

import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Logger;

import Ice.Communicator;
import Ice.ObjectPrx;
import Ice.Util;
import cn.segema.learn.ice.fileserver.service.BytesHolder;
import cn.segema.learn.ice.fileserver.service.FileInfoHolder;
import cn.segema.learn.ice.fileserver.service.FileServerPrx;
import cn.segema.learn.ice.fileserver.service.FileServerPrxHelper;

public class FileServerClient {
	private static Logger log = Logger.getLogger(FileServerClient.class.getSimpleName());


    public static void main(String[] args) {

        log.info("文件客户端启动...");

        // 通信器
        Communicator ic = null;
        // 初始化这个通信器
        ic = Util.initialize(args);
        // 根据地址生成一个服务代理对象
        // HelloIce -- 服务端那边自己定义的名字
        ObjectPrx proxy = ic.stringToProxy("FileServer:default -h 127.0.0.1 -p 10030");
        // 转换成HelloService类型的代理服务 --5BAB238800000000001FEFF2
        
        FileServerPrx fileReadServerPrx = FileServerPrxHelper.checkedCast(proxy);
        //调用方法
        //String filename ="E:\\test\\t1.txt";
        String downfilename ="E:\\test_down\\t1.txt";
        
        FileInfoHolder fileinfo= new FileInfoHolder();
        
       boolean readFileInfoResult = fileReadServerPrx.ReadFileInfo("5BAB238800000000001FEFF2", fileinfo);
        
        byte[] buff = new byte[1048516];
        BytesHolder readbuffer = new BytesHolder(buff);
        FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(new File(downfilename));
			int readFileResult = fileReadServerPrx.ReadFile("5BAB238800000000001FEFF2", readbuffer);
			if(readFileResult>0) {
				outputStream.write(readbuffer.value, 0, readFileResult);
			}
		/*	while ((readFileResult = fileReadServerPrx.ReadFile("5BAB238800000000001FEFF2", readbuffer)) > 0  ) {
				outputStream.write(readbuffer.value, 0, readFileResult);
			}*/
			outputStream.close();
			log.info("客戶端文件写入完成！");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}   
       
        
        
        //測試代碼
		/*try {
			String filename ="E:\\test\\t1.txt";
	        String downfilename ="E:\\test_down\\t1.txt";
			int bytesum = 0;   
			int byteread = 0;   
	         InputStream inputStream = new FileInputStream(filename); //读入原文件   
	         FileOutputStream outputStream = new FileOutputStream(new File(downfilename));   
	         byte[] buffer = new byte[5120];   
	         while ( (byteread = inputStream.read(buffer)) != -1) {   
	             bytesum += byteread; //字节数 文件大小   
	             outputStream.write(buffer, 0, byteread);   
	         }   
	         inputStream.close();
	         outputStream.close();
	         System.out.println("bytesum:"+bytesum);
		} catch (Exception e) {
			e.printStackTrace();
		}   */
		
        System.out.println("調用完成");

    }
}
