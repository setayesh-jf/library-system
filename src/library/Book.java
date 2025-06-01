package library;

import datastructures.queues.CustomQueue;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    // TODO: Define a data structure to hold members waiting for this book
    private CustomQueue<Member> waitlist; //

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;

        // TODO: Initialize your data structure here
        this.waitlist = new CustomQueue<>();
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public void addToWaitlist(Member member) {
        // TODO
        if (member == null) {
            throw new NullPointerException("Member cannot be null");
        }
        waitlist.add(member);
    }

    public Member getNextInWaitlist() {
        // TODO
        if (waitlist.isEmpty()) {
            return null;
        }
        return waitlist.poll();

    }

    public boolean hasWaitlist() {
        // TODO
        return !waitlist.isEmpty();

    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", available=" + isAvailable +
                '}';
    }
}