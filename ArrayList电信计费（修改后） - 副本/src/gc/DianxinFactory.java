package gc;
import telcomuser.TelcomUser;
import tx.*;
public  class DianxinFactory implements Factory{

	public Tongxin creat() {
		return new Dianxin();
	}
}
