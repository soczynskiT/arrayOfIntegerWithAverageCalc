import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

class ListGenerator {
    private Random random = new Random();

    public ArrayList<Double> generateRandomArrayOfGrades(int noOfElements) {
        final int maxValue = 7;
        ArrayList<Double> newArrayList = new ArrayList<>();

        for(int i=0; i<noOfElements; i++) {
            double newGrade = random.nextInt(maxValue);
            if (newGrade > 0) {
                newArrayList.add(newGrade);
            }
            else {
                i--;
            }
        }
        return newArrayList;
    }
}

class ArrayListCalculator {
    public double showLowestValueOfList(ArrayList<Double> arrayList) {
        double lowestValue = arrayList.get(0);
        for (Double anArrayList : arrayList) {
            if (lowestValue > anArrayList) {
                lowestValue = anArrayList;
            }
        }
        return lowestValue;
    }
    public double showHighestValueOfList(ArrayList<Double> arrayList) {
        double highestValue = arrayList.get(0);
        for (Double anArrayList : arrayList) {
            if (highestValue < anArrayList) {
                highestValue = anArrayList;
            }
        }
        return highestValue;
    }
    public double calculateSumOfElementsFrom(ArrayList<Double> arrayList) {
        double sumOfElements = 0;
        for (Double anArrayList : arrayList) {
            sumOfElements += anArrayList;
        }
        return sumOfElements;
    }
    public double calculateSpecificAverageFrom(ArrayList<Double>arrayList , double lowestValue, double highestValue, double sumOfElements) {
        return (sumOfElements-highestValue-lowestValue)/(arrayList.size() - 2);
    }
}

class Book {
    private int publicYear;
    private String title;

    Book(int publicYear, String title) {
        this.publicYear = publicYear;
        this.title = title;
    }

    public int getPublicYear() {
        return publicYear;
    }

    public String getTitle() {
        return title;
    }
}

class App {
    public static void main(String[] args) {

        ListGenerator gradesArrayListGenerator = new ListGenerator();
        final ArrayList<Double> informatykaGradesArray = gradesArrayListGenerator.generateRandomArrayOfGrades(12);

        System.out.println("List of grades for \"Informatyka\":\n");
        for(Double grades : informatykaGradesArray) {
            System.out.println(grades);
        }

        ArrayListCalculator arrayListCalculator = new ArrayListCalculator();
        final double lowestValue = arrayListCalculator.showLowestValueOfList(informatykaGradesArray);
        final double highestValue = arrayListCalculator.showHighestValueOfList(informatykaGradesArray);
        final double sumOfElements = arrayListCalculator.calculateSumOfElementsFrom(informatykaGradesArray);
        final double specificAverage = arrayListCalculator.calculateSpecificAverageFrom(informatykaGradesArray, lowestValue, highestValue, sumOfElements);

        System.out.println("\nLowest value is: " + lowestValue);
        System.out.println("Highest value is: " + highestValue);
        System.out.println("Sum of all elements is: " + sumOfElements);
        System.out.println("Requested average value is: " + specificAverage + "\n");

        Book book1 = new Book(1998, "Random title no 1.");
        Book book2 = new Book(2000, "Random title no 2.");
        Book book3 = new Book(2003, "Random title no 3.");
        Book book4 = new Book(1650, "Random title no 4.");
        Book book5 = new Book(2004, "Random title no 5.");

        final LinkedList<Book> bookList = new LinkedList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);

        for (Book newerThan : bookList) {
            final int oldestPublicYear = 2000;
            if (newerThan.getPublicYear() >= oldestPublicYear) {
                System.out.println("Book " + newerThan.getTitle() + " was published in " + newerThan.getPublicYear());
            }
        }
    }
}
