package dto;

public class PetDto {
    private String name;
    private int age;
    private long idNumber;
    private String species;
    private String breed;
    private String characteristics;
    private double weight;
    private PersonDto ownerId;

    public PetDto(String name, int age, String species, String breed, String characteristics, double weight, PersonDto ownerId) {
        this.name = name;
        this.age = age;
        //this.idNumber = idNumber;
        this.species = species;
        this.breed = breed;
        this.characteristics = characteristics;
        this.weight = weight;
        this.ownerId = ownerId;
    }

    public PetDto() {
    }

    public PetDto(long mascota) {
    }

    public PetDto(String petName, int petAge, String specie, String breed, String characteristic, double weight) {
    }

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

    public PersonDto getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(PersonDto ownerId) {
        this.ownerId = ownerId;
    }
}
