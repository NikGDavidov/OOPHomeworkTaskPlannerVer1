package OOPHomework4;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteCSV {
    public static void write(Task task) {


  String fileName = "demo.csv";

        StringBuilder sb = new StringBuilder();
        sb.append(task.getId());
        sb.append(',');
        sb.append(task.getDescription());
        sb.append(',');

        Date dt = task.getDateOfAdd();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy/hh/mm");
        sb.append(f.format(dt));
        sb.append(',');
        dt = task.getDeadLine();
        f = new SimpleDateFormat("dd/MM/yyyy");
        sb.append(f.format(dt));
        sb.append(',');
        sb.append(task.getPriority());
        sb.append(',');
        sb.append(task.getFullName());
        sb.append('\n');

        try( FileWriter fw = new FileWriter(fileName, true)){

            fw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


//    WriteCSV testCSV =  new WriteCSV();
//        testCSV.readCSVFile();
}

//    public void readCSVFile(){
//        List<List<String>> records = new ArrayList<>();
//        try (Scanner scanner = new Scanner(new File("demo.csv"));) {
//            while (scanner.hasNextLine()) {
//                records.add(getRecordFromLine(scanner.nextLine()));
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println(records.toString());
//    }
//    private List<String> getRecordFromLine(String line) {
//        List<String> values = new ArrayList<String>();
//        try (Scanner rowScanner = new Scanner(line)) {
//            rowScanner.useDelimiter(",");
//            while (rowScanner.hasNext()) {
//                values.add(rowScanner.next());
//            }
//        }
//        return values;
//    }

}

