package forAjob;

import java.io.Serializable;

/**
 *
 */
public class People implements Serializable {
    private static final int serialVersionUID = 2;
    String job;
    int a;
    transient String surname;
    static String firstName;

    public People(String job, int a, String surname,String firstName1) {
        this.job = job;
        this.a = a;
        this.surname = surname;
        firstName = firstName1;
    }

    public People() {

    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        People.firstName = firstName;
    }

    @Override
    public String toString() {
        return "People{" +
                "job='" + job + '\'' +
                ", a=" + a +
                ", surname='" + surname + '\'' +
                ",firstName=" + firstName +
                '}';
    }
}
