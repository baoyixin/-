public class Teacher implements Runnable {
	private int homework=80;
	public void run() {
		while(true) {
			if(homework>0) {
				Thread th=Thread.currentThread();
				String thname = th.getName();
				System.out.println(thname+"正在发第"+homework--+"个本子");
			}
		}
	}
  
}

public class ZUOYE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teacher tc= new Teacher();
		new Thread(tc,"老师1").start();
        new Thread(tc,"老师2").start();
        new Thread(tc,"老师3").start();
 	}

}

