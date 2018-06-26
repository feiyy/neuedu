package com.neusoft.service;

import java.util.List;
import java.util.Map;

import com.neusoft.po.Emp;
import com.neusoft.vo.EmpDeptVO;

public interface EmpService {
	public List<Emp> findAll();
	public List<EmpDeptVO> findEmpDeptAll();
	public List<Emp> findEmpDeptAll2();
	public List<Emp> findEmpLike1(Map m) ;
	public List<Emp> findEmpLike2(Map m) ;
	public List<Emp> findEmpLikeOther(Map m);
	public void saveEmp(Emp emp) throws Exception;
}
