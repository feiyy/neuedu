package com.neusoft.mapper;

import java.util.List;
import java.util.Map;

import com.neusoft.po.Emp;
import com.neusoft.vo.EmpDeptVO;


public interface EmpMapper {
	public List<Emp> findAll() throws Exception;
	public List<EmpDeptVO> findEmpDeptAll() throws Exception;
	public List<Emp> findEmpDeptAll2() throws Exception;
	public List<Emp> findEmpLike1(Map m) throws Exception;
	public List<Emp> findEmpLike2(Map m) throws Exception;
	public List<Emp> findEmpLikeOther(Map m) throws Exception;
	public void addEmp(Emp emp)throws Exception;
	
	
	
	
}
