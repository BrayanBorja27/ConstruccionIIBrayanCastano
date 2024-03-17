package Validators;

public class OrderInputsValidator extends InputsValidator{
    public long orderIdValidator(String orderId) throws Exception {
        return super.longValidator(orderId, " id de orden");
    }
    public long idPetValidator(String idPet) throws Exception {
        return super.longValidator(idPet, " identificacion de mascota");
    }
    public long idOwnerValidator(String idOwner) throws Exception {
        return super.longValidator(idOwner, " identificacion del dueño");
    }
    public void personValidator(String person) throws Exception {
        super.stringValidator(person, " Nombre de usuario incorrecto");
    }
    public void nameMedicationsValidator(String nameMedications) throws Exception {
        super.stringValidator(nameMedications, " Nombre de medicamentos");
    }
}
