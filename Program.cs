using System;

namespace WumpusProject 
{
    internal class Program
    {
        static void Main(string[] args)
        {
            game newGame = new game();
            newGame.caveToString();
            Console.WriteLine(newGame.getRoomCount());
        }
    }
}