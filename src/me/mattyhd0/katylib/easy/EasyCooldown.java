package me.mattyhd0.katylib.easy;

public class EasyCooldown {

    public long cooldownEnd;

    public EasyCooldown(){
        cooldownEnd = System.currentTimeMillis();
    }

    public EasyCooldown(long addToColdownEnd){
        this.cooldownEnd = System.currentTimeMillis()+addToColdownEnd;
    }

    public void addMilliseconds(long milliseconds){
        cooldownEnd += milliseconds* EasyTime.MS_IN_MILLISECOND;
    }

    public void addSeconds(long seconds){
        cooldownEnd += seconds* EasyTime.MS_IN_SECOND;
    }

    public void addMinutes(long minutes){
        cooldownEnd += minutes* EasyTime.MS_IN_MINUTE;
    }
    public void addHours(long hours){
        cooldownEnd += hours* EasyTime.MS_IN_HOUR;
    }
    public void addDays(long days){
        cooldownEnd += days* EasyTime.MS_IN_DAY;
    }
    public void addWeeks(long weeks){
        cooldownEnd += weeks* EasyTime.MS_IN_WEEK;
    }

    public void addMonths(long months){
        cooldownEnd += months* EasyTime.MS_IN_MONTH;
    }

    public void addYears(long years){
        cooldownEnd += years* EasyTime.MS_IN_YEAR;
    }

    public boolean hasPassed(){
        return System.currentTimeMillis() >= cooldownEnd;
    }

    public long getCooldownEnd() {
        return cooldownEnd;
    }

    public long getTimeDifference() {
        return System.currentTimeMillis()-cooldownEnd;
    }

    /*
    public String getFormattedTimeDifference() {

        long difference = cooldownEnd-System.currentTimeMillis();

        long milliseconds = (difference);
        long seconds = (difference/ EasyTime.MS_IN_SECOND) % EasyTime.SECONDS_IN_MINUTE;
        long minutes = (difference/ EasyTime.MS_IN_MINUTE) % EasyTime.MINUTES_IN_HOUR;
        long hours = (difference/ EasyTime.MS_IN_HOUR) % EasyTime.HOURS_IN_DAY;
        long days = (difference/ EasyTime.MS_IN_DAY) % EasyTime.DAYS_IN_WEEK;
        long weeks = (difference/ EasyTime.MS_IN_WEEK) % EasyTime.WEEKS_IN_MONTH;
        long months = (difference/ EasyTime.MS_IN_MONTH) % EasyTime.MONTHS_IN_YEAR;

        // Estas weas no se como calcularlas xd
        long years = (difference-(months* EasyTime.MS_IN_MONTH))/ EasyTime.MS_IN_YEAR;
        milliseconds = milliseconds-(years* EasyTime.MS_IN_YEAR)-(months* EasyTime.MS_IN_MONTH)-(weeks* EasyTime.MS_IN_WEEK)-(days* EasyTime.MS_IN_DAY)-(hours* EasyTime.MS_IN_HOUR)-(minutes* EasyTime.MS_IN_MINUTE)-(seconds* EasyTime.MS_IN_SECOND);

        return MessageFormat.format("{0} years, {1} months, {2} weeks, {3} days, {4} hours, {5} minutes, {6} seconds, {7}ms", years, months, weeks, days, hours, minutes, seconds, milliseconds);

    } */
}
