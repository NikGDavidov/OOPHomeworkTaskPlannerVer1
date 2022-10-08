package OOPHomework4;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        System.out.print("\033[H\033[J");// ru.stackoverflow.com/questions/1315049/Как-очистить-консоль-в-java-во-время-действия-программы
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Введите опцию - 1 - добавить запись; 2- вывести записи на экран; 3 - удалить запись");
                String key = scanner.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "1":
                        addTask();
                        break;
                    case "2":
                        PrintCSV.print(ReadCSV.read());
                        break;
                    case "3":
                        removeTask();
                        break;

                    default:
                        System.out.println("Такой команды нет");
                        break;
                }
            }
        }
    }
    public static void addTask()throws IOException{
   //     BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc1 = new Scanner (System.in);
        Task task = new Task();
        System.out.println("Введите название задачи");
       // task.setDescription(r.readLine());
        task.setDescription(sc1.next());
        System.out.println("Введите дату завершения задачи в формате dd/MM/yyyy");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            task.setDeadLine(simpleDateFormat.parse(sc1.next()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Назначьте приоритет задачи : 1-важная; 2 - средней важности; 3 - менее важная.");
        task.setPriority(Integer.parseInt(sc1.next()));
        System.out.println("Введите имя ответственного лица");
        task.setFullName(sc1.next());
        task.setDateOfAdd(new Date());
        task.setId(task.getDateOfAdd().hashCode()%100*(-1));
        WriteCSV.write(task);
      // r.close();
        return;
    }
    static void removeTask() throws IOException, ParseException {
        System.out.println("Введите id задачи, которую хотите удалить");
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int id = Integer.parseInt(r.readLine());
        ArrayList<Task> lt = (ArrayList)ReadCSV.read();
        for (int i=0; i<lt.size();i++){
            if (lt.get(i).getId()==id) lt.remove(i);
        }
        File file = new File("demo.csv");
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();
        for (int i=0; i<lt.size();i++){
            WriteCSV.write(lt.get(i));
        }
    }
}