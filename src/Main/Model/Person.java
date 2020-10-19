package Main.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private int id;

    private String name;

    private int age;

    private String remark;

    private double account;

    private List<Person> aroundPerson;

}
