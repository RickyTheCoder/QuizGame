import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

// below will implement user interface
public class Quiz implements ActionListener {

    // array that stores all the different questions that will be asked
    String[] questions = {
            "What is the name of the professor for COMP 170 section 003?",
            "When is the last day of the semester?",
            "What is the name of this course?"
    };
    // 2D array of strings that holds all the different possibilities of answers for all the different questions
    String[][] options = {
            {"Professor Yacobellis", "Professor Joe", "Professor Honig", "Professor Younis"},
            {"October 16th", "November 16th", "December 16th", "I don't know!"},
            {"Organic Chemistry", "Objected Oriented Programming", "Biology", "Calculus"}
    };
    // array of strings that holds all the different correct answers for all the different questions
    char[] answers = {
            'A',
            'C',
            'B'
    };
    // declaring a char data type that holds the guess
    char guess;
    char answer;
    int index;
    int correct_guesses = 0;
    int total_questions = questions.length;
    int result;
    int seconds = 10;

    // declaring and initializing some GUI components

    JFrame frame = new JFrame();
    JTextField textfiled = new JTextField(); // holds the current question we are on
    JTextArea textarea = new JTextArea(); // text area that holds the current question
    JButton buttonA = new JButton(); // creates button A
    JButton buttonB = new JButton(); // creates button B
    JButton buttonC = new JButton(); // creates button C
    JButton buttonD = new JButton(); // creates button D
    JLabel answer_labelA = new JLabel(); // creates label A
    JLabel answer_labelB = new JLabel(); // creates label B
    JLabel answer_labelC = new JLabel(); // creates label C
    JLabel answer_labelD = new JLabel(); // creates label D
    JLabel time_label = new JLabel(); // displays the timer
    JLabel seconds_left = new JLabel(); // functions as display for count down timer
    JTextField number_right = new JTextField(); // displays the number
    JTextField percentage = new JTextField(); // displays percentage of score


    // below is the constructor
    public Quiz() {

    }

    // this method allows us to move to the next question
    public void nextQuestion() {

    }

    // this method will deal with any button clicking
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    // this method will display the correct answer
    public void displayAnswer() {

    }

    // this method will display the final results
    public void results() {

    }

}
