package home_work2207;

public class MyDate {

    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

   public MyDate() {
    }

    public MyDate(String year, String month, String day){
        this.year = Integer.parseInt(year);
        this.month = Integer.parseInt(month);
        this.day = Integer.parseInt(day);
    }

    public MyDate (String dateFormat) {
        this.year = Integer.parseInt(dateFormat.substring(0, 4));
        this.month = Integer.parseInt(dateFormat.substring(5, 7));
        this.day = Integer.parseInt(dateFormat.substring(8, 10));
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void printDateDetails() {
        System.out.println("Inputted year: " + this.getYear());
        System.out.println("Inputted month: " + this.getMonth());
        System.out.println("Inputted day: " + this.getDay());
        System.out.println("----------------------------------");
    }


}
