
package finalproject2;
public class Library {
    private LibraryItem[] catalog;
    private int count=0;
    
    public Library(){
        catalog = new LibraryItem[50];
        count = 0;
    }
    private LibraryItem findItem(String id){
        for (int i = 0; i < count; i++) {
            if (catalog[i].getId().equals(id)){
                return catalog[i];
            }
        }
        return null;
    }
    
    public void addBook(String title, String id, String author) {
        if (count >= catalog.length){
            System.out.println("Catalog is full!");
            return;
        }
        catalog[count] = new Book(title, id, author);
        count++;
    }
    
    public void addMagazine(String title, String id, int issueNumber) {
        if (count >= catalog.length){
            System.out.println("Catalog is full!");
            return;
        }
        catalog[count] = new Magazine(title, id, issueNumber);
        count++;
    }    
    
    public void printCatalog(){
        if (count == 0) {
            System.out.println("Catalog is empty!");
            return;
        }
        for (int i = 0; i < count; i++) {
            catalog[i].printInfo();
        }
    }
    public int getCount(){
        return count;
    }
    public void checkOutItem(String id)throws ItemNotFoundException, ItemNotAvailableException {
        LibraryItem item = findItem(id);
        if (item == null) {
            throw new ItemNotFoundException("Item not found");
        }
        item.checkOut();
    }
    public void checkInItem(String id)throws ItemNotFoundException{
        LibraryItem item = findItem(id);
        if (item == null) {
            throw new ItemNotFoundException("Item not found");
        }
        item.checkIn();
    }
    
    public LibraryItem searchById(String id) throws ItemNotFoundException{
        LibraryItem item = findItem(id);
        if(item == null){
            throw new ItemNotFoundException("Item not found");
        }
        return item;
    }
    public void printBooksOnly() {
        for (int i = 0; i < count; i++) {
            if (catalog[i] instanceof Book) {
                Book book = (Book) catalog[i];
                book.printInfo();
            }
        }
    }
    public void printMagazineOnly(){
        for(int i=0;i<count;i++){
            if(catalog[i] instanceof Magazine){
                Magazine magazine = (Magazine) catalog[i];
                magazine.printInfo();
            }
        }
    }
    
}
