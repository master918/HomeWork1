//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import HomeWork1.Ex1.MyArrayList;
import HomeWork1.Ex1.MyHashSet;
import HomeWork1.Ex2.Book;
import HomeWork1.Ex2.Student;

void main() {
    CheckMyArrayList();
    CheckMyHashSet();
    List<Student> students = List.of(
            new Student("Alex", List.of(
                    new Book("Java", 100, 1999),
                    new Book("Spring", 300, 2005),
                    new Book("Algorithms", 450, 2001),
                    new Book("Patterns", 350, 2003),
                    new Book("Docker", 200, 2020)
            )),
            new Student("Maria", List.of(
                    new Book("Java", 100, 1999),
                    new Book("C#", 150, 2007),
                    new Book("C", 300, 2005),
                    new Book("Networks", 400, 2018),
                    new Book("Docker", 200, 2020)
            ))
    );

    students.stream()
            .peek(System.out::println) // вывести студентов
            .flatMap(s -> s.getBooks().stream()) // все книги
            .sorted(Comparator.comparingInt(Book::getPages)) // сортировка по страницам
            .distinct() // уникальные книги
            .filter(b -> b.getYear() > 2000) // книги после 2000
            .limit(3) // первые 3
            .map(Book::getYear) // взять годы выпуска
            .findFirst() // короткое замыкание -> Optional<Integer>
            .ifPresentOrElse( // вывести значение
                    year -> System.out.println("Год выпуска: " + year),
                    () -> System.out.println("Книга не найдена")
            );
}

void CheckMyArrayList(){
    MyArrayList<String> List = new MyArrayList<String>(3);
    List.add("a0");
    List.add("a1");
    List.add("a2");
    List.add("a3");
    List.add(2,"!!!");

    List.remove(1);

    String i = List.get(0);

    ArrayList<String> Add = new ArrayList<String>(10);
    Add.add("b0");
    Add.add("b2");
    Add.add(1,"b1");

    List.addAll(3, Add);
}
void CheckMyHashSet(){
    MyHashSet<String> states = new MyHashSet<String>();

    states.add("Germany");
    states.add("France");
    states.add("Italy");
    states.add("Italy");

    states.remove("Italy");
}
