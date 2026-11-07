
package finalproject2;

public class Book extends LibraryItem {
    private String author;
    public Book(String title, String id,String author){
        super(title,id);
        if(author == null || author.isEmpty())throw new IllegalArgumentException("Auther can not be epmty");
        else this.author=author;
    }
    
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        if(author == null || author.isEmpty() ) throw new IllegalArgumentException("Author can not be epmty");
        else this.author = author;
    }
    
    
    @Override
    public double getLateFeePerDay(){
        return 0.25;
    }
    
    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("And the author is: "+getAuthor());
    }
}
