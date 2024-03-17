package dao;

import config.MYSQLConnection;
import dto.OrderDto;
import dto.PersonDto;
import dto.PetDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao{

    public Connection connection = MYSQLConnection.getConnection();
    @Override
    public long createOrder(OrderDto orderDto) throws Exception {
        String query = "INSERT INTO orden(mascota,propietario,medico,medicamento,fecha) VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        int i = 1;
        preparedStatement.setLong(i++, orderDto.getIdPet().getIdNumber());
        preparedStatement.setLong(i++, orderDto.getIdOwner().getId());
        preparedStatement.setLong(i++, orderDto.getPerson().getId());
        preparedStatement.setString(i++, orderDto.getNameMedications());
        preparedStatement.setDate(i++, orderDto.getGenerationDate());
        preparedStatement.execute();
        query = "SELECT id FROM orden WHERE fecha = ? AND medicamento = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setDate(1, orderDto.getGenerationDate());
        preparedStatement.setString(2, orderDto.getNameMedications());
        ResultSet resulSet = preparedStatement.executeQuery();
        if (resulSet.next()) {
            long id = resulSet.getLong("ID");
            resulSet.close();
            preparedStatement.close();
            return id;
        }
        resulSet.close();
        preparedStatement.close();
        return (Long) null;
    }

    @Override
    public List<OrderDto> findOrders() throws Exception {
        String query = "SELECT  O.id,O.mascota,O.propietario,O.medico,O.medicamento,O.fecha FROM orden AS O JOIN historia AS H ON (H.orden= O.id) WHERE H.CancelacionOrden = 0";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resulSet = preparedStatement.executeQuery();
        List<OrderDto> orders = new ArrayList<OrderDto>();
        while (resulSet.next()) {
            OrderDto resultOrderDto = new OrderDto();
            PetDto petDto = new PetDto(resulSet.getLong("MASCOTA"));
            PersonDto ownerDto = new PersonDto(resulSet.getLong("PROPIETARIO"));
            PersonDto veterinarianDto = new PersonDto(resulSet.getLong("MEDICO"));
            resultOrderDto.setOrderId(resulSet.getLong("ID"));
            resultOrderDto.setIdPet(petDto);
            resultOrderDto.setIdOwner(ownerDto);
            resultOrderDto.setPerson(veterinarianDto);
            resultOrderDto.setNameMedications(resulSet.getString("MEDICAMENTO"));
            resultOrderDto.setGenerationDate(resulSet.getDate("FECHA"));
            orders.add(resultOrderDto);
        }
        resulSet.close();
        preparedStatement.close();
        return orders;
    }

    @Override
    public boolean findOrderById(OrderDto orderDto) throws Exception {
        String query = "SELECT orden FROM historia WHERE orden = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, orderDto.getOrderId());
        ResultSet resulSet = preparedStatement.executeQuery();
        boolean result = resulSet.next();
        resulSet.close();
        preparedStatement.close();
        return result;
    }

    @Override
    public void cancelOrder(OrderDto orderDto) throws Exception {
        String query = "UPDATE historia SET CancelacionOrden = 1 WHERE orden = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, orderDto.getOrderId());
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public OrderDto findDataOrder(OrderDto orderDto) throws Exception {
        String query = "SELECT id,mascota,propietario,medico,medicamento,fecha FROM orden WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, orderDto.getOrderId());
        ResultSet resulSet = preparedStatement.executeQuery();
        if(resulSet.next()) {
            OrderDto responseOrderDto = new OrderDto();
            PetDto petDto = new PetDto(resulSet.getLong("MASCOTA"));
            PersonDto ownerDocument = new PersonDto(resulSet.getLong("PROPIETARIO"));
            PersonDto vetDocument = new PersonDto(resulSet.getLong("MEDICO"));
            responseOrderDto.setOrderId(resulSet.getLong("ID"));
            responseOrderDto.setIdPet(petDto);
            responseOrderDto.setIdOwner(ownerDocument);;
            responseOrderDto.setPerson(vetDocument);
            responseOrderDto.setNameMedications(resulSet.getString("MEDICAMENTO"));
            responseOrderDto.setGenerationDate(resulSet.getDate("FECHA"));
            return responseOrderDto;
        }
        resulSet.close();
        preparedStatement.close();
        return null;
    }
}
