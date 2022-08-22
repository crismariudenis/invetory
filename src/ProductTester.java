import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductTester {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int maxSize, menuChoice;

        maxSize = getNumProducts(in);
        if (maxSize == 0) {
            System.out.println("No products required!");
        } else {
            Product[] products = new Product[maxSize];
            addToInventory(products, in);
            do {
                menuChoice = getMenuOption(in);
                executeMenuChoice(menuChoice, products, in);
            } while (menuChoice != 0);
        }
    }

    private static void executeMenuChoice(int menuChoice, Product[] products, Scanner in) {
        switch (menuChoice) {
            case 1 -> displayInventory(products);
            case 2 -> addInventory(products, in);
            case 3 -> deductInventor(products, in);
            case 4 -> discontinueInventory(products, in);
        }
    }

    private static void discontinueInventory(Product[] products, Scanner in) {
        int productChoice = getProductNumber(products, in);
        products[productChoice].setActive(false);
    }

    private static void oldAddInventory(Product[] products, Scanner in) {
        int productChoice = getProductNumber(products, in);
        int updateValue = -1;
        System.out.println("How many products do you want to add?");
        while (true) {
            try {
                updateValue = in.nextInt();
                if (updateValue >= 0)
                    break;
                else
                    System.out.println("Incorrect Value entered");
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data type entered!");
                in.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                in.nextLine();
            }
        }
        products[productChoice].addToInventory(updateValue);

    }

    private static void addInventory(Product[] products, Scanner in) {
        int stockChoice = -1;
        int productChoice = getProductNumber(products, in);
        System.out.println("""
                    1: CD
                    2: DVD
                    Please enter the product type: """);
        while (true) {
            try {
                stockChoice = in.nextInt();
                if (stockChoice >= 1 && stockChoice <= 2)
                    break;
                else
                    System.out.println("Only numbers 1 or 2 allowed!");
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data type entered!");
                in.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                in.nextLine();
            }
        }
        switch (stockChoice) {
            case 1 -> addCDToInventory(products, in, productChoice);
            case 2 -> addDVDToInventory(products, in, productChoice);
        }

    }
    private static void deductInventor(Product[] products, Scanner in) {
        int productChoice = getProductNumber(products, in);
        int updateValue = 1;
        System.out.println("How many products do you want to deduct?");
        while (true) {
            try {
                updateValue = in.nextInt();
                if (updateValue >= 0)
                    break;
                else
                    System.out.println("Incorrect Value entered");
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data type entered!");
                in.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                in.nextLine();
            }

        }
        products[productChoice].deductFromInventory(updateValue);

    }

    private static int getMenuOption(Scanner in) {
        int ans = -1;
        while (true) {
            try {
                System.out.print("""
                        1. View Inventory
                        2. Add Stock
                        3. Deduct Stock
                        4. Discontinue Product
                        0. Exit
                        Please enter a menu option:\s""");

                ans = in.nextInt();
                if (ans == 0)
                    return 0;

                else if (ans < 0 || ans > 4)
                    System.out.println("Incorrect Value entered");
                else
                    break;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data type entered!");
                in.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                in.nextLine();
            }
        }
        return ans;
    }

    private static int getProductNumber(Product[] products, Scanner in) {
        int productChoice = -1;

        for (int i = 0; i < products.length; i++) {
            System.out.println("Product name: " + products[i].getName() + " Index value: " + i);
        }
        while (true) {
            try {
                System.out.print("Choose the id of the product: ");
                productChoice = in.nextInt();
                if (productChoice >= 0 && productChoice < products.length) {
                    return productChoice;
                } else
                    System.out.println("Incorrect Value entered");

            } catch (InputMismatchException e) {
                System.out.println("Incorrect data type entered!");
                in.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                in.nextLine();
            }

        }
    }

    private static void displayInventory(Product[] products) {
        System.out.println();
        for (Product product : products)
            System.out.println(product.toString() + "\n");
    }

    private static void addToInventory(Product[] products, Scanner in) {
        String tempName;
        int tempQty, tempNumber;
        double tempPrice;
        for (int i = 0; i < products.length; i++) {
            System.out.print("Please enter the name: ");
            tempName = in.next();
            System.out.print("Please enter the quantity of stock for this product: ");
            tempQty = in.nextInt();
            System.out.print("Please enter the price for this product: ");
            tempPrice = in.nextDouble();
            System.out.print("Please enter the item number: ");
            tempNumber = in.nextInt();
            in.nextLine();
            products[i] = new Product(tempNumber, tempName, tempQty, tempPrice);
        }
    }

    private static void addCDToInventory(Product[] products, Scanner in, int i) {
        String tempName, tempLabel, tempArtist;
        int tempQty, tempNumber, tempNrSongs;
        double tempPrice;
        System.out.print("Please enter the CD name: ");
        tempName = in.next();
        System.out.print("Please enter the artist name: ");
        tempArtist = in.next();
        System.out.print("Please enter the record label name: ");
        tempLabel = in.next();
        System.out.print("Please enter the number of songs: ");
        tempNrSongs = in.nextInt();
        System.out.print("Please enter the quantity of stock for this product: ");
        tempQty = in.nextInt();
        System.out.print("Please enter the price for this product: ");
        tempPrice = in.nextDouble();
        System.out.print("Please enter the item number: ");
        tempNumber = in.nextInt();
        in.nextLine();
        products[i] = new CD(tempNumber, tempName, tempQty, tempPrice, tempArtist, tempNrSongs, tempLabel);
    }

    private static void addDVDToInventory(Product[] products, Scanner in, int i) {
        String tempName, tempStudio;
        int tempQty, tempNumber, tempLength, tempAgeRating;
        double tempPrice;
        System.out.print("Please enter the DVD name: ");
        tempName = in.next();
        System.out.print("Please enter the film studio name: ");
        tempStudio = in.next();
        System.out.print("Please enter the age rating: ");
        tempAgeRating = in.nextInt();
        System.out.print("Please enter the length in minutes: ");
        tempLength = in.nextInt();
        System.out.print("Please enter the quantity of stock for this product: ");
        tempQty = in.nextInt();
        System.out.print("Please enter the price for this product: ");
        tempPrice = in.nextDouble();
        System.out.print("Please enter the item number: ");
        tempNumber = in.nextInt();
        in.nextLine();
        products[i] = new DVD(tempNumber, tempName, tempQty, tempPrice, tempLength, tempAgeRating, tempStudio);
    }

    private static int getNumProducts(Scanner in) {
        int maxSize = 0;
        do {
            try {
                System.out.print("Enter the number of products you would like to add\n" +
                        "Enter 0 (zero) if you do not wish to add products: ");
                maxSize = in.nextInt();
                if (maxSize > 0)
                    break;
                else if (maxSize < 0)
                    System.out.println("Incorrect Value entered");
                else
                    break;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data type entered!");
                in.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                in.nextLine();
            }
        } while (true);
        return maxSize;
    }


}
