

public class Baoyixin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println("1~���ѧ����Ϣ----------------------");
       add();
       System.out.println("2~ɾ��ѧ����Ϣ----------------------");
       remove();
       System.out.println("3~�޸�ѧ����Ϣ----------------------");
       alter();
	}
	public static void add() {
		StringBuffer sb1=new StringBuffer();
		StringBuffer sb2=new StringBuffer();
		StringBuffer sb3=new StringBuffer();
		StringBuffer sb4=new StringBuffer();
		sb1.append("������ ");
		sb2.append("184805001 ");
		sb3.append("Ů ");
		sb4.append("�� ");

		System.out.println("ѧ��������"+sb1);
		System.out.println("ѧ��ѧ�ţ�"+sb2);
		System.out.println("�Ա�"+sb3);
		System.out.println("���ã�"+sb4);
	}
	public static void remove() {
		StringBuffer sb=new StringBuffer("������ѽ184805001");
		sb.deleteCharAt(3);
		System.out.println("ɾ������ʾ��"+sb);
		sb.delete(3,6);
		System.out.println(sb);
	}
	public static void alter() {
		StringBuffer sb=new StringBuffer("�����������ѧԺ������һ���ѧ��");
		sb.replace(4,14,"�������ѧԺ������һ��" );
		System.out.println("�޸ĺ�"+sb);
	}

}
