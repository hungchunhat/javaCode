package day13;

import java.util.*;

class Phone {
    private String _hangSX;
    private int _namSX;
    private String _ten;
    private double _gia;

    public Phone() {
    }

    public Phone(String _hangSX, int _namSX, String _ten, double _gia) {
        this._hangSX = _hangSX;
        this._namSX = _namSX;
        this._ten = _ten;
        this._gia = _gia;
    }

    public String get_hangSX() {
        return _hangSX;
    }

    public void set_hangSX(String _hangSX) {
        this._hangSX = _hangSX;
    }

    public int get_namSX() {
        return _namSX;
    }

    public void set_namSX(int _namSX) {
        this._namSX = _namSX;
    }

    public String get_ten() {
        return _ten;
    }

    public void set_ten(String _ten) {
        this._ten = _ten;
    }

    public double get_gia() {
        return _gia;
    }

    public void set_gia(double _gia) {
        this._gia = _gia;
    }

    @Override
    public String toString() {
        return "_hangSX= " + _hangSX +
                ", _namSX= " + _namSX +
                ", _ten= '" + _ten + '\'' +
                ", _gia= " + _gia +
                "\n";
    }
}

class Stock {
    List<Phone> phoneList = new ArrayList<>();

    public int getPhoneListSize() {
        return phoneList.size();
    }

    public void addPhone(String _hangSX, int _namSX, String _ten, double _gia) {
        phoneList.add(new Phone(_hangSX, _namSX, _ten, _gia));
    }

    public void addPhone(Phone p) {
        phoneList.add(p);
    }

    public void showPhoneList() {
        System.out.println("Danh sách điện thoại: ");
        for (int i = 0; i < phoneList.size(); i++) {
            System.out.print("Phone " + (i + 1) + ":" + phoneList.get(i));
        }
    }

    public void showPhoneListInYear() {
        Set<Integer> years = new HashSet<>();
        System.out.println("Năm sản xuất của tất cả điện thoại là");
        for (Phone p : phoneList) {
            years.add(p.get_namSX());
        }
        for (int year : years) {
            System.out.println(year);
        }
    }


    public void showPhoneList(int _namSX1, int _namSX2) {
        for (Phone p : phoneList) {
            if (p.get_namSX() >= _namSX1 && p.get_namSX() <= _namSX2) {
                System.out.println(p);
            }
        }
    }

    public void showPhoneList(String _hangSX) {
        for (Phone p : phoneList) {
            if (p.get_hangSX().equals(_hangSX)) {
                System.out.println(p);
            }
        }
    }

    public void removeInBrand(String _hangSX) {
        for (Phone p : phoneList) {
            if (p.get_hangSX().equals(_hangSX)) {
                phoneList.remove(p);
            }
        }
    }

    public void sortBy_gia() {//8
        phoneList.sort(Comparator.comparing(Phone::get_gia));
    }

    public void showRandom_namSX(int index) {
        System.out.println(phoneList.get(index).get_ten() + " sản xuất năm: " + phoneList.get(index).get_namSX());
    }

    public void fixIn4(int index, String _hangSX, int _namSX, String _ten, double _gia) {
        phoneList.get(index - 1).set_hangSX(_hangSX);
        phoneList.get(index - 1).set_namSX(_namSX);
        phoneList.get(index - 1).set_ten(_ten);
        phoneList.get(index - 1).set_gia(_gia);
    }

    public void getTop3Price() {
        sortBy_gia();
        System.out.println("Top3 ĐT đắt nhất là:");
        for (int i = 0; i < 3; i++) {
            System.out.println(phoneList.get(i));
        }
    }

    public void showBy_ten() {
        for (Phone p : phoneList) {
            if (p.get_ten().equals("IP12")) {
                System.out.println(p);
            }
        }
    }
}

