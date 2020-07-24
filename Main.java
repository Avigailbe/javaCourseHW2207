package home_work2207;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

       
        DateServiceImpl dateServiceImpl = new DateServiceImpl();

        String date1 = JOptionPane.showInputDialog("Please pick a date in format of: YYYY/MM/DD");

        String date2 = JOptionPane.showInputDialog("Please pick a second date in format of: YYYY/MM/DD");

        MyDate myDate1 = new MyDate(date1);
        myDate1.printDateDetails();

        MyDate myDate2 = new MyDate(date2);
        myDate2.printDateDetails();

        //get date diff
        int dateDiff = dateServiceImpl.differenceInDays(myDate1, myDate2);
        System.out.println("The date difference between the 2 dates is:"+ dateDiff+ " days");

        //get diff in years
        int yearDayDiff = dateServiceImpl.differenceInYearsDays(myDate1, myDate2);
        System.out.println("The date difference between the 2 years is:"+ yearDayDiff+ " days");

        //get new date
        MyDate newDate= dateServiceImpl.newDate(myDate1, 6);
        System.out.println("The new date is:"+ newDate.getYear()+"/"+newDate.getMonth()+"/"+newDate.getDay());
    }


}
