import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.Scanner;

public class WhatsForDinner{

    private HashMap<String, Recipe> cookbook;
    
    public WhatsForDinner() {

        cookbook = new HashMap<>();
    }

        public void addRecipe(Recipe recipe) {

            if (recipe == null || recipe.getRecipeName() == null || recipe.getRecipeName().trim().isEmpty()) {
                throw new IllegalArgumentException("Please provide a Recipe name");
            }
            cookbook.put(recipe.getRecipeName(), recipe);
            System.out.println(recipe.getRecipeName() + " added.");
        }

        public void addDefaultRecipes() {

            Map<String, Recipe> defaultRecipes = DefaultRecipes.createDefaultRecipes();

            //Add recipes to cookbook
            for (Map.Entry<String, Recipe> entry : defaultRecipes.entrySet()) {
                cookbook.put(entry.getKey(), entry.getValue());
            }
        }

        public void printBook() {

            if(cookbook.isEmpty()) {
                System.out.println("The cookbook is empty");
                return;
            }

            for (Recipe recipe : cookbook.values()) {
                System.out.println(recipe.getRecipeName() + ": ");
                
                // construct a String with all ingredients
                String ingredients = recipe.getIngredients().stream()
                        .map(Ingredient::getIngredient)
                        .collect(Collectors.joining(", "));
    
                // add sauce if present
                if (recipe.hasSauce()) {
                    ingredients += ", " + recipe.getSauce();
                }
    
                System.out.println(ingredients + "\n");
            }
        }

        public void whatToCook(Set<Ingredient> userIngredients) {

            if (userIngredients == null || userIngredients.isEmpty()) {
                throw new IllegalArgumentException("Please provide the ingredients");
            }

            StringBuilder fullRec = new StringBuilder();
            StringBuilder halfRec = new StringBuilder();

            for (Recipe recipe : cookbook.values()) {
                Set<Ingredient> neededIngredients = new HashSet<>(recipe.getIngredients());
                neededIngredients.removeAll(userIngredients);
    
                if (neededIngredients.isEmpty()) {
                    fullRec.append(recipe.getRecipeName()).append(" ");

                } else if (neededIngredients.size() < 4) {
                    halfRec.append(recipe.getRecipeName()).append(" - if you had: ");
                    String neededIngredientsList = neededIngredients.stream()
                            .map(Ingredient::getIngredient)
                            .collect(Collectors.joining(", "));
                    halfRec.append(neededIngredientsList);
    
                    if (recipe.hasSauce()) {
                        halfRec.append(" and ").append(recipe.getSauce());
                    }
                    halfRec.append("\n");
                }

        }
            System.out.println("You can make: " + (fullRec.length() > 0 ? fullRec.toString() : "nothing with the current ingredients."));
            System.out.println("Or you could make: " + (halfRec.length() > 0 ? halfRec.toString() : "you might need more ingredients."));
        }

        public void surpriseRecipe() {

            if(cookbook.isEmpty()) {
                System.out.println("Sorry, you currently have no recipes.");
                return;
            }

            // get all Recipe titles
            List<String> recipeTitles = new ArrayList<>(cookbook.keySet());
            // generate random number from number of recipes
            int randomIndex = new Random().nextInt(recipeTitles.size());

            System.out.println("What about " + recipeTitles.get(randomIndex) + "?");

            }

        public void planForMe(int days) {

            if (days <= 0) {
                System.out.println("The number of days needs to be bigger than 0");
                return;
            }

            if (cookbook.size() < days) {
                System.out.println("You will need to add more recipes.");
                return;
            }
            
            // get all Recipes and shuffles them
            List<Recipe> recipes = new ArrayList<>(cookbook.values());
            Collections.shuffle(recipes);

            // set to collect ingredients needed
            Set<Ingredient> needIngredients = new HashSet<>();
            Set<Sauce> needSauce = new HashSet<>();

            for (int i=0; i < days; i++) {
                Recipe aRecipe = recipes.get(i);
                needIngredients.addAll(aRecipe.getIngredients());
                if (aRecipe.hasSauce()) {
                    needSauce.add(aRecipe.getSauce());
                    }
                System.out.println("Day " + (i+1) + " " + aRecipe.getRecipeName());
                }

            // Format the output of ingredients
            String ingredientsList = needIngredients.stream()
            .map(Ingredient::getIngredient)
            .collect(Collectors.joining(", "));

            // Format the output of sauces
            String saucesList = needSauce.stream()
            .map(Sauce::getSauce) 
            .collect(Collectors.joining(", "));

            System.out.println("\nYou will need: " + ingredientsList + (needSauce.isEmpty() ? "" : "\nAnd " + saucesList));
            
        }

        public void deleteRecipe(String aRecipe) {

            if (aRecipe == null || aRecipe.trim().isEmpty()) {
                throw new IllegalArgumentException("Please provide a Recipe name");
            }
            String recipeName = StringUtil.capitalizeFirstLetter(aRecipe);
            if(cookbook.containsKey(recipeName)) {
                cookbook.remove(recipeName);
                System.out.println(recipeName + " has been removed.");
            }
            else {
                System.out.println("Sorry, I could not find " + recipeName);
            }
        }

        public static void main(String[] args) {

             WhatsForDinner whatsForDinner = new WhatsForDinner();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to Whats For Dinner!\nWould you like me to add some recipes for you? Type Y or N: ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("Yes")) {
                whatsForDinner.addDefaultRecipes();
                System.out.println("Recipes added.");
                
            }

            boolean running = true;

            while (running) {
            System.out.println("\nWould you like to do?\n1 Add a Recipe\n2 View Recipe book\n3 Get a random dinner suggestion\n"
                + "4 Get a Recipe based on your ingredients\n5 Create a Meal Planner\n6 Delete a Recipe\n7 Exit");
            String decision = scanner.nextLine();

            switch (decision) {
                case "1":
            System.out.print("Enter the name of the recipe: ");
            String recipeName = scanner.nextLine();
        
            Set<Ingredient> userIngredients = new HashSet<>();
            System.out.println("Enter ingredients one by one. Press Enter when finished.");
            String input;

            while (!(input = scanner.nextLine()).isEmpty()) {
                userIngredients.add(new Ingredient(input));
            }

            Recipe recipe = new Recipe(recipeName, userIngredients);
            whatsForDinner.addRecipe(recipe);
            break;

                case "2" :
            whatsForDinner.printBook();
            break;

                case "3" :
            whatsForDinner.surpriseRecipe();
            break;

                case "4" :
            System.out.println("What ingredients do you have? Press Enter when finished");
            Set<Ingredient> ingredients = new HashSet<>();
            System.out.println("Enter ingredient: ");

            while(!(input = scanner.nextLine()).isEmpty()) {
                ingredients.add(new Ingredient(input));
            }
            whatsForDinner.whatToCook(ingredients);
            break;

                case "5" :
            boolean validInput = false;

            while (!validInput) {
                System.out.println("How many days would you like to plan for? ");
                String days = scanner.nextLine();

                try {
                    // convert the input to an int
                    int number = Integer.parseInt(days);
                    if (number <= 0) {
                        System.out.println("The number of days needs to be bigger than 0");
                    } else {
                    whatsForDinner.planForMe(number);
                    validInput = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
                break;

            
                case "6" :
            System.out.println("What is the name of the Recipe you would like to delete? ");
            String toDelete = scanner.nextLine();

            whatsForDinner.deleteRecipe(toDelete);
            break;
        
                case "7":
            System.out.println("Goodbye!");
            running = false;
            break;

                default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
        } 

    }
}



