public class Circle {
    
    private double x;
    private double y;
    private double radius;
    private double xPrime;
    private double yPrime;

    public Circle(double x, double y, double radius)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getRadius()
    {
        return radius;
    }

    public void moveCircle(double moveUD, double moveRL)
    {
        x = x + moveUD;
        y = y + moveRL;
    }


    public void rotateCircle(double angle)
    {
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

    public void pointAroundCircle(double angle)
    {
        //change degree to radian
        double radian = Math.toRadians(angle);

        //get the XPrime value
        xPrime = x + ((radius) * Math.cos(radian));

        //get the YPrime value
        yPrime = x + ((radius) * Math.sin(radian));

    }


    //return the value of a point in a certain angle inside a circle
    public double getPrimeX()
    {
        return xPrime;
    }

    public double getPrimeY()
    {
        return yPrime;
    }

}
