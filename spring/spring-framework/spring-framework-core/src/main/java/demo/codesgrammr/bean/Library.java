package demo.codesgrammr.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

    private String name;

    private List<Book> books = new ArrayList<>();

    private Map<String, Boolean> checkList = new HashMap<>();

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public Map<String, Boolean> getCheckList() {
        return checkList;
    }

    public void setCheckList(Map<String, Boolean> checkList) {
        this.checkList = checkList;
    }

    public void addCheckList(String key, Boolean checked) {
        this.checkList.put(key, checked);
    }
}
