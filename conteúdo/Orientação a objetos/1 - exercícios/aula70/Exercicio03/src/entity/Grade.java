package entity;

public class Grade {
    public String name;
    public double firstSemester;
    public double secondSemester;
    public double thirdSemester;

    public double finalGrade(){
        return firstSemester + secondSemester + thirdSemester;
    }

    public String toString(){
        double finalGrade = finalGrade();
        String finalMessage;

        if (finalGrade < 60){
            double missingPoints = 60 - finalGrade;
            finalMessage = "\nFAILD\nMISSING " + String.format("%.2f", missingPoints) + " POINTS";
        } else{
            finalMessage = "\nPASS";
        }

        return "FINAL GRADE = " + String.format("%.2f", finalGrade) + finalMessage;
    }
}
