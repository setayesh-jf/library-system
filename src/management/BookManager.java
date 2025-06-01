package management;

import datastructures.interfaces.Map;
import datastructures.maps.CustomHashMap;
import library.Book;
import library.Member;

public class BookManager {
    private Map<String, Book> bookMap;
    private MemberManager memberManager;

    public BookManager(MemberManager memberManager) {
        this.bookMap = new CustomHashMap<>();
        this.memberManager = memberManager;
    }

    public void addBook(Book book) {
        if (book == null) {
            throw new NullPointerException("Book cannot be null");
        }
        bookMap.put(book.getIsbn(), book);
    }

    public Book getBookByIsbn(String isbn) {
        return bookMap.get(isbn);
    }

    public boolean isBookAvailable(String isbn) {
        Book book = getBookByIsbn(isbn);
        return book != null && book.isAvailable();
    }

    public void setBookAvailability(String isbn, boolean available) {
        Book book = getBookByIsbn(isbn);
        if (book != null) {
            book.setAvailable(available);
        }
    }

    public void addToWaitlist(String isbn, String memberId) {
        Book book = getBookByIsbn(isbn);
        Member member = memberManager.getMember(memberId);

        if (book != null && member != null) {
            book.addToWaitlist(member);
        }
    }

    public Member getNextFromWaitlist(String isbn) {
        Book book = getBookByIsbn(isbn);
        return book != null ? book.getNextInWaitlist() : null;
    }

    public boolean hasWaitlist(String isbn) {
        Book book = getBookByIsbn(isbn);
        return book != null && book.hasWaitlist();
    }
}