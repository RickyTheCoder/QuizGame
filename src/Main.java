// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Quiz quiz = new Quiz();
    }
}

/*

Pseudo code:

Constructor Quiz(): Initializes the quiz game interface. Sets up the frame, text fields, buttons, labels, and timers. It configures the layout, colors, fonts, and action listeners for the buttons. Finally, it calls nextQuestion() to start the quiz.

Method nextQuestion(): Displays the next question and its corresponding options. It updates the question and answer labels and resets the timer. If all questions have been answered, it calls results() to display the final score.

Method actionPerformed(ActionEvent e) (from the ActionListener interface): Handles button clicks. Determines which option (A, B, C, or D) was selected and compares it with the correct answer to update the score. It then calls displayAnswer() to show the correct answer.

Method displayAnswer(): Stops the timer and disables the option buttons. Indicates the correct and incorrect answers by changing label colors. Sets a delay, then re-enables the buttons, resets the timer, and proceeds to the next question via nextQuestion().

Method results(): Displays the final results of the quiz. It calculates and shows the percentage of correct answers and the total number of correct guesses. It also disables all option buttons to conclude the quiz.

*/
