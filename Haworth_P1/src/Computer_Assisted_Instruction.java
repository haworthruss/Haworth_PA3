import java.util.Scanner;
import java.security.SecureRandom;

public class Computer_Assisted_Instruction {

    public static int multiplicationQuestion(int number1, int number2 ){ //returns 1 if correct, 0 if wrong.
        System.out.print("How much is " + number1 + " times " + number2 +"?  ");
        if  (answerCheck(getStudentAnswer(),number1 * number2 )){
            return 1;
        }
        else return 0;

    }

    //-----------------------------------------------------------------------------------------------------------------
    public static int additionQuestion(int number1, int number2 ){ //returns 1 if correct, 0 if wrong.
            System.out.print("How much is " + number1 + " plus " + number2 +"?  ");
            if  (answerCheck(getStudentAnswer(),number1 + number2 )){
                return 1;
            }
            else return 0;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static int subtractionQuestion(int number1, int number2 ){ //returns 1 if correct, 0 if wrong.
        System.out.print("How much is " + number1 + " minus " + number2 +"?  ");
        if  (answerCheck(getStudentAnswer(),number1 - number2 )){
            return 1;
        }
        else return 0;
    }
    //------------------------------------------------------------------------------------------------------------------
    public static int divisionQuestion(int number1, int number2 ){ //returns 1 if correct, 0 if wrong.

        System.out.print("How much is " + number1 + " divided by " + number2 +"?  ");
        if  (answerCheck(getStudentAnswer(),(double) number1 / (double) number2 )){
            return 1;
        }
        else return 0;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static double getStudentAnswer(){
        Scanner in = new Scanner(System.in);
        return in.nextDouble();
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean answerCheck(double studentAnswer, double answerKey){
        SecureRandom rand = new SecureRandom();
        if (Math.abs(studentAnswer - answerKey) < .01){
            correctAnswer(rand.nextInt(4));
            return true;
        }
        else{
            wrongAnswer(rand.nextInt(4));
            return false;
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    public static void correctAnswer(int responseNumber){
        switch (responseNumber){
            case 0:
                System.out.println("Very good!") ;
                break;
            case 1:
                System.out.println("Excellent!") ;
                break;
            case 2:
                System.out.println("Nice work!") ;
                break;
            case 3:
                System.out.println("Keep up the good work!") ;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + responseNumber);
        }
    }

    //---------------------------------------------------------------------------------------------------------
    public static void wrongAnswer(int responseNumber){
        switch (responseNumber){
            case 0:
                System.out.println("No. Please try again.") ;
                break;
            case 1:
                System.out.println("Wrong. Try once more.") ;
                break;
            case 2:
                System.out.println("Don’t give up!") ;
                break;
            case 3:
                System.out.println("No. Keep trying.") ;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + responseNumber);
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static int getLevel(int level){
        switch (level){
            case 1: return 9;
            case 2: return 99;
            case 3: return 999;
            case 4: return 9999;

            default:
                throw new IllegalStateException("Unexpected value: " + level);
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void menu(){
        System.out.println("Select type of problems to work.");
        System.out.println("1: Addition");
        System.out.println("2: Multiplication");
        System.out.println("3: Subtraction");
        System.out.println("4: Division");
        System.out.println("5: Random Mix");
        System.out.printf("Selection: ");
    }

    //------------------------------------------------------------------------------------------------------------------
    public static int questionSelector(int option, int number1, int number2){// returns 1 if question is correct and 0 if wrong.
        switch(option){
            case 1: return additionQuestion(number1, number2);
            case 2: return multiplicationQuestion(number1, number2);
            case 3: return subtractionQuestion(number1, number2);
            case 4: return divisionQuestion(number1, number2);
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static int validEntry( int option, int lowerBound, int upperBound){
        Scanner in = new Scanner(System.in);
        while ((option > upperBound) || (option < lowerBound)) {

            System.out.println("Invalid Entry!  Please select a number between " + lowerBound + " and " + upperBound + ".");
            option = in.nextInt();
        }
        return option;
    }

    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public static void main (String [ ] args) {
        Scanner in = new Scanner(System.in);

        SecureRandom rand = new SecureRandom();
        int level, option, numberOfCorrectAns ;
        float score;
        boolean randOption;
        char startAgain ='y';


        do {
            numberOfCorrectAns = 0;
            System.out.println("------- Computer Assisted Instruction ---------");
            System.out.printf("Enter a difficality level (1-4): ");
            level = validEntry(in.nextInt(), 1, 4);
            System.out.println("");

            menu();
            option = validEntry(in.nextInt(), 1, 5);
            randOption = (option == 5);
            System.out.println("");


            for (int i = 0; i < 10; ++i) {
                if (randOption) {
                    option = 1 + rand.nextInt(4);
                }
                System.out.println("Question " + (i + 1) + ":");
                numberOfCorrectAns = numberOfCorrectAns + questionSelector(option,
                        rand.nextInt(getLevel(level)) + 1, rand.nextInt(getLevel(level) ) + 1);

                System.out.printf("\n\n");
            }
            System.out.println("Correct Answers: " + numberOfCorrectAns);
            System.out.println("Incorrect Answers: " + (10 - numberOfCorrectAns));
            score = ((float) numberOfCorrectAns / 10) * 100;
            System.out.printf("Your Score: %.0f", score);
            System.out.println("");
            if (score < 75) {
                System.out.println("Please ask your teacher for extra help.");
            } else if (score > 75) {
                System.out.println("Congratulations, you are ready to go to the next level!");
            }

            System.out.printf("\n\nDo you want too try again? (y/n) : ");
            startAgain = in.next().charAt(0);

        }while( Character.toLowerCase(startAgain) == 'y');

        System.out.println("Goodbye!");
        in.close();
    }
}
