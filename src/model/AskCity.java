package model;

import client.ClientConsole;

import java.util.Arrays;

/**
 * Класс, запрашивающий у пользователя ввод объекта класса City
 */
public class AskCity {
    private static ClientConsole console = ClientConsole.getConsole();

    /**
     *
     * @param id id города
     * @return дынные, на основе которых создастся экземпляр класса City
     */
    public static String[] askCity(long id) throws IllegalArgumentException {
        String[] data = new String[11];

        while (true){
            console.print("Name: ");
            data[0] = console.readLine();
            if (data[0] == null || data[0].isEmpty()) {
                console.println("name cannot be empty");
                continue;
            }
            break;
        }

        while (true){
            console.print("coordinate x: ");
            try {
                data[1] = console.readWord();
            } catch (IllegalArgumentException e) {
                console.println(e.getMessage());
                continue;
            }
            try {
                Double.parseDouble(data[1]);
            } catch (NumberFormatException e) {
                console.println("this value must be a number");
                continue;
            }
            break;
        }

        while (true){
            console.print("coordinate y: ");
            try {
                data[2] = console.readWord();
            } catch (IllegalArgumentException e) {
                console.println(e.getMessage());
                continue;
            }
            try {
                Double.parseDouble(data[2]);
            } catch (NumberFormatException e) {
                console.println("this value must be a number");
                continue;
            }
            break;
        }

        while (true){
            console.print("area: ");
            try {
                data[3] = console.readWord();
            } catch (IllegalArgumentException e) {
                console.println(e.getMessage());
                continue;
            }
            try {
                if (Long.parseLong(data[3]) <= 0){
                    console.println("this value must be a positive number");
                    continue;
                }
            } catch (Exception e) {
                console.println("this value must be a positive number");
                continue;
            }
            break;
        }

        while (true){
            console.print("population: ");
            try {
                data[4] = console.readWord();
            } catch (IllegalArgumentException e) {
                console.println(e.getMessage());
                continue;
            }
            try {
                if (Integer.parseInt(data[4]) <= 0){
                    console.println("this value must be a positive number");
                    continue;
                }
            } catch (Exception e) {
                console.println("this value must be a positive number");
                continue;
            }
            break;
        }

        while (true){
            console.print("meters above sea level: ");
            try {
                data[5] = console.readWord();
            } catch (IllegalArgumentException e) {
                console.println(e.getMessage());
                continue;
            }
            try {
                Float.parseFloat(data[5]);
            } catch (NumberFormatException e) {
                console.println("this value must be a number");
                continue;
            }
            break;
        }

        while (true){
            console.print("climate(" + Climate.valuesList() + "): ");
            data[6] = console.readLine();
            try{
                Climate.fromDescription(data[6]);
            } catch (IllegalArgumentException e) {
                console.println(e.getMessage());
                continue;
            }
            break;
        }

        while (true){
            console.print("government(" + Government.valuesList() + "): ");
            data[7] = console.readLine();
            try{
                Government.fromDescription(data[7]);
            } catch (IllegalArgumentException e) {
                console.println(e.getMessage());
                continue;
            }
            break;
        }

        while (true){
            console.print("standard of living(" + StandardOfLiving.valuesList() + "): ");
            data[8] = console.readLine();
            try{
                StandardOfLiving.fromDescription(data[8]);
            } catch (IllegalArgumentException e) {
                console.println(e.getMessage());
                continue;
            }
            break;
        }

        while (true){
            console.print("governors age: ");
            try {
                data[9] = console.readWord();
            } catch (IllegalArgumentException e) {
                console.println(e.getMessage());
                continue;
            }
            try {
                if (Integer.parseInt(data[9]) <= 0){
                    console.println("this value must be a positive number");
                    continue;
                }
            } catch (Exception e) {
                console.println("this value must be a positive number");
                continue;
            }
            break;
        }

        data[10] = String.valueOf(id);
        return data;
    }
}
