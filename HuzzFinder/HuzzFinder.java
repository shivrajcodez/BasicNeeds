import java.util.*;
import java.io.*;

public class HuzzFinder {

    private ArrayList<User> users = new ArrayList<>();
    private final String FILE_NAME = "data.db";

    public HuzzFinder(){
        loadFromFile();
    }

    public void viewAll(){
        if(users.isEmpty()){
            System.out.println("No profiles available.");
            return;
        }

        for(User u : users){
            u.display();
        }
    }

    public void searchByVibe(String vibe){
        boolean found = false;

        for(User u : users){
            if(u.vibe.equalsIgnoreCase(vibe)){
                u.display();
                found = true;
            }
        }

        if(!found){
            System.out.println("No matches found.");
        }
    }

    public void addUser(String name, int age, String vibe, List<String> interests){
        users.add(new User(name, age, vibe, interests));
        saveToFile();
        System.out.println("Profile added and saved!");
    }

    public void findBestMatch(List<String> yourInterests){

        User bestMatch = null;
        int highestScore = 0;

        for(User u : users){

            int score = 0;

            for(String interest : yourInterests){
                if(u.interests.contains(interest.trim())){
                    score++;
                }
            }

            if(score > highestScore){
                highestScore = score;
                bestMatch = u;
            }
        }

        if(bestMatch != null){
            System.out.println("\n Best Match (Score: " + highestScore + ")");
            bestMatch.display();
        }
        else{
            System.out.println("No compatible matches found.");
        }
    }

    private void saveToFile(){
        try(ObjectOutputStream out =
            new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
            out.writeObject(users);
        }
        catch(Exception e){
            System.out.println("Error saving data.");
        }
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile(){
        try(ObjectInputStream in =
            new ObjectInputStream(new FileInputStream(FILE_NAME))){
            users = (ArrayList<User>) in.readObject();
        }
        catch(Exception e){
            users = new ArrayList<>();
        }
    }
}
