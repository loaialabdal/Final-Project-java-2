
package finalproject2;

public class Magazine extends LibraryItem{
    private int issueNumber;
    
    public Magazine(String title, String id, int issueNumber){
        super(title, id);
        setIssueNumber(issueNumber);
    }
    public int getIssueNumber(){
        return issueNumber;
    }
    public void setIssueNumber(int issueNumber){
        if(issueNumber <= 0) throw new IllegalArgumentException("Issue Number can not be Zero or under.");
        else this.issueNumber = issueNumber;
    }
    @Override
     public double getLateFeePerDay(){  
         return 0.10;
     }
     @Override
     public void printInfo(){
         super.printInfo();
         System.out.println("And the Issue Number is "+getIssueNumber());
     }
}
