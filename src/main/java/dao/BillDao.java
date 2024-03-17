package dao;

import dto.BillDto;

public interface BillDao {
    public void createBill(BillDto billDto) throws Exception;
}
