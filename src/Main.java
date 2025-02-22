import util.InteractiveMode;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("you need to write filename");
            System.exit(0);
        }
        if (args.length > 1) {
            System.out.println("you need to write only filename, don't write many arguments");
            System.exit(0);
        }
        InteractiveMode session = new InteractiveMode(args[0]); //Перед сборкой jar изменить на аргумент командной строки
        session.run();
    }
}
