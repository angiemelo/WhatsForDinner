public class Ingredient {
        private String ingredient;

        public Ingredient(String anIng) {
            if (anIng == null || anIng.isEmpty()) {
                throw new IllegalArgumentException("Ingredient name cannot be null or empty");
            }
            ingredient = StringUtil.capitalizeFirstLetter(anIng);
        }

        public String getIngredient() {
            return ingredient;
        }      

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Ingredient that = (Ingredient) o;
            return ingredient.equals(that.ingredient);
        }
    
        @Override
        public int hashCode() {
            return ingredient.hashCode();
        }
    }
   

