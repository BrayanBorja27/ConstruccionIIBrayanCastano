package Models;

public class Pet {
    private String name;
    private int age;
    private long idNumber;
    private String species;
    private String breed;
    private String characteristics;
    private double weight;
    private Person petOwner;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public long getIdNumber() {
        return idNumber;
    }
    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public String getCharacteristics() {
        return characteristics;
    }
    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public Person getPetOwner() {
        return petOwner;
    }
    public void setPetOwner(Person petOwner) {
        this.petOwner = petOwner;
    }
}
