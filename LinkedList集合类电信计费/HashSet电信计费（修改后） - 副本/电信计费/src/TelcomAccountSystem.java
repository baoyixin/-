import gc.*;
import telcomuser.*;
import tx.*;
import utility .*;


public class TelcomAccountSystem{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TelcomUser telcomuser=new TelcomUser("15515157625");
		telcomuser.generateCommunicateRecords();
		telcomuser.printDetails();
	}
}	