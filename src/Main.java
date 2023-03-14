import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int auto_Generated;
    static Boolean isExistId = false;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<DataFactorization> list = new ArrayList<>();

        list.add(new DataFactorization(1, "Suzan"));
        list.add(new DataFactorization(2, "Mahmoud"));
        list.add(new DataFactorization(3, "Mohamed"));

        while (true) {
            Choice();
            String choose = scanner.next();
            switch (choose) {
                case "1" -> changeName(list);
                case "2" -> getExistName(list);
                case "3" -> insertName(list);
            }
        }
    }

    static void Choice() {
        System.out.println("""
                1-Add a new name to an exist id
                2-Get an existence name
                3-Add new name with auto_generated id""");
    }

    static int auto_Generated(ArrayList<DataFactorization> list) {
        auto_Generated++;
        for (DataFactorization dataFactorization : list) {
            if (auto_Generated != dataFactorization.id) {
                return auto_Generated;
            } else {
                auto_Generated++;
            }
        }
        return auto_Generated;
    }

    static void unExistsId(Boolean isUnExist) {
        if (!isUnExist) {
            System.out.println("id is not exist");
        }
        isExistId = false;
        System.out.println("------------------------------------------");

    }

    static void changeName(ArrayList<DataFactorization> list) {
        System.out.println("Enter the name");
        String new_name = scanner.next();
        System.out.println("Enter id");
        int new_id = scanner.nextInt();

        for (DataFactorization dataFactorization : list) {
            if (new_id == dataFactorization.getId()) {
                dataFactorization.name = new_name;
                System.out.print("This id existed and now name is changed ");
                dataFactorization.print(dataFactorization.name);
                isExistId = true;
            }
        }
        unExistsId(isExistId);
    }

    static void getExistName(ArrayList<DataFactorization> list) {
        System.out.println("Enter the id you want to get his name :");
        int unknown_id;

        unknown_id = scanner.nextInt();
        for (DataFactorization dataFactorization : list) {
            if (dataFactorization.getId() == unknown_id) {
                dataFactorization.print(dataFactorization.name);
                isExistId = true;
            }
        }
        unExistsId(isExistId);
    }

    static void insertName(ArrayList<DataFactorization> list) {
        System.out.println("Add new name , Enter the name : ");
        String name = scanner.next();
        int id = auto_Generated(list);
        DataFactorization newObj = new DataFactorization(id, name);
        list.add(newObj);
        newObj.print(name);
        System.out.println("------------------------------------------");
    }
}
