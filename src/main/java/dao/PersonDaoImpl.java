package dao;

import Models.Person;
import config.MYSQLConnection;
import dto.PersonDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonDaoImpl implements  PersonDao{
    public Connection connection = MYSQLConnection.getConnection();

    @Override
    public void createPerson(PersonDto personDto) throws Exception {
        String query = "INSERT INTO PERSONA(cedula,nombre,edad,username,password,rol) VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        int i = 1;
        preparedStatement.setLong(i++, personDto.getId());
        preparedStatement.setString(i++, personDto.getFullName());
        preparedStatement.setInt(i++, personDto.getAge());
        preparedStatement.setString(i++, personDto.getUserName());
        preparedStatement.setString(i++, personDto.getPassword());
        preparedStatement.setString(i++, personDto.getRole());
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public boolean findUserExist(PersonDto personDto) throws Exception {
        String query = "SELECT 1 FROM persona WHERE cedula = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, personDto.getId());
        ResultSet resulSet = preparedStatement.executeQuery();
        boolean userExists = resulSet.next();
        resulSet.close();
        preparedStatement.close();
        return userExists;
    }

    @Override
    public boolean existUserByUserName(PersonDto personDto) throws Exception {
        String query = "SELECT 1 FROM persona WHERE username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, personDto.getUserName());
        ResultSet resulSet = preparedStatement.executeQuery();
        boolean userExists = resulSet.next();
        resulSet.close();
        preparedStatement.close();
        return userExists;
    }

    @Override
    public PersonDto findUserByUserName(PersonDto personDto) throws Exception {
        String query = "SELECT cedula,nombre,edad,rol,username,password FROM persona WHERE username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, personDto.getUserName());
        ResultSet resulSet = preparedStatement.executeQuery();
        if(resulSet.next()) {
            Person person = new Person();
            person.setId(resulSet.getLong("CEDULA"));
            person.setFullName(resulSet.getString("NOMBRE"));
            person.setAge(resulSet.getInt("EDAD"));
            person.setRole(resulSet.getString("ROL"));
            person.setUserName(resulSet.getString("USERNAME"));
            person.setPassword(resulSet.getString("PASSWORD"));
            resulSet.close();
            preparedStatement.close();
            return new PersonDto(person.getId());
        }
        resulSet.close();
        preparedStatement.close();
        return null;
    }

    @Override
    public PersonDto findUserById(PersonDto personDto) throws Exception {
        String query = "SELECT cedula,nombre,edad,username,password,Rol FROM persona WHERE cedula = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, personDto.getId());
        ResultSet resulSet = preparedStatement.executeQuery();
        if(resulSet.next()) {
            Person person = new Person();
            person.setId(resulSet.getLong("CEDULA"));
            person.setFullName(resulSet.getString("NOMBRE"));
            person.setAge(resulSet.getInt("EDAD"));
            person.setRole(resulSet.getString("ROL"));
            person.setUserName(resulSet.getString("USERNAME"));
            person.setPassword(resulSet.getString("PASSWORD"));
            resulSet.close();
            preparedStatement.close();
            return new PersonDto(person.getId());
        }
        resulSet.close();
        preparedStatement.close();
        return null;
    }


}
