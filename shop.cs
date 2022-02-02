using System.Collections;

namespace Wumpus
{
    public class shop
    {
        private ArrayList secrets;
        private player player;

        public Shop(player player) {
            this.player = player;
            secrets = new ArrayList();
        }

        public void buyFuel(int fuel, player player) {
            int numCoins = fuel*10;
            if (numCoins > player.getNumCoins()){
                Console.WriteLine("You do not have enough coins");
            }
            else {
                player.setNumCoins(player.getNumCoins()-numCoins);
                player.setNumFuel(player.getNumFuel() + fuel);
            }
        }

        public void buySecret(int numSecrets, player player, Trivia trivia) {
            int numCoins = numSecrets*20;
            int availableCoins = player.getNumCoins();
            if (numCoins > availableCoins){
                Console.WriteLine("You do not have enough coins");
            }
            else {
                player.setNumCoins(availableCoins - numCoins);
                secrets.Add(Trivia.getNumSecret());
            }
        }

        public String redeemSecret() {
            if (secrets.Count == 0) {
                return "You have no secrets";
            } else {
                string secret = (string) secrets[1];
                secrets.RemoveAt(1);
                return secret;
            }
        }

        public void buyArrows(int numArrows, player player) {
            int numCoins = numArrows*5;
            if (numCoins > player.getCoins()){
                Console.WriteLine("You do not have enough coins");
            }
            else {
                player.setNumCoins(player.getNumCoins()-numCoins);
                player.setNumArrows(player.getNumArrows() + numArrows);
            }
        }

    }
}
