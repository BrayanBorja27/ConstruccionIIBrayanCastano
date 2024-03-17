package Service;

import dao.*;
import dto.*;

import java.util.Arrays;
import java.util.List;

public class VetShopService implements AdminService , LoginService , VeterinarianService , SellerService{
    List<String> roles = Arrays.asList("Administrador", "Veterinario","Dueño", "Vendedor");

    List<String> Animales = Arrays.asList("Perro", "Gato", "Pez", "Ave");
    private static long sessionId = 0L;

    public void createUser(PersonDto personDto) throws Exception{
        PersonDao personDao = new PersonDaoImpl();
        if (personDao.findUserExist(personDto)) {
            throw new Exception("Ya existe usuario con esa cedula");
        }
        if (personDto.getRole() != "Owner") {
            if (personDao.existUserByUserName(personDto)) {
                throw new Exception("Ya existe el usuario");
            }
        }
        personDao.createPerson(personDto);
    }
    @Override
    public void createUserWithRole(PersonDto personDto) throws Exception {
        createUser(personDto);
    }

    @Override
    public void setSesionID(long sesionId) {
        sessionId = sesionId;
    }

    @Override
    public void login(PersonDto personDto) throws Exception {
        PersonDao personDao = new PersonDaoImpl();
        PersonDto personDtoValidate = personDao.findUserByUserName(personDto);
        if (personDtoValidate == null) {
            throw new Exception("Usuario no valido");
        }
        /*if (!personDto.getPassword().equals(personDtoValidate.getPassword())) {
            throw new Exception("Usuario o contraseña incorrecta");
        }*/
        personDto.setRole(personDtoValidate.getRole());
        LoginDao loginDao = new LoginDaoImpl();
        SessionDto sessionDto = loginDao.login(personDtoValidate);
        setSesionID(sessionDto.getId());
    }

    @Override
    public void logout() throws Exception {
        LoginDao loginDao = new LoginDaoImpl();
        loginDao.logout(sessionId);
        setSesionID(0);
    }


    @Override
    public void createOwnerUser(PersonDto personDto) throws Exception {
        createUser(personDto);
    }

    @Override
    public void createPet(PetDto petDto) throws Exception {
        LoginDao loginDao = new LoginDaoImpl();
        SessionDto sessionDto = loginDao.findSessionById(sessionId);
        if (sessionDto == null) {
            throw new Exception("no hay una sesion valida");
        }
        PersonDao personDao = new PersonDaoImpl();
        PersonDto personDto = new PersonDto(petDto.getOwnerId().getId());
        personDto = personDao.findUserById(personDto);
        if (personDto == null) {
            throw new Exception("no hay un dueño valido");
        }
        if (!Animales.contains(petDto.getSpecies())) {
            throw new Exception("No se antiende esa especie");
        }
        PetDao petDao = new PetDaoImpl();
        petDao.createPet(petDto);

    }

    @Override
    public long createOrder(OrderDto orderDto) throws Exception {
        LoginDao loginDao = new LoginDaoImpl();
        SessionDto sessionDto = loginDao.findSessionById(sessionId);
        if (sessionDto == null) {
            throw new Exception("no hay una sesion valida");
        }
        PersonDao personDao = new PersonDaoImpl();
        PersonDto personDto = new PersonDto(sessionDto.getUserName(), "");
        personDto = personDao.findUserByUserName(personDto);
        if (personDto == null) {
            throw new Exception("no hay un usuario valido");
        }
        orderDto.setPerson(personDto);
        PetDao petDao = new PetDaoImpl();
        PersonDto ownerDocument = new PersonDto(petDao.findOwnerPetById(orderDto.getIdPet()));
        orderDto.setPerson(personDto);
        OrderDao orderDao = new OrderDaoImpl();
        long idOrder = orderDao.createOrder(orderDto);
        return idOrder;
    }

    @Override
    public void createHistoryClinic(ClinicHistoryDto clinicHistoryDto) throws Exception {
        LoginDao loginDao = new LoginDaoImpl();
        SessionDto sessionDto = loginDao.findSessionById(sessionId);
        if (sessionDto == null) {
            throw new Exception("no hay una sesion valida");
        }
        PersonDao personDao = new PersonDaoImpl();
        PersonDto personDto = new PersonDto(sessionDto.getUserName(), "");
        personDto = personDao.findUserByUserName(personDto);
        if (personDto == null) {
            throw new Exception("no hay un usuario valido");
        }
        clinicHistoryDto.setVeterinarian(personDto);
        PetDao petDao = new PetDaoImpl();
        if (!petDao.findPetById(clinicHistoryDto.getIdPet())) {
            throw new Exception("no hay una mascota valida");
        }
        ClinicHistoryDao clinicHistoryDao = new ClinicHistoryDaoImpl();
        clinicHistoryDao.createHistory(clinicHistoryDto);

    }

    @Override
    public void findHistoryClinic(ClinicHistoryDto clinicHistoryDto) throws Exception {
        PetDao petDao = new PetDaoImpl();
        if (!petDao.findPetById(clinicHistoryDto.getIdPet())) {
            throw new Exception("no hay una mascota valida");
        }
        ClinicHistoryDao clinicHistoryDao= new ClinicHistoryDaoImpl();
        List<ClinicHistoryDto> resultHistoryDto = clinicHistoryDao.findHistory(clinicHistoryDto);
        if (resultHistoryDto.size() == 0) {
            throw new Exception("no hay un historia clinica");
        }
        for (int i = 0; i < resultHistoryDto.size(); i++) {
            resultHistoryDto.get(i).showHistorys();
        }

    }

    @Override
    public void findOrders() throws Exception {
        OrderDao orderDao = new OrderDaoImpl();
        List<OrderDto> resultOrders = orderDao.findOrders();
        if (resultOrders.size() == 0) {
            throw new Exception("no hay un historia clinica, o ya estan anuladas");
        }
        for (int i = 0; i < resultOrders.size(); i++) {
            resultOrders.get(i).showOrders();
        }

    }

    @Override
    public void cancelOrder(OrderDto orderDto) throws Exception {
        OrderDao orderDao = new OrderDaoImpl();
        if (!orderDao.findOrderById(orderDto)) {
            throw new Exception("no hay una orden valida");
        }
        orderDao.cancelOrder(orderDto);

    }

    @Override
    public void createBill(BillDto billDto) throws Exception {
        OrderDao orderDao = new OrderDaoImpl();
        if (!orderDao.findOrderById(billDto.getIdOrder())) {
            throw new Exception("no hay una orden valida");
        }
        OrderDto dataOrder = orderDao.findDataOrder(billDto.getIdOrder());
        billDto.setIdPet(dataOrder.getIdPet());
        billDto.setIdOwner(dataOrder.getIdOwner());
        BillDao billDao= new BillDaoImpl();
        billDao.createBill(billDto);
    }
}
