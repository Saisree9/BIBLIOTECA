package com.twu.biblioteca;

public class LoginOption implements MainMenuOption {
    private Console console;
    private Library library;
    private Authenticator authenticator;
    private User user;
    private MovieStore movieStore;

    public LoginOption(Console console, Library library, MovieStore movieStore, Authenticator authenticator) {
        this.console = console;
        this.library = library;
        this.movieStore = movieStore;
        this.authenticator = authenticator;
    }

    @Override
    public void doOperation() {
        user = authenticateUserDetails();
        MainMenuOptionDelegator mainMenuOptionDelegator = getMainMenuOptionDelegator();
    }

    private MainMenuOptionDelegator getMainMenuOptionDelegator() {
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
            default:
                console.display("Option1:ListBooks\n" +
                        "Option2:Quit\n" +
                        "Option4:ListMovies\n" +
                        "Option5:CheckOutMovie\n" +
                        "\nEnterTheOption:");
                return new DefaultMainMenuOptionsDelegator(authenticator);
        }
    }


    public User authenticateUserDetails() {
        String libraryNumber = console.getUserInput();
        String passWord = console.getUserInput();
        return authenticator.authenticate(libraryNumber, passWord);
    }
}