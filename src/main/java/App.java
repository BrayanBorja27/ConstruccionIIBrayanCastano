import controller.AdminController;
import controller.LoginController;

import java.util.Scanner;

public class App {
    private static Scanner reader = new Scanner(System.in);
    private static LoginController loginController = new LoginController();
    private static AdminController adminController = new AdminController();

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            try {
                run = runApplication();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.print("deteniendo la aplicacion");
        }
    }

    public static boolean runApplication() throws Exception {
        String menu = "1. Para iniciar sesion \n2.Crear Usuario \n3. Para cerrar la aplicacion";
        System.out.println("==========INGRESE=============");
        System.out.println(menu);
        System.out.println("==============================");
        String option = reader.nextLine();
        switch (option) {
            case "1": {
                loginController.login();
                return true;
            }
            case "2": {
                adminController.createUser();
                return false;
            }
            default: {
                System.out.print("ingrese una opcion valida");
                return true;
            }
        }

    }

}

