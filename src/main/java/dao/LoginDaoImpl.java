package dao;

import config.MYSQLConnection;
import dto.PersonDto;
import dto.SessionDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDaoImpl implements LoginDao {

    public Connection connection = MYSQLConnection.getConnection();
    @Override
    public SessionDto login(PersonDto personDto) throws Exception {
        String query = "INSERT INTO sesion(username , role) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        int i = 1;
        preparedStatement.setString(i++, personDto.getUserName());
        preparedStatement.setString(i++, personDto.getRole());
        preparedStatement.execute();
        query = "SELECT id,role,username FROM sesion WHERE username = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, personDto.getUserName());
        ResultSet resulSet = preparedStatement.executeQuery();
        if (resulSet.next()) {
            long id = resulSet.getLong("ID");
            String userName = resulSet.getString("USERNAME");
            String userRol = resulSet.getString("ROLE");
            resulSet.close();
            preparedStatement.close();
            return new SessionDto(id, userName, userRol);
        }
        resulSet.close();
        preparedStatement.close();
        return null;
    }

    @Override
    public SessionDto findSessionById(long sessionId) throws Exception {
        String query = "SELECT id,role,username FROM sersion WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, sessionId);
        ResultSet resulSet = preparedStatement.executeQuery();
        if (resulSet.next()) {
            long id = resulSet.getLong("ID");
            String userRol = resulSet.getString("ROLE");
            String userName = resulSet.getString("USERNAME");
            resulSet.close();
            preparedStatement.close();
            return new SessionDto(id, userName, userRol);
        }
        resulSet.close();
        preparedStatement.close();
        return null;
    }

    @Override
    public void logout(long sessionId) throws Exception {
        String query = "DELETE FROM sesion WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, sessionId);
        preparedStatement.execute();
        preparedStatement.close();
    }
}
