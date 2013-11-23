package warehouseObject;

import java.util.ArrayList;
import java.util.List;

import com.sun.jersey.spi.resource.Singleton;

//singleton pattern
public final class Schedule {

	private static volatile Schedule instance = null;
	private List<Transaction> transactionList;

	private Schedule() {
		this.transactionList = new ArrayList<Transaction>();
	}

	public static Schedule getSchedule() {
		if(Schedule.instance == null) {
			synchronized(Singleton.class) {
				if(Schedule.instance == null) {
					Schedule.instance = new Schedule();
				}
			}
		}
		return Schedule.instance;
	}

	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

	public String printScheludeByWarehouse(Warehouse wh) {
		String scheduleToString = "";
		for(Transaction transaction : this.transactionList )
		{
			if(transaction.getWarehouse().getId() == wh.getId()) {
				scheduleToString += transaction.toString() + "\n";
			}
		}		
		return scheduleToString;
	}

	public String printScheludeByWarehouse(List<Warehouse> whList) {
		String scheduleToString = "";
		for(Warehouse wh : whList) {
			scheduleToString += printScheludeByWarehouse(wh);
		}	
		return scheduleToString;
	}

	public String toString() {
		String scheduleToString = "*******Schedule********";
		for(Transaction transaction : this.transactionList )
		{
			scheduleToString += transaction.toString() + "\n";
		}		
		scheduleToString += "*******EndSchedule********";
		return scheduleToString;
	}
}
