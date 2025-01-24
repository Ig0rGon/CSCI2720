package Project_1;

public class ItemType {

    private int value;

    public int compareTo(ItemType item) {
        return Integer.compareTo(this.value, item.value);
    }

    public int getValue() {
        return value;
    }

    public void initialize(int num) {
        this.value = num;
    }
}