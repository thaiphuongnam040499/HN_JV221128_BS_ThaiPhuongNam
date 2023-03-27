package ra.run;

import ra.bussinessImp.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookManagement {

    public static void main(String[] args) {
        List<Book> listBook = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("1. Nhập số sách và nhập thông tin sách");
            System.out.println("2. Hiển thị thông tin các sách");
            System.out.println("3. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm sách theo tên sách");
            System.out.println("6. Thay đổi trạng thái của sách theo mã sách");
            System.out.println("7. Thoát ");
            System.out.println("Nhập lựa chọn của bạn:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    creatBooks(listBook, scanner);
                    break;
                case 2:
                    displayBook(listBook);
                    break;
                case 3:
                    sortByInterest(listBook);
                    break;
                case 4:
                    deleteBookById(listBook, scanner);
                    break;
                case 5:
                    searchBookByName(listBook, scanner);
                    break;
                case 6:
                    changeBookStatus(listBook, scanner);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (choice != 7);
    }

    public static void creatBooks(List<Book> list, Scanner scanner) {
        System.out.println("Nhập số lượng sách:");
        int count = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập sách thứ " + (i + 1));
            Book book = new Book();
            book.inputData(list, scanner);
            if (list.size() == 0) {
                book.setBookId(1);
            } else {
                int newBookId = list.get(list.size() - 1).getBookId() + 1;
                book.setBookId(newBookId);
            }
            list.add(book);
        }
        System.out.println("thêm thành công:");
    }

    public static void displayBook(List<Book> list) {
        for (Book book : list) {
            book.displayData();
        }
    }

    public static void sortByInterest(List<Book> list) {
        Collections.sort(list);
        displayBook(list);
    }

    public static void deleteBookById(List<Book> list, Scanner scanner) {
        Boolean check = false;
        System.out.println("Nhập vào id muốn xóa:");
        int idDel = scanner.nextInt();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getBookId() == idDel) {
                check = true;
                list.remove(list.get(i));
            }
        }
        if (!check) {
            System.out.println("không tìm thấy id nhập vào");
        } else {
            System.out.println("xóa thành công");
        }
    }

    public static void searchBookByName(List<Book> list, Scanner scanner) {
        scanner.nextLine();
        System.out.println("nhập vào tên sách muốn tìm kiếm");
        String searchName = scanner.nextLine();
        List<Book> listBookSearch = new ArrayList<>();
        for (Book book : list) {
            if (book.getBookName().contains(searchName)) {
                listBookSearch.add(book);
            }
        }
        System.out.println("Sách bạn tìm kiếm là:");
        displayBook(listBookSearch);
    }

    public static void changeBookStatus(List<Book> list, Scanner scanner) {
        Boolean check = false;
        System.out.println("nhập vào id muốn thay đổi trạng thái sách:");
        int id = scanner.nextInt();
        for (Book book : list) {
            if (book.getBookId() == id) {
                book.setBookStatus(!book.getBookStatus());
                check = true;
            }
        }
        if (!check) {
            System.out.println("không tìm thấy id nhập vào");
        } else {
            System.out.println("thay đổi thành công!");
        }
    }
}

