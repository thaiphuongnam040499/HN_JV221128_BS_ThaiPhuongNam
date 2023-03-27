package ra.bussiness;

import ra.bussinessImp.Book;

import java.util.List;
import java.util.Scanner;

public interface IBook {
    void inputData(List<Book> listBook, Scanner scanner);
    void displayData();

}
