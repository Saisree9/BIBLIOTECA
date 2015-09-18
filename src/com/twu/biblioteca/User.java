package com.twu.biblioteca;

public class User {
    private String libraryNumber;
    private String passWord;
    private String role;
    private String name;
    private String emailID;
    private String mobileNumber;

    public User(String libraryNumber, String passWord, String role, String name, String emailID, String mobileNumber) {
        this.libraryNumber = libraryNumber;
        this.passWord = passWord;
        this.role = role;
        this.name = name;
        this.emailID = emailID;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        User thatUser = (User) that;
        if ((this.hasValidLibraryNumber() && this.libraryNumber.equals(thatUser.libraryNumber)) && this.passWord.equals(thatUser.passWord))
            return true;

        return false;
    }

    @Override
    public int hashCode() {
        int result = libraryNumber != null ? libraryNumber.hashCode() : 0;
        result = 31 * result + (passWord != null ? passWord.hashCode() : 0);
        return result;
    }

    public boolean hasValidLibraryNumber() {
        return libraryNumber.length() == 8 && libraryNumber.charAt(3) == '-';
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "libraryNumber='" + libraryNumber + '\'' +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", emailID='" + emailID + '\'' +
                ", mobileNumber='" + mobileNumber + '\''+"\n";
    }
}
