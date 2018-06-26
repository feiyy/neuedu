package com.neusoft.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.mapper.EmpMapper;
import com.neusoft.po.Emp;
import com.neusoft.service.EmpService;
import com.neusoft.vo.EmpDeptVO;

@Service
public class EmpServiceImp implements EmpService{
	
	@Autowired
	private EmpMapper empMapper;

	@Override
	public List<Emp> findAll() {
		// TODO Auto-generated method stub
		try {
			return empMapper.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<EmpDeptVO> findEmpDeptAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> findEmpDeptAll2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> findEmpLike1(Map m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> findEmpLike2(Map m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> findEmpLikeOther(Map m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveEmp(Emp emp) throws Exception {	
				
	   empMapper.addEmp(emp); 
	   
	   Integer.parseInt("s");
	   
	   Emp e2 = new Emp();
	   e2.setEname("xxxxx");
	   e2.setDeptno(10);
	   empMapper.addEmp(e2);  
			   
	}

}
