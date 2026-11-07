
package finalproject2;

public abstract class LibraryItem implements Loanable{
    
    private String title;
    private String id;
    private boolean available = true;
    
    public LibraryItem(String title, String id){
        if(id == null || id.isEmpty()) throw new IllegalArgumentException("id can not be epmty");
        else this.id = id;
        if(title == null || title.isEmpty())throw new IllegalArgumentException("title can not be epmty");
        else this.title = title;
    }
    
    public String getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public boolean isAvailabe(){
        return available;
    }
    public void setId(String id){
        if(id == null || id.isEmpty() ) throw new IllegalArgumentException("id can not be epmty");
        else this.id = id;
    }
    public void setTitle(String title){
        if( title == null || title.isEmpty())throw new IllegalArgumentException("title can not be epmty");
        else this.title = title;
    }
    
    @Override
    public void checkOut()throws ItemNotAvailableException{
        if(!isAvailable()) throw new ItemNotAvailableException("Item is not available");
        else available = false;
    }
    
    @Override
    public void checkIn(){
        available = true;
    }
    
    @Override
    public boolean isAvailable() {
        return available;
    }
    
    public abstract double getLateFeePerDay();
    
    public void printInfo(){
        System.out.println("the title is "+getTitle()+" and the id: "+getId());
        printLoanStatus();
    }
}
