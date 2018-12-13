import java.util.Scanner;
class Cricket
{
    static Scanner in = new Scanner(System.in);
    static int play;
    static int r ;
    int score=0;
    int target ;
    static Cricket player = new Cricket();
    static Cricket comp = new Cricket();
    static int choice;
    static boolean bowlFirst = false;
    static boolean batFirst = false;

    static void batting()
    {
        System.out.println("You are batting");

        for(;;)
        {

            System.out.println("Enter:");
            play=in.nextInt();
            r = (int)((Math.random()*(10-1)+1));
            System.out.print(" "+r+"\n");

            if(play>10)
            {
                System.out.println("\t\t\t\tYou need enter a number less than"+
                    " or equal to 10.");
                continue;
            }

            if(r==play)
            {
                System.out.println("\t\t\t\tYou're out!");
                break;
            }

            player.score=player.score+play;

            if(player.score>=player.target && player.target!=0)
                break;

        }
        if(r==play && batFirst)
        {
            System.out.println("\t\t\t\tYou scored "+player.score+" runs.");
            System.out.println("\t\t\t\tMy target : "+(player.score+1));
            comp.target=player.score+1;
            bowling();
        }
        else if(player.score>=player.target && player.target!=0)
        {
            System.out.println("\t\t\t\tYou scored "+player.score+" runs.");
            System.out.println("\t\t\t\tYour target : "+player.target);
            System.out.println("\t\t\t\tSo... YOU WIN!!!!");
        }
        else
        {
            System.out.println("\t\t\t\tYou scored "+player.score+" runs.");
            System.out.println("\t\t\t\tYour target : "+player.target);
            System.out.println("\t\t\t\tSo...YOU LOSE!!!! Muhahaha.");

        }

    }

    static void bowling()
    {
        System.out.println("You are bowling");

        for(;;)
        {

            System.out.println("Enter:");
            play=in.nextInt();
            r = (int)((Math.random()*(10-1)+1));
            System.out.print(" "+r+"\n");

            if(play>10)
            {
                System.out.println("\t\t\t\tYou need enter a number less than"+
                    " or equal to 10.");
                continue;
            }

            if(r==play)
            {
                System.out.println("\t\t\t\tI'm out :_(");
                break;
            }

            comp.score=comp.score+r;

            if(comp.score>=comp.target && comp.target!=0)
                break;

        }
        if(r==play && bowlFirst)
        {
            System.out.println("\t\t\t\tI scored "+comp.score+" runs.");
            System.out.println("\t\t\t\tYour target : "+(comp.score+1));
            player.target=comp.score+1;
            batting();
        }
        else if(comp.score>=comp.target && comp.target!=0)
        {
            System.out.println("\t\t\t\tI scored "+comp.score+" runs.");
            System.out.println("\t\t\t\tMy target : "+comp.target);
            System.out.println("\t\t\t\tSo... YOU LOSE!!!! Hehehe");
        }
        else
        {
            System.out.println("\t\t\t\tI scored "+comp.score+" runs.");
            System.out.println("\t\t\t\tMy target : "+comp.target);
            System.out.println("\t\t\t\tSo...YOU WIN!!!!");

        }

    }

    public static void main()
    {
        for(;;){
            System.out.println("\t\t\t\tTOSS\n");
            System.out.println("\t\t\t\t1.Odd");
            System.out.println("\t\t\t\t2.Even");
            choice  = in.nextInt();
            if(choice>2 || choice<1){
                System.out.println("\t\t\t\tYou need to enter a number between 1 and 2");
                continue;

            }
            else
                break;
        }
        for(;;)
        {
            System.out.println("Enter:");
            play = in.nextInt();

            if(play>10){
                System.out.println("\t\t\t\tYou need to enter a number less than 10");
                continue;

            }
            else
                break;

        }
        r = (int)(Math.random()*(10-1)+1);
        System.out.print(" "+r+"\n");
        System.out.println(play+"+"+r+"="+(play+r));

        int toss;
        if((play + r)%2==0)
        {
            toss = 2;
        }
        else
            toss = 1;

        if(toss == choice)
        {
            for(;;){
                System.out.println("\t\t\t\tWhat do you choose ? ");
                System.out.println("\t\t\t\t1.Batting");
                System.out.println("\t\t\t\t2.Bowling");
                choice = in.nextInt();
                if(choice>2 || choice<1){
                    System.out.println("\t\t\t\tYou need to enter a number between 1 and 2");
                    continue;

                }
                else
                    break;
            }

            switch (choice)
            {
                case 1 :batFirst = true;
                batting();

                break;

                case 2 :bowlFirst = true;
                bowling();

            }
        }
        else
        {
            r = (int)((Math.random()*(2-1)+1));
            System.out.print("\t\t\t\tI choose ");

            if(r==1){
                System.out.println("batting");
                bowlFirst=true;
                bowling();
            }

            else{
                System.out.println("bowling");
                batFirst=true;
                batting();
            }
        }

    }
}