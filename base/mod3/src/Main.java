import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Чтобы считать символ новой строки
        System.out.print("Введите хобби через запятую: ");
        String hobbiesInput = scanner.nextLine();
        List<String> hobbies = new ArrayList<>();
        String[] hobbyArray = hobbiesInput.split(",");
        for (String hobby : hobbyArray) {
            hobbies.add(hobby.trim());
        }

        User user = new User(name, login, age, hobbies);

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("user.ser"));
        outputStream.writeObject(user);
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("user.ser"));
        User deserializedUser = (User) inputStream.readObject();
        inputStream.close();

        System.out.println(deserializedUser);
    }
}