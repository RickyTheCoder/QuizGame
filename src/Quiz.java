import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

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
    //this controls what the UI looks like (color, font, border, background etc.)
    public Quiz() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.getContentPane().setBackground(new Color(20,20,60));
        frame.setLayout(null);
        frame.setResizable(false);
//textfield = textfiled for some reason
        //This is the text box
        textfiled.setBounds(0,0,650,50);
        textfiled.setBackground(new Color(25,25,25));
        textfiled.setForeground(new Color(255,50,100));
        textfiled.setFont(new Font("Marker Felt",Font.BOLD,30));
        textfiled.setBorder(BorderFactory.createBevelBorder(1));
        textfiled.setHorizontalAlignment(JTextField.CENTER);
        textfiled.setEditable(false);
        //How the text behaves when its written
        textarea.setBounds(0,50,650,50);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(25,25,25));
        textarea.setForeground(new Color(255,50,100));
        textarea.setFont(new Font("Marker Felt",Font.BOLD,25));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);
        textarea.setText("QUESTION");

        buttonA.setBounds(0,100,100,100);
        buttonA.setFont(new Font("VOGUE",Font.BOLD,35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0,200,100,100);
        buttonB.setFont(new Font("VOGUE",Font.BOLD,35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0,300,100,100);
        buttonC.setFont(new Font("VOGUE",Font.BOLD,35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0,400,100,100);
        buttonD.setFont(new Font("VOGUE",Font.BOLD,35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answer_labelA.setBounds(125,100,500,100);
        answer_labelA.setBackground(new Color(20,100,200));
        answer_labelA.setForeground(new Color(255,50,100));
        answer_labelA.setFont(new Font("Marker Felt",Font.PLAIN,35));
        answer_labelA.setText("Answer 1");

        answer_labelB.setBounds(125,200,500,100);
        answer_labelB.setBackground(new Color(20,100,200));
        answer_labelB.setForeground(new Color(255,50,100));
        answer_labelB.setFont(new Font("Marker Felt",Font.PLAIN,35));
        answer_labelB.setText("Answer 2");

        answer_labelC.setBounds(125,300,500,100);
        answer_labelC.setBackground(new Color(20,100,200));
        answer_labelC.setForeground(new Color(255,50,100));
        answer_labelC.setFont(new Font("Marker Felt",Font.PLAIN,35));
        answer_labelC.setText("Answer 3");

        answer_labelD.setBounds(125,400,500,100);
        answer_labelD.setBackground(new Color(20,100,200));
        answer_labelD.setForeground(new Color(255,50,100));
        answer_labelD.setFont(new Font("Marker Felt",Font.PLAIN,35));
        answer_labelD.setText("Answer 4");
//set the time left
        seconds_left.setBounds(535,510,100,100);
        seconds_left.setBackground(new Color(25,25,25));
        seconds_left.setForeground(new Color(255,0,0));
        seconds_left.setFont(new Font("Ink Free",Font.BOLD,60));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true); // revisit
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        //time label
        time_label.setBounds(535,475,100,25);
        time_label.setBackground(new Color(50,50,25));
        time_label.setForeground(new Color(255,0,0));
        time_label.setFont(new Font("MV Boli",Font.PLAIN,20));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("timer");
//display the number of questions got right out of total amount
        number_right.setBounds(225,225,200,100);
        number_right.setBackground(new Color(25,25,25));
        number_right.setForeground(new Color(25,255,0));
        number_right.setFont(new Font("Ink Free",Font.BOLD,50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);
//display label that displays percentage right
        percentage.setBounds(225,325,200,100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(new Color(25,255,0));
        percentage.setFont(new Font("Ink Free",Font.BOLD,50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

//Inserting them into the frame we made earlier
        //frame.add(number_right);
       //frame.add(percentage);
        frame.add(time_label);
        frame.add(seconds_left);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textarea);
        frame.add(textfiled);
        frame.setVisible(true);
        nextQuestion();
    }

    // this method allows us to move to the next question
    public void nextQuestion() {
        if(index >= total_questions){
            results();
        }
        else{
            textfiled.setText("Question " + (index + 1));
            //whenever we increase our index it will retrieve our next question and recall next-
            //question method
            textarea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);
        }
    }

    // this method will deal with any button clicking
    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        //determine which button is being pressed and match to see if thats the
        // array of answers that matches what we have
        if(e.getSource()==buttonA){
            answer = 'A';
            if(answer == answers[index]){  //you choose A and if A matches the answer then correct guesses incteases by 1
                correct_guesses++;
            }
        }
        if(e.getSource()==buttonB){
            answer = 'B';
            if(answer == answers[index]){
                correct_guesses++;
            }
        }
        if(e.getSource()==buttonC){
            answer = 'C';
            if(answer == answers[index]){
                correct_guesses++;
            }
        }
        if(e.getSource()==buttonD){
            answer = 'D';
            if(answer == answers[index]){
                correct_guesses++;
            }
        }
        //now call the display answer method
        displayAnswer();

    }

    // this method will display the correct answer
    public void displayAnswer() {

    }

    // this method will display the final results
    public void results() {

    }

}
