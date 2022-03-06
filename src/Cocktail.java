import java.util.ArrayList;

public class Cocktail {
    //instance fields
    private String name;
    private ArrayList <String> ingredients;


    public Cocktail (String name, ArrayList<String> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() { return this.name; }

    public ArrayList<String> getIngredients() { return this.ingredients; }

    /** randomCocktail genertates a random cocktail for the user to guess
     *
     * @param Cocktails the list of all the cocktails
     * @return a Cocktail that the user will try to guess
     */
    public Cocktail randomCocktail( ArrayList<Cocktail> Cocktails) {
        int randomNum = (int)(Math.random() * Cocktails.size());
        return Cocktails.get(randomNum);
    }

    /** checkIngredients goes through the cocktail guess ingredient list and sees if they are equal to
     * the ingredient list in the cocktail answer. Depending on how many ingredients match up between
     * the guess and the answer then it will return a color to show how close the guess is
     *
     * @param answer the cocktail answer the user is trying to guess
     * @param userGuess the cocktail the user guessed
     * @return a String that tells us the color of the guess
     */
    public String checkIngredients ( Cocktail answer, Cocktail userGuess) {
        int match = 0;
        String color;
        //get the right answer cocktail list
        //then compares it with the users cocktail list
        for (int i = 0; i < answer.ingredients.size(); i++) {
            for (int j = 0; j < userGuess.ingredients.size(); j++) {
                if ( (answer.ingredients.get(i)).equals(userGuess.ingredients.get(j)) ) {
                    match++;
                }
            }
        }

        if ( match == 0 ) {
            //no matching ingredients
            color = "grey";
        } else if ( match > 0 && match < userGuess.ingredients.size() ) {
            //at least 1 or more similar ingredients
            color = "yellow";
        } else {
            //all ingredients match up
            color = "green";
        }

        return color;
    }

}
