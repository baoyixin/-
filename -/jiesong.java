
public class jiesong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Taix ti=new Taix();
      new Thread(ti,"出租车1").start();
      new Thread(ti,"出租车2").start();
      new Thread(ti,"出租车3").start();
      new Thread(ti,"出租车4").start();
      new Thread(ti,"出租车5").start();
	}

}

public class Taix implements Runnable{
	private int passengers = 100;
	public void run() {
		while(true)
		{
			if(passengers>0) {
				Thread th= Thread.currentThread();
				String thname = th.getName();
				System.out.println(thname+"出租车正在接送第"+passengers--+"个乘客");
			}
		}
	}

}
