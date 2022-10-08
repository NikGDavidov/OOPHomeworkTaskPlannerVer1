package OOPHomework4;

import sun.util.calendar.LocalGregorianCalendar;

import java.text.SimpleDateFormat;
import java.util.Date;

//Спроектировать и реализовать планировщик дел для работы с задачами разных приоритетов.
//        Например:
//        определить уровень приоритетов: низкий, средний, немедленное выполнение
//        выделить компоненту для хранения данных
//        выделить компоненту для организации импорта\экспорта данных
//        Файл должен содержать следующие данные: id, дату добавления записи,
//        время добавления записи, дедлай задачи, ФИО автора,
//        данные хранятся в файле csv/jsom/xml
//        другие компоненты
public class Task implements Comparable<Task>{
    private int id;
    private int priority;
    private Date dateOfAdd;
    private Date deadLine;
    private String description;
    private String fullName;

    public Task() { }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getDateOfAdd() {
        return dateOfAdd;
    }

    public void setDateOfAdd(Date dateOfAdd) {
        this.dateOfAdd = dateOfAdd;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public int compareTo(Task o) {
        int result =this.getDeadLine().compareTo( o.getDeadLine());
        if (result == 0)
            result = this.getPriority()-o.getPriority();
        if (result == 0) result = this.getDateOfAdd().compareTo(o.getDateOfAdd());
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +", " + description +
                ", priority = " + priority +
                ", Сделать до " + new SimpleDateFormat("yyyy-MM-dd").format(deadLine)+
                ", Добавлена " + dateOfAdd+

                ", Ответственный " + fullName  +
                '}';
    }
}
