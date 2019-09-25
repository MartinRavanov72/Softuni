package interfaces;

public class Message {
    private Importance level;
    private String content;

    public Message(Importance level, String content) {
        this.level = level;
        this.content = content;
    }

    Importance getLevel() {
        return this.level;
    }

    @Override
    public String toString() {
        return this.getLevel() + ": " + this.content;
    }
}
