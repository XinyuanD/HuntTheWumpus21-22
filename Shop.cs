using System.Collections;

namespace Wumpus
{
    public class shop
    {
        private ArrayList secrets;
        private player player;
        private game game;
        public Shop(player game) {
            this.game = game;
            secrets = new ArrayList();
        }

        public void buyFuel(int fuel, player player) {
            int numCoins = fuel*10;
            if (numCoins > game.getPlayer().getNumCoins()){
                Console.WriteLine("You do not have enough coins");
            }
            else {
                player.setNumCoins(game.getPlayer().getNumCoins()-numCoins);
                player.setNumFuel(game.getPlayer().getNumFuel() + fuel);
            }
        }

        public void buySecret(int numSecrets, player player, Trivia trivia) {
            int numCoins = numSecrets*20;
            int availableCoins =  game.getPlayer().getNumCoins();
            if (numCoins > availableCoins){
                Console.WriteLine("You do not have enough coins");
            }
            else {
                 game.getPlayer().setNumCoins(availableCoins - numCoins);
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
                game.getPlayer().setNumCoins(player.getNumCoins()-numCoins);
                game.getPlayer().setNumArrows(player.getNumArrows() + numArrows);
            }
        }

    }
}
