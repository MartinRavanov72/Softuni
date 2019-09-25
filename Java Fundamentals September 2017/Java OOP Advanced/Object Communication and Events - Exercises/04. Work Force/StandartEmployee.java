package b_secondPrinciple;

public class StandartEmployee implements Employee {

    private static final int WORK_HOURS_PER_WEEK = 40;
    private String name;

    public StandartEmployee(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getWorkHoursPerWeek() {
        return WORK_HOURS_PER_WEEK;
    }
}