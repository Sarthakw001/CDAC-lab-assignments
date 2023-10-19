package core;

public enum ServicePlan {
    INVALID(0),
    SILVER(1000),
    GOLD(2000),
    DIAMOND(5000),
    PLATINUM(10000);

    private int value;

    private ServicePlan(int value) {
        this.value = value;
    }

    public static ServicePlan getPlanName(int value) {
       ServicePlan planName = switch(value){
            case 1000 -> SILVER;
            case 2000 -> GOLD;
            case 5000 -> DIAMOND;
            case 10_000 -> PLATINUM;
            default -> INVALID;
        };
        return planName;
    }

    @Override
    public String toString() {
        return name() + " : " + value;
    }
}
