package Service;

import dto.BillDto;

public interface SellerService {
    public void createBill(BillDto billDto) throws Exception;
}
