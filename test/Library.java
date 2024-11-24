import java.util.Scanner; // or *;
// Base Class
class Book {
    //data members
    private int bookId;
    private String title,author;
    static String collegeName = "Christ University";


    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("The Book Id:" + this.bookId);
        System.out.println("The Book Title:" + this.title);
        System.out.println("The Book Author:" + this.author);
        System.out.println("College Name:" + collegeName);
    }
}

// Subclass ReferenceBook
class ReferenceBook extends Book {
    private int edition;

    // p_constructor
    public ReferenceBook(int bookId, String title, String author, int edition) {
        super(bookId, title, author); // calling parent class constructor
        this.edition = edition;
    }

    // Method to display additional details
    public void displayDerivedDetails() {
        super.displayDetails(); // Call parent class method
        System.out.println("The Reference Book Edition: " + this.edition);
    }
}

class Periodical extends ReferenceBook{
    String issueFrequency;
   // p_constructor
    public Periodical(int bookId, String title, String author, int edition,String issueFrequency){
        super(bookId, title, author, edition);
        this.issueFrequency=issueFrequency;
    }
    public void display() {
        super.displayDerivedDetails(); // Call parent class method of ReferenceBooks
        System.out.println("The issue Frequency: " + this.issueFrequency);
    }

}

// Subclass FictionBook
class FictionBook extends Book {
    private String genre;

    // p_constructor
    public FictionBook(int bookId, String title, String author, String genre) {
        super(bookId, title, author); // calling parent class constructor of books
         this.genre = genre;
    }

    // method to display
    public void displayDerivedDetails() {
        super.displayDetails(); // Call parent class method
        System.out.println("The Fiction Book Genre = " + this.genre);
    }
}

/**
 * Data Validation: (R4:5 Marks) Implement robust data validation mechanisms to ensure that
 * book IDs, edition numbers, and other relevant attributes conform to predefined ranges.
 * Additional Features:
 * Extend the classes with methods to compute and display overdue fines for late returns.Integrate
 * functionality for tracking and displaying the total number of books available and borrowed,
 * maintaining a professional and comprehensive overview of the library&#39;s collection and usage.
 */
public class Library {
    public static void main(String[] args) {
        System.out.println("Part-B Work");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Book id:");
        int BookId=sc.nextInt();
        //Book count need to 4 digits
        Boolean Vaildation=countInt(BookId);
        if(Vaildation){
            System.out.println("The count of the book need to be 4 digits");
        }
        System.out.println("Enter the Book title:");
        String title=sc.nextLine();
        System.out.println("Enter the Author Name:");
        String Author=sc.nextLine();

        System.out.println("Enter the Genre Type You need:");
        String Genre=sc.nextLine();
        //frequency months
        System.out.println("Enter issues the Frequency of book issue of "+ title +":");
        String issue=sc.nextLine();


        System.out.println("Enter issues the edition of book issue of "+ title +":");
        int edition=sc.nextInt();

        // creating the reference variable for ReferenceBook and FictionBook
        ReferenceBook refBook = new ReferenceBook(101, "Java", "Srinija", 3);

        ReferenceBook ref = new ReferenceBook(BookId,title,Author,edition);
        Periodical refg=new Periodical(BookId,title,Author,edition,issue);
        FictionBook ficBook = new FictionBook(202, "Adventure", "Sudha", "Fantasy");

        // method calling details
        System.out.println("\nreference Book Details:");
        refBook.displayDerivedDetails();

        System.out.println("\nfiction Book Details:");
        ficBook.displayDerivedDetails();
    }

    public static boolean countInt(int n){
        int count=0;
        while(n>0){
            n=n/10;
            count++;
        }
        return count == 4;
    }

}
