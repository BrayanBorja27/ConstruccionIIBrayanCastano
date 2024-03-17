package Validators;

public class BillInputsValidator extends InputsValidator {
    public long invoiceIdValidator(String invoiceId) throws Exception {
        return super.longValidator(invoiceId, "id de usuario");
    }
    public long idPetValidator(String idPet) throws Exception {
        return super.longValidator(idPet, " id de mascota");
    }
    public long idOwnerValidator(String idOwner) throws Exception {
        return super.longValidator(idOwner, " dueño de mascota");
    }
    public void productNameValidator(String productName) throws Exception {
        super.stringValidator(productName, " Nombre de usuario incorrecto");
    }
    public double priceValidator(String price) throws Exception {
        return super.doubleValidator(price, " id de mascota");
    }

    public int amountValidator(String amount) throws Exception {
        return super.integerValidator(amount, " cantidad de productos");
    }


}
