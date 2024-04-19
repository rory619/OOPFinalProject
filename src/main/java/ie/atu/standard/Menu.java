package ie.atu.standard;
import java.sql.SQLException;
import java.util.Scanner;
public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {//while 1
            while (true) {
                System.out.println("Online Car store\n Press 1 for car table\n Press 2 for customer table \n Press 3 for payment table\n Press 4 for store table\n1. Car\n2. Customer\n3. Payment\n4. Store\n0. Exit");
                int decision = scanner.nextInt();
                if (decision == 0) {
                    break;
                }
                DatabaseOperations table;
                switch (decision) {
                    case 1:
                        table = new Car();
                        break;
                    case 2:
                        table = new Customer();
                        break;
                    case 3:
                        table = new Payment();
                        break;
                    case 4:
                        table = new Store();
                        break;
                    default:
                        System.out.println("Error Incorrect input");
                        continue;
                }

                System.out.println("Select Operation:\n1. Read\n2. Create\n3. Update\n4. Delete");
                int operation = scanner.nextInt();



                switch (operation) {
                    case 1:
                        table.select();
                        break;
                    case 2:
                        table.insert();
                        break;
                    case 3:
                        table.update();
                        break;
                    case 4:
                        table.delete();
                        break;
                     default:
                        System.out.println("Wrong number");
                        break;
                }
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            scanner.close();
        }
    }
}
