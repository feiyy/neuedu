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
		//1. �ļ��ϴ�
		 //1.1. ������ ʱ���+�ļ��� UUID+�ļ���
		String filename = System.currentTimeMillis()+upload.getOriginalFilename();
		 //1.2    �ļ������� ���ڵ�ǰ����ͬ��Ŀ¼��
		String path = request.getServletContext().getRealPath("/");
		
		File f = new File(path);
		String ppath = f.getParent();
		
		//1.3 ��ʱ-��Ŀ��
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
		//1. �ļ��ϴ�
		 //1.1. ������ ʱ���+�ļ��� UUID+�ļ���
		String filename = System.currentTimeMillis()+upload.getOriginalFilename();
		 //1.2    �ļ������� ���ڵ�ǰ����ͬ��Ŀ¼��
		String path = request.getServletContext().getRealPath("/");
		
		File f = new File(path);
		String ppath = f.getParent();
		
		//1.3 ��ʱ-��Ŀ��
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
