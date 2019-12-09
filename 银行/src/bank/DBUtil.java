package bank;
import java.util.*;
/*
 * ģ������ϵͳ�е��˻���Ϣ���൱�����ݿ�Ĺ���
 */
public class DBUtil {

	private static DBUtil instance = null;
	private HashMap<String,User> users = new HashMap<String,User>();
	
	private DBUtil() {
		//
		User u1 = new User();
		u1.setCardId("1001");
		u1.setCardPwd("123456");
		u1.setUserName("����");
		u1.setCall("15515157625");
		u1.setAccount(1000);
		users.put(u1.getCardId(),u1);
		//
		User u2 = new User();
		u2.setCardId("1002");
		u2.setCardPwd("234567");
		u2.setUserName("�ŷ�");
		u2.setCall("15515150000");
		u2.setAccount(2000);
		users.put(u2.getCardId(),u2);
		//
		User u3 = new User();
		u3.setCardId("1003");
		u3.setCardPwd("345678");
		u3.setUserName("�ŷ�");
		u3.setCall("15515155555");
		u3.setAccount(3000);
		users.put(u3.getCardId(),u3);
	}
	//����ʽ����ģʽ
	public static DBUtil getInstance() {
		if(instance == null) {
			synchronized (DBUtil.class) {
				if(instance == null) {
					instance = new DBUtil();
				}
			}
		}
		return instance;
	}
	//�������п���ȡ��Ӧ�����˻�����Ϣ
	public User getUser(String cardId) {
		User user = (User) users.get(cardId);
		return user;
	}
	
	public HashMap<String, User>  getUsers() {
		return users;
	}	
}
