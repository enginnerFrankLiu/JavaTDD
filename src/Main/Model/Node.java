package Main.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Node {

    private int id;

    private String name;

    private List<Node> nodes;

    @Override
    public boolean equals(Object otherObject){
        System.out.println("call equals method.");
//        if(otherObject instanceof Node){
//            Node otherNode=(Node)(otherObject);
//            return this.getId()==otherNode.getId() && this.getName()==otherNode.getName();
//        }
//        return false;
        return false;
    }

    @Override
    public int hashCode(){
        System.out.println("call hashCode method.");
//        return new Integer(this.getId()).hashCode()+this.getName().hashCode();
        return 0;
    }

}
