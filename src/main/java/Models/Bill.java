package Models;

import java.sql.Date;

public class Bill {
    private long invoiceId;
    private Pet idPet;
    private Person idOwner;
    private String productName;
    private double price;
    private int amount;
    private Date date;

    public Bill() {
        this.date=new Date(System.currentTimeMillis());
    }

    public long getInvoiceId() {
        return invoiceId;
    }
    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }
    public Pet getIdPet() {
        return idPet;
    }
    public void setIdPet(Pet idPet) {
        this.idPet = idPet;
    }
    public Person getIdOwner() {
        return idOwner;
    }
    public void setIdOwner(Person idOwner) {
        this.idOwner = idOwner;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

}
