public class Robot implements Identificatable {

    private String id;

    public Robot(String id) {
        this.id = id;
    }

    @Override
    public String getID() {
        return this.id;
    }
}