import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {

        // -------- Пункт 3: чтение Library.txt и заполнение List<Student> --------
        List<Student> students = Files.readAllLines(Path.of("hw2/Library.txt")).stream()
                .map(line -> line.split("\\|"))
                .map(parts -> new Student(
                        parts[0],
                        Arrays.stream(parts, 1, parts.length)
                              .map(s -> s.split(","))
                              .map(a -> new Book(a[0], Integer.parseInt(a[1]), Integer.parseInt(a[2])))
                              .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());

        // -------- Пункт 4: ОДИН стрим, без промежуточных переменных --------
        Optional<Integer> foundYear = students.stream()
                .peek(System.out::println)                                        // 1. вывести каждого
                .map(Student::getBooks)                                           // 2. списки книг
                .flatMap(List::stream)                                            // 3. книги
                .sorted(Comparator.comparingInt(Book::getPageCount).reversed())   // 4. по страницам ↓
                .distinct()                                                       // 5. уникальные
                .filter(b -> b.getYear() > 2000)                                  // 6. после 2000
                .limit(3)                                                         // 7. не больше 3
                .map(Book::getYear)                                               // 8. годы
                .findFirst();                                                     // 9. короткое замыкание

        // -------- Финал: год или сообщение --------
        System.out.println(
                foundYear.map(y -> "Год выпуска найденной книги: " + y)
                         .orElse("Книга, выпущенная после 2000 года, не найдена")
        );
    }
}

// TO DO
// Лучше использовать Jackson