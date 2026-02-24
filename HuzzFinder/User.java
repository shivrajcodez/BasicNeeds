import java.io.Serializable;
import java.util.*;

public class User implements Serializable {

    String name;
    int age;
    String vibe;
    List<String> interests;

    public User(String name, int age, String vibe, List<String> interests){
        this.name = name;
        this.age = age;
        this.vibe = vibe;
        this.interests = interests;
    }

    public void display(){
        System.out.println("\nName: " + name);
        System.out.println("Age: " + age);
        System.out.println("Vibe: " + vibe);
        System.out.println("Interests: " + interests);
        System.out.println("----------------------");
    }
}
