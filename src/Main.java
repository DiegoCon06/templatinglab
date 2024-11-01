import java.util.ArrayList;
import java.util.Scanner;

interface Ingredient {
    String getName();
    double getQuantity();
}


class SolidIngredient implements Ingredient{
    private String _name;
    private double _quantity;
    public SolidIngredient(String n, double q){
        _name = n;
        _quantity = q;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public double getQuantity() {
        return 0;
    }

    public String toString() {
        String s = "" + _name + " ";
        return s;
    }
}

class LiquidIngredient implements Ingredient{
    private String _name;
    private double _quantity;
    public LiquidIngredient(String n, int q){
        _name = n;
        _quantity = q;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public double getQuantity() {
        return _quantity;
    }

    public String toString() {
        String s = "" + _name + " ";
        return s;
    }
}

class Recipe<T extends Ingredient>{
    private String _name;
    private String _instructions;
    private ArrayList<T> _setOfIngredients;
    public Recipe(String n, String i){
        _name = n;
        _instructions = i;
        _setOfIngredients = new ArrayList<>();
    }

    public void addIngredient(T t){
        _setOfIngredients.add(t);
    }

    public void print() {
        if (_setOfIngredients != null)
            System.out.println("Name: " + _name + "\nInstructions: " + _instructions + "\nSet of Ingredients: " + _setOfIngredients.get(0));
        else
            System.out.println("null member variable");
    }
}


public class Main {

    public static void addIngredientFunction(Scanner keyboardInput, Recipe<Ingredient> recipe) {
        System.out.print("Solid (1) or Liquid (2)?: ");
        String type = keyboardInput.next();
        keyboardInput.nextLine(); //Dummy read
        System.out.println();
        System.out.print("Enter ingredient name: ");
        String ingName = keyboardInput.next();
        System.out.println();
        System.out.print("Enter quantity: ");
        double ingQuant = keyboardInput.nextDouble();
        switch (type) {
            case "1" -> {
                SolidIngredient so = new SolidIngredient(ingName, ingQuant);
                recipe.addIngredient(so);
            }
            case "2" -> {
                LiquidIngredient ro = new LiquidIngredient(ingName, ingQuant);
                recipe.addIngredient(ro);

            }
            default -> {
                System.out.println("*ERROR: ILLEGAL TYPE*");
                System.out.println();
                addIngredientFunction(keyboardInput, recipe);
            }
        }
    }


    public static void listIngredientsFunction(Scanner keyboardInput, Recipe<Ingredient> recipe) {
        System.out.print("Recipe Name: ");
        String type = keyboardInput.next();
        keyboardInput.nextLine(); //Dummy read
        System.out.println();
        System.out.print("Enter ingredient name: ");
        String ingName = keyboardInput.next();
        System.out.println();
        System.out.print("Enter quantity: ");
        double ingQuant = keyboardInput.nextDouble();
        switch (type) {
            case "1" -> {
                SolidIngredient so = new SolidIngredient(ingName, ingQuant);
                recipe.addIngredient(so);
            }
            case "2" -> {
                LiquidIngredient ro = new LiquidIngredient(ingName, ingQuant);
                recipe.addIngredient(ro);

            }
            default -> {
                System.out.println("*ERROR: ILLEGAL TYPE*");
                System.out.println();
                addIngredientFunction(keyboardInput, recipe);
            }
        }
    }




    public static void main(String[] args) {
        Scanner keyboardInput = new Scanner(System.in);
        Recipe<Ingredient> a = new Recipe<>("Apple Slices", "Cut into slices");
        SolidIngredient ap = new SolidIngredient("Apple", 2.0);
        a.addIngredient(ap);
        Recipe<Ingredient> p = new Recipe<>("Pumpkin Pie", "Bake");

        System.out.println("Recipe Program\nAvailable Commands:\n1 - Add Ingredient\n2 - List Ingredients\n0 - Exit");
        System.out.print("Enter Command: ");
        String userCommand = keyboardInput.next();
        System.out.println();
        while (!userCommand.equals("0")) {
            switch (userCommand) {
                case "1" -> {
                    addIngredientFunction(keyboardInput, p);
                }
                case "2" -> {
                    listIngredientsFunction(keyboardInput, p)
                }
                default -> { System.out.println("*ERROR: INVALID COMMAND*"); }
            }
            System.out.println("\nAvailable Commands:\n1 - Display Employee Payroll Information by Type\n0 - Exit Program\n");
            System.out.print("Enter Command: ");
            userCommand = keyboardInput.next();
            System.out.println();
        }
        System.out.println("*PROGRAM TERMINATED*");

        Recipe<Ingredient>a = new Recipe<Ingredient>("Apple Slices", "Cut apple into slices");
        SolidIngredient ar = new SolidIngredient("Apple", 2.0);
        a.addIngredient(ar);
        a.print();
    }
}