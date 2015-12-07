import java.util.Calendar;

public class Time {

	int hours;
	int minutes;
	int seconds;
	int day;
	int month;
	int year;
	
	Time(int hours,int minutes,int seconds,int day,
			int month,int year){
			
		this.hours=hours;
		this.minutes=minutes;
		this.seconds=seconds;
		this.day=day;
		this.month=month;
		this.year=year;
		
	}
	@Override
	public String toString(){
		return String.format("%d:%d:%d %d.%d.%d",
				hours,minutes,seconds,day,month,year);
	}
	
	public static Time now(){
		Calendar currTime=Calendar.getInstance();
		Time nowTime=
				new Time(currTime.get(Calendar.HOUR),currTime.get(Calendar.MINUTE),
						currTime.get(Calendar.SECOND),currTime.get(Calendar.DAY_OF_MONTH),
						currTime.get(Calendar.MONTH),currTime.get(Calendar.YEAR));
		return nowTime;
	}
	
}
