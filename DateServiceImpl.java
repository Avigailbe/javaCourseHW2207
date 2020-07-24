package home_work2207;

import java.util.HashMap;
import java.util.Map;

public class DateServiceImpl implements DateService{

   private Map<String, Integer> daysInMonthMap= new HashMap<>();

    public DateServiceImpl() {
        createMonthMap();
    }

    @Override
    public int differenceInDays(MyDate date1, MyDate date2){
        leapYearCheck(String.valueOf(date1.getYear()));
        int m1 = date1.getMonth();
        int m2 = date2.getMonth();
        int highMonth;
        int lowMonth;
        int highDay;
        int lowDay;
        if (m1 > m2) {
            highMonth=m1;
            highDay=date1.getDay();
            lowMonth=m2;
            lowDay=date2.getDay();
        }
        else{
            lowMonth=m1;
            lowDay=date1.getDay();
            highMonth=m2;
            highDay=date2.getDay();
        }
        int totalDays=0;
        if (highMonth!=lowMonth){
            int diff = highMonth-lowMonth;
             totalDays = daysInMonthMap.get(String.valueOf(lowMonth)) - lowDay;
            for (int i = 1; i <= diff; i++) {
                if (highMonth == lowMonth + i) {
                    totalDays += highDay;
                } else {
                    totalDays += daysInMonthMap.get(String.valueOf(lowMonth + i));
                }
            }
        }
        else {
             totalDays = Math.abs(highDay-lowDay);
               }
       return totalDays;
    }

    @Override
    public int differenceInYearsDays(MyDate date1, MyDate date2){
       int yearsDiff= Math.abs(date1.getYear()-date2.getYear());
       int daysDiff = differenceInDays(date1,date2);
       int yearsDays = yearsDiff*365;
       return yearsDays+daysDiff;
    }

    @Override
    public MyDate newDate(MyDate fromDate, int daysToAdd) {
        int fromYear = fromDate.getYear();
        leapYearCheck(String.valueOf(fromDate.getYear()));
        int fromMonth = fromDate.getMonth();
        int fromDay = fromDate.getDay();
        int newDay = fromDay;
        int newMonth = fromMonth;
        int newYear = fromYear;
        int daysOfMonth = daysInMonthMap.get(String.valueOf(fromMonth));
        int daysLeft = daysToAdd;
        while (daysLeft > 0) {
            newDay++;
            //if passed amount of days in month, add month, change day to 1st
            if (newDay > daysOfMonth) {
                if(newMonth==12){
                    newMonth = 1;
                }
                else {
                    newMonth++;
                }
                daysOfMonth = daysInMonthMap.get(String.valueOf(newMonth));
                newDay = 1;
                //january, add year
                if (newMonth == 1 && newDay == 1) {
                    newYear++;
                }
            }
            daysLeft--;
        }
        return new MyDate(newYear, newMonth, newDay);
    }


    @Override
    public void createMonthMap(){
        daysInMonthMap.put("1", Integer.valueOf(31));
        daysInMonthMap.put("2", Integer.valueOf(28));
        daysInMonthMap.put("3", Integer.valueOf(31));
        daysInMonthMap.put("4", Integer.valueOf(30));
        daysInMonthMap.put("5", Integer.valueOf(31));
        daysInMonthMap.put("6", Integer.valueOf(30));
        daysInMonthMap.put("7", Integer.valueOf(31));
        daysInMonthMap.put("8", Integer.valueOf(31));
        daysInMonthMap.put("9", Integer.valueOf(30));
        daysInMonthMap.put("10", Integer.valueOf(31));
        daysInMonthMap.put("11", Integer.valueOf(30));
        daysInMonthMap.put("12", Integer.valueOf(31));
    }
    @Override
    public void leapYearCheck(String year){
        if ((Float.parseFloat(year)%4 == 0) || (Float.parseFloat(year)%10 > 0) || (Float.parseFloat(year)%400 == 0)){
            daysInMonthMap.replace("02", Integer.valueOf(28),  Integer.valueOf(29));
        }
    }
}
