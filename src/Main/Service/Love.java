package Main.Service;

import Main.Model.Address;
import Main.Model.Node;
import Main.Model.User;

import java.util.*;
import java.util.stream.Collectors;

public class Love {

    public void getMaxA() {
        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
        Integer max = listOfIntegers.stream()
                .mapToInt(x -> x)
                .max()
                .orElse(0);

        System.out.println(max);
    }

    public void getMaxB() {
        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
        Integer max = Collections.max(listOfIntegers);
        System.out.println(max);
    }

    /**
     *
     */
    public void getMaxC() {
        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
        Integer max = listOfIntegers
                .stream()
                .max(Integer::compare)
                .orElse(0);
        System.out.println(max);

    }

    public void getMaxD() {

        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
        Integer max = listOfIntegers
                .stream()
                .collect(Collectors.maxBy(Integer::compare))
                .orElse(0);
        System.out.println(max);
    }

    /**
     * 先这样写这吧；
     */
    public void getSum(){

        List<Integer> listOfIntegers = Arrays.asList(1, 1, 1, 1,1);
        Long sum=listOfIntegers
                .stream()
                .collect(Collectors.summarizingInt(Integer::intValue))
                .getSum();

         System.out.println(sum);

    }

    public void printInfo(){
        Class<?> class1=new ArrayList<String>().getClass();
        Class<?> class2=new ArrayList<Integer>().getClass();
        System.out.println(class1);		//class java.util.ArrayList
        System.out.println(class2);		//class java.util.ArrayList
        System.out.println(class1.equals(class2));	//true

    }

    public void selectMany(){

        List<Integer> PrimeNumbers = Arrays.asList(1, 2, 3);

        List<Integer> OddNumbers = Arrays.asList(4,5,6);

        List<Integer> EvenNumbers = Arrays.asList(7,8,9);

        List<List<Integer>> listOfListofInts =
                Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);

     List<Integer> result= listOfListofInts
                .stream()
                .flatMap(x->x.stream())
                .collect(Collectors.toList());

        System.out.println(result);
    }

    public void selectManyA(){

        Node node=new Node();
        node.setId(1);
        node.setName("A");

        Node node1=new Node();
        node1.setId(2);
        node1.setName("B");

        Node node2=new Node();
        node2.setId(3);
        node2.setName("C");


        List<Node> nodes=new ArrayList<>();
        nodes.add(node);
        nodes.add(node1);
        nodes.add(node2);

        Node rootNdoe=new Node(0,"root_name",nodes);

        List<Node> allNodes=new ArrayList<>();
        allNodes.add(rootNdoe);
        allNodes.add(rootNdoe);





        List<Node> dd =allNodes
                .stream()
                .flatMap(x->x.getNodes().stream())
                .collect(Collectors.toList());

        System.out.println(dd);


        String allNames=allNodes
                .stream()
                .flatMap(x->x.getNodes().stream())
                .map(x->x.getName())
                .collect(Collectors.joining(","));

        System.out.println(allNames);
    }

    public User getUserById(int userId){
        if(userId>0){

            return new User(userId,"marsh",18,new Address(1,"SiChuan","ChengDu","Five Street","company address"));
        }else{

            return null;
        }
    }

    /**
     *
     * @param userId
     * @return
     */
    public String getUserAddress(int userId){
        User user=getUserById(userId);
        if(user==null){
            return "";
        }
        if(user.getAddress()==null){
            return "";
        }
        Address address=user.getAddress();
        String detailAddress=address.getProvince()+"_"+address.getCity()+"_"+address.getStreet();
        return detailAddress;
    }


    /**
     *
     * @param userId
     * @return
     */
    public String getUserAddressV2(int userId){
        User user=getUserById(userId);
        String detailAddress="";
      if(user!=null){
          if(user.getAddress()!=null){
              Address address=user.getAddress();
               detailAddress=address.getProvince()+"_"+address.getCity()+"_"+address.getStreet();
          }

      }
        return detailAddress;
    }

    /**
     * how to use optional optimize this code
     * this is how optional optimize code.
     * @param userId
     * @return
     */
    public String getUserAddressV3(int userId) {
        User userInfo=Optional
                .ofNullable(getUserById(userId))
                .orElse(new User(-1,"unKnow",18,null));

        Address addressInfo=Optional
                .ofNullable(userInfo.getAddress())
                .orElse(new Address(-1,"","","",""));

        String detailAddress=addressInfo.getProvince()+"_"+addressInfo.getCity()+"_"+addressInfo.getStreet();
        return detailAddress;
    }

    /**
     * how to use optional optimize this code
     * this is how optional optimize code.
     * or
     * you can throw exceptions directly.
     * @param userId
     * @return
     */
    public String getUserAddressV4 (int userId) throws  Exception {
        User userInfo=Optional
                .ofNullable(getUserById(userId))
                .orElseThrow(() -> new  Exception("user didn't existed in our system,please check it."));

        Address addressInfo=Optional
                .ofNullable(userInfo.getAddress())
                .orElseThrow(() -> new  Exception("user didn't config address,please check it."));

        String detailAddress=addressInfo.getProvince()+"_"+addressInfo.getCity()+"_"+addressInfo.getStreet();
        return detailAddress;
    }
}
