package a_DefiningClassesEx.foods;

public abstract class Food {
    private int quantity;

    Food(int quantity) {
        this.setQuantity(quantity);
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
