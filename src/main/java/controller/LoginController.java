package controller;

import Service.LoginService;
import Service.VetShopService;
import Validators.PersonInputsValidator;
import dto.PersonDto;

import java.util.Scanner;

public class LoginController {
    private static Scanner reader = new Scanner(System.in);
    private static PersonInputsValidator personInputValidator = new PersonInputsValidator();
    private static LoginService loginService = new VetShopService();

    private static AdminController adminController = new AdminController();

    public void login() throws Exception {
        System.out.println("==============================");
        System.out.println("Ingrese su usuario");
        String userName = reader.nextLine();
        personInputValidator.userNameValidator(userName);
        System.out.println("Ingrese su contraseña");
        String password = reader.nextLine();
        personInputValidator.passwordValidator(password);
        PersonDto personDto = new PersonDto(userName, password);
        loginService.login(personDto);
        loginRouter(personDto);
        loginService.logout();
    }

    private void loginRouter(PersonDto personDto) {
        if (personDto.getRole().equals("Administrador")) {
            adminController.sessionAdmin();
        } else if (personDto.getRole().equals("Veterinario")){
            adminController.sessionVet();
        }else if (personDto.getRole().equals("Vendedor")){
            adminController.sessionSeller();
        }
    }
}
