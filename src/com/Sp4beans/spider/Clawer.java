package com.Sp4beans.spider;

import java.sql.SQLException;
import java.text.ParseException;

import com.Sp4beans.Flag.Flag;
import com.Sp4beans.db.newsDao;

/**
 * ���棬����ȡ����Ϣ�洢�����ݿ�
 */

public class Clawer {
	public static void getInfo(Flag flag) throws ParseException, SQLException {
		// ���ԭ�б�����Ϣ
		newsDao.clearDb(flag);
		
		GetInfo.getInfoCs(flag);
		//GetInfo.getInfoCs_news();
		
		flag.changeFLAG();
	}

	public static void main(String args[]) throws ParseException, SQLException {
		Flag flag = new Flag();
		getInfo(flag);
		
		getInfo(flag);
	}
}
