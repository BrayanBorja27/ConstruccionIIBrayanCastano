package Models;

import java.sql.Date;

public class Order {
    private long orderId;
    private Pet idPet;
    private Person idOwner;
    private Person person;
    private String nameMedications;
    private Date generationDate;

    public Order() {
        this.generationDate=new Date(System.currentTimeMillis());
    }

    public long getOrderId() {
        return orderId;
    }
    public void setOrderId(long orderId) {
        this.orderId = orderId;
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
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public String getNameMedications() {
        return nameMedications;
    }
    public void setNameMedications(String nameMedications) {
        this.nameMedications = nameMedications;
    }
    public Date getGenerationDate() {
        return generationDate;
    }
    public void setGenerationDate(Date generationDate) {
        this.generationDate = generationDate;
    }

}
