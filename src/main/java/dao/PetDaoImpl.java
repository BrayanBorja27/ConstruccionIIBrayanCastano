package dao;

import config.MYSQLConnection;
import dto.PetDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PetDaoImpl implements PetDao{

    public Connection connection = MYSQLConnection.getConnection();
    @Override
    public void createPet(PetDto petDto) throws Exception {
        String query = "INSERT INTO MASCOTA(id,propietario,nombre,edad,peso,raza,especie,caracteristicas) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        int i = 1;
        preparedStatement.setLong(i++, petDto.getOwnerId().getId());
        preparedStatement.setString(i++, petDto.getName());
        preparedStatement.setInt(i++, petDto.getAge());
        preparedStatement.setDouble(i++, petDto.getWeight());
        preparedStatement.setString(i++, petDto.getBreed());
        preparedStatement.setString(i++, petDto.getSpecies());
        preparedStatement.setString(i++, petDto.getCharacteristics());
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public long findOwnerPetById(PetDto petDto) throws Exception {
        String query = "SELECT propietario FROM mascota WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, petDto.getIdNumber());
        ResultSet resulSet = preparedStatement.executeQuery();
        if (resulSet.next()) {
            long id = resulSet.getLong("PROPIETARIO");
            resulSet.close();
            preparedStatement.close();
            return id;
        }
        resulSet.close();
        preparedStatement.close();
        return (Long) null;
    }

    @Override
    public boolean findPetById(PetDto petDto) throws Exception {
        String query = "SELECT id FROM mascota WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, petDto.getIdNumber());
        ResultSet resulSet = preparedStatement.executeQuery();
        boolean result = resulSet.next();
        resulSet.close();
        preparedStatement.close();
        return result;
    }
}
