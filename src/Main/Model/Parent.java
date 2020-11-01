package Main.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parent {

   protected Integer id;

   protected String name;

   /**
    * use getClass will be better than instance of.
    * @param otherObject
    * @return
    */
   @Override
   public boolean equals(Object otherObject) {
      if(otherObject==null) return false;
      if(otherObject instanceof  Parent){
         Parent other=(Parent)otherObject;
         if(other.getName()==null || this.getName()==null){
            return false;
         }else{
            return this.getId().equals(other.getId()) &&
                    this.getName().equals(other.getName());
         }
      }
      return false;
   }

}
