public class DVD extends Product {
   private int length, ageRating;
   private String studio;

    public DVD(int number, String name, int qty, double price, int length, int ageRating, String studio) {
        super(number, name, qty, price);
        this.length = length;
        this.ageRating = ageRating;
        this.studio = studio;
    }

    @Override
    public double inventoryValues() {
        //adding 5%
        return super.inventoryValues() * 105 / 100;
    }

    @Override
    public String toString() {
        return "Item Number      : " + super.getNumber() +
                "\nName             : " + super.getName() +
                "\nMovie Length     : " + length +
                "\nAge Rating       : " + ageRating +
                "\nFilm Studio      : " + studio +
                "\nQuantity in stock: " + super.getQty() +
                "\nPrice            : " + super.getPrice() +
                "\nStock Value      : " + inventoryValues() +
                "\nProduct Status   : " + (super.isActive() ? "Active" : "Discontinued");

    }


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }
}
