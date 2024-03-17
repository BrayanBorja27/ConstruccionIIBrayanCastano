package dao;

import dto.ClinicHistoryDto;

import java.util.List;

public interface ClinicHistoryDao {
    public void createHistory(ClinicHistoryDto clinicHistoryDto) throws Exception;
    public List<ClinicHistoryDto> findHistory(ClinicHistoryDto clinicHistoryDto) throws Exception;

}
