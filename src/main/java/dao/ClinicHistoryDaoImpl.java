package dao;

import config.MYSQLConnection;
import dto.ClinicHistoryDto;
import dto.OrderDto;
import dto.PersonDto;
import dto.PetDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClinicHistoryDaoImpl implements ClinicHistoryDao {
    public Connection connection = MYSQLConnection.getConnection();
    @Override
    public void createHistory(ClinicHistoryDto clinicHistoryDto) throws Exception {
        String query = "INSERT INTO historia(fecha,mascota,medico,motivo,sintomatologia,procedimiento,medicamento,orden,vacunacion,alergia,detalles_procedimiento,diagnosis,medicationDosage,ordercancelation) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        int i = 1;
        preparedStatement.setLong(i++, clinicHistoryDto.getAdmission());
        preparedStatement.setLong(i++, clinicHistoryDto.getIdPet().getIdNumber());
        preparedStatement.setLong(i++, clinicHistoryDto.getVeterinarian().getId());
        preparedStatement.setString(i++, clinicHistoryDto.getReasonForConsultation());
        preparedStatement.setString(i++, clinicHistoryDto.getSymptoms());
        preparedStatement.setString(i++, clinicHistoryDto.getProcedures());
        preparedStatement.setString(i++, clinicHistoryDto.getMedicines());
        preparedStatement.setLong(i++, clinicHistoryDto.getIdOrder().getOrderId());
        preparedStatement.setString(i++, clinicHistoryDto.getVaccinationHistory());
        preparedStatement.setString(i++, clinicHistoryDto.getAllergies());
        preparedStatement.setString(i++, clinicHistoryDto.getDetailsProcedures());
        preparedStatement.setString(i++, clinicHistoryDto.getDiagnostico());
        preparedStatement.setString(i++, clinicHistoryDto.getMedicationDosage());
        preparedStatement.setInt(i++, clinicHistoryDto.getEstado());
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public List<ClinicHistoryDto> findHistory(ClinicHistoryDto clinicHistoryDto) throws Exception {
        String query = "SELECT FECHA,MASCOTA,MEDICO,MOTIVO,SINTOMATOLOGIA,PROCEDIMIENTO,MEDICAMENTO,ORDEN,VACUNACION,ALERGIA,DETALLES_PROCEDIMIENTO,DIAGNOSIS,MEDICATIONDOSAGE,ORDERCANCELATION FROM  HISTORIA WHERE MASCOTA = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, clinicHistoryDto.getIdPet().getIdNumber());
        ResultSet resulSet = preparedStatement.executeQuery();

        List<ClinicHistoryDto> historys = new ArrayList<ClinicHistoryDto>();
        while (resulSet.next()) {
            ClinicHistoryDto resultHistoryDto = new ClinicHistoryDto();
            PetDto petDto = new PetDto(resulSet.getLong("MASCOTA"));
            PersonDto personDto = new PersonDto(resulSet.getLong("MEDICO"));
            OrderDto orderDto = new OrderDto(resulSet.getLong("MEDICO"));
            resultHistoryDto.setAdmission(resulSet.getLong("FECHA"));
            resultHistoryDto.setIdPet(petDto);
            resultHistoryDto.setVeterinarian(personDto);
            resultHistoryDto.setReasonForConsultation(resulSet.getString("MOTIVO"));
            resultHistoryDto.setSymptoms(resulSet.getString("SINTOMATOLOGIA"));
            resultHistoryDto.setProcedures(resulSet.getString("PROCEDIMIENTO"));
            resultHistoryDto.setMedicines(resulSet.getString("MEDICAMENTO"));;
            resultHistoryDto.setIdOrder(orderDto);
            resultHistoryDto.setVaccinationHistory(resulSet.getString("VACUNACION"));
            resultHistoryDto.setAllergies(resulSet.getString("ALERGIA"));
            resultHistoryDto.setDetailsProcedures(resulSet.getString("DETALLES_PROCEDIMIENTO"));
            resultHistoryDto.setDiagnostico(resulSet.getString("DIAGNOSIS"));
            resultHistoryDto.setMedicationDosage(resulSet.getString("MEDICATIONDOSAGE"));
            resultHistoryDto.setEstado(resulSet.getInt("ORDERCANCELATION"));;
            historys.add(resultHistoryDto);
        }
        resulSet.close();
        preparedStatement.close();
        return historys;
    }
}
