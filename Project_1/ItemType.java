package Project_1;
/**
public class ItemType {

    private int value;

    public int compareTo(ItemType item) {
        return Integer.compare(this.value, item.value);
    }

    public int getValue() {
        return value;
    }

    public void initialize(int num) {
        this.value = num;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
} 
**/
 public class ItemType {
  4     private int value;
  5
  6     public ItemType(int value) {
  7         this.value = value;
  8     }
  9
 10     public int getValue() {
 11         return value;
 12     }
 13
 14     public int compareTo(ItemType item) {
 15         return Integer.compare(this.value, item.value);
 16     }
 17 }
