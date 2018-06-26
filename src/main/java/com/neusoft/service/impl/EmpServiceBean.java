package com.neusoft.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.neusoft.mapper.EmpMapper;
import com.neusoft.mybatis.SqlSessionUtil;
import com.neusoft.po.Emp;
import com.neusoft.service.EmpService;
import com.neusoft.vo.EmpDeptVO;

public class EmpServiceBean implements EmpService {

	@Override
	public List<Emp> findAll() {
		System.out.println("...EmpServiceBean...findAll().....");
		List<Emp> list=null;
		SqlSession session=SqlSessionUtil.getSession();
		EmpMapper mapper=session.getMapper(EmpMapper.class);
		try {
			list=mapper.findAll();
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public List<EmpDeptVO> findEmpDeptAll() {
		System.out.println("...EmpServiceBean...findEmpDeptAll().....");
		List<EmpDeptVO> list=null;
		SqlSession session=SqlSessionUtil.getSession();
		EmpMapper mapper=session.getMapper(EmpMapper.class);
		try {
			list=mapper.findEmpDeptAll();
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public List<Emp> findEmpDeptAll2() {
		System.out.println("...EmpServiceBean...findEmpDeptAll2().....");
		List<Emp> list=null;
		SqlSession session=SqlSessionUtil.getSession();
		EmpMapper mapper=session.getMapper(EmpMapper.class);
		try {
			list=mapper.findEmpDeptAll2();
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public List<Emp> findEmpLike1(Map m) {
		System.out.println("..EmpServiceBean..findEmpLike1...");
		SqlSession session=SqlSessionUtil.getSession();
		EmpMapper mapper=session.getMapper(EmpMapper.class);
		List list=null;
		try {
			list=mapper.findEmpLike1(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}


	@Override
	public List<Emp> findEmpLike2(Map m) {
		System.out.println("..EmpServiceBean..findEmpLike2...");
		SqlSession session=SqlSessionUtil.getSession();
		EmpMapper mapper=session.getMapper(EmpMapper.class);
		List list=null;
		try {
			list=mapper.findEmpLike2(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	@Override
	public List<Emp> findEmpLikeOther(Map m)  {
		System.out.println("..EmpServiceBean..findEmpLikeOther...");
		SqlSession session=SqlSessionUtil.getSession();
		EmpMapper mapper=session.getMapper(EmpMapper.class);
		List list=null;
		try {
			list=mapper.findEmpLikeOther(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	public static void main(String[] args)  {
		EmpServiceBean service=new EmpServiceBean();
		Map<String, Object> m=new HashMap<>();
		m.put("empno", null);
		m.put("ename", "R");
		m.put("deptno", null);
		m.put("sal", null);
		List<Emp> list=service.findEmpLikeOther(m);
		for(Emp e:list){
			System.out.println(e.getEmpno()+"\t"+e.getEname()+"\t"+e.getDeptno()+"\t"+e.getDept().getDname());
		}
	}
	public void test1(){
		EmpServiceBean service=new EmpServiceBean();
		Map<String, Object> m=new HashMap<>();
		m.put("ename", "%S%");
		m.put("deptno", 20);
		List<Emp> list=service.findEmpLike1(m);
		for(Emp e:list){
			System.out.println(e.getEmpno()+"\t"+e.getEname()+"\t"+e.getDeptno()+"\t"+e.getDept().getDname());
		}
	}
	public void test2(){
		EmpServiceBean service=new EmpServiceBean();
		Map<String, Object> m=new HashMap<>();
		m.put("ename", "S");
		m.put("deptno", 20);
		List<Emp> list=service.findEmpLike2(m);
		for(Emp e:list){
			System.out.println(e.getEmpno()+"\t"+e.getEname()+"\t"+e.getDeptno()+"\t"+e.getDept().getDname());
		}
	}

	@Override
	public void saveEmp(Emp emp) {
		// TODO Auto-generated method stub
		
	}


}
