package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;


import utils.DbUtil;

public class ChatContentDao {

	public static void saveToDB(ChatContent chatContent) throws SQLException {
		Connection conn = DbUtil.getConn();
		PreparedStatement prepStat;
		ResultSet rs = null;
		if (chatContent.getId() == 0) {
			String sql = "INSERT INTO chatcontent (nickname, message, socketID, datetime) VALUES (?, ?, ?, ?);";
			String columnNames[] = { "ID" };
			prepStat = conn.prepareStatement(sql, columnNames);
			prepStat.setString(1, chatContent.getNickName());
			prepStat.setString(2, chatContent.getMessage());
			prepStat.setString(3, chatContent.getSocketID());
			prepStat.setTimestamp(4, chatContent.getDatetime());
			prepStat.executeUpdate();
			rs = prepStat.getGeneratedKeys();
			if (rs.next()) {
				chatContent.setId(rs.getInt(1));
			}
		} else {
			String sql = "UPDATE solution SET nickname=?, message=?, socketID=?, datetime=? WHERE id=?";
			java.util.Date javaDate = new java.util.Date();
			long javaTime = javaDate.getTime();
			chatContent.setDatetime(new Timestamp(javaTime));
			prepStat = conn.prepareStatement(sql);
			prepStat.setString(1, chatContent.getNickName());
			prepStat.setString(2, chatContent.getMessage());
			prepStat.setString(3, chatContent.getSocketID());
			prepStat.setTimestamp(4, chatContent.getDatetime());
			prepStat.setInt(4, chatContent.getId());
			prepStat.executeUpdate();
		}
		rs.close();
		prepStat.close();
		conn.close();
	}
	
	static public Map<Integer, ChatContent> loadAllChatConent() throws SQLException {
		Connection conn = DbUtil.getConn();
		String sql = "SELECT * FROM chatcontent;";
		Map<Integer, ChatContent> chatContentMap = new HashMap<>();
		PreparedStatement prepStat = conn.prepareStatement(sql);
		ResultSet rs = prepStat.executeQuery();
		while (rs.next()) {
			ChatContent chatContent = new ChatContent();
			chatContent.setId(rs.getInt(1));
			chatContent.setNickName(rs.getString(2));
			chatContent.setMessage(rs.getString(3));
			chatContent.setSocketID(rs.getString(4));
			chatContent.setDatetime(rs.getTimestamp(5));
			chatContentMap.put(chatContent.getId(), chatContent);
		}
		rs.close();
		prepStat.close();
		conn.close();
		return chatContentMap;
	}
}
