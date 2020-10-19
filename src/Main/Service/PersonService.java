package Main.Service;
import Main.Interface.IAction;

public class PersonService {

    public void loveJava(int i)
    {
        if(i==0){
            getUp();
        }
    }

    private void getUp(){
        System.out.println("get up early.");
    }

    /**
     * this way we can expose our interface, specific implement by class consumer self.
     * @param i
     * @param action
     */
    public void loveJavaV2(int i, IAction action){

        if(i==0){
            action.doAction();
        }
    }

}
