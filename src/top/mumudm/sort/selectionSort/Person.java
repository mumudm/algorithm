package top.mumudm.sort.selectionSort;

/**
 * @author mumu
 * @date 2021-5-1 22:47
 */
public class Person implements Comparable<Person> {

    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        if (this.age < person.getAge()) {
            return -1;
        } else if (this.age.equals(person.getAge())) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
