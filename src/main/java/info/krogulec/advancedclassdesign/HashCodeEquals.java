package info.krogulec.advancedclassdesign;

/**
 * Na egzaminie trzeba znać kontrakt equals i hash code
 */
public class HashCodeEquals {

    public static void main(String[] args) {
        Person person = new Person("jan", "kowalski", "8403");
        Person otherEq = new Person("jan", "kowalski", "8403");
        Person otherNotEq = new Person("jan", "nowak", "8402");

        System.out.println(person.equals(otherEq));
        System.out.println(person.equals(otherNotEq));

        //jeśli equals jest true hash code musi być równy
        System.out.println(person.hashCode());
        System.out.println(otherEq.hashCode());
        System.out.println(otherNotEq.hashCode());
    }
}

class Person {
    private String name;
    private String surname;
    private String pesel;

    public Person(String name, String surname, String pesel) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null){
            return false;
        }

        if (!(obj instanceof Person)){
            return false;
        }

        Person other = (Person)obj;

        return other.name.equals(name) && other.surname.equals(surname) && other.pesel.equals(pesel);

    }

    // Jeśli equals jest równy hashCode też musi być równy - zazwyczaj jest wyliczany na podstawie podzbioru pól, które są wykorzystywane do wyznaczenia równości
    @Override
    public int hashCode() {
        return name.length() + surname.length();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
