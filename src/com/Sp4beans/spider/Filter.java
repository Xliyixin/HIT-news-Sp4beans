package com.Sp4beans.spider;

/**
 * 
 * ������������ͬ��վ
 *
 */

public class Filter {
	public static Type istype(String path) {
		if(path.contains("cs.hit.edu.cn/?q=taxionomy/term"))
			return Type.CS_NEWS;
		else if (path.contains("cs.hit.edu.cn"))
			return Type.CS;
		else
			return Type.NO;
	}

	public static boolean isnews(String path, Type type) {
		switch (type) {
		case CS:
			if (path.contains("http://cs.hit.edu.cn/?q=node/"))
				return true;
			break;
		case NO:
			break;
		default:
			return false;
		}
		return false;
	}

	public static boolean islist(String path, Type type) {
		switch (type) {
		case CS:
			if (path.contains("http://cs.hit.edu.cn/?q=notice"))
				return true;
			break;
		case NO:
			break;
		default:
			return false;
		}
		return false;
	}
}
