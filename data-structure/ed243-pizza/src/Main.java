import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Ingredients that Mario do not like
        int numberOfIngredientsMario = sc.nextInt();
        int[] ingredientsMario = new int[numberOfIngredientsMario];
        for (int i = 0; i < numberOfIngredientsMario; i++) {
            ingredientsMario[i] = sc.nextInt();
        }

        //Pizzas and ingredients
        int numberOfPizzas = sc.nextInt();
        int[][] pizzas = new int[numberOfPizzas][];
        for (int i = 0; i < numberOfPizzas; i++) {
            int numberOfIngredients = sc.nextInt();
            int[] ingredients = new int[numberOfIngredients];
            for (int j = 0; j < numberOfIngredients; j++) {
                ingredients[j] = sc.nextInt();
            }
            pizzas[i] = ingredients;
        }
        int result = marioCanEat(ingredientsMario, pizzas);
        System.out.println(result);
    }

    public static int marioCanEat(int[] ingredientsMario, int[][] pizzas) {
        int sum = 0;
        int[] placeHolders = new int[pizzas.length];
        for (int i = 0; i < ingredientsMario.length; i++) {
            for (int j = 0; j < pizzas.length; j++) {
                for(int z = 0; z <pizzas[j].length; z++){
                    if (ingredientsMario[i] == pizzas[j][z]){
                        if(placeHolders[j]==0){
                            sum+=1;
                            placeHolders[j] = 1;
                        }
                        break;
                    }
                }
            }
        }
        return pizzas.length-sum;
    }

}
