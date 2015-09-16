package com.twu.biblioteca;

public class User {
    private String libraryNumber;
    private String passWord;
    private String role;

    public User(String libraryNumber, String passWord, String role) {
        this.libraryNumber = libraryNumber;
        this.passWord = passWord;
        this.role = role;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        User thatUserCredentials = (User) that;
        return this.libraryNumber.equals(thatUserCredentials.libraryNumber) && this.passWord.equals(thatUserCredentials.passWord);

    }

    @Override
    public int hashCode() {
        int result = libraryNumber != null ? libraryNumber.hashCode() : 0;
        result = 31 * result + (passWord != null ? passWord.hashCode() : 0);
        return result;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "LibraryNumber='" + libraryNumber + '\'' +
                ", PassWord='" + passWord + '\'' +
                ", Role='" + role + '\'';
    }
}
