package dao;

import dto.PersonDto;
import dto.SessionDto;

public interface LoginDao {
    public SessionDto login(PersonDto personDto) throws Exception;
    public SessionDto findSessionById(long sessionId) throws Exception;
    public void logout(long sessionId) throws Exception;
}
