import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HuzzFinder hf = new HuzzFinder();

        while(true){

            System.out.println("\n===== Huzz Finder =====");
            System.out.println("1. View All Profiles");
            System.out.println("2. Search By Vibe");
            System.out.println("3. Add Profile");
            System.out.println("4. Find Best Match");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1){
                hf.viewAll();
            }

            else if(choice == 2){
                System.out.print("Enter vibe: ");
                String vibe = sc.nextLine();
                hf.searchByVibe(vibe);
            }

            else if(choice == 3){

                System.out.print("Enter name: ");
                String name = sc.nextLine();

                System.out.print("Enter age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter vibe: ");
                String vibe = sc.nextLine();

                System.out.print("Enter interests (comma separated): ");
                List<String> interests =
                        Arrays.asList(sc.nextLine().split(","));

                hf.addUser(name, age, vibe, interests);
            }

            else if(choice == 4){

                System.out.print("Enter your interests (comma separated): ");
                List<String> interests =
                        Arrays.asList(sc.nextLine().split(","));

                hf.findBestMatch(interests);
            }

            else if(choice == 5){
                System.out.println("Exiting app...");
                break;
            }

            else{
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
