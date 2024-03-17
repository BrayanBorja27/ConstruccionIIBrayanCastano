package Service;

import dto.PersonDto;

public interface AdminService {
    public void createUserWithRole(PersonDto personDto) throws Exception;

}
