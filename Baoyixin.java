

public class Baoyixin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println("1~添加学生信息----------------------");
       add();
       System.out.println("2~删除学生信息----------------------");
       remove();
       System.out.println("3~修改学生信息----------------------");
       alter();
	}
	public static void add() {
		StringBuffer sb1=new StringBuffer();
		StringBuffer sb2=new StringBuffer();
		StringBuffer sb3=new StringBuffer();
		StringBuffer sb4=new StringBuffer();
		sb1.append("鲍怡心 ");
		sb2.append("184805001 ");
		sb3.append("女 ");
		sb4.append("无 ");

		System.out.println("学生姓名："+sb1);
		System.out.println("学生学号："+sb2);
		System.out.println("性别："+sb3);
		System.out.println("爱好："+sb4);
	}
	public static void remove() {
		StringBuffer sb=new StringBuffer("鲍怡心呀184805001");
		sb.deleteCharAt(3);
		System.out.println("删除后显示："+sb);
		sb.delete(3,6);
		System.out.println(sb);
	}
	public static void alter() {
		StringBuffer sb=new StringBuffer("鲍怡心是软件学院大数据一班的学生");
		sb.replace(4,14,"来自软件学院大数据一班" );
		System.out.println("修改后："+sb);
	}

}
