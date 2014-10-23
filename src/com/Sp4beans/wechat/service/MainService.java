package com.Sp4beans.wechat.service;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.Sp4beans.wechat.message.resp.TextMessage;
import com.Sp4beans.wechat.util.MessageUtil;

/**
 * 
 * ���ķ�����
 *
 */

public class MainService {
	/**
	 * ����΢�ŷ���������
	 */
	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		try {
			// Ĭ�Ϸ��ص��ı���Ϣ����
			String respContent = "�������쳣�����Ժ�����~";

			// xml�������
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// ���ͷ��˺�(open_id)
			String fromUserName = requestMap.get("FromUserName");
			// �����˺�
			String toUserName = requestMap.get("ToUserName");
			// ��Ϣ����
			String msgType = requestMap.get("MsgType");

			// �ظ��ı���Ϣ
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);

			// �ı���Ϣ
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				respContent = "�ı���Ϣ~\n";
				respContent += fromUserName + "\n";
				respContent += toUserName + "\n";
			}
			// ͼƬ��Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "ͼƬ��Ϣ~";
			}
			// ����λ����Ϣ
			else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "����λ����Ϣ~";
			}
			// ������Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "������Ϣ~";
			}
			// ���l��Ϣ
			else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "��Ƶ��Ϣ~";
			}
			// �¼�����
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// �¼�����
				String eventType = requestMap.get("Event");
				// ����
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = "лл���Ĺ�ע~";
				}
				// ȡ������
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// ��
				}
			}
			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respMessage;
	}
}
