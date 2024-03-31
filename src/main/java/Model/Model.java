package Model;

import java.util.*;

public class Model {

    // System variables and initialization
    public boolean over;
    public boolean good = false;
    public boolean next = false; //Signifies what player has a turn
    Set<String> result;
    Set<Integer> C1 = new TreeSet<Integer>();
    Set<Integer> C2 = new TreeSet<Integer>();
    Set<Integer> F = new TreeSet<Integer>();
    Set<Integer> F1 = new TreeSet<Integer>();
    Set<Integer> F2 = new TreeSet<Integer>();
    Set<Integer> F1F2Union = new TreeSet<Integer>();
    Set<Integer> F3;

    //declare other elements that will be utilized

    public void initializeF()
    {
        for(int i=1;i<=6;i++)
        {
            for(int f=1;f<=6;f++)
            {
                F.add((i*10)+f);
            }
        }
    }

    public void systemFacts()
    {
        //FIRST SYSTEM FACT-------------------------------
        initializeF();

        F1F2Union = new TreeSet<Integer>(F1);
        F1F2Union.addAll(F2);
        F3 = new TreeSet<Integer>(F);
        F3.removeAll(F1F2Union);
        //-----------------------------------------------

        //SECOND SYSTEM FACT-----------------------------
        if(F3.isEmpty()||checkPlayerWin()!=0)
            over = true;
        else
            over = false;
        //-----------------------------------------------
    }

    public void NextPlayerMove(int a, int b)
    {
        int pos=a*10+b;
        int c = ((a-1)/3)+1;
        int d = ((b-1)/3)+1;
        int cd = (c*10)+d;
        if (!over&&next&&F3.contains(pos))
        {
            good = !good && F1.add(pos);
            next=true;
        }
        else if(!over&&!next&&F3.contains(pos))
        {
            good = !good && F2.add(pos);
            next = false;
        }

        if(!over&&good&&next&&countCompletedQuadrants()>C1.size())
        {
            C1.add(cd);
        }
        else if(!over&&good&&!next&&countCompletedQuadrants()>C2.size())
        {
            C2.add(cd);
        }

        if(!over&&good)
        {
            good = !good;
        }
    }

    public int countCompletedQuadrants()
    {
        int completedQuadrantsCount=0;
        if(next==true)
        {
            if(F1.contains(11)&&F1.contains(13)&&F1.contains(22)&&F1.contains(31)&&F1.contains(33))
            {
                completedQuadrantsCount++;
            }
            if(F1.contains(44)&&F1.contains(46)&&F1.contains(55)&&F1.contains(64)&&F1.contains(66))
            {
                completedQuadrantsCount++;
            }
            if(F1.contains(15)&&F1.contains(24)&&F1.contains(25)&&F1.contains(26)&&F1.contains(35))
            {
                completedQuadrantsCount++;
            }
            if(F1.contains(41)&&F1.contains(43)&&F1.contains(51)&&F1.contains(53)&&F1.contains(61)&&F1.contains(63))
            {
                completedQuadrantsCount++;
            }
        }
        else if(next==false)
        {
            if(F2.contains(11)&&F2.contains(13)&&F2.contains(22)&&F2.contains(31)&&F2.contains(33))
            {
                completedQuadrantsCount++;
            }
            if(F2.contains(44)&&F2.contains(46)&&F2.contains(55)&&F2.contains(64)&&F2.contains(66))
            {
                completedQuadrantsCount++;
            }
            if(F2.contains(15)&&F2.contains(24)&&F2.contains(25)&&F2.contains(26)&&F2.contains(35))
            {
                completedQuadrantsCount++;
            }
            if(F2.contains(41)&&F2.contains(43)&&F2.contains(51)&&F2.contains(53)&&F2.contains(61)&&F2.contains(63))
            {
                completedQuadrantsCount++;
            }
        }
        return completedQuadrantsCount;
    }

    public void GameOver()
    {
        result = new TreeSet<String>();
        boolean winCondition = false;

        if(checkPlayerWin()!=0)
            winCondition=true;

        if(over&&next&&winCondition)
        {
            result.add("A wins");
        }
        else if(over&&!next&&winCondition)
        {
            result.add("B wins");
        }
        else if(!over)
        {
            next = !next;
        }
    }

    public int checkPlayerWin()
    {
        if(C1.contains(11)&&C1.contains(22)||C1.contains(12)&&C1.contains(21))
        {
            System.out.println("Player 1 wins!");
            return 1;
        }
        else if(C2.contains(11)&&C2.contains(22)||C2.contains(12)&&C2.contains(21))
        {
            System.out.println("Player 2 wins!");
            return 2;
        }
        return 0;
    }

    public boolean getNext() //returns the player turn
    {
        return next;
    }

}
