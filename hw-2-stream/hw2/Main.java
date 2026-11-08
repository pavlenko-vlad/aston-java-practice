package hw2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class Main {
    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        String json = Files.readString(Path.of("hw2/LibraryCard.json"));

        List<Student> students = mapper.readValue(json, new TypeReference<List<Student>>() {});

        Optional<Integer> foundYear = students.stream()
                .peek(System.out::println)                                        
                .map(Student::getBooks)                                           
                .flatMap(List::stream)                                            
                .sorted(Comparator.comparingInt(Book::getPageCount).reversed())   
                .distinct()                                                       
                .filter(b -> b.getYear() > 2000)                                 
                .limit(3)                                                        
                .map(Book::getYear)                                               
                .findFirst();                                                     

        System.out.println(
                foundYear.map(y -> "Год выпуска найденной книги: " + y)
                         .orElse("Книга, выпущенная после 2000 года, не найдена")
        );
    }
}