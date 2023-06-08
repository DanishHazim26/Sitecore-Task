import java.util.Scanner;

public class Aggregation{

    //take random number for Circle, Line and Points
    private int RanP;
    private int RanL;
    private int RanC;

    //initialize the array
    Point[] points;
    Line[] pointLine;
    Circle[] circlePoint;

    public Aggregation(int RanP, int RanL, int RanC)
    {
        this.RanP = RanP;
        this.RanL = RanL;
        this.RanC = RanC;
    }

    public void TaskStore()
    {
        Scanner sc = new Scanner(System.in);
        //ask for a point value
        //repeat based on random value generated

        points = new Point[RanP];
        pointLine = new Line[RanL];
        circlePoint = new Circle[RanC];

        //enter for Line
        if (RanP == 0)
        {
            System.out.print("No Point involved !");
        }

        else
        {
            
            for(int i = 0; i < RanP ; i++)
            {
                System.out.print("\nPoint " + (i+1) + " : ");
                System.out.print("\nX : " );
                double x = sc.nextDouble();

                System.out.print("Y : " );
                double y = sc.nextDouble();

                //save to the classs
                points[i] = new Point(x,y);

            }
        }

 

        //enter for Line
        if (RanL == 0)
        {
            System.out.print("No Line involved !");
        }

        else
        {
            
            for(int i = 0; i < RanL ; i++)
            {
                System.out.print("\nStart Point " + (i+1) + " : ");
                System.out.print("\nX : " );
                double xStart = sc.nextDouble();

                System.out.print("Y : " );
                double yStart = sc.nextDouble();

                System.out.print("\nEnd Point " + (i+1) + " : ");
                System.out.print("\nX : " );
                double xEnd = sc.nextDouble();

                System.out.print("Y : " );
                double yEnd = sc.nextDouble();

                //save to the classs
                pointLine[i] = new Line(xStart,yStart,xEnd,yEnd);

            }
        }

        //enter for Line
        if (RanC == 0)
        {
            System.out.print("No Circle involved !");
        }

        else
        {
            
            for(int i = 0; i < RanC ; i++)
            {
                System.out.print("\nCenter Point " + (i+1) + " : ");
                System.out.print("\nX : " );
                double x = sc.nextDouble();

                System.out.print("Y : " );
                double y = sc.nextDouble();

                System.out.print("\nRadius " + (i+1) + " : ");
                double radius = sc.nextDouble();

                //save to the classs
                circlePoint[i] = new Circle(x,y,radius);

            }
        }
    }


    public void moveAll(double moveUD, double moveRL)
    {
        if(checkNumber(RanP))
        {
            for(int i = 0 ; i < RanP ; i++)
            {
                points[i].move(moveUD, moveRL);
                System.out.print("\nPoint " + (i+1) + " : (" + points[i].getX() + "," + points[i].getY() + ")");
            }
        }

        if(checkNumber(RanL))
        {
            for(int i = 0 ; i < RanL ; i++)
            {
                pointLine[i].moveLine(moveUD, moveRL);
                System.out.print("\n\nNew coordinates of Line " + (i+1) + " after moving: \nStart Point (" + pointLine[i].getStartX() + ", " + pointLine[i].getStartY() + ")" + "\nEnd Point (" + pointLine[i].getEndX() + ", " + pointLine[i].getEndY() + ")");
            }
        }

        if(checkNumber(RanC))
        {
            for(int i = 0 ; i < RanC ; i++)
            {
                circlePoint[i].moveCircle(moveUD, moveRL);
                System.out.print("\n\nNew coordinates for the Center Point : (" + circlePoint[i].getX() + ", " + circlePoint[i].getY() + ")");
            }
        }
        
    }


    public void rotateAll(double angle)
    {
        if(checkNumber(RanP))
        {
            for(int i = 0 ; i < RanP ; i++)
            {
                points[i].rotate(angle);
                System.out.print("\nPoint " + (i+1) + " : (" + points[i].getX() + "," + points[i].getY() + ")");
            }
        }

        if(checkNumber(RanL))
        {
            for(int i = 0 ; i < RanL ; i++)
            {
                pointLine[i].rotatLine(angle);
                System.out.print("\n\nNew coordinates of L1 after rotate: \nStart Point (" + pointLine[i].getStartX() + ", " + pointLine[i].getStartY() + ")" + "\nEnd Point (" + pointLine[i].getEndX() + ", " + pointLine[i].getEndY() + ")");
            }
        }

        if(checkNumber(RanC))
        {
            for(int i = 0 ; i < RanC ; i++)
            {
                circlePoint[i].rotateCircle(angle);
                System.out.print("\n\nNew coordinates for the Center Point : (" + circlePoint[i].getX() + ", " + circlePoint[i].getY() + ")");
            }
        }
        
    }



    public boolean checkNumber(int ranValue)
    {
        //to check if the random value is 0 or not
        if(ranValue == 0)
            return false;
        else
            return true;
    }
}