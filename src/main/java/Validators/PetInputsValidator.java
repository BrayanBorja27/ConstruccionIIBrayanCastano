package Validators;

public class PetInputsValidator extends InputsValidator {
    public void nameValidator(String name) throws Exception {
        super.stringValidator(name, " Nombre de mascota incorrecto");
    }
    public int ageValidator(String age) throws Exception{
        return super.integerValidator(age, "Ingrese edad de la mascota");
    }
    public long idNumberValidator(String idNumber) throws Exception {
        return super.longValidator(idNumber, " identificacion de mascota");
    }
    public void speciesValidator(String species) throws Exception {
        super.stringValidator(species, " Especie no valida");
    }
    public void breedValidator(String breed) throws Exception {
        super.stringValidator(breed, " raza no valida");
    }
    public void characteristicsValidator(String characteristics) throws Exception {
        super.stringValidator(characteristics, " caracteristicas no validas");
    }
    public double weightValidator(String weight) throws Exception {
        return super.doubleValidator(weight, " peso no valido");
    }
    public long ownerValidator(String owner) throws Exception {
        return super.longValidator(owner, " dueño no valido");
    }
}
