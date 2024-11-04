import java.util.*;

interface Ingredient {
    String getName();

    double getQuantity();
}


class SolidIngredient implements Ingredient {
    private String _name;
    private double _quantity;

    public SolidIngredient(String n, double q) {
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
}

class LiquidIngredient implements Ingredient {
    private String _name;
    private double _quantity;

    public LiquidIngredient(String n, double q) {
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
}

class Recipe<T extends Ingredient> {
    private String _name;
    private String _instructions;
    private ArrayList<T> _setOfIngredients;

    public Recipe(String n, String i) {
        _name = n;
        _instructions = i;
        _setOfIngredients = new ArrayList<>();
    }

    public void addIngredient(T t) {
        _setOfIngredients.add(t);
    }

    public ArrayList<T> getSetOfIngredients() {
        return _setOfIngredients;
    }

    public String getName() {
        return _name;
    }

    public String print() {
        String out;
        if (_setOfIngredients != null)
            out = "Name: " + _name + "\nInstructions: " + _instructions + "\nSet of Ingredients: " + _setOfIngredients.get(0);
        else
            out = "null member variable";
        return out;
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
        System.out.println(recipe.getName() + " Ingredient List:");
        for (Ingredient ing : recipe.getSetOfIngredients()) {
            System.out.println(ing.getName() + " (" + ing.getQuantity() + ")");
        }
    }


    public static void main(String[] args) {
        Scanner keyboardInput = new Scanner(System.in);
        Recipe<Ingredient> a = new Recipe<>("Caramel Apple Slices", "Cut into slices");
        SolidIngredient ap = new SolidIngredient("Apple", 2.0);
        a.addIngredient(ap);
        Recipe<Ingredient> p = new Recipe<>("Pumpkin Pie", "Bake");

        System.out.println("Recipe Program\nAvailable Commands:\n1 - Add Ingredient\n2 - List Ingredients\n0 - Exit\n");
        System.out.print("Enter Command: ");
        String userCommand = keyboardInput.next();
        System.out.println();
        while (!userCommand.equals("0")) {
            switch (userCommand) {
                case "1" -> {
                    addIngredientFunction(keyboardInput, a);
                }
                case "2" -> {
                    listIngredientsFunction(keyboardInput, a);
                }
                default -> {
                    System.out.println("*ERROR: INVALID COMMAND*");
                }
            }
            System.out.println("\nAvailable Commands:\n1 - Add Ingredient\n2 - List Ingredients\n0 - Exit\n");
            System.out.print("Enter Command: ");
            userCommand = keyboardInput.next();
            System.out.println();
        }
        System.out.println("*PROGRAM TERMINATED*");
    }
}