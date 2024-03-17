package dao;

import config.MYSQLConnection;
import dto.BillDto;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BillDaoImpl implements BillDao{
    public Connection connection = MYSQLConnection.getConnection();

    @Override
    public void createBill(BillDto billDto) throws Exception {
        String query = "INSERT INTO factura(mascota,propietario,producto,valor,cantidad,fecha) VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        int i = 1;
        preparedStatement.setLong(i++, billDto.getIdPet().getIdNumber());
        preparedStatement.setLong(i++, billDto.getIdOwner().getId());
        preparedStatement.setString(i++, billDto.getProductName());
        preparedStatement.setDouble(i++, billDto.getPrice());
        preparedStatement.setInt(i++, billDto.getAmount());
        preparedStatement.setDate(i++, billDto.getDate());
        preparedStatement.execute();
        preparedStatement.close();
    }
}
