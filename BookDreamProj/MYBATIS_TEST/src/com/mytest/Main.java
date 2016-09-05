package com.mytest;

import java.util.List;

import com.mytest.dao.ZipDAO;
import com.mytest.mybatis.MyBatisConnectionFactory;
import com.mytest.vo.Zip;

public class Main {

	public static void main(String[] args) {
		
		ZipDAO zipDAO = new ZipDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		
		Zip zip = new Zip();
		
		List<Zip> zips = zipDAO.selectAll();
		
		for(int i = 0; i < zips.size(); i++){
			System.out.println(zips.get(i).getSido());
		}

	}

}
