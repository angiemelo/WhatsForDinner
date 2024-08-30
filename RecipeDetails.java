import java.util.HashSet;
import java.util.Set;

public class RecipeDetails {
    
    private Set<Ingredient> ingredients;
    private Sauce sauce;
    private String instructions;

    public RecipeDetails(Set<Ingredient> needIng, Sauce aSauce) {
        ingredients = new HashSet<>(needIng);
        sauce = aSauce;
    }

    public void addInstructions(String cooking) {
        instructions = cooking;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public String getInstructions() {
        return instructions;
    }
}
