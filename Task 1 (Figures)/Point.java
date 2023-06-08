import java.lang.Math;

class Point {

    private double x;
    private double y;
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    //function to move the Point
    public void move(double moveRL, double moveUD) {
        //move either right or left
        x = x + moveRL;
        //move either up and down
        y = y + moveUD;
    }


    //function to Rotate the Point
    public void rotate(double angle) {

        //change degree to radian
        double radian = Math.toRadians(angle);
        //find the new value of X
        double xPrime = x * Math.cos(radian) - y * Math.sin(radian);
        //find the new value of Y
        double yPrime = x * Math.sin(radian) + y * Math.cos(radian);

        //initialize back to x and y
        x = xPrime;
        y = yPrime;
    }

    
}


