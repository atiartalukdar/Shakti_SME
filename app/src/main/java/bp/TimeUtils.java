package bp;

import org.joda.time.Interval;
import org.joda.time.Period;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
    private Long seconds;
    private Long minutes;
    private Long hours;
    private Long days;
    private Long months;
    private int years;
    private String CompleteDifference;
    private String yearMonthDate;

    private String startDate;
    private String endtDate;

    public TimeUtils(String bornTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");

        try {
            Date oldDate = dateFormat.parse(bornTime);
            System.out.println(oldDate);

            Date currentDate = new Date();

            setCompleteDifference(oldDate,currentDate);
            setYearMonthDate(oldDate,currentDate);

            long diff = currentDate.getTime() - oldDate.getTime();
            long seconds = diff / 1000;
            long minutes = seconds / 60;
            long hours = minutes / 60;
            long days = hours / 24;
            long months = days / 30;

            if (oldDate.before(currentDate)) {
                this.seconds = seconds;
                this.minutes = minutes;
                this.hours = hours;
                this.days = days;
                this.months = months;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public Long getSeconds() {
        return seconds;
    }

    public Long getMinutes() {
        return minutes;
    }

    public Long getHours() {
        return hours;
    }

    public Long getDays() {
        return days;
    }

    public Long getMonths() {
        return months;
    }

    public int getYears() {
        return years;
    }



    private void setCompleteDifference(Date startDate, Date endDate){
        String diff = "";

        Interval interval =
                new Interval(startDate.getTime(), endDate.getTime());
        Period period = interval.toPeriod();

        diff += period.getYears() + " Years, "+ period.getMonths() + " Months, "+
                period.getDays() + " Days, "+
                period.getHours() + " Hours, "+  period.getMinutes() + " Mins, "+
                period.getSeconds()  + " Seconds, ";
        this.CompleteDifference = diff;
    }

    private void setYearMonthDate(Date startDate, Date endDate){
        String diff = "";

        Interval interval =
                new Interval(startDate.getTime(), endDate.getTime());
        Period period = interval.toPeriod();

        diff += period.getYears() + " Years, "+ period.getMonths() + " Months, "+
                period.getDays() + " Days";
        this.yearMonthDate = diff;
        this.years = period.getYears();
    }

    public String getYearMonthDate(){
        return yearMonthDate;
    }

    public String getCompleteDifference() {
        return CompleteDifference;
    }

    @Override
    public String toString() {
        return "TimeDifferences{" +
                "seconds=" + seconds +
                ", minutes=" + minutes +
                ", hours=" + hours +
                ", days=" + days +
                ", months=" + months +
                ", years=" + years +
                "\n\n Complete Difference= "+ getCompleteDifference() +
                '}';
    }

    public static String getCurrentTime(){
        Calendar calender = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate =mdformat.format(calender.getTime());
        return currentDate;
    }



}
