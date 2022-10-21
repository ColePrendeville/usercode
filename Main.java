import java.util.Scanner;
public class Main {
static String character = "";
static String[][] gameBoard = new String[5][5];
static int turnCounter = 0;
static int monsterY = 0;
static int charY = 0;
static int monsterX = 0;
static int charX = 0;
static int rounds = 0;
    public static void main(String[] args) {
        
        characterSelect();
        makeGameBoard();
        printBoard();
        for(int i = 0; i < rounds ; i++)
        {
            turnCounter = i+1;
            playerMove();
            monsterMove();
            printBoard();
            isGameFishished();
        }
        wellPlayed();

    }
        public static void characterSelect()
        {
            Scanner userInput = new Scanner(System.in);
            System.out.println("Would you like to be an (1)X or an (2)O.");
            int menuChoice = userInput.nextInt();
                if(menuChoice ==1)
                {
                character = "X";
                System.out.println("Pefect, your character is marked by the letter: "+character);
                }
                else if(menuChoice ==2)
                {
                character = "O";
                System.out.println("Pefect, your character is marked by the letter: "+character);
                }
                else 
                {
                    characterSelect();
                }
            System.out.println("How many rounds would you like to run from the Monster for?");
            rounds = userInput.nextInt();
                System.out.println("Rocks are marked by R, Monsters are marked by M. Survive the Monsters for "+rounds+" turns and you win the game!");
        }
            public static void makeGameBoard()
            {
                int rockChance = 0;
                for(int row = 0; row<gameBoard.length;row++)
                    {
                        for(int col = 0; col<gameBoard[0].length;col++)
                            {
                              rockChance = (int)(Math.random()*10)+1;
                                if(rockChance>2)
                                {
                                    gameBoard[row][col] = " ";
                                }
                                else if(rockChance<=2)
                                {
                                    gameBoard[row][col] = "R";
                                }
                            }
                    }
                monsterY=(int)(Math.random())*3+1;
                monsterX=(int)(Math.random())*3+1;
                gameBoard[monsterY][monsterX] = "M";

                charY= (int)(Math.random())*2+3;
                charX= (int)(Math.random())*2+3;
                gameBoard[charY][charX] = character;

            }
                    public static void printBoard()
                        {
                            System.out.println(" ___________________");
                            System.out.println("|_"+gameBoard[0][0]+"_|_"+gameBoard[0][1]+"_|_"+gameBoard[0][2]+"_|_"+gameBoard[0][3]+"_|_"+gameBoard[0][4]+"_|");
                            System.out.println("|_"+gameBoard[1][0]+"_|_"+gameBoard[1][1]+"_|_"+gameBoard[1][2]+"_|_"+gameBoard[1][3]+"_|_"+gameBoard[1][4]+"_|");
                            System.out.println("|_"+gameBoard[2][0]+"_|_"+gameBoard[2][1]+"_|_"+gameBoard[2][2]+"_|_"+gameBoard[2][3]+"_|_"+gameBoard[2][4]+"_|");
                            System.out.println("|_"+gameBoard[3][0]+"_|_"+gameBoard[3][1]+"_|_"+gameBoard[3][2]+"_|_"+gameBoard[3][3]+"_|_"+gameBoard[3][4]+"_|");
                            System.out.println("|_"+gameBoard[4][0]+"_|_"+gameBoard[4][1]+"_|_"+gameBoard[4][2]+"_|_"+gameBoard[4][3]+"_|_"+gameBoard[4][4]+"_|");
                        }
           public static void playerMove()
            {
                Scanner userInput = new Scanner(System.in);
                System.out.println("Turn "+turnCounter+"/"+rounds);
                System.out.println("Which direction would you like to move?");
                System.out.println("        Up(1)");
                System.out.println("Left(2)     Right(3)");
                System.out.println("       Down(4)");
                int menuChoice = userInput.nextInt();
                if(menuChoice == 1)
                    {
                        if(charY - 1 < 0)
                        { 
                           System.out.println("You have to stay in the board!");  
                        }
                        else {
                            
                        
                        if(gameBoard[charY-1][charX].equals("R"))
                        {
                            System.out.println("You cant travel through rocks!");
                            
                        }
                        else if(gameBoard[charY-1][charX].equals("M"))
                        {
                            System.out.println("Your Dead!");
                            
                        }
                        else 
                        {
                        gameBoard[charY][charX] = " ";
                        charY = charY - 1;
                        gameBoard[charY][charX] = character;
                        }
                        
                    }
                    }
                else if(menuChoice == 2)
                    {
                        if(charX - 1 < 0 )
                        {
                            System.out.println("You have to stay in the board!");
                        }
                        else {
                            
                        
                        if(gameBoard[charY][charX-1].equals("R"))
                        {
                            System.out.println("You cant travel through rocks!");
                            
                        }
                        else if(gameBoard[charY][charX-1].equals("M"))
                        {
                            System.out.println("Your Dead!");
                            
                        }
                        else 
                        {
                        gameBoard[charY][charX] = " ";
                        charX = charX - 1;
                        gameBoard[charY][charX] = character;
                        }
                        
                    }
                    }
                else if(menuChoice == 3)
                    {
                        if(charX + 1 >4 )
                        {
                            System.out.println("You have to stay in the board!");
                        }
                        else {
                            
                        
                        if(gameBoard[charY][charX+1].equals("R"))
                        {
                            System.out.println("You cant travel through rocks!");
                            
                        }
                        else if(gameBoard[charY][charX+1].equals("M"))
                        {
                            System.out.println("Your Dead!");
                            
                        }
                        else 
                        {
                            gameBoard[charY][charX] = " ";
                        charX = charX + 1;
                        gameBoard[charY][charX] = character;
                        } 
                        }
                        
                        
                    }
                else if(menuChoice == 4)
                    {
                        if(charY + 1 >4 )
                        {
                            System.out.println("You have to stay in the board!");
                        }
                        else {
                            
                        
                        if(gameBoard[charY+1][charX].equals("R"))
                        {
                            System.out.println("You cant travel through rocks!");
                            
                        }
                        else if(gameBoard[charY+1][charX].equals("M"))
                        {
                            System.out.println("Your Dead!");
                            
                        }
                        else 
                        {
                        gameBoard[charY][charX] = " ";
                        charY = charY + 1;
                        gameBoard[charY][charX] = character;   
                        }
                    }
                    }
            }
        public static void monsterMove()
            {
                int chance = 0;
            if(monsterY<charY && monsterX<charX)
                {
                    chance = (int)((Math.random())*2)+1;
                    
                    if(chance == 1)
                    {
                        gameBoard[monsterY][monsterX] = " ";
                        monsterY = monsterY + 1;
                        gameBoard[monsterY][monsterX] = "M";
                    }
                    else if(chance == 2)
                    {
                        gameBoard[monsterY][monsterX] = " ";
                        monsterX = monsterX + 1;
                        gameBoard[monsterY][monsterX] = "M"; 
                    }
                }
            else if(monsterY>charY && monsterX<charX)
                {
                    chance = (int)((Math.random())*2)+1;
                    
                    if(chance == 1)
                    {
                        gameBoard[monsterY][monsterX] = " ";
                        monsterY = monsterY - 1;
                        gameBoard[monsterY][monsterX] = "M";
                    }
                    else if(chance == 2)
                    {
                        gameBoard[monsterY][monsterX] = " ";
                        monsterX = monsterX + 1;
                        gameBoard[monsterY][monsterX] = "M"; 
                    }
                }
            else if(monsterY>charY && monsterX>charX)
                {
                    chance = (int)((Math.random())*2)+1;
                    
                    if(chance == 1)
                    {
                        gameBoard[monsterY][monsterX] = " ";
                        monsterY = monsterY - 1;
                        gameBoard[monsterY][monsterX] = "M";
                    }
                    else if(chance == 2)
                    {
                        gameBoard[monsterY][monsterX] = " ";
                        monsterX = monsterX - 1;
                        gameBoard[monsterY][monsterX] = "M"; 
                    }
                }
            else if(monsterY<charY && monsterX>charX)
                {
                    chance = (int)((Math.random())*2)+1;
                    System.out.println(chance);
                    if(chance == 1)
                    {
                        gameBoard[monsterY][monsterX] = " ";
                        monsterY = monsterY + 1;
                        gameBoard[monsterY][monsterX] = "M";
                    }
                    else if(chance == 2)
                    {
                        gameBoard[monsterY][monsterX] = " ";
                        monsterX = monsterX - 1;
                        gameBoard[monsterY][monsterX] = "M"; 
                    }
                }
            else if(monsterY == charY && monsterX<charX)
            {
                    gameBoard[monsterY][monsterX] = " ";
                        monsterX = monsterX + 1;
                        gameBoard[monsterY][monsterX] = "M";
            }
             else if(monsterX == charX && monsterY<charY)
            {
                    gameBoard[monsterY][monsterX] = " ";
                        monsterY = monsterY + 1;
                        gameBoard[monsterY][monsterX] = "M";
            }
            else if(monsterY == charY && monsterX>charX)
            {
                    gameBoard[monsterY][monsterX] = " ";
                        monsterX = monsterX - 1;
                        gameBoard[monsterY][monsterX] = "M";
            }
             else if(monsterX == charX && monsterY>charY)
            {
                    gameBoard[monsterY][monsterX] = " ";
                        monsterY = monsterY - 1;
                        gameBoard[monsterY][monsterX] = "M";
            }
                

            }
            public static void isGameFishished()
            {
                if(gameBoard[charY][charX].equals("M"))
                {
                    System.out.println("The Monster got you slow poke!!!");
                    System.out.println("You survived for only "+turnCounter+" turns. Pathetic loser");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                    System.exit(0);
                }
            }
            public static void wellPlayed()
            {
                System.out.println("You survived the Monster.");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                gameBoard[monsterY][monsterX] = "N";
                delay();
                printBoard();
                System.out.println("You survived the Monster.");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                gameBoard[monsterY][monsterX] = "I";
                delay();
                printBoard();
                System.out.println("You survived the Monster.");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                gameBoard[monsterY][monsterX] = ":";
                delay();
                printBoard();
                System.out.println("You survived the Monster.");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                gameBoard[monsterY][monsterX] = "'";
                delay();
                printBoard();
                System.out.println("You survived the Monster.");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                gameBoard[monsterY][monsterX] = " ";
                delay();
                printBoard();
                System.out.println("You survived the Monster. Congrats!!");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                
            }
            private static void delay()

            {
                try
                    {

                Thread.sleep(750);
            } catch (InterruptedException e)

            {
                e.printStackTrace();

            }


}
}
