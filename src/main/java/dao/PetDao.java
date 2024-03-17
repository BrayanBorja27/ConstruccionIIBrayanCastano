package dao;

import dto.PetDto;

public interface PetDao {
    public void createPet(PetDto petDto) throws Exception;
    public long findOwnerPetById(PetDto petDto) throws Exception;
    public boolean findPetById(PetDto petDto) throws Exception;
}
