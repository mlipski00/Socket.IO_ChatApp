package model;

import java.sql.Timestamp;

public class ChatContent {

	private int id;
	private String nickName;
	private String message;
	private String socketID;
	private Timestamp datetime;

	public ChatContent(int id, String nickName, String message, String socketID, Timestamp datetime) {
		java.util.Date javaDate = new java.util.Date();
		long javaTime = javaDate.getTime();
		this.nickName = nickName;
		this.message = message;
		this.socketID = socketID;
		this.datetime = new Timestamp(javaTime);
	}

	public ChatContent() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSocketID() {
		return socketID;
	}

	public void setSocketID(String socketID) {
		this.socketID = socketID;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

}
