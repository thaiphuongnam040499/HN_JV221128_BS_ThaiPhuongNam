package ra.bussinessImp;

import ra.bussiness.IBook;

import java.util.List;
import java.util.Scanner;

public class Book implements IBook,Comparable<Book> {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private Boolean bookStatus;

    public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float exportPrice, float interest, Boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public Book() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public Boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData(List<Book> listBook, Scanner scanner) {
        System.out.println("nhập tên sách:");
        bookName = scanner.nextLine();
        System.out.println("nhập title:");
        title = scanner.nextLine();
        System.out.println("Nhập số trang sách");
        numberOfPages = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập giá nhập sách:");
        importPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập giá bán sách:");
        exportPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập trạng thái:");
        bookStatus = Boolean.parseBoolean(scanner.nextLine());
        interest = exportPrice - importPrice;
    }

    @Override
    public void displayData() {
        System.out.println("----------------------------------------------------------");
        System.out.printf("mã sách: %d\n", bookId);
        System.out.printf("tên sách: %s\n", bookName);
        System.out.printf("title: %s\n", title);
        System.out.printf("số trang sách: %d\n", numberOfPages);
        System.out.printf("giá nhập: %s\n", importPrice);
        System.out.printf("giá bán: %s\n", exportPrice);
        System.out.printf("lợi nhuận: %s\n", interest);
        System.out.printf("trạng thái sách: %s\n", bookStatus ? "bán" : "không bán");
        System.out.println("----------------------------------------------------------");
    }


    @Override
    public int compareTo(Book o) {
        return (int) (o.interest - this.interest);
    }
}
