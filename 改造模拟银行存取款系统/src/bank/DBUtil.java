package bank;

import java.util.*;

import java.io.*;

/*
 * 模拟银行系统中的账户信息，相当于数据库的功能
 */
public class DBUtil {

	private static DBUtil instance = null;
	private HashMap<String, User> users = new HashMap<String, User>();

	//增加从文件读取的功能
	private DBUtil() throws FileNotFoundException {
		getUsersFromInputStream("user.txt");
	}

	// 懒汉式单例模式
	public static DBUtil getInstance() throws FileNotFoundException {
		if (instance == null) {
			synchronized (DBUtil.class) {
				if (instance == null) {
					instance = new DBUtil();
				}
			}
		}
		return instance;
	}

	// 根据银行卡获取对应单个账户的信息
	public User getUser(String cardId) {
		User user = (User) users.get(cardId);
		return user;
	}

	public HashMap<String, User> getUsers() {
		return users;
	}

	public void processUserString(String userString) {

		String[] userFields = userString.split(",");
		User u = new User();
		u.setCardId(userFields[0]);
		u.setCardPwd(userFields[1]);
		u.setUserName(userFields[2]);
		u.setCall(userFields[3]);
		u.setAccount(Integer.parseInt(userFields[4]));
		users.put(u.getCardId(), u);

	}

	//读取文件，以InputStream的形式读取
	private void getUsersFromInputStream(String isName) throws FileNotFoundException {

		FileInputStream fs = new FileInputStream(isName);
		byte[] content = new byte[1024];
		int i = 0;
		int conInteger = 0;
		while (true) {
			try {
				conInteger = fs.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (-1 == conInteger) {
				break;
			} else if ('\r' == (char) conInteger || '\n' == (char) conInteger) {
				try {
					this.processUserString(new String(content, "GBK").trim());
					i = 0;
				} catch (UnsupportedEncodingException e) {
					e.getStackTrace();
				}
				continue;
			} else {
				content[i] = (byte) conInteger;
				i++;
			}
		}
	}
    //增加一个用户
	public void addUser(User u) {
		users.put(u.getCardId(), u);
	}

	// 存盘操作
	public void update() throws IOException {
		Set<String> userSet = users.keySet();
		StringBuffer uStringBuffer = new StringBuffer();
		for (String cardId : userSet) {
			User u = (User) users.get(cardId);
			String uString = u.getCardId() + "," + u.getCardPwd() + "," + u.getUserName() + "," + u.getCall() + ","
					+ u.getAccount() + "\r\n";
			uStringBuffer.append(uString);
		}
		putUserToFile(uStringBuffer.toString(), "user.txt");
	}

	// 写入文件的函数
	private void putUserToFile(String uString, String osName) throws IOException {
		try {
			FileOutputStream fos = new FileOutputStream(osName);
			try {
				fos.write(uString.getBytes("GBK"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
