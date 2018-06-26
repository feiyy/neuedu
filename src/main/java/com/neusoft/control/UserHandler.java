package com.neusoft.control;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserHandler {
	
	@RequestMapping("/test/upload")
	public String upload(String username,String pwd, MultipartFile upload,HttpServletRequest request)
	{
		System.out.println(username);
		System.out.println(pwd);
		//1. 文件上传
		 //1.1. 重命名 时间戳+文件名 UUID+文件名
		String filename = System.currentTimeMillis()+upload.getOriginalFilename();
		 //1.2    文件传到哪 放在当前工程同级目录下
		String path = request.getServletContext().getRealPath("/");
		
		File f = new File(path);
		String ppath = f.getParent();
		
		//1.3 临时-》目的
		File dest = new File(ppath+"/upload",filename);
		try {
			upload.transferTo(dest);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/main.jsp";
		
	}
	
	@RequestMapping("/test/uploadajax")
	@ResponseBody
	public String uploadajax(String username,String pwd, MultipartFile upload,HttpServletRequest request)
	{
		System.out.println(username);
		System.out.println(pwd);
		//1. 文件上传
		 //1.1. 重命名 时间戳+文件名 UUID+文件名
		String filename = System.currentTimeMillis()+upload.getOriginalFilename();
		 //1.2    文件传到哪 放在当前工程同级目录下
		String path = request.getServletContext().getRealPath("/");
		
		File f = new File(path);
		String ppath = f.getParent();
		
		//1.3 临时-》目的
		File dest = new File(ppath+"/upload",filename);
		try {
			upload.transferTo(dest);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"result\":true}";
		
	}

}
