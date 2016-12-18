package chat_room;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

class Message {
	private String mUserName;
	private String mMessage;
	private String mDate;

	public Message(String aUserName, String aMessage) {
		super();
		this.mUserName = aUserName;
		this.mMessage = aMessage;
	}

	public String getmUserName() {
		return mUserName;
	}

	public void setmUserName(String mUserName) {
		this.mUserName = mUserName;
	}

	public String getmMessage() {
		return mMessage;
	}

	public void setmMessage(String mMessage) {
		this.mMessage = mMessage;
	}

	public String getmDate() {
		return mDate;
	}

	public void setmDate(String mDate) {
		this.mDate = mDate;
	}

	@Override
	public String toString() {
		return "Message [mUserName=" + mUserName + ", mMessage=" + mMessage + ", mDate=" + mDate + "]";
	}

}

public class MessageStorage {
	static final JSONObject obj = new JSONObject();
	static long countSize = 0;

	public static JSONObject main(boolean isNull, String key, String value) {
		if (!isNull) {
			try {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateTime = df.format(new Date()).toString();
				obj.put(String.valueOf(++countSize), dateTime + "¡@¡@¡@" + key + "¡@»¡:¡@" + value);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(countSize);
		return obj;
	}
}
