import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando um catálogo de livros
        CatalogoDeLivros catalogo = new CatalogoDeLivros();
        Book book1 = new Book("O Senhor dos Anéis", "J.R.R. Tolkien");
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("Dom Quixote", "Miguel de Cervantes");
        
        catalogo.addBook(book1);
        catalogo.addBook(book2);
        catalogo.addBook(book3);

        // Criando um usuário
        User user = new User("joao", "1234", "joao@gmail.com");

        // Verificando detalhes do usuário
        System.out.println("Username: " + user.getUsername());
        System.out.println("Email: " + user.getEmail());

        // Validando senha do usuário
        if (user.validatePassword("1234")) {
            System.out.println("Senha correta!");
        } else {
            System.out.println("Senha incorreta!");
        }

        // Criando o sistema de empréstimos
        Emprestimos emprestimos = new Emprestimos();

        // Mostrando os livros disponíveis para empréstimo
        System.out.println("\nLivros disponíveis para empréstimo:");
        List<Book> availableBooks = catalogo.getAvailableBooks();
        for (int i = 0; i < availableBooks.size(); i++) {
            System.out.println((i + 1) + ". " + availableBooks.get(i).getTitle() + " de " + availableBooks.get(i).getAuthor());
        }

        // Pedindo para o usuário escolher um livro
        int choice = -1;
        while (choice < 1 || choice > availableBooks.size()) {
            System.out.print("\nEscolha o número do livro que deseja emprestar: ");
            try {
                choice = scanner.nextInt();
                if (choice < 1 || choice > availableBooks.size()) {
                    System.out.println("Por favor, escolha um número válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número.");
                scanner.next(); // Limpa o input inválido
            }
        }

        // Validando a escolha e processando o empréstimo
        Book selectedBook = availableBooks.get(choice - 1);
        emprestimos.addLoan(user, selectedBook);
        System.out.println("Você emprestou o livro: " + selectedBook.getTitle());

        // Mostrando os livros disponíveis após o empréstimo
        System.out.println("\nLivros disponíveis após empréstimo:");
        availableBooks = catalogo.getAvailableBooks(); // Atualiza a lista após o empréstimo
        for (Book book : availableBooks) {
            System.out.println("- " + book.getTitle() + " de " + book.getAuthor());
        }

        // Mostrando os empréstimos do usuário
        System.out.println("\nEmpréstimos do usuário:");
        List<Loan> userLoans = emprestimos.getLoansForUser(user);
        for (Loan loan : userLoans) {
            System.out.println("- " + loan.getBook().getTitle() + " emprestado em " + loan.getLoanDate());
        }

        // Pedindo para devolver o livro emprestado
        System.out.print("\nDeseja devolver o livro emprestado? (sim/não): ");
        String returnResponse = scanner.next();
        if (returnResponse.equalsIgnoreCase("sim")) {
            emprestimos.returnLoan(user, userLoans.get(0).getBook());
            System.out.println("Você devolveu o livro: " + userLoans.get(0).getBook().getTitle());
        }

        // Mostrando os livros disponíveis após a devolução
        System.out.println("\nLivros disponíveis após devolução:");
        for (Book book : catalogo.getAvailableBooks()) {
            System.out.println("- " + book.getTitle() + " de " + book.getAuthor());
        }

        scanner.close();
    }
}
