package controller;

import Service.SellerService;
import Service.VetShopService;
import Service.VeterinarianService;
import Validators.*;
import dto.*;
import dao.ClinicHistoryDao;
import dao.*;
import java.util.Scanner;
import Service.AdminService;

public class AdminController {
    private static PersonInputsValidator personInputsValidator = new PersonInputsValidator();
    private static ClinicHistoryInputsValidator clinicHistoryInputsValidator = new ClinicHistoryInputsValidator();
    BillInputsValidator billInputsValidator = new BillInputsValidator();
    OrderInputsValidator orderInputsValidator = new OrderInputsValidator();

    PetInputsValidator petInputsValidator = new PetInputsValidator();
    private static AdminService adminService = new VetShopService();
    private static VeterinarianService veterinarianService = new VetShopService();
    private static SellerService sellerService = new VetShopService();
    private static Scanner reader = new Scanner(System.in);
    private static final String MENUADMIN = "1. Crear usuario \n2. Cerrar sesion";
    private static final String MENUVET = "1. Crear dueño \n2. Crear Historia Clinica \n3. Para crear Mascota \n4. Consultar Historia Clinica \n5. Editar Historia Clinica \n6. Listado Ordenes \n7. Anular Orden \n8. Cerrar sesion";
    private static final String MENUSELLER = "1. Para crear Factura \n2. Para cerrar sesion";

