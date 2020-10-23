package Main.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.channels.Pipe;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;

    private String name;

    private int age;
}
