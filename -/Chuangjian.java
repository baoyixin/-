public class Chuangjian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Mythread my = new Mythread();
        new Thread(my,"线程一").start();
        new Thread(my,"线程二").start();
	}

}

public class Mythread extends Thread {
	public void run() {
			Thread th = Thread.currentThread();
			String name=th.getName();
			System.out.println(name+"在创建");		
		}
}
