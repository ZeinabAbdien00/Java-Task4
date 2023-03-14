public class DataFactorization extends Print {

    public final int id;
    String name;

    @Override
    void print(String name) {
        System.out.print("Name : " + name + " , ");
        System.out.println("Id : " + id);
        printLine();
    }


    public DataFactorization(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

}