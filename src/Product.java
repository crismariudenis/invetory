public class Product {
    //Instance field declarations
    private int number, qty;
    private String name;
    private double price;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private boolean active = true;


    //Default constructor
    public Product() {
        number=0;
        qty=0;
        price=0;
        name="";
    }

    public Product(int number, String name, int qty, double price) {
        this.number = number;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public void addToInventory(int quantity) {
        if(active)
        qty += quantity;
        else
            System.out.println("This products was discontinued: ");
    }
    public void deductFromInventory(int quantity) {
        qty -= quantity;
    }

    //get number value
    public int getNumber() {
        return number;
    }

    //set number value
    public void setNumber(int number) {
        this.number = number;
    }

    //get quantity value
    public int getQty() {
        return qty;
    }

    //set quantity value
    public void setQty(int qty) {
        this.qty = qty;
    }

    //get name value
    public String getName() {
        return name;
    }

    //set name value
    public void setName(String name) {
        this.name = name;
    }

    //get price value
    public double getPrice() {
        return price;
    }

    //set price value
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item Number      : " + number +
                "\nName             : " + name +
                "\nQuantity in stock: " + qty +
                "\nPrice            : " + price +
                "\nStock Value      : " + inventoryValues() +
                "\nProduct Status   : " + (active ? "Active" : "Discontinued");
    }

    public double inventoryValues() {
        return qty * price;
    }
}
