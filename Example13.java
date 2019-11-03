
public class Example13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Ticket1 ticket=new Ticket1();
        new Thread (ticket,"1").start();
        new Thread (ticket,"2").start();
        new Thread (ticket,"3").start();
        new Thread (ticket,"4").start();
	}

}
class Ticket1 implements Runnable{
	private int tickets =10;
	public void run() {
		while(true) {
			saleTicket();
			if(tickets<=0) {
				break;
			}
		}
	}
	private synchronized void saleTicket() {
		if(tickets>0) {
			try {
				 Thread.sleep(10);
			 }catch(InterruptedException e) {
				 e.printStackTrace();
			 }
			System.out.println(Thread.currentThread().getName()+"---Âô³öµÄÆ±"+tickets--);
		}
	}
}