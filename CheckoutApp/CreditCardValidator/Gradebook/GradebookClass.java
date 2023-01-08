package ClassProjects.CheckoutApp.CreditCardValidator.Gradebook;

import java.util.Arrays;
import java.util.Scanner;

public class GradebookClass {
    private String className;
    private int [][] grades;

    private int lengthOfStudents;
    private int lengthOfCourses;

    public void setGrades(){
        System.out.println("How Many Students do you want to Enter grades for?");
        Scanner scanner = new Scanner(System.in);
        this.lengthOfStudents = scanner.nextInt();

        System.out.println("How courses do you want to set grades for?: ");
        this.lengthOfCourses = scanner.nextInt();

        this.grades = new int[lengthOfStudents][lengthOfCourses];

        for (int row = 0; row < grades.length; row++) {
            System.out.printf("Entering Score for student %d%n ", row +1);
            for (int column = 0; column < grades[row].length ; column++) {
                System.out.printf("Enter score for subject %d%n ",  column+ 1);
                int grade = scanner.nextInt();
                while (grade < 0 || grade > 100){
                    System.out.println("Enter a Valid Grade Input");
                    grade = scanner.nextInt();}

                if (grade > 0 && grade <= 100 ){
                    grades[row][column] = grade;
                }
            }

        }
    }
    public String getGrades() {
        String value = Arrays.deepToString(grades);
        return value;
    }

    public void printDashLines(){
        String dash = "========================";
        for (int i = 0; i < lengthOfCourses; i++) {
            System.out.printf("%s",dash);
        }
        System.out.println();
    }
    public void headers(){
        printDashLines();
        System.out.printf("%4s", "STUDENT");
        for (int subject = 0; subject < lengthOfCourses; subject++) {
            System.out.printf("%8s", "SUB" + (subject + 1));
        }
        System.out.printf("%8s%8s%8s%n", "TOT", "AVE", "POS");
        printDashLines();
    }
    public void display(){
        headers();
        displayTableOfGrades();
        printDashLines();
        printDashLines();
        displaySummaryOfEachOfSubjects();
        displayOverallClassSummary();
    }

    public void displayTableOfGrades(){
        for (int student = 0; student < lengthOfStudents ; student++) {
            System.out.printf("Student%d ", student + 1);
            for (int grade = 0; grade < grades[student].length; grade++) {
                System.out.printf("%7.5s", grades[student][grade]);
            }
            System.out.printf("%7.4s", totalForEachStudent()[student]);
            System.out.printf("%7.4s", averageForEachStudents()[student]);
            System.out.printf("%8.2s", returnIndexOfPositionOfScores(totalForEachStudent(), student,bubbleSort(totalForEachStudent()) ));
            System.out.println();
        }
    }
    public void displaySummaryOfEachOfSubjects(){
        summaryOfEachSubject(subjectSorting());
    }

    public void displayOverallClassSummary(){
        System.out.println(returnHardestSubject());
        System.out.println(returnEasiestSubject());
        System.out.println(overallHighestScore(grades));
        System.out.println(overallLowestScore(grades));
        printDashLines();
        System.out.println();
        System.out.println();

        System.out.println("CLASS SUMMARY");
        printDashLines();
        System.out.println(returnBestGraduatingStudent());
        printDashLines();

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(returnWorstGraduatingStudent());
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println();

        printDashLines();

        System.out.println(returnClassTotalScore());
        System.out.println(returnClassAverageScore());

    }
    public int[] totalForEachStudent(){
        int[] totalOfSubjects = new int[lengthOfStudents];
        for (int student = 0; student < lengthOfStudents; student++) {
            int total= 0;
            for (int subject = 0; subject < lengthOfCourses; subject++) {
                total = total + grades[student][subject];
                totalOfSubjects[student] = total;
            }
        }
        return totalOfSubjects;
    }

