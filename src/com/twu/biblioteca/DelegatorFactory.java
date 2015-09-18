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
                console.display("Option1:ListBooks\n" +
                        "Option2:UserDetails\n" +
                        "Option3:CheckOutBooks\n" +
                        "Option4:ReturnOption\n" +
                        "Option5:ListMovies\n" +
                        "Option6:CheckOutMovie\n" +
                        "Option7:logout\n" +
                        "\n" +
                        "EnterTheOption:");
                return new UserMainMenuOptionsDelegator(user);
            case "librarian":
                console.display("Option1:ListBooks\n" +
                        "Option2:UserDetails\n" +
                        "Option3:CheckOutBooks\n" +
                        "Option4:ReturnOption\n" +
                        "Option5:ListMovies\n" +
                        "Option6:CheckOutMovie\n" +
                        "Option7:logout\n" +
                        "Option8:BookDetails\n" +
                        "\n" +
                        "EnterTheOption:");
                return new LibrarianMainMenuOptionsDelegator(user);
            default:
                console.display("Option1:ListBooks\n" +
                        "Option2:Quit\n" +
                        "Option4:ListMovies\n" +
                        "Option5:CheckOutMovie\n" +
                        "\nEnterTheOption:");
                return new DefaultMainMenuOptionsDelegator(authenticator);
        }
    }
}
