package com.neusoft.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtil {

	private static SqlSessionFactory ssf = null;

	static {
		// ����Mybatis���������ļ�
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("SqlMapConfig.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ��������session�Ĺ����� session���������� -- �൱��connection
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		ssf = sfb.build(is);
	}

	public static SqlSession getSession() {
		return ssf.openSession();
	}

}
