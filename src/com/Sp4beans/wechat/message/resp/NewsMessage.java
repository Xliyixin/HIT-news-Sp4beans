package com.Sp4beans.wechat.message.resp;

import java.util.List;

/**
 * 
 * ͼ����Ϣ
 *
 */

public class NewsMessage extends BaseMessage {
	// ͼ����Ϣ�ĸ���������Ϊ10������
	private int ArticleCount;
	// ����ͼ����Ϣ��Ϣ��Ĭ�ϵ�һ��itemΪ��ͼ
	private List<Article> Atricles;

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getAtricles() {
		return Atricles;
	}

	public void setAtricles(List<Article> atricles) {
		Atricles = atricles;
	}

}
