package cn.segema.learn.ice.fileserver.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Logger;

import Ice.Current;
import Ice.StringHolder;
import cn.segema.learn.ice.fileserver.service.BytesHolder;
import cn.segema.learn.ice.fileserver.service.ExtInfoHolder;
import cn.segema.learn.ice.fileserver.service.FileInfo;
import cn.segema.learn.ice.fileserver.service.FileInfoHolder;
import cn.segema.learn.ice.fileserver.service._FileServerDisp;

public class FileServerServiceImpl extends _FileServerDisp{
	
	 private Logger log = Logger.getLogger(this.getClass().getSimpleName());

		@Override
		public boolean ReadFileInfo(String fileid, FileInfoHolder fileinfo, Current __current) {
			//測試文件信息
			try {
				String filename ="E:\\test\\中文文件.txt";
				InputStream inputStream = new FileInputStream(filename);
				FileInfo fileInfo = new FileInfo();
				Long fileLength = new File(filename).length();
				fileInfo.filename = "中文文件.txt";
				fileInfo.filesize= fileLength.intValue();
				fileinfo.value =fileInfo;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}

		@Override
		public int ReadFile(String fileid, BytesHolder readbuffer, Current __current) {
			try {
				String filename ="E:\\test\\中文文件.txt";
				 FileInputStream fis = new FileInputStream(filename);
				 byte[] buff = new byte[1048516];
	             int len;
	             int bytesum = 0; 
	             while ((len = fis.read(buff)) != -1) {
	            	 bytesum += len;
	            	 readbuffer.value = buff;
	             }
	             fis.close();
				return bytesum;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return 0;
		}
		
		

		@Override
		public boolean UpdateFileInfo(String fileid, FileInfo fileinfo, Current __current) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean CleanFileBlock(String timefrom, String timeto, int status, Current __current) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean GetExInfo(String fileid, String key, int vallen, StringHolder value, Current __current) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean GetAllExInfo(String fileid, ExtInfoHolder extinfo, Current __current) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean ReadFileInfoEx(String fileid, FileInfoHolder fileinfo, ExtInfoHolder extinfo, Current __current) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public long GenPcap(String pcapid, StringHolder fileid, Current __current) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public long ReadPcap(String fileid, long offset, long len, BytesHolder buf, Current __current) {
			// TODO Auto-generated method stub
			return 0;
		}
}
