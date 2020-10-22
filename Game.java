import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Game{
    private ArrayList<Question> questionSet;
    public Game(){
        questionSet = new ArrayList<Question>();
        String question = "Where does the sun rise?";
        String[] answers = {"East", "South", "West", "North"};
        questionSet.add(new Question(question, answers, "East"));
        question = "Who invented the Telephone?";
        //must reuse variable with new String[]
        answers = new String[]{"Thomas Edison", "Michael Faraday", "James Watt", "Alexander Bell"};
        questionSet.add(new Question(question, answers, "Alexander Bell"));
        question = "Where is the capital of Japan?";
        answers = new String[]{"Beijing", "Tokyo", "Soul", "Bangkok"};
        questionSet.add(new Question(question, answers, "Tokyo"));
        Collections.shuffle(questionSet, new Random());
    }
    public void start(){
        Scanner scan = new Scanner(System.in);
        int numCorrect = 0;
        //Show Question from question Set
        for (int question = 0; question < questionSet.size(); question++){
            System.out.println(questionSet.get(question).getQuestion());
            int numChoices = questionSet.get(question).getChoices().size();
            // show choices from question in questionSet
            for(int choice = 0; choice < numChoices; choice++){
                System.out.println((choice + 1 ) + ": " + questionSet.get(question).getChoices().get(choice));
            }
            int playerAnswer = scan.nextInt();
            ArrayList<String> choiceSet = 
                    questionSet.get(question).getChoices();
            String correctAnswer = questionSet.get(question).getAnswer();
            int correctAnswerIndex = choiceSet.indexOf(correctAnswer);
            if (playerAnswer == correctAnswerIndex + 1){
                numCorrect++; 
            }
        }
        scan.close();
        System.out.println("You got " + numCorrect +" correct anwer(s)");
    }
}