    // SESION ADMIN
    public void sessionAdmin() {
        boolean runApp = true;
        while (runApp) {
            try {
                System.out.println("==========INGRESE=============");
                System.out.println(MENUADMIN);
                System.out.println("==============================");
                String option = reader.nextLine();
                runApp = menuAdmin(option);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private boolean menuAdmin(String option) throws Exception {
        switch (option) {
            case "1": {
                createUser();
                return true;
            }
            case "2": {
                return false;
            }
            default: {
                System.out.println("ingrese una opcion valida");
                return true;
            }
        }
    }

    public void createUser() throws Exception {
        System.out.println("==============================");
        System.out.println("Ingresa la cedula");
        Long id = personInputsValidator.idValidator(reader.nextLine());

        System.out.println("Ingresa el nombre completo");
        String fullName = reader.nextLine();
        personInputsValidator.fullNameValidator(fullName);

        System.out.println("Ingresa la edad");
        int age = personInputsValidator.ageValidator(reader.nextLine());

        System.out.println("ingrese el rol (Administrador , Veterinario , Vendedor)");
        String role = reader.nextLine();
        personInputsValidator.rollValidator(role);

        System.out.println("ingrese nombre de usuario");
        String userName = reader.nextLine();
        personInputsValidator.fullNameValidator(userName);

        System.out.println("ingrese la contraseña");
        String password = reader.nextLine();
        personInputsValidator.fullNameValidator(password);

        PersonDto personDto = new PersonDto(id, fullName, age, userName, password,role);
        LoginDaoImpl loginDao = new LoginDaoImpl();
        loginDao.login(personDto);
        adminService.createUserWithRole(personDto);
    }

    public void sessionVet() {
        boolean runApp = true;
        while (runApp) {
            try {
                System.out.println("==========INGRESE=============");
                System.out.println(MENUVET);
                System.out.println("==============================");
                String option = reader.nextLine();
                runApp = menuVet(option);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private boolean menuVet(String option) throws Exception {
        switch (option) {
            case "1": {
                createOwnerUser();
                return true;
            }
            case "2": {
                createPet();
                return true;
            }
            case "3": {
                createHistoryClinic();
                return true;
            }
            case "4": {
                findHistoryClinic();
                return true;
            }
            case "5": {
                findOrders();
                return true;
            }
            case "6": {
                cancelOrders();
                return true;
            }
            case "7": {
                return false;
            }
            default: {
                System.out.println("ingrese una opcion valida");
                return true;
            }
        }
    }
    public void createOwnerUser() throws Exception {
        System.out.println("==============================");
        System.out.println("Ingresa la cedula");
        Long id = personInputsValidator.idValidator(reader.nextLine());
        System.out.println("Ingresa el nombre completo");
        String fullName = reader.nextLine();
        personInputsValidator.fullNameValidator(fullName);
        System.out.println("Ingresa la edad");
        int age = personInputsValidator.ageValidator(reader.nextLine());
        String role = "Owner";
        String userName = "N/A";
        String password = "N/A";
        PersonDto personDto = new PersonDto(id, fullName, age, role, userName, password);
        veterinarianService.createOwnerUser(personDto);
    }

    public void createPet() throws Exception {
        System.out.println("==============INGRESO DE MASCOSTA================");
        System.out.println("Ingresa el nombre de la mascota");
        String PetName = reader.nextLine();
        petInputsValidator.nameValidator(PetName);
        System.out.println("Ingresa el documento del dueño");
        Long ownerDoct = petInputsValidator.idNumberValidator(reader.nextLine());
        PersonDto personDto = new PersonDto(ownerDoct);
        System.out.println("Ingresa la edad");
        int PetAge = petInputsValidator.ageValidator(reader.nextLine());
        System.out.println("ingrese la especie (Perro,Gato,Pez,Ave)");
        String specie = reader.nextLine();
        petInputsValidator.breedValidator(specie);
        System.out.println("ingrese la raza");
        String breed = reader.nextLine();
        petInputsValidator.speciesValidator(specie);
        System.out.println("ingrese las caracteristicas (color,tamaño)");
        String characteristic = reader.nextLine();
        petInputsValidator.characteristicsValidator(characteristic);
        System.out.println("Ingresa el peso en KLS");
        double weight = petInputsValidator.weightValidator(reader.nextLine());
        PetDto petDto = new PetDto(PetName, PetAge, specie, breed, characteristic, weight);
        petDto.setOwnerId(personDto);
        veterinarianService.createPet(petDto);
    }

    public void createHistoryClinic() throws Exception{
        long actualDate = System.currentTimeMillis();
        System.out.println("Ingresa tu nombre completo de Veterinario");
        String veterinarian = reader.nextLine();
        clinicHistoryInputsValidator.veterinarianValidator(veterinarian);
        System.out.println("Ingresa la razon de consulta");
        String reasonForConsultation = reader.nextLine();
        clinicHistoryInputsValidator.reasonForConsultationValidator(reasonForConsultation);
        System.out.println("Ingresa los sintomas");
        String symptoms = reader.nextLine();
        clinicHistoryInputsValidator.symptomsValidator(symptoms);
        System.out.println("Ingresa el diagnostico");
        String diagnostic = reader.nextLine();
        clinicHistoryInputsValidator.diagnosticValidator(diagnostic);
        System.out.println("Ingresa el procedimiento");
        String procedures = reader.nextLine();
        clinicHistoryInputsValidator.proceduresValidator(procedures);
        System.out.println("Ingresa las medicinas recomendadas");
        String medicines = reader.nextLine();
        clinicHistoryInputsValidator.medicinesValidator(medicines);
        System.out.println("Ingresa el historial de vacunacion");
        String vaccinationHistory = reader.nextLine();
        clinicHistoryInputsValidator.vaccionationHistoryValidator(vaccinationHistory);
        System.out.println("Ingresa las alergias");
        String allergies = reader.nextLine();
        clinicHistoryInputsValidator.allergiesValidator(allergies);
        System.out.println("Ingresa los detaller del procedimiento");
        String detailsProcedures = reader.nextLine();
        clinicHistoryInputsValidator.medicinesValidator(detailsProcedures);


        OrderDto orderDto = new OrderDto();
        PetDto petDto = new PetDto();

        ClinicHistoryDto clinicHistoryDto = new ClinicHistoryDto(actualDate , veterinarian, reasonForConsultation, symptoms, diagnostic, procedures, medicines, orderDto, petDto ,vaccinationHistory, allergies, detailsProcedures);
        veterinarianService.createHistoryClinic(clinicHistoryDto);
        System.out.println("Historia clínica creada exitosamente");
    }

    public OrderDto createOrder(PetDto petDto, String medicine, String medicationDosage) throws Exception {
        OrderDto orderDto = new OrderDto();
        orderDto.setIdPet(petDto);
        orderDto.setNameMedications(medicine + " - " + medicationDosage);
        long idOrder = veterinarianService.createOrder(orderDto);
        orderDto.setOrderId(idOrder);
        System.out.println("Se genero a la Orden con el id: " + idOrder);
        return orderDto;
    }

    public void findHistoryClinic() throws Exception {
        System.out.println("==============INGRESO DE DATOS================");
        System.out.println("Ingresa el id de la mascota");
        long idPet = clinicHistoryInputsValidator.idOrderValidator(reader.nextLine());
        PetDto petDto = new PetDto(idPet);
        ClinicHistoryDto clinicHistoryDto= new ClinicHistoryDto();
        clinicHistoryDto.setIdPet(petDto);
        veterinarianService.findHistoryClinic(clinicHistoryDto);
    }

    public void findOrders() throws Exception {
        System.out.println("==============ORDENES================");
        veterinarianService.findOrders();
    }

    public void cancelOrders() throws Exception{
        System.out.println("================ANULACION===============");
        System.out.println("Ingresa el id de la Orden");
        long idOrder = clinicHistoryInputsValidator.idOrderValidator(reader.nextLine());
        OrderDto orderDto = new OrderDto(idOrder);
        ClinicHistoryDto historyDto = new ClinicHistoryDto();
        historyDto.setIdOrder(orderDto);
        veterinarianService.cancelOrder(orderDto);

    }

    public void sessionSeller() {
        boolean runApp = true;
        while (runApp) {
            try {
                System.out.println("==========INGRESE=============");
                System.out.println(MENUSELLER);
                System.out.println("==============================");
                String option = reader.nextLine();
                runApp = menuSeller(option);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private boolean menuSeller(String option) throws Exception {
        switch (option) {
            case "1": {
                findOrders();
                return true;
            }
            case "2": {
                createBill();
                return true;
            }
            case "3": {
                return false;
            }
            default: {
                System.out.println("ingrese una opcion valida");
                return true;
            }
        }
    }

    public void createBill()  throws Exception{
        System.out.println("================ANULACION===============");
        System.out.println("Ingresa el id de la Orden");
        long idOrder = clinicHistoryInputsValidator.idOrderValidator(reader.nextLine());
        OrderDto orderDto = new OrderDto(idOrder);
        System.out.println("Ingresa el nombre del producto");
        String productName = reader.nextLine();
        billInputsValidator.productNameValidator(productName);
        System.out.println("Ingresa el cantidad");
        int amount = billInputsValidator.amountValidator(reader.nextLine());
        System.out.println("Ingresa el precio");
        double price = billInputsValidator.priceValidator(reader.nextLine());
        BillDto billdto = new BillDto();
        billdto.setIdOrder(orderDto);
        billdto.setProductName(productName);
        billdto.setAmount(amount);
        billdto.setPrice(price);
        sellerService.createBill(billdto);
    }




}
