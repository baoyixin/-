package telcomuser;

import java.util.*;
import java.text.*;
import java.util.*;
import java.util.Date;
import java.util.Random;
import java.lang.*;

import gc.*;
import tx.*;
import utility.*;

public class TelcomUser {
	private String phoneNumber;
	private String callTo;
	private ArrayList communicationRecords;
	private ArrayList callToSum;
	private LinkedHashMap singleRecord;
	private TreeMap treeMapCallToAndFee;
	Tongxin tongxin;

	public TelcomUser(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.communicationRecords = new ArrayList();
		this.treeMapCallToAndFee = new TreeMap();
		this.callToSum = new ArrayList();
		Factory factory1 = (Factory) XMLUtility.getBean();
		tongxin = factory1.creat();
	}

	private String accountFee(long timeStart, long timeEnd) {
		double fee = tongxin.feePerMinute();
		int minutes = Math.round((timeEnd - timeStart) / 60000);
		double feeTotal = fee * minutes;
		return String.format("%.4f", feeTotal);
	}

	private String getcallToPhoneNumber() {
		return "1380372" + String.valueOf(new Random().nextInt(10)) + String.valueOf(new Random().nextInt(10))
				+ String.valueOf(new Random().nextInt(10)) + String.valueOf(new Random().nextInt(10));
	}

	public void generateCommunicateRecords() {

		int recordNum = new Random().nextInt(10);
		for (int i = 0; i <= recordNum; i++) {
			// ������ɵ�i��ͨ����¼
			// ��Calendar��ȡ��ǰʱ��
			Calendar cal = Calendar.getInstance();
			// �����ȥ����Сʱ��ʮСʱ���ڣ�
			cal.add(Calendar.HOUR, -new Random().nextInt(10));
			callTo = getcallToPhoneNumber();
			this.callToSum.add(callTo);
			long timeStart = System.currentTimeMillis() - new Random().nextInt(36000000);
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);

			// ����ͨ����¼
			this.singleRecord = new LinkedHashMap();
			this.singleRecord.put("����", this.phoneNumber);
			this.singleRecord.put("��ʼʱ��", new Date(timeStart));
			this.singleRecord.put("����ʱ��", new Date(timeEnd));
			this.singleRecord.put("���к���", this.callTo);
			this.singleRecord.put("�Ʒ�", this.accountFee(timeStart, timeEnd));
			this.communicationRecords.add(this.singleRecord);
			
			this.treeMapCallToAndFee.put(this.callTo, this.accountFee(timeStart, timeEnd));
		}

	}

	
	
	public void printCallToAndFee() {
		Iterator it = this.treeMapCallToAndFee.entrySet().iterator();
		System.out.println("���к���----------���");
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			System.out.println(entry.getKey()+":"+entry.getValue());
			
		}
	}
}