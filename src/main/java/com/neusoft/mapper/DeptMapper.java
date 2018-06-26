package com.neusoft.mapper;

import com.neusoft.po.Dept;

public interface DeptMapper {
	
	public Dept findDeptByDeptno(int deptno) throws Exception;
	
}
