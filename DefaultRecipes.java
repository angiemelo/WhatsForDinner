import java.util.Set;
import java.util.HashMap;

public class DefaultRecipes {

    public static HashMap<String, Recipe> createDefaultRecipes() {
        
        HashMap<String, Recipe> defaultRecipes = new HashMap<>();
        // creating ingredients
        Ingredient tomato = new Ingredient("Tomato");
        Ingredient basil = new Ingredient("Basil");
        Ingredient mozzarella = new Ingredient("Mozzarella Cheese");
        Ingredient pasta = new Ingredient("Pasta");
        Ingredient groundBeef = new Ingredient("Ground Beef");
        Ingredient garlic = new Ingredient("Garlic");
        Ingredient chickenBreast = new Ingredient ("Chicken Breast");
        Ingredient parmesan = new Ingredient("Parmesan Cheese");
        Ingredient butter = new Ingredient("Butter");
        Ingredient broccoli = new Ingredient("Broccoli");
        Ingredient carrot = new Ingredient("Carrot");
        Ingredient redPepper = new Ingredient("Red Pepper");
        Sauce oliveOil = new Sauce("Olive Oil");
        Sauce tomatoSauce = new Sauce("Tomato Sauce");
        Sauce alfredoSauce = new Sauce("Alfredo Sauce");
        Sauce heavyCream = new Sauce("Heavy Cream");
        Sauce soySauce = new Sauce("Soy Sauce");

        // creating Recipes
        Recipe capreseSalad = new Recipe("Caprese Salad", Set.of(tomato, basil, mozzarella), oliveOil);
        Recipe spaghettiBolognese = new Recipe("Spaghetti Bolognese", Set.of(pasta, groundBeef, garlic), tomatoSauce);
        Recipe tomatoSoup = new Recipe("Tomato Soup", Set.of(tomato, basil, garlic), oliveOil);
        Recipe chickenAlfredoPasta = new Recipe("Chicken Alfredo Pasta", Set.of(chickenBreast, pasta, parmesan, butter, garlic), alfredoSauce);
        Recipe beefStirFry = new Recipe("Beef Stir-Fry", Set.of(groundBeef, broccoli, carrot, redPepper, garlic), soySauce);
        Recipe creamyTomatoBasilPasta = new Recipe("Creamy Tomato Basil", Set.of(tomato, basil, pasta, garlic, parmesan), heavyCream);
        Recipe vegetableAlfredoPasta = new Recipe("Vegetable Alfredo Pasta", Set.of(broccoli, carrot, pasta, parmesan, butter, garlic), alfredoSauce);

        // add Recipes 
        defaultRecipes.put("Caprese Salad", capreseSalad);
        defaultRecipes.put("Spaghetti Bolognese", spaghettiBolognese);
        defaultRecipes.put("Tomato Soup", tomatoSoup);
        defaultRecipes.put("Chicken Alfredo Pasta", chickenAlfredoPasta);
        defaultRecipes.put("Beef Stir Fry", beefStirFry);
        defaultRecipes.put("Creamy Tomato Pasta", creamyTomatoBasilPasta);
        defaultRecipes.put("Vegetable Alfredo Pasta", vegetableAlfredoPasta);

        return defaultRecipes;
    }
}
