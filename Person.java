package coronatree;

public class Person implements Comparable<Person> {

    String name;
    int id;

    /**
     * A standard constructor for the Person class.
     *
     * @param id - the ID number of the subject
     */
    public Person(int id, String name) {
        //your code comes here
        this.id = id;
        this.name = name;
    }

    /**
     * Compares this person with another person.
     * Returns a negative integer, zero, or a positive integer as the ID number of this person
     * is less than, equal to, or greater than the ID number of the other person.
     *
     * @param other - the person to be compared
     * @return a negative integer, zero, or a positive integer as the ID number of this person
     * is less than, equal to, or greater than the ID number of the other person.
     */
    public int compareTo(Person other) {
        //your code comes here
        if (this.id < other.id) return -1;
        if (this.id == other.id) return 0;
        return 1;

    }

    /**
     * Returns a textual representation of this person.
     * The output string should be in the format:
     * <name>, ID number: <ID>.
     * For example if a person is named "John Locke" with ID 57, the output will be
     * "Jhon Locke, ID number: 57".
     */
    public String toString() {
        //your code comes here
        String str = "";
        str = this.name + ", ID number: " + this.id;
        return str;
    }

}
