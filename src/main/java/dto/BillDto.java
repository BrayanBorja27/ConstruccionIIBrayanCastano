package dto;

import java.sql.Date;

public class BillDto {
    private long invoiceId;
    private PetDto idPet;
    private PersonDto idOwner;
    private OrderDto idOrder;
    private String productName;
    private double price;
    private int amount;
    private Date date;

    public BillDto(PetDto idPet, PersonDto idOwner, String productName, double price, int amount, Date date) {

        this.idPet = idPet;
        this.idOwner = idOwner;
        this.productName = productName;
        this.price = price;
        this.amount = amount;
        this.date = date;
    }

    public BillDto() {
        this.date=new Date(System.currentTimeMillis());
    }

    public long getInvoiceId() {
        return invoiceId;
    }
    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }
    public PetDto getIdPet() {
        return idPet;
    }
    public void setIdPet(PetDto idPet) {
        this.idPet = idPet;
    }
    public PersonDto getIdOwner() {
        return idOwner;
    }
    public void setIdOwner(PersonDto idOwner) {
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

    public OrderDto getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(OrderDto idOrder) {
        this.idOrder = idOrder;
    }
}
