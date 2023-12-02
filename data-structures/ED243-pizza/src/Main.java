import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ingredientsMario = sc.nextInt();
        int[] ingredientesMarioArray = new int[ingredientsMario];

        //Fill the array with ingredients that Mario do not like
        for (int i = 0; i < ingredientsMario; i++) {
            ingredientesMarioArray[i] = sc.nextInt();
        }
        int count = 0;

        int numberOfPizzas = sc.nextInt();
        for (int i = 0; i < numberOfPizzas; i++) {
            int quantity = sc.nextInt();
            int[] ingredients = new int[quantity];
            for (int j = 0; j < quantity; j++) {
                ingredients[j] = sc.nextInt();
                int count2 = 0;
                count += marioCanEat(ingredientesMarioArray, ingredients[j]);
                if(count2>0) {
                    int count3 = 1;


                }
                if(count3 == 1) count
            }

        }
        System.out.println(count);
    }

    public static int marioCanEat(int[] marioIngredients, int ingredient) {
        for (int i = 0; i < marioIngredients.length; i++) {
            if (marioIngredients[i] == ingredient) return 0;
        }
        return 1;
    }







//        //Ingredients that Mario do not like
//        int numberOfIngredientsMario = sc.nextInt();
//        int[] ingredientsMario = new int[numberOfIngredientsMario];
//        for (int i = 0; i < numberOfIngredientsMario; i++) {
//            ingredientsMario[i] = sc.nextInt();
//        }
//
//        //Pizzas and ingredients
//        int numberOfPizzas = sc.nextInt();
//        int[][] pizzas = new int[numberOfPizzas][];
//        for (int i = 0; i < numberOfPizzas; i++) {
//            int numberOfIngredients = sc.nextInt();
//            int[] ingredients = new int[numberOfIngredients];
//            for (int j = 0; j < numberOfIngredients; j++) {
//                ingredients[j] = sc.nextInt();
//            }
//            pizzas[i] = ingredients;
//        }
//        int result = marioCanEat(ingredientsMario, pizzas);
//        System.out.println(result);
//    }
//
//    public static int marioCanEat(int[] ingredientsMario, int[][] pizzas) {
//        int sum = 0;
//        int[] placeHolders = new int[pizzas.length];
//        for (int i = 0; i < ingredientsMario.length; i++) {
//            for (int j = 0; j < pizzas.length; j++) {
//                for(int z = 0; z <pizzas[j].length; z++){
//                    if (ingredientsMario[i] == pizzas[j][z]){
//                        if(placeHolders[j]==0){
//                            sum+=1;
//                            placeHolders[j] = 1;
//                        }
//                        break;
//                    }
//                }
//            }
//        }
//        return pizzas.length-sum;

}
