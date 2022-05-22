public class UtopiaCoins {
    //Algoritmen fungrer ved hele tiden at finde den største mønt vi kan tage, uden at komme over den amount vi skal bruge. 
    //Hver gang den har fundet den største mønt, trækker den det fra amount, og det giver en resterende amount vi så skal finde den størst mulige mønt til. 
    // Hvis man f.eks. skulle have 100 kr, ville man tage 22 først.Så 100-22 = 78. Den største mønt der passer er 22 igen, så 78-22 = 56 så det er 22 der passer igen osv.
    static int minCoins(int[] coins, int amount) {
        int[] table = new int[amount + 1];

     
        for (int i = 1; i <= amount; i++) {
            table[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
                        table[i] = sub_res + 1;
                }
            }
        }
        if (table[amount] == Integer.MAX_VALUE)
            return -1;

        return table[amount];
    }

    public static void main(String[] args)
    {
        int[] coins = {1, 7, 10, 22};
        int amount = 410;
        System.out.println("Minimum coins required is " + minCoins(coins, amount));
    }
}
