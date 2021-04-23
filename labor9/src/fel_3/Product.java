package fel_3;

public class Product implements Comparable<Product> {
    private final int ID;
    private final String name;
    private int amount;
    private final int price;

    public Product(int ID, String name, int amount, int price) {
        this.ID = ID;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }

    public void increaseAmount(int newAmount) {
        this.amount += newAmount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Product other) {
        return this.ID - other.ID;
    }
}
