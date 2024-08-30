import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class Recipe {

        private String recipeName;
        private Set<Ingredient> ingredients;
        private Sauce sauce;
        private String cookingInstructions;

        public Recipe(String aName, Set<Ingredient> listIng) {
            if(aName == null || aName.trim().isEmpty()) {
                throw new IllegalArgumentException("Please provide a name for this Recipe");
            }
            if(listIng == null || listIng.isEmpty()) {
                throw new IllegalArgumentException("Add at least one ingredient");
            }
            recipeName = StringUtil.capitalizeFirstLetter(aName);
            ingredients = new HashSet<>(listIng);
            sauce = null;
        }

        public Recipe(String aName, Set<Ingredient> listIng, Sauce aSauce) {
            if(aName == null || aName.trim().isEmpty()) {
                throw new IllegalArgumentException("Please provide a name for this Recipe");
            }
            if(listIng == null || listIng.isEmpty()) {
                throw new IllegalArgumentException("Add at least one ingredient");
            }
            recipeName = aName;
            ingredients = new HashSet<>(listIng);
            sauce = aSauce;
        }

        public void addSauce(Sauce aSauce) {
            if(aSauce == null) {
                throw new IllegalArgumentException("Please provide a Sauce");
            }
            sauce = aSauce;
        }

        public void addInstructions(String instructions) {
            if(instructions == null || instructions.trim().isEmpty()) {
                throw new IllegalArgumentException("Please provide the instructions for this Recipe");
            }
            cookingInstructions = instructions;
        }

        public void addIngredients(Set<Ingredient> moreIng) {
            if(moreIng == null || moreIng.isEmpty()) {
                throw new IllegalArgumentException("Please provide the ingredients for this Recipe");
            }
            ingredients.addAll(moreIng);
        }

        public String getRecipeName() {
            return recipeName;
        }

        public String getCookingInstructions() {
            if(cookingInstructions == null) {
                return "No cooking instructions have been provided yet";
            }
            return cookingInstructions;
        }

        public Set<Ingredient> getIngredients() {
            if(ingredients == null || ingredients.isEmpty()) {
                return new HashSet<>();
            }
            return ingredients;
        }

        public Sauce getSauce() {
            return sauce;       // could be null
        }

        public boolean contains(Ingredient ing) {
            return ingredients.contains(ing);
        }

        public boolean hasSauce() {
            return sauce != null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Recipe that = (Recipe) o;
            return recipeName.equals(that.recipeName) && ingredients.equals(that.ingredients);
        }
    
        @Override
        public int hashCode() {
            return recipeName.hashCode();
        }

   

    
   // Main method to test the Recipe class
   public static void main(String[] args) {
    // Create Ingredient objects
    Ingredient tomato = new Ingredient("Tomato");
    Ingredient basil = new Ingredient("Basil");
    Ingredient mozzarella = new Ingredient("Mozzarella Cheese");
    Ingredient oliveOil = new Ingredient("Olive Oil");

    // Create an array of ingredients
    Set<Ingredient> ingredientsSet = new HashSet<>();
    Collections.addAll(ingredientsSet, tomato, basil, mozzarella, oliveOil);

    // Create a Recipe object
    //Recipe capreseSalad = new Recipe("Caprese Salad");

    // Add ingredients to the recipe
    //capreseSalad.addIngredients(ingredientsSet);

    // // Print the recipe title
    // System.out.println("Recipe: " + capreseSalad.getTitle());

    // // Print the ingredients
    // System.out.println("Ingredients:");
    // for (Ingredient ingredient : capreseSalad.getIngredients()) {
    //     System.out.println("- " + ingredient.getIngredient());
    //    }
   }
}


