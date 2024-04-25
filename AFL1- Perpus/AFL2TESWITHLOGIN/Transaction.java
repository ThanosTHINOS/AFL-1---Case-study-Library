import java.util.*;

public class Transaction {
    private Member member;
    private Date borrowDate;
    private Date returnDate;
    private List<Book> borrowedBooks;
    private List<CD> borrowedCDs;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public List<CD> getBorrowedCDs() {
        return borrowedCDs;
    }

    public void setBorrowedCDs(List<CD> borrowedCDs) {
        this.borrowedCDs = borrowedCDs;
    }
}
