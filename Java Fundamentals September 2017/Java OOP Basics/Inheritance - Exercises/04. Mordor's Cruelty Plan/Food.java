package a_DefiningClassesEx;

public class Food {
    private int points;

    public Food(String name) {
        this.setPoints(name);
    }

    public void setPoints(String name) {
        switch (name.toLowerCase()){
            case "cram":
                this.points = 2;
                break;
            case "lembas":
                this.points = 3;
                break;
            case "apple":
                this.points = 1;
                break;
            case "melon":
                this.points = 1;
                break;
            case "honeycake":
                this.points = 5;
                break;
            case "mushrooms":
                this.points = -10;
                break;
            default:
                this.points = -1;
                break;
        }
    }

    int getPoints() {
        return points;
    }
}
