public class Line {
    
    private double startX;
    private double startY;
    private double endX;
    private double endY;

    public Line(double startX, double startY, double endX, double endY )
    {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public double getStartX()
    {
        return startX;
    }

    public double getStartY()
    {
        return startY;
    }

    public double getEndX()
    {
        return endX;
    }

    public double getEndY()
    {
        return endY;
    }


    public void moveLine(double moveUD, double moveRL)
    {
        //move the X axis
        startX = startX + moveUD;
        endX = endX + moveUD;

        //move the Y axis
        startY = startY + moveUD;
        endY = endY + moveUD;
    }

    //this function rotate both start and end point
    public void rotatLine(double angle)
    {
        //change degree to radian
        double radian = Math.toRadians(angle);
        //find the new value of start X
        double xStartPrime = startX * Math.cos(radian) - startY * Math.sin(radian);
        //find the new value of start Y
        double yStartPrime = startX * Math.sin(radian) + startY * Math.cos(radian);

        //initialize back to start point of x and y
        startX = xStartPrime;
        startY = yStartPrime;


        //find the new value of start X
        double xEndPrime = endX * Math.cos(radian) - endY * Math.sin(radian);
        //find the new value of start Y
        double yEndPrime = endX * Math.sin(radian) + endY * Math.cos(radian);

        //initialize back to start point of x and y
        endX = xEndPrime;
        endY = yEndPrime;

    }


}
