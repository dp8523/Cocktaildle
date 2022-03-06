import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Cocktaildle
{
    private static ArrayList<Cocktail> makeCocktails()
    {
        ArrayList<String> mojito = new ArrayList<>();
        mojito.add("white rum");
        mojito.add("mint");
        mojito.add("lime juice");
        mojito.add("simple syrup");
        mojito.add("mint syrup");
        mojito.add("club soda");
        ArrayList<String> pinaColada = new ArrayList<>();
        pinaColada.add("white rum");
        pinaColada.add("pineapple slice");
        pinaColada.add("pineapple juice");
        pinaColada.add("coconut cream");
        ArrayList<String> martini = new ArrayList<>();
        martini.add("gin");
        martini.add("dry vermouth");
        martini.add("lemon twist");
        ArrayList<String> oldFashioned = new ArrayList<>();
        oldFashioned.add("bourbon");
        oldFashioned.add("angostura bitters");
        oldFashioned.add("sugar");
        oldFashioned.add("orange wedge");
        ArrayList<String> french75 = new ArrayList<>();
        french75.add("gin");
        french75.add("champagne");
        french75.add("simple syrup");
        french75.add("lime juice");
        ArrayList<String> daiquiri = new ArrayList<>();
        daiquiri.add("white rum");
        daiquiri.add("lime juice");
        daiquiri.add("simple syrup");
        ArrayList<String> mimosa = new ArrayList<>();
        mimosa.add("champagne");
        mimosa.add("orange wedge");
        mimosa.add("orange juice");
        ArrayList<String> paloma = new ArrayList<>();
        paloma.add("tequila");
        paloma.add("grapefruit wedge");
        paloma.add("grapefruit juice");
        paloma.add("simple syrup");
        paloma.add("lime juice");
        ArrayList<String> sunsetBrickCorona = new ArrayList<>();
        sunsetBrickCorona.add("corona");
        sunsetBrickCorona.add("tequila");
        sunsetBrickCorona.add("orange juice");
        sunsetBrickCorona.add("pomegranate juice");
        sunsetBrickCorona.add("lime juice");

        ArrayList<Cocktail> cocktails = new ArrayList<>();
        cocktails.add(new Cocktail("mojito", mojito));
        cocktails.add(new Cocktail("pina colada", pinaColada));
        cocktails.add(new Cocktail("martini", martini));
        cocktails.add(new Cocktail("old fashioned", oldFashioned));
        cocktails.add(new Cocktail("french 75", french75));
        cocktails.add(new Cocktail("daiquiri", daiquiri));
        cocktails.add(new Cocktail("mimosa", mimosa));
        cocktails.add(new Cocktail("paloma", paloma));
        cocktails.add(new Cocktail("sunset brick corona", sunsetBrickCorona)); //our special drink
        return cocktails;
    }

    public static void main(String[] args) {
        ArrayList<Cocktail> cocktails = makeCocktails();
        Cocktail secretCocktail = Cocktail.randomCocktail(cocktails);
        System.out.println("secret: " + secretCocktail.getName());
        Scanner in = new Scanner(System.in);
        System.out.println("Guess the secret cocktail!");
        int attempt = 1;
        while (attempt <= 4)
        {
            System.out.println("Next guess: ");
            Cocktail userCocktail = null;
            String guess = in.nextLine();
            boolean inList = false;
            while (!inList)
            {
                for (Cocktail cocktail : cocktails)
                {
                    if (guess.equals(cocktail.getName()))
                    {
                        inList = true;
                        break;
                    }
                }
                if (inList)
                {
                    break;
                }
                System.out.println("Not in list, try again");
                guess = in.nextLine();
            }
            for (Cocktail cocktail : cocktails)
            {
                if (guess.equals(cocktail.getName()))
                {
                    userCocktail = new Cocktail(guess, cocktail.getIngredients());
                    break;
                }
            }
            System.out.println("guess: " + userCocktail.getName());
            String correctness = Cocktail.checkIngredients(secretCocktail, userCocktail);
            System.out.println(correctness + ", attempt "+attempt);
            if(correctness.equals("green"))
            {
                System.out.println("You Win!");
                break;
            }
            attempt++;
        }
        System.out.println("No more guesses! Answer: "+secretCocktail.getName());
    }
}
