package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import model.ChatContent;
import model.ChatContentDao;

public class ChatContentService {

	private static Map<Integer, ChatContent> chatContentMap;
	
	public ChatContentService() {
		try {
			chatContentMap = ChatContentDao.loadAllChatConent();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<ChatContent> getAllChatContent() {
		return new ArrayList<ChatContent>(chatContentMap.values());
	}
	
	public ChatContent addChatContent(ChatContent chatContent) throws SQLException {
		if (chatContent.getId()!=0) {
			return null;
		}
		chatContent.setNewDatetime();
		ChatContentDao.saveToDB(chatContent);
		System.out.println(chatContent);
		return chatContent;
	}
}
