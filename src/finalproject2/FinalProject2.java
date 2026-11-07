
package finalproject2;
import java.util.Scanner;
public class FinalProject2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Library library = new Library();
        int option;
        boolean running = true;
        while(running){
            mainMenu();
            System.out.print("Choose an option: ");
            while(true){
                if(!s.hasNextInt()){
                System.out.println("Invalid input! Please enter a number.");
                s.next();
                System.out.print("Choose an option: ");
                continue;                
                }
                option =s.nextInt();
            if(option >= 1 && option <= 9){
                break;
            }
            System.out.println("Please enter a number from 1 to 9.");
            System.out.print("Choose an option: ");
            }
            s.nextLine();
            switch(option){
                case 1:{
                    System.out.print("Enter book Title: ");
                    String title = s.nextLine();
                    System.out.print("Enter book ID: ");
                    String id = s.nextLine();
                    System.out.print("Enter book Author");
                    String author = s.nextLine();
                    try{
                        library.addBook(title, id, author);
                    } catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                    
                case 2:{
                    System.out.print("Enter magazine Title: ");
                    String title = s.nextLine();
                    System.out.print("Enter magazine ID: ");
                    String id = s.nextLine();
                    System.out.print("Enter magazine Issue Number: ");
                    while(!s.hasNextInt()){
                        System.out.println("Please enter a valid number. ");
                        s.next();
                    }
                    int issueNumber = s.nextInt();
                    try{
                        library.addMagazine(title, id, issueNumber);
                    } catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    s.nextLine();
                    break;
                }
                case 3:{
                    library.printCatalog();
                    break;
                }
                case 4:{
                    library.printBooksOnly();
                    break;
                }
                case 5:{
                    library.printMagazineOnly();
                    break;
                }
                case 6:{
                    System.out.println("Enter ID ");
                    String id = s.nextLine();
                    try{
                        library.checkOutItem(id);
                        System.out.println("Item checked out successfully");
                    }catch (ItemNotFoundException | ItemNotAvailableException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 7:{
                    System.out.println("Enter ID ");
                    String id = s.nextLine();
                    try{
                        library.checkInItem(id);
                        System.out.println("Item checked in successfully");
                    }catch (ItemNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 8:{
                    System.out.print("Enter ID to search: ");
                    String id = s.nextLine();
                    try{
                        LibraryItem item = library.searchById(id);
                        item.printInfo();
                    }catch(ItemNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 9:{
                    System.out.println("Thank you for using our Library.");
                        System.out.println("Goodbye! The catalog has "
                        + library.getCount() + " items.");
                    running = false;
                    break;
                }
                
            }
        }
    }
   
    public static void mainMenu(){
        System.out.println("1.Add a Book    2.Add a Magazine    3.Show Catalog\n4.Show Books    5.Show Magazines"
                + "    6.Borrow Book or Magazine\n7.Return it     8.Search            9.Exit");
    }
}
