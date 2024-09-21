//Timothy Pham
//Period 4
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Zipline
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(new File("ziplineSample.txt")); //Scanner to scan thru the text file (CHANGE THE NAME TO CHANGE THE FILE TO SCAN)
        int testCases = scanner.nextInt(); //sets the first int as the num of test cases
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) //loop to iterate thru the test cases
        {
            int ziplines = scanner.nextInt(); //scans the nextInt to set the num of ziplines
            int ziplineLength = scanner.nextInt(); //scans the nextInt to set the length of each zipline
            scanner.nextLine();

            int[][] intervals = new int[ziplines][]; //matrix so we can iterate thru the ziplines
            for (int x = 0; x < ziplines; x++) //loop to iterate thru rows
            {
                int numIntervals = scanner.nextInt(); //scans the nextInt to get the num of intervals
                intervals[x] = new int[2 * numIntervals]; //sets the row length of the matrix according to the intervals
                for (int y = 0; y < 2 * numIntervals; y++) //loop to iterate thru cols
                {
                    intervals[x][y] = scanner.nextInt(); //sets the target position based on the nextInt
                }
            }
            boolean result = canEscapeZipline(ziplines, ziplineLength, intervals, 0, 0, 0); //boolean variable for the result
            if (result == true) //prints YES if escape is possible
            {
                System.out.println("YES");
            }
            else //prints NO if escape is impossible
            {
                System.out.println("NO");
            }
        }
    }

    public static boolean canEscapeZipline(int ziplines, int length, int[][] intervals, int currentZipline, int position, int prevPosition) //method to check if its possible to escape
    {
        if (position == length) //base case when reached the end
        {
            return true;
        }

        if (currentZipline >= ziplines || position > length) //checks if the position is not valid
        {
            return false;
        }

        for (int i = 0; i < intervals[currentZipline].length; i += 2) //loop to iterate thru the intervals of the current zipline
        {
            int start = intervals[currentZipline][i]; //sets the start variable to the start position based on the interval of the zipline
            int end = intervals[currentZipline][i + 1]; //sets the end variable to the end position based on the interval of the zipline
            if (end >= position && end > prevPosition) //checks if its possible to switch and continue
            {
                if (canEscapeZipline(ziplines, length, intervals, currentZipline, end + 1, position)) //checks if possible to escape on the current zip
                {
                    return true;
                }
            }
        }
        return canEscapeZipline(ziplines, length, intervals, currentZipline + 1, position, prevPosition); //move to next zipline if we cant switch
    }
}




    
 



