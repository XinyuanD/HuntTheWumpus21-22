using System.Collections;

namespace Wumpus
{
    public class shop
    {
        private ArrayList secrets;
        private game game;
        public shop(game game) {
            this.game = game;
            secrets = new ArrayList();
        }

        public void buyFuel(int fuel, player player) {
            int numCoins = fuel*10;
            if (numCoins > game.getPlayer().getNumCoins()){
                Console.WriteLine("You do not have enough coins");
            }
            else {
                game.getPlayer().setCoins(game.getPlayer().getNumCoins()-numCoins);
                game.getPlayer().setFuel(game.getPlayer().getNumFuel() + fuel);
            }
        }

        public void buySecret(int numSecrets, player player, trivia trivia) {
            int numCoins = numSecrets*20;
            int availableCoins =  game.getPlayer().getNumCoins();
            if (numCoins < availableCoins){
                Console.WriteLine("You do not have enough coins");
            }
            else {
                 game.getPlayer().setCoins(availableCoins - numCoins);
                secrets.Add(game.getTrivia().getSecret());
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
            if (numCoins > game.getPlayer().getNumCoins()){
                Console.WriteLine("You do not have enough coins");
            }
            else {
                game.getPlayer().setCoins(player.getNumCoins()-numCoins);
                game.getPlayer().setArrows(player.getNumArrows() + numArrows);
            }
        }

    }
}
