package com.neusoft.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.po.Dept;
import com.neusoft.po.Emp;
import com.neusoft.service.DeptService;
import com.neusoft.service.EmpService;
import com.neusoft.vo.EmpDeptVO;

@Controller
public class EmpHandler {
	@Autowired
	private EmpService empService;
	@Autowired
	private DeptService deptService;
	
	@RequestMapping(value="/test/EmpHandler_addEmp.action")
	public String addEmp() throws Exception
	{
		Emp emp = new Emp();
		emp.setEname("feiyy");
		emp.setJob("teacher");
		emp.setMgr(7369);
		emp.setSal(8000);
		emp.setDeptno(10);
		
		empService.saveEmp(emp);
		
		return "forward:/main.jsp";
	}
	
	@RequestMapping(value="/test/ajax.action")
	@ResponseBody
	public List<Emp> getAll()
	{
		return empService.findAll();
	}
	
	@RequestMapping(value="/test/addemp")
	@ResponseBody
	public String addEmpAjax(Emp emp)
	{
		try {
			empService.saveEmp(emp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//error
			return "{\"result\":false}";
		}
		
		//sucess
		return "{\"result\":true}";
	}
	
	@RequestMapping(value="/test/EmpHandler_findAll.action")
	public String findAll(HttpServletRequest request){
		System.out.println("....EmpHandler....findAll()......");
		List<Emp> list=empService.findAll();
		request.setAttribute("list", list);
		return "forward:/main.jsp";
	}
	@RequestMapping(value="/test/EmpHandler_findAll2.action")
	public String findAll2(HttpServletRequest request){
		System.out.println("....EmpHandler....findAll2()......");
		List<EmpDeptVO> list=empService.findEmpDeptAll();
		request.setAttribute("list", list);
		return "forward:/main2.jsp";
	}
	@RequestMapping(value="/test/EmpHandler_findAll3.action")
	public String findAll3(HttpServletRequest request){
		System.out.println("....EmpHandler....findAll3()......");
		List<Emp> list=empService.findEmpDeptAll2();
		request.setAttribute("list", list);
		return "forward:/main3.jsp";
	}
	@RequestMapping(value="/test/EmpHandler_findDeptByDeptno.action")
	public String findDeptByDeptno(HttpServletRequest request,int deptno){
		System.out.println("....EmpHandler....findDeptByDeptno()......");
		Dept d=deptService.findDeptByDeptno(deptno);
		
		request.setAttribute("dept", d);
		return "forward:/main4.jsp";
	}
	
	@RequestMapping(value="/test/EmpHandler_findEmpByOther.action")
	public String findEmpByOther(HttpServletRequest request){
		System.out.println("....EmpHandler....findDeptByDeptno()......");
		Map<String,Object> m=new HashMap<>();
		if(request.getParameter("empno")==null || request.getParameter("empno")==""){
			m.put("empno", null);
		}else{
			m.put("empno", request.getParameter("empno"));
		}
		if(request.getParameter("ename")==null || request.getParameter("ename")==""){
			m.put("ename", null);
		}else{
			m.put("ename", request.getParameter("ename"));
		}
		if(request.getParameter("sal")==null || request.getParameter("sal")==""){
			m.put("sal", null);
		}else{
			m.put("sal", Float.parseFloat( request.getParameter("sal")));
		}
		if(request.getParameter("deptno")==null || request.getParameter("deptno")==""){
			m.put("deptno", null);
		}else{
			m.put("deptno", Integer.parseInt( request.getParameter("deptno")));
		}
	//	System.out.println(e.getEmpno()+"\t"+e.getEname()+"\t"+e.getSal()+"\t"+e.getDeptno());
		System.out.println(m);
		List<Emp> list=empService.findEmpLikeOther(m);
		request.setAttribute("list", list);
		return "forward:/main5.jsp";
	}
}