public class TestPhone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Phone phone1 = new Phone("Iphone", 2004, "16 Pro Max", 2000000);
        Phone phone2 = new Phone("Iphone", 2004, "15 Pro", 3000000);
        Phone phone3 = new Phone("Samsung", 2002, "S20", 2500000);
        Phone phone4 = new Phone("Samsung", 2003, "A18", 2600000);
        Phone phone5 = new Phone("Xiaomi", 2004, "Mi8", 4000000);
        Phone phone6 = new Phone("Iphone", 2004, "IP12", 1500000);
        Stock stock1 = new Stock();
        stock1.addPhone(phone1);
        stock1.addPhone(phone2);
        stock1.addPhone(phone3);
        stock1.addPhone(phone4);
        stock1.addPhone(phone5);
        stock1.addPhone(phone6);
        boolean running = true;
        while (running) {
            Menu();
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Bạn muốn nhập dữ liệu cho bao nhiêu ĐT:");
                    int quantity = scanner.nextInt();
                    for (int i = 0; i < quantity; i++) {
                        System.out.println("----->Sản phẩm " + (i + 1) + ":");
                        System.out.print("Nhập hãng SX: ");
                        String _hangSX = scanner.nextLine();
                        System.out.print("Nhập năm SX: ");
                        int _namSX = scanner.nextInt();
                        System.out.print("Nhập tên ĐT: ");
                        String _ten = scanner.nextLine();
                        System.out.print("Nhập giá của sp: ");
                        double _gia = scanner.nextDouble();
                        stock1.addPhone(_hangSX, _namSX, _ten, _gia);
                    }
                    break;
                case 2:
                    System.out.println("Danh sách tất cả điện thoại trong kho:");
                    stock1.showPhoneList();
                    break;
                case 3:
                    stock1.showPhoneListInYear();
                    break;
                case 4:
                    System.out.print("Chọn một mốc từ gian cụ thể (xxxx - xxxx):");
                    int _namSX1 = scanner.nextInt();
                    int _namSX2 = scanner.nextInt();
                    System.out.println("Từ năm " + _namSX1 + " đến " + _namSX2 + " có những sản phẩm sau:");
                    stock1.showPhoneList(_namSX1, _namSX2);
                    break;
                case 5:
                    System.out.print("Bạn muốn tìm điện thoại của hãng nào: ");
                    scanner.nextLine();
                    String _hangSX = scanner.nextLine();
                    stock1.showPhoneList(_hangSX);
                    break;
                case 6:
                    System.out.print("Bạn muốn xoá điện thoại của hãng nào: ");
                    scanner.nextLine();
                    String _hangSX1 = scanner.nextLine();
                    stock1.removeInBrand(_hangSX1);
                    break;
                case 7:
                    stock1.sortBy_gia();
                    stock1.showPhoneList();
                    break;
                case 8:
                    int random = (int) (Math.random() * stock1.getPhoneListSize());
                    stock1.showRandom_namSX(random);
                    break;
                case 9:
                    stock1.showPhoneList();
                    System.out.print("Bạn muốn sử thông tin của điện thoại nào: ");
                    int index = scanner.nextInt();
                    System.out.print("Nhập hãng SX: ");
                    String _hangSX2 = scanner.nextLine();
                    System.out.print("Nhập năm SX: ");
                    int _namSX = scanner.nextInt();
                    System.out.print("Nhập tên ĐT: ");
                    String _ten = scanner.nextLine();
                    System.out.print("Nhập giá của sp: ");
                    double _gia = scanner.nextDouble();
                    stock1.fixIn4(index, _hangSX2, _namSX, _ten, _gia);
                    break;
                case 10:
                    stock1.getTop3Price();
                    break;
                case 11:
                    stock1.showBy_ten();
                    break;
                case 0:
                    System.out.println("KẾT THÚC CHƯƠNG TRÌNH");
                    running = false;
                    break;
                default:
                    System.out.println("Bạn bị ngáo à???");
            }
        }
    }

    public static void Menu() {
        System.out.println("==============MENU==============");
        System.out.println("1. Nhập danh sách điện thoại");
        System.out.println("2. Xuất danh sách điện thoại");
        System.out.println("3. In ra năm SX của tất cả ĐT");
        System.out.println("4. In ra ĐT trong khoảng năm");
        System.out.println("5. Tìm ĐT theo hãng");
        System.out.println("6. Xoá ĐT theo hãng");
        System.out.println("7. Sắp xếp ĐT theo giá");
        System.out.println("8. In ra năm của ĐT ở vị trí bất kỳ");
        System.out.println("9. Sửa thông tin ĐT");
        System.out.println("10. In ra top3 theo giá");
        System.out.println("11. In ra điện thoại có tên IP12");
        System.out.println("0. Kết thúc");
    }
}
