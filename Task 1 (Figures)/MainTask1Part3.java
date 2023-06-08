import java.util.*;

public class MainTask1Part3 {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        //generate random number of Point, Line and Circle
        Random rand = new Random();
        int randomPoint = rand.nextInt(3);
        int randomLine = rand.nextInt(3);
        int randomCircle = rand.nextInt(3);


        Aggregation aggr = new Aggregation(randomPoint, randomLine, randomCircle);

        aggr.TaskStore();

        System.out.print("/nEnter move value for Up Down : ");
        double moveUD = sc.nextDouble();

        System.out.print("/nEnter move value for Left Right : ");
        double moveLR = sc.nextDouble();

        System.out.print("/nEnter rotate value in degree : ");
        double angle = sc.nextDouble();

        aggr.moveAll(moveUD, moveLR);

        aggr.rotateAll(angle);


    }
}
