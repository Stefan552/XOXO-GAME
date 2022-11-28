import java.util.Random;
import java.util.Scanner;

public class XoXoXo {
    static int playerScore=0;
    static int computerScore=0;
    static Scanner input=new Scanner(System.in);
    public static void main(String[] args) {

        char [][] xoxo= new char[][]{{' ', ' ', ' '},
                                     {' ', ' ', ' '},
                                     {' ', ' ', ' '}};
        char [][] xoxoExamplePozitie= new char[][]{{'1', '2', '3'},
                                                    {'6', '5', '4'},
                                                    {'7', '8', '9'}};


        boolean gameOver=false;
        boolean playAgain=true;
        while(playAgain){
        System.out.println("Pozitiile game-ului sunt: ");
        printBoard(xoxoExamplePozitie);

        while(!gameOver){
            playerMove(xoxo);
            gameOver=isGameOver(xoxo);
            if (gameOver){
                break;
            }
            computerMove(xoxo);
            gameOver=isGameOver(xoxo);
            if (gameOver){
                break;
            }
        }
            System.out.println("Player score: "+playerScore);
            System.out.println("Computer score: "+computerScore);
            System.out.println("Vrei sa mai joci din nou ? (Y/N) ");
        input.nextLine();
        String result=input.nextLine();
        switch (result){
            case "y":
            case"Y":
                playAgain=true;
                System.out.println("Fain!Hai sa jucam !");
                resetBoard(xoxo);
                gameOver=false;

                break;
            case"N":
            case"n":
                playAgain=false;
                System.out.println("Ok!La revedere!");
                break;
            default:break;

        }
    }

    }
    public static void printLaFinal(char[][]xoxo){
        System.out.println("|"+ xoxo[0][0]+" "+xoxo[0][1]+" "+xoxo[0][2]+"|");
        System.out.println("|"+xoxo[1][0]+" "+xoxo[1][1]+" "+xoxo[1][2]+"|");
        System.out.println("|"+xoxo[2][0]+" "+xoxo[2][1]+" "+xoxo[2][2]+"|");
    }
    public static void printBoard(char [][] xoxo){

        for (char [] row:xoxo){
            System.out.print("|");
            for (char c:row){

                System.out.print(c); System.out.print("|");
            }
            System.out.println();

        }
    }
    public static void updateBoard(int position,int player,char[][]xoxo){
        char character;
        if (player==1){
            character='x';
        }else{
            character='o';
        }
        switch (position){
            case 1:
                xoxo[0][0]=character;
                printBoard(xoxo);
                break;
            case 2:
                xoxo[0][1]=character;
                printBoard(xoxo);
                break;
            case 3:
                xoxo[0][2]=character;
                printBoard(xoxo);
                break;
            case 4:
                xoxo[1][0]=character;
                printBoard(xoxo);
                break;
            case 5:
                xoxo[1][1]=character;
                printBoard(xoxo);
                break;
            case 6:
                xoxo[1][2]=character;
                printBoard(xoxo);
                break;
            case 7:
                xoxo[2][0]=character;
                printBoard(xoxo);
                break;
            case 8:
                xoxo[2][1]=character;
                printBoard(xoxo);
                break;
            case 9:
                xoxo[2][2]=character;
                printBoard(xoxo);
                break;
            default:
                break;
        }
    }
    public static void playerMove(char[][] xoxo){
        System.out.println("Te rog sa alegi pozitia (1->9.) ");


        int move=input.nextInt();

        boolean result=isValidMove(move,xoxo);
        while(!result){
            System.out.println("Sorry!Invalid move.Incearca din nou!");
            move= input.nextInt();
            result=isValidMove(move,xoxo);
        }
        System.out.println("PLayer a ales pozitia "+move);
        updateBoard(move,1,xoxo);
    }
    public static boolean isValidMove(int move,char[][]xoxo){
        switch (move){


            case 1:
                if (xoxo[0][0]==' '){
            return  true;
        }else {
            return false;
        }
            case 2:
                if (xoxo[0][1]==' '){
                    return  true;
                }else {
                    return false;
                }
            case 3:
                if (xoxo[0][2]==' '){
                    return  true;
                }else {
                    return false;
                }
            case 4:
                if (xoxo[1][0]==' '){
                    return  true;
                }else {
                    return false;
                }
            case 5:
                if (xoxo[1][1]==' '){
                    return  true;
                }else {
                    return false;
                }
            case 6:
                if (xoxo[1][2]==' '){
                    return  true;
                }else {
                    return false;
                }
            case 7:
                if (xoxo[2][0]==' '){
                    return  true;
                }else {
                    return false;
                }
            case 8:
                if (xoxo[2][1]==' '){
                    return  true;
                }else {
                    return false;
                }
            case 9:
                if (xoxo[2][2]==' '){
                    return  true;
                }else {
                    return false;
                }
            default:
                return false;
        }


    }
    public static void computerMove(char[][]xoxo){
        Random random=new Random();
        int move= random.nextInt(9)+1;
        boolean result=isValidMove(move,xoxo);
        while(!result){
            move= random.nextInt(9)+1;
            result=isValidMove(move,xoxo);

        }
        System.out.println("Computerul a ales pozitia "+move);
        updateBoard(move,2,xoxo);
    }
    public static  boolean  isGameOver(char[][]xoxo){
        //orizontal win player
        if (xoxo[0][0]=='x'&&xoxo[0][1]=='x'&&xoxo[0][2]=='x'){
            System.out.println("Playerul a castigat!");
            System.out.println("Tabel castigator este: ");
            printLaFinal(xoxo);
            playerScore++;
            return true;
        }
        if (xoxo[1][0]=='x'&&xoxo[1][1]=='x'&&xoxo[1][2]=='x'){
            System.out.println("Playerul a castigat!");
            System.out.println("Tabel castigator este: ");
            printLaFinal(xoxo);
            playerScore++;
            return true;
        }
        if (xoxo[2][0]=='x'&&xoxo[2][1]=='x'&&xoxo[2][2]=='x'){
            System.out.println("Playerul a castigat!");
            System.out.println("Tabel castigator este: ");
            printLaFinal(xoxo);
            playerScore++;
            return true;
        }
        //vertical player win
        if (xoxo[0][0]=='x'&&xoxo[1][0]=='x'&&xoxo[2][0]=='x'){
            System.out.println("Playerul a castigat!");
            System.out.println("Tabel castigator este: ");
            printLaFinal(xoxo);
            playerScore++;
            return true;
        }
        if (xoxo[0][1]=='x'&&xoxo[1][1]=='x'&&xoxo[2][1]=='x'){
            System.out.println("Playerul a castigat!");
            System.out.println("Tabel castigator este: ");
            printLaFinal(xoxo);
            playerScore++;
            return true;
        }
        if (xoxo[0][2]=='x'&&xoxo[1][2]=='x'&&xoxo[2][2]=='x'){
            System.out.println("Playerul a castigat!");
            System.out.println("Tabel castigator este: ");
            printLaFinal(xoxo);
            playerScore++;
            return true;
        }
        // diagonal player win
        if (xoxo[0][0]=='x'&&xoxo[1][1]=='x'&&xoxo[2][2]=='x'){
            System.out.println("Playerul a castigat!");
            System.out.println("Tabel castigator este: ");
            printLaFinal(xoxo);
            playerScore++;
            return true;
        }
        if (xoxo[0][2]=='x'&&xoxo[1][1]=='x'&&xoxo[2][0]=='x'){
            System.out.println("Playerul a castigat!");
            System.out.println("Tabel castigator este: ");
            printLaFinal(xoxo);
            playerScore++;
            return true;
        }






        //orizontal computer win
        if (xoxo[0][0]=='o'&&xoxo[0][1]=='o'&&xoxo[0][2]=='o'){
            System.out.println("Computerul a castigat!");
            System.out.println("Tabel castigator este: ");
            printLaFinal(xoxo);
            computerScore++;
            return true;
        }
        if (xoxo[1][0]=='o'&&xoxo[1][1]=='o'&&xoxo[1][2]=='o'){
            System.out.println("Computerul a castigat!");
            System.out.println("Tabel castigator este: ");
            printLaFinal(xoxo);
            computerScore++;
            return true;
        }
        if (xoxo[2][0]=='o'&&xoxo[2][1]=='o'&&xoxo[2][2]=='o'){
            System.out.println("Computerul a castigat!");
            System.out.println("Tabel castigator este: ");
            printLaFinal(xoxo);
            computerScore++;
            return true;
        }
        //vertical computer win
        if (xoxo[0][0]=='o'&&xoxo[1][0]=='o'&&xoxo[2][0]=='o'){
            System.out.println("Computerul a castigat!");
            System.out.println("Tabel castigator este: ");
            printLaFinal(xoxo);
            computerScore++;
            return true;
        }
        if (xoxo[0][1]=='o'&&xoxo[1][1]=='o'&&xoxo[2][1]=='o'){
            System.out.println("Computerul a castigat!");
            System.out.println("Tabel castigator este: ");
            printLaFinal(xoxo);
            computerScore++;
            return true;
        }
        if (xoxo[0][2]=='o'&&xoxo[1][2]=='o'&&xoxo[2][2]=='o'){
            System.out.println("Computerul a castigat!");
            System.out.println("Tabel castigator este: ");
            printLaFinal(xoxo);
            computerScore++;
            return true;
        }
        // diagonal computer win
        if (xoxo[0][0]=='o'&&xoxo[1][1]=='o'&&xoxo[2][2]=='o'){
            System.out.println("Computerul a castigat!");
            System.out.println("Tabel castigator este: ");
            printLaFinal(xoxo);
            computerScore++;
            return true;
        }
        if (xoxo[0][2]=='o'&&xoxo[1][1]=='o'&&xoxo[2][0]=='o'){
            System.out.println("Computerul a castigat!");
            System.out.println("Tabel castigator este: ");
            printLaFinal(xoxo);
            computerScore++;
            return true;
        }
        if (xoxo[0][0]!=' '&&xoxo[0][1]!=' '&&xoxo[0][2]!=' '&&xoxo[1][0]!=' '&&xoxo[1][1]!=' '&&
                xoxo[1][2]!=' '&&xoxo[2][0]!=' '&&xoxo[2][1]!=' '&&xoxo[2][2]!=' '){
            System.out.println("It`s a tie! NU exista fel castigator!");
        }

return false;
    }
    public static void resetBoard(char [][]xoxo){
        xoxo[0][0]=' ';
        xoxo[0][1]=' ';
        xoxo[0][2]=' ';
        xoxo[1][0]=' ';
        xoxo[1][1]=' ';
        xoxo[1][2]=' ';
        xoxo[2][0]=' ';
        xoxo[2][1]=' ';
        xoxo[2][2]=' ';
    }

}
