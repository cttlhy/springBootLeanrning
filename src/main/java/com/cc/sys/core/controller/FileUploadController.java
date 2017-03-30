package com.cc.sys.core.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 文件上传
 * @author CTT
 *
 */
@Controller
@RequestMapping(path="cc/sys/core/controller/fileUploadController")
public class FileUploadController {
	
	@RequestMapping("/uploadFile")
	public String file(){
		System.out.println("--------");
		return "cc/sys/core/uploadFile";
	}
	
	/**
     * 文件上传具体实现方法;
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file")MultipartFile file){
       if(!file.isEmpty()){
           try {
              /*
               * 这段代码执行完毕之后，图片上传到了工程的跟路径；
               * 大家自己扩散下思维，如果我们想把图片上传到 d:/files大家是否能实现呢？
               * 等等;
               * 这里只是简单一个例子,请自行参考，融入到实际中可能需要大家自己做一些思考，比如：
               * 1、文件路径；
               * 2、文件名；
               * 3、文件格式;
               * 4、文件大小的限制;
               */
        	  long startTime = System.currentTimeMillis();
              BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File("d:/igFile")));
              out.write(file.getBytes());
              out.flush();
              out.close();
              long endTime = System.currentTimeMillis();
              System.out.println("二进制流上传耗时："+(endTime-startTime));
           } catch (FileNotFoundException e) {
              e.printStackTrace();
              return"上传失败,"+e.getMessage();
           } catch (IOException e) {
              e.printStackTrace();
              return"上传失败,"+e.getMessage();
           }
           return"上传成功";
       }else{
           return"上传失败，因为文件是空的.";
       }
    }
    
    @RequestMapping("/upload2")
    @ResponseBody
    public String handleFileUpload2(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
    	CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
    	//判断是否有文件上传
    	if (resolver.isMultipart(request)) {
			MultipartHttpServletRequest multiReq = (MultipartHttpServletRequest) request;
			Iterator<String> iter = multiReq.getFileNames();
			while (iter.hasNext()) {
				 long startTime = System.currentTimeMillis();
				MultipartFile file = multiReq.getFile(iter.next());
				if (file != null) {
					String myFileName = file.getOriginalFilename();
					if (!myFileName.trim().equals("")) {
						System.out.println(myFileName);
						String newFileName = "upload"+myFileName;
						String path = "d:/"+newFileName;
						File localFile = new File(path);
						file.transferTo(localFile);
						long endTime = System.currentTimeMillis();
			            System.out.println("解析器上传耗时："+(endTime-startTime));
					}
				}
			}
			return "上传成功";
		}else{
			return "请上传非空文件";
		}
    	
		
    }
}

