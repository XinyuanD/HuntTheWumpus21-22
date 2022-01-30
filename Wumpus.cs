using System.Collections;

namespace Wumpus
{
    public class trivia
    {
        // private ArrayList rooms;
        private ArrayList questions;
        private ArrayList answers;

        private game game;

        public trivia(game game) {
            this.game = game;
            questions = new ArrayList();
            answers = new ArrayList();
            using (StreamReader file = new StreamReader("triviaQs.txt")) {  
                int counter = 0;  
                string line;  
                while ((line = file.ReadLine()) != null) {  
                    if (counter % 2 == 0) {
                        questions.Add(line);
                    } else {
                        answers.Add(line);
                    }
                counter++;  
                }  
            } 
        }

        public bool askQuestions(int amount, int needCorrect) {
            Random rand = new Random();
            int right = 0;
            int wrong = 0;
            for (int i = 0; i < amount; i++) {
                if (wrong > amount-needCorrect) {  
                    Console.WriteLine("You lost the game!");
                    return false;
                } else {  
                    int idx = rand.Next(questions.Count);
                    string question = (string) questions[idx]; // random question
                    string answer = (string) answers[idx]; // random answer
                    Console.WriteLine(question);
                    string userAnswer = Console.ReadLine();
                    if (String.Equals(answer.ToLower(), userAnswer.ToLower())) { // check user answer
                        right++;
                    } else {
                        wrong++;
                    }
                }
            }   
            if (right >=needCorrect) {
                Console.WriteLine("You beat the trivia! You will now be respawned.");
                return true;
            }
            return true;
        }
    }
}
