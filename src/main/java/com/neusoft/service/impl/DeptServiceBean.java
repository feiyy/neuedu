package com.neusoft.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.neusoft.mapper.DeptMapper;
import com.neusoft.mybatis.SqlSessionUtil;
import com.neusoft.po.Dept;
import com.neusoft.service.DeptService;

@Service
public class DeptServiceBean implements DeptService {

	@Override
	public Dept findDeptByDeptno(int deptno) {
		System.out.println("...DeptServiceBean.....findDeptByDeptno().......");
		Dept d=new Dept();
		SqlSession session=SqlSessionUtil.getSession();
		DeptMapper mapper=session.getMapper(DeptMapper.class);
		try {
			d=mapper.findDeptByDeptno(deptno);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return d;
	}

}
