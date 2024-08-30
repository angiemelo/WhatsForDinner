import java.util.HashSet;
import java.util.Set;

public class Sauce {

    private String sauce;
    private Set<Ingredient> ingredients;
    private String cookingInstructions;

        public Sauce(String aSauce) {
            if(aSauce == null || aSauce.trim().isEmpty()) {
                throw new IllegalArgumentException("Sauce name cannot be empty");
            }
            sauce = StringUtil.capitalizeFirstLetter(aSauce);
        }

        public String getSauce() {
            return sauce;
        } 
        
        public void addIngredients(Set<Ingredient> ingredient) {
            ingredients = new HashSet<Ingredient>(ingredient);
        }

        public void addInstructions(String instructions) {
            cookingInstructions = instructions;
        }

        public Set<Ingredient> getIngredients() {
            return ingredients;
        }

        public String getInstructions() {
            return cookingInstructions;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Sauce that = (Sauce) o;
            return sauce.equals(that.sauce);
        }
    
        @Override
        public int hashCode() {
            return sauce.hashCode();
        }

        @Override
        public String toString() {
            return sauce;
        }
}
