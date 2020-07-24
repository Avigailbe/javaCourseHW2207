package home_work2207;

public interface DateService {
    public void createMonthMap();
    public void leapYearCheck(String year);
    public int differenceInDays(MyDate date1, MyDate date2);
    public int differenceInYearsDays(MyDate date1, MyDate date2);
    public MyDate newDate(MyDate fromDate, int daysToAdd);
}
