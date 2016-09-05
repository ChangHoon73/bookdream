package com.mytest.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mytest.vo.Zip;

public class ZipDAO {
	private SqlSessionFactory sqlSessionFactory = null;
	
	public ZipDAO(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public List<Zip> selectAll(){
		List<Zip> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
		list = session.selectList("Zip.selectAll");
		}finally {
			session.close();
		}
		
		return list;
	}
}
