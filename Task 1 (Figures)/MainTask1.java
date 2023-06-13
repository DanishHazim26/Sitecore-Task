import java.util.*;
import java.text.DecimalFormat;

public class MainTask1 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        DecimalFormat dF = new DecimalFormat("#.00");
        

        //ask user which do you want to start
        String condition;
        System.out.print("\nDo you want to start? (Y for yes / N for no) : ");
        condition = sc.next();

        while (condition.equalsIgnoreCase("Y"))
        {
            //ask which figure to use
            System.out.print("\nP for Point \nL for Line \nC for Circle" );
            System.out.print("\nEnter the figure that you want to use : " );
            String figureType = sc.next();

            if(figureType.equalsIgnoreCase("P"))
            {
                //for Line

                //user enter the point
                System.out.print("\nEnter point for Point : ");

                System.out.print("\nX : " );
                int X = sc.nextInt();
        
                System.out.print("Y : ");
                int Y = sc.nextInt();

                //declare class of Point 
                Point p1 = new Point(X,Y);

                ///prompt the task
                String startTask = "Y";

                while(startTask.equalsIgnoreCase("Y"))
                {
                    //prompt the task
                    System.out.print("\nM for move \nR for Rotate ");
                    System.out.print("\nChoose type of Task : ");
                    String task = sc.next();

                    if(task.equalsIgnoreCase("M"))
                    {
                        // Move the point by (1, 1)
                        System.out.print("\nNegative Value represents the Opposite Direction. For example, to move to the Left, please input '-4'. It move the point to the left for the distance of 4.");
                        System.out.print("\n\nEnter value to Move Right or Left : ");
                        int m1 = sc.nextInt();

                        System.out.print("\nEnter value to Move Up or Down : ");
                        int m2 = sc.nextInt();

                        //called the move function
                        p1.move(m1,m2);
                        System.out.print("\nNew coordinates of P1 after moving: (" + dF.format(p1.getX()) + ", " + dF.format(p1.getY()) + ")");
                    }

                    else if(task.equalsIgnoreCase("R"))
                    {
                        //enter the degree of the point
                        System.out.print("\n\nEnter angle value to Rotate the Point : ");
                        double angleRotate = sc.nextDouble();

                       //called the rotate function
                        p1.rotate(angleRotate);
         
                        System.out.print("\nNew coordinates of P1 after rotating: (" + dF.format(p1.getX()) + ", " + dF.format(p1.getY()) + ")");
                    }

                    else
                    {
                        System.out.print("\nWrong input ! ");
                    }

                    System.out.print("\nDo you want to continue? (Y / N) : ");
                    startTask = sc.next();
                }
                

                
            }

            else if(figureType.equalsIgnoreCase("L"))
            {
                //for Point

                System.out.print("\nEnter START Point for the Line : ");

                System.out.print("\nX : " );
                double XStart = sc.nextDouble();
        
                System.out.print("Y : ");
                double YStart = sc.nextDouble();

                System.out.print("\nEnter END Point for the Line : ");

                System.out.print("\nX : " );
                double XEnd = sc.nextDouble();
        
                System.out.print("Y : ");
                double YEnd = sc.nextDouble();

                //called the Line Class
                Line L1 = new Line(XStart, YStart, XEnd, YEnd);

                //prompt the task
                String startTask = "Y";

                while(startTask.equalsIgnoreCase("Y"))
                {
                    //prompt the task
                    System.out.print("\nM for move \nR for Rotate ");
                    System.out.print("\nChoose type of Task : ");
                    String task = sc.next();

                    if(task.equalsIgnoreCase("M"))
                    {
                        System.out.print("\nNegative Value represents the Opposite Direction. For example, to move to the Left, please input '-4'. It move the point to the left for the distance of 4.");
                        System.out.print("\n\nEnter value to Move Right or Left : ");
                        int Lmove1 = sc.nextInt();

                        System.out.print("\nEnter value to Move Up or Down : ");
                        int Lmove2 = sc.nextInt();

                        L1.moveLine(Lmove1, Lmove2);
                        System.out.print("\nNew coordinates of L1 after moving: \nStart Point (" + dF.format(L1.getStartX()) + ", " + dF.format(L1.getStartY()) + ")" + "\nEnd Point (" + dF.format(L1.getEndX()) + ", " + dF.format(L1.getEndY()) + ")");
                    }

                    else if(task.equalsIgnoreCase("R"))
                    {
                        //enter the degree of the point
                        System.out.print("\n\nEnter angle value to Rotate the Line : ");
                        double LineRotate = sc.nextDouble();
 
                        //called the rotate function
                        L1.rotatLine(LineRotate);
                        System.out.print("\nNew coordinates of L1 after moving: \nStart Point (" + dF.format(L1.getStartX()) + ", " + dF.format(L1.getStartY()) + ")" + "\nEnd Point (" + dF.format(L1.getEndX()) + ", " + dF.format(L1.getEndY()) + ")");
                    }

                    else
                    {
                        System.out.print("\nWrong input ! ");
                    }

                    System.out.print("\nDo you want to continue? (Y / N) : ");
                    startTask = sc.next();
                }
            }

            else if(figureType.equalsIgnoreCase("C"))
            {
                //for Circle

                //user enter the point
                System.out.print("\nEnter Center Point for Circle : ");

                System.out.print("\nX : " );
                double X = sc.nextDouble();
        
                System.out.print("Y : ");
                double Y = sc.nextDouble();

                System.out.print("Radius : ");
                double Radius = sc.nextDouble();

                //declare class of Point 
                Circle C1 = new Circle(X,Y, Radius);

                //prompt the task
                String startTask = "Y";

                while(startTask.equalsIgnoreCase("Y"))
                {
                    //prompt the task
                    System.out.print("\nM for move \nR for Rotate \nG for getting a Point value along the circle ");
                    System.out.print("\nChoose type of Task : ");
                    String task = sc.next();

                    if(task.equalsIgnoreCase("M"))
                    {
                        System.out.print("\nNegative Value represents the Opposite Direction. For example, to move to the Left, please input '-4'. It move the point to the left for the distance of 4.");
                        System.out.print("\n\nEnter value to Move Right or Left : ");
                        double Cmove1 = sc.nextDouble();

                        System.out.print("\nEnter value to Move Up or Down : ");
                        double Cmove2 = sc.nextDouble();

                        C1.moveCircle(Cmove1, Cmove2);
                        System.out.print("\nNew coordinates for the Center Point : (" + dF.format(C1.getX()) + ", " + dF.format(C1.getY()) + ")");
                    }

                    else if(task.equalsIgnoreCase("R"))
                    {
                        //enter the degree of the point
                        System.out.print("\n\nEnter angle value to Rotate the Line : ");
                        double CRotate = sc.nextDouble();
 
                        //called the rotate function
                        C1.rotateCircle(CRotate);
                        System.out.print("\nNew coordinates for the Center Point : (" + dF.format(C1.getX()) + ", " + dF.format(C1.getY()) + ")");
                    }

                    else if(task.equalsIgnoreCase("G"))
                    {
                        //enter the degree of the point
                        System.out.print("\n\nEnter angle value to the Point : ");
                        double CValue = sc.nextDouble();
 
                        //called the rotate function
                        C1.pointAroundCircle(CValue);
                        System.out.print("\nCoordinates for the Point : (" + dF.format(C1.getPrimeX()) + ", " + dF.format(C1.getPrimeY()) + ")");
                    }

                    else
                    {
                        System.out.print("\nWrong input ! ");
                    }

                    System.out.print("\nDo you want to continue? (Y / N) : ");
                    startTask = sc.next();
                }

            }

            System.out.print("\nDo you want to Continue? (Y for yes / N for no) : ");
            condition = sc.next();


        }
        
    }


}



