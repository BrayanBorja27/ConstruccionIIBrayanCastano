package Service;

import dto.ClinicHistoryDto;
import dto.OrderDto;
import dto.PersonDto;
import dto.PetDto;

public interface VeterinarianService {
    public void createOwnerUser(PersonDto personDto) throws Exception;
    public void createPet(PetDto petDto) throws Exception;
    public long createOrder(OrderDto orderDto) throws Exception;
    public void createHistoryClinic(ClinicHistoryDto clinicHistoryDto) throws Exception;
    public void findHistoryClinic(ClinicHistoryDto clinicHistoryDto) throws Exception;
    public void findOrders() throws Exception;
    public void cancelOrder(OrderDto orderDto) throws Exception;
}
