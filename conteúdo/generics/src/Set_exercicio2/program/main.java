static Scanner sc = new Scanner(System.in);

void main(){
    Set<Integer> studentsCourseA = numStudents("A");
    Set<Integer> studentsCourseB = numStudents("B");
    Set<Integer> studentsCourseC = numStudents("C");

    Set<Integer> allStudents = new HashSet<>();
    allStudents.addAll(studentsCourseA);
    allStudents.addAll(studentsCourseB);
    allStudents.addAll(studentsCourseC);

    System.out.println("Total students: " + allStudents.size());
}

static Set<Integer> numStudents(String course){
    System.out.printf("How many students for course %s? ", course);
    int quantityStudents = sc.nextInt();

    Set<Integer> students = new HashSet<>();
    for (int i = 0; i < quantityStudents; i++) {
        sc.nextLine();
        try {
            students.add(sc.nextInt());
        } catch (InputMismatchException e){
            System.out.println("Informação inválida - insira novamente");
            i--;
        } catch (Exception e){
            System.out.println("Erro inesperado - insira novamente");
            i--;
        }
    }

    return students;
}

