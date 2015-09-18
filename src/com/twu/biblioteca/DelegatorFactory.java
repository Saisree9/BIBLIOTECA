package com.twu.biblioteca;

public class DelegatorFactory {
    private Console console;
    private Authenticator authenticator;

    public DelegatorFactory(Console console, Authenticator authenticator) {
        this.console = console;
        this.authenticator = authenticator;
    }

    public MainMenuOptionDelegator getMainMenuOptionDelegator(User user) {
        String role = user.getRole();
        switch (role) {
            case "user":
                console.display("1:ListBooks\n" +
                        "2:UserDetails\n" +
                        "3:CheckOutBooks\n" +
                        "4:ReturnOption\n" +
                        "5:ListMovies\n" +
                        "6:CheckOutMovie\n" +
                        "7:logout\n" +
                        "\n" +
                        "EnterTheOption:\n");
                return new NormalUserMainMenuOptionsDelegator(user);
            case "librarian":
                console.display("1:ListBooks\n" +
                        "2:UserDetails\n" +
                        "3:CheckOutBooks\n" +
                        "4:ReturnOption\n" +
                        "5:ListMovies\n" +
                        "6:CheckOutMovie\n" +
                        "7:BookDetails\n" +
                        "8:logout\n" +
                        "\n" +
                        "EnterTheOption:\n");
                return new LibrarianMainMenuOptionsDelegator(user);
            default:
                console.display("1:ListBooks\n" +
                        "2:Quit\n" +
                        "3:Login\n" +
                        "4:ListMovies\n" +
                        "5:CheckOutMovie\n" +
                        "\nEnterTheOption:\n");
                return new DefaultMainMenuOptionsDelegator(authenticator, this);
        }
    }
}
