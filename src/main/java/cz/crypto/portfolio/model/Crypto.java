package cz.crypto.portfolio.model;

public class Crypto {
    private int id;
    private String name;
    private String symbol;
    private double price;
    private double quantity;

    //V praxi (slovy lektora Marka: "Neznám vývojáře Javy, který by nepoužíval
    //Lombok") by se zde měla naimportováním použít knihovna Lombok, která sama
    //vytvoří potřebné konstruktory, gettery a settery. Kód se tím podstatně zkrátí.

    public Crypto(int id, String name, String symbol, double price, double quantity) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.quantity = quantity;
    }

    public Crypto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

}
