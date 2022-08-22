public class CD extends Product {
    private String artist, label;
    private int nrSongs;

    public CD(int number, String name, int qty, double price, String artist, int nrSongs, String label) {
        super(number, name, qty, price);
        this.artist = artist;
        this.nrSongs = nrSongs;
        this.label = label;
    }
    @Override
    public String toString() {
        return "Item Number      : " + super.getNumber() +
                "\nName             : " + super.getName() +
                "\nArtist           : " + artist +
                "\nSongs on Album   : " + nrSongs +
                "\nRecord label     : " + label +
                "\nQuantity in stock: " + super.getQty() +
                "\nPrice            : " + super.getPrice() +
                "\nStock Value      : " + super.inventoryValues() +
                "\nProduct Status   : " + (super.isActive() ? "Active" : "Discontinued");

    }
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getNrSongs() {
        return nrSongs;
    }

    public void setNrSongs(int nrSongs) {
        this.nrSongs = nrSongs;
    }


}