    public double[] averageForEachStudents(){
        double[] arrayOfAverages = new double[lengthOfStudents];
        int[] eachTotal = totalForEachStudent();
        for (int students = 0; students < lengthOfStudents; students++) {
            double totalAverage = (double) eachTotal[students] / lengthOfCourses;
            totalAverage = Math.round(totalAverage * 100.0) / 100.0;
            arrayOfAverages[students] = totalAverage;
        }
        return  arrayOfAverages;
    }
    public int[] bubbleSort(int[] arr){
        int[] newArray = new int[arr.length];
        int temp = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j+1] > arr[j]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }}
        }
        newArray = arr;
        return newArray;
    }

    public int returnIndexOfPositionOfScores(int[] arr, int studentIndex, int[] sortedArray){
        int item = arr[studentIndex];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sortedArray[i] == item){
                index = i;
                break;
            }
        }
        return index + 1;
    }

    public int [][] subjectSorting() {
        int[][] arrayOfSubjectsSorted = new int[lengthOfCourses][lengthOfStudents];
        for (int i = 0; i < lengthOfCourses; i++) {
            for (int j = 0; j < lengthOfStudents; j++) {
                arrayOfSubjectsSorted[i][j] = grades[j][i];
            }
        }
        return arrayOfSubjectsSorted;
    }

    public void summaryOfEachSubject(int[][] arr){
        System.out.println();
        System.out.println();
        System.out.println("SUBJECT SUMMARY ");
        for (int i = 0; i < arr.length ; i++) {
            System.out.printf("Subject %s%n", i+1);
            System.out.println(findHighestScoringStudent(arr[i]));
            System.out.println(findLowestScoringStudent(arr[i]));
            System.out.println(totalOfEachSubjects(arr[i]));
            System.out.println(averageScore(arr[i]));
            System.out.println(numberOfPasses(arr[i]));
            System.out.println(numberOfFails(arr[i]));
            System.out.println();
            System.out.println();
        }

    }
    public String findHighestScoringStudent(int[]arr){
        int tempindex = 0;
        int highestPosition = 1;
        int highestElement = arr[tempindex];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > highestElement){
                highestElement = arr[i];
                highestPosition = i+1;
            }
            tempindex++;
        }
        String output = "The Highest scoring student is Student " +  highestPosition + " scoring " + highestElement;
        return output;
    }

    public String findLowestScoringStudent(int[]arr){
        int tempindex = 0;
        int lowestPosition = 1;
        int lowestElement = arr[tempindex];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < lowestElement){
                lowestElement = arr[i];
                lowestPosition = i+1;
            }
            tempindex++;
        }
        String output = "The Lowest scoring student is: Student " +  lowestPosition + " scoring " + lowestElement;
        return output;
    }

    public String totalOfEachSubjects(int[]arr){
        int total = 0;
        for (int grade:arr) {
            total = total + grade;
        }
        return "Total score is: " + total;
    }

    public String averageScore(int[] arr){

        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            total = total + arr[i];
        }
        double averageScore = (double) total / lengthOfCourses;
        averageScore = Math.round(averageScore * 100.0) / 100.0;
        return "Average score is: " + averageScore;
    }
    public String numberOfPasses(int[] arr){
        int numberOfPasses = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 50) numberOfPasses += 1;
        }
        return "Number of passes is: " + numberOfPasses;
    }
    public String numberOfFails(int[] arr){
        int numberOfFails = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 50) numberOfFails += 1;
        }
        return "Number of fails is: " + numberOfFails;
    }

    public String overallHighestScore(int[][] arr){
        int highestSub = 0;
        int highestSubIndex = 1;
        int subIndex = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < lengthOfCourses; j++) {
                if (arr[i][j] > highestSub){
                    highestSub = arr[i][j];
                    highestSubIndex = i+1;
                    subIndex = j+1;
                }}
        }return "The Overall Highest score is scored by Student " + highestSubIndex + " in subject " + subIndex + " scoring " + highestSub;
    }

    public String overallLowestScore(int[][] arr){
        int lowestSub = 200;
        int lowestSubIndex = 1;
        int subIndex = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < lengthOfCourses; j++) {
                if (arr[i][j] < lowestSub){
                    lowestSub = arr[i][j];
                    lowestSubIndex = i+1;
                    subIndex = j+1;
                }}
        }return "The Overall lowest score is scored by student " + lowestSubIndex + " in subject " + subIndex + " scoring " + lowestSub;
    }


    public String returnBestGraduatingStudent(){
        int tempBest = 0;
        int tempBestIndex = 0;
        int[] total = totalForEachStudent();
        for (int i = 0; i < total.length ; i++) {
            if (total[i] > tempBest){tempBest = total[i];
                tempBestIndex = i+1;}
        }
        return "Best Graduating Student is: Student " + tempBestIndex + " scoring " + tempBest;
    }

    public String returnWorstGraduatingStudent(){
        int tempLowest = 200000;
        int tempLowestIndex = 0;
        int[] total = totalForEachStudent();
        for (int i = 0; i < total.length ; i++) {
            if (total[i] < tempLowest){tempLowest = total[i];
                tempLowestIndex = i+1;}
        }
        return "Worst Graduating Student is: Student " + tempLowestIndex + " scoring " + tempLowest;
    }

    public String returnClassTotalScore(){
        int[] total = totalForEachStudent();
        int totalscore = 0;

        for (int score:total) {
            totalscore = totalscore + score;
        }
        return "Class Total Score is: " + totalscore;
    }

    public String returnClassAverageScore(){
        int[] total = totalForEachStudent();
        int totalScore = 0;
        double averageScore = 0;
        for (int score:total) {
            totalScore = totalScore + score;
        }
        averageScore = (double) totalScore/total.length;
        return "Class Total Score is: " + averageScore;
    }

    public int[] returnNumberOfFailsForEachSubject(){
        int[] arr = new int[subjectSorting().length];
        int passMark = 50;
        for (int i = 0; i < subjectSorting().length ; i++) {
            int failCount = 0;
            for (int j = 0; j < subjectSorting()[i].length ; j++) {
                if (subjectSorting()[i][j] < passMark){
                    failCount++;
                }
            }
            arr[i] = failCount;
        }
        return arr;
    }

    public String returnHardestSubject(){
        int highestFailSubject = 0;
        int highestFailSubjectIndex = 0;
        for (int i = 0; i < returnNumberOfFailsForEachSubject().length ; i++) {
            if (returnNumberOfFailsForEachSubject()[i] > highestFailSubject){
                highestFailSubject = returnNumberOfFailsForEachSubject()[i];
                highestFailSubjectIndex = i+1;
            }
        }
        return "The Hardest Subject is Subject " + highestFailSubjectIndex + " With " + highestFailSubject + " Failures";
    }

    public int[] returnNumberOfPassesForEachSubject(){
        int[] arr = new int[subjectSorting().length];
        int passMark = 50;
        for (int i = 0; i < subjectSorting().length ; i++) {
            int passCount = 0;
            for (int j = 0; j < subjectSorting()[i].length ; j++) {
                if (subjectSorting()[i][j] > passMark){
                    passCount++;
                }
            }
            arr[i] = passCount;
        }
        return arr;
    }

    public String returnEasiestSubject(){
        int highestPassSubject = 0;
        int highestPassSubjectIndex = 0;
        for (int i = 0; i < returnNumberOfPassesForEachSubject().length ; i++) {
            if (returnNumberOfPassesForEachSubject()[i] > highestPassSubject){
                highestPassSubject = returnNumberOfPassesForEachSubject()[i];
                highestPassSubjectIndex = i+1;
            }
        }
        return "The Easiest Subject is Subject " + highestPassSubjectIndex + " With " + highestPassSubject + " Passes";
    }

}