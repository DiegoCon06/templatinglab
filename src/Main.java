import java.util.ArrayList;

interface Ingredient {
    String getName();
    int getQuantity();
}


class SolidIngredient implements Ingredient{
    private String _name;
    private int _quantity;
    public SolidIngredient(String n, int q){
        _name = n;
        _quantity = q;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public int getQuantity() {
        return 0;
    }

    public String toString() {
        String s = "" + _name + " ";
        return s;
    }
}

class LiquidIngredient implements Ingredient{
    private String _name;
    private int _quantity;
    public LiquidIngredient(String n, int q){
        _name = n;
        _quantity = q;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public int getQuantity() {
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
    public Recipe(String n, String i, ArrayList<T> s){
        _name = n;
        _instructions = i;
        _setOfIngredients = s;
    }

    public void addItem(T t){
        _thing.add(t);
    }
    public T removeItem(int idx){
        return _thing.remove(idx);
    }

    public boolean findItem(T item){
        boolean found = false;
        int i = 0;
        while(i < _thing.size() && !found){
            if (_thing.get(i).equals(item))
                found = true;
            i++;
        }
        return found;
    }

    public void printItems(){

    }
    //public T getThing() {return _thing;}
    //public void setThing(T t){_thing = t;}
    public void print() {
        if (_thing != null)
            System.out.println("Type: " + _thing.getClass().getName() +
                    ", value: " + _thing);
        else
            System.out.println("null member variable");
    }
}




public class Main {
    public static void main(String[] args) {
    }
}