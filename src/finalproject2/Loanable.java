
package finalproject2;
public interface Loanable {
    void checkOut()throws ItemNotAvailableException ;
    void checkIn();
    boolean isAvailable();
    default void printLoanStatus(){
        if (isAvailable())System.out.println("Availabe");
        else System.out.println("Checked Out");
    }
}
