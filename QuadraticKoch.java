//UPDATED VERSION 

/*************************************************************************
 * Compilation: javac QuadraticKoch.java
 * Execution: java QuadraticKoch n
 *
 * @author Jeremy Hui
 *
 *************************************************************************/


 public class QuadraticKoch { 

    /*
     * Gets the set of coordinates to draw one segment of the Quadratic Koch Curve.
     * Returns the coordinates in a 2D array of doubles in the following format:
     * {array of x-coordinates,
     * array of y-coordinates}
     * 
     * @param x0 the x-coordinate of one endpoint
     * @param y0 the y-coordinate of one endpoint
     * @param x5 the x-coordinate of the other endpoint
     * @param y5 the y-coordinate of the other endpoint
     * @return the set of coordinates to draw one segment of the Quadratic Koch
     *         Curve
     */
    public static double[][] getCoords(double x0, double y0, double x5, double y5) {
        

        //make a 2d matrxi and update the matrix values with x0,y0,x5,y5

        double[][] matrix = new double[2][6];


        //the updating part 
        matrix[0][0] = x0;
        matrix[1][0] = y0;

        //the updating part 

        matrix[0][5] = x5;
        matrix[1][5] = y5;
        

        //find the change in x and y 
        //this makes sure you can use your values

        double xdelta = (x5 - x0); 
        double ydelta = (y0 - y5); 

        //find the absolute ma of the boh 
        //double d3 is d/3.0


 double d = Math.max(Math.abs(xdelta), Math.abs(ydelta)); // one will be 0, other will be some value, 
        double d3 = d/3.0;

        //initializing all the varioables 
        //make sure i incluse x1, y1, y2, y3, y4...
        double x1, y1, x2, y2, x3, y3, x4, y4;
//finding the horizontal, using the math.absolute 
        if (d == Math.abs(xdelta))
        {
            //first find the top edge
            // x 1 = x0+d3 is the top edge 
        //then x2 = x1
        //x3 = x2+d3 because you need ot update d2 
        //then starting at x4= x3


            if (xdelta > 0) 
            //if xDeltal is greater 0
            {
                x1 = x0 + d3; 
                x2 = x1; 
                x3 = x2 + d3; 
                x4 =  x3; 

                //do the same thing as x0,
                //UGH WHY ISNT THIS FWORKNG

         y1 = y0; 

                //mised this sotp 
                y2 = y0 + d3; 
                y3 = y2; 

                //update y4 to be y0 because ou want to start trom the same 
                y4 = y0; 
            }
        else // bottom edge
            {
                x1 = x0 - d3;
                x2 = x1;
                x3 = x2 - d3;
                x4 = x3;

                y1 = y0;
                y2 = y0 - d3; 
                
                
                //this is the downward spike 

                y3 = y2;
                y4 = y0;
            }
        }
        else // vertical
        {
            if (ydelta > 0) 
            //moving the right edge 
            //if the yedge isnt 0
            {
                //update the y1 value to be the inital value of y to y0-d3

                //continu with the same process burh 

                y1 = y0 - d3; 

                //STYA HERE 
                y2 = y1; 

                //move again
     y3 = y2 - d3; //fix this 


        y4 =  y3; 

                        x1 = x0;
                        //if the x1 =x0
                        x2 = x0 + d3;

                        //keep doing what you done before 

                        //omg 
                        //i cant even 
                        //this sassignment is ass



                        x3 = x2;

                        //ok do the same thing what you did for y0
                        x4 = x0;
            }
            else // left edge
            {
                y1 = y0 + d3; // move up
                y2 = y1; // stay
                y3 = y2 + d3; // move up
                y4 = y3; // stay

                x1 = x0;

                //MAKE SURE THiS S THE LEFTWARD SPIKE 
                //update the values like before again. 
                x2 = x0 - d3; 
                x3 = x2;
                x4 = x0;
            }
        }

        //after updatng all the value, append them to the matrix 
        //each coordiante of the 2d matrix 


        //update: 
        matrix[0][1] = x1;


        matrix[1][1] = y1;

        matrix[0][2] = x2;

        matrix[1][2] = y2;

        matrix[0][3] = x3;


        matrix[1][3] = y3;


        matrix[0][4] = x4;

        matrix[1][4] = y4;


        //return the matrix 

        return matrix;
    }

    /**
     * Gets the set of coordinates from getCoords() to draw the snowflake,
     * and calls Koch on two adjacent array indices with n being one less.
     * The method draws a line between the two endpoints if n == 0.
     * 
     * @param x0 the x-coordinate of one endpoint
     * @param y0 the y-coordinate of one endpoint
     * @param x5 the x-coordinate of the other endpoint
     * @param y5 the y-coordinate of the other endpoint
     * @param n  The current order
     */
    public static void koch(double x0, double y0, double x5, double y5, int n) {
        if (n == 0) {

            //base case if the STddraw is x0,y0,x5,y5

            StdDraw.line(x0, y0, x5, y5);

            return;
        } 
        else{

            double[][] matrix = getCoords(x0, y0, x5, y5);
//called the get coords to update the getCoords array with the inputs of x0,y0,x5,y5

            double x1 = matrix[0][1];

            //update all values
            double y1 = matrix[1][1];
            double x2 = matrix[0][2];
            double y2 = matrix[1][2];

            //more values
            double x3 = matrix[0][3];
            double y3 = matrix[1][3];
            //agian SIGH WHAT IS THIS SHIT 
            double x4 = matrix[0][4];
            double y4 = matrix[1][4];


            //calling the koch function 
            //what a werid ahh name wtf is tha t
         koch(x0,y0,x1,y1,n-1);
         koch(x1,y1,x2,y2,n-1);
         koch(x2,y2,x3,y3,n-1);

            //more 
                 koch(x3,y3,x4,y4,n-1);

                 //i cant with thi shit 
             koch(x4,y4,x5,y5,n-1);
        }   

    }

    /**
     * Takes an integer command-line argument n,
     * and draws a Quadratic Koch Curve of order n in a 1 x 1 canvas
     * with an initial square side length of 0.5.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        //add input value 
        //update x0,1,2,3,y,0,1,2,3,
        //and drawthe dam snow



        int z = Integer.parseInt(args[0]);
        double x0 = 0.25, y0 = 0.25;
        double x1 = 0.25, y1 = 0.75;
        double x2 = 0.75, y2 = 0.75;
        double x3 = 0.75, y3 = 0.25;
        koch(x0, y0, x1, y1, z);  
        koch(x1, y1, x2, y2, z); 
        koch(x2, y2, x3, y3, z);  
        koch(x3, y3, x0, y0, z);  

    }
} 