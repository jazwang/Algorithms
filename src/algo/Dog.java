import java.util.PriorityQueue;

public class Dog implements Comparable<Dog>{

    private Integer age;
    private String name;

    public Dog(int age, String name)
    {
        super();
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Dog dog) {
        return this.getAge().compareTo(dog.getAge());
    }

    public static void main(String[] args)
    {
        Dog a = new Dog(1, "BO");
        Dog b = new Dog(2, "XX");
        Dog c = new Dog(10, "HH");
        Dog d = new Dog(5, "JJ");
        Dog e = new Dog(3, "WW");

        PriorityQueue<Dog> queue = new PriorityQueue<>();
        queue.add(a);
        queue.add(b);
        queue.add(c);
        queue.add(d);
        queue.add(e);

        System.out.println(queue.toString());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.toString());
    }
}
