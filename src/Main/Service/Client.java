package Main.Service;

public class Client {

     private PersonService personService;

     public Client(PersonService personService){
         this.personService=personService;
     }

     public void consume(){

         //消费该方法的对象，只能被动的消费内部的方法；无法将内部的实现，保罗在外部；
         //让消费方法的自己定义具体的实现；
         personService.loveJava(1);

     }
}
