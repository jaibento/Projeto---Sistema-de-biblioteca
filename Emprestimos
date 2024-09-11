import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Emprestimos {
    private List<Loan> loans;

    public Emprestimos() {
        this.loans = new ArrayList<>();
    }

    public void addLoan(User user, Book book) {
        Loan loan = new Loan(user, book, new Date(), null);
        loans.add(loan);
        book.borrowBook();
    }

    public void returnLoan(User user, Book book) {
        for (Loan loan : loans) {
            if (loan.getUser().getUsername().equals(user.getUsername()) && 
                loan.getBook().getTitle().equals(book.getTitle()) &&
                loan.getReturnDate() == null) {
                loan.setReturnDate(new Date());
                book.returnBook();
                break;
            }
        }
    }

    public List<Loan> getLoansForUser(User user) {
        List<Loan> userLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getUser().getUsername().equals(user.getUsername())) {
                userLoans.add(loan);
            }
        }
        return userLoans;
    }
}

class Loan {
    User user;
    Book book;
    Date loanDate;
    Date returnDate;

    public Loan(User user, Book book, Date loanDate, Date returnDate) {
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
