import java.util.*;
import java.util.stream.*;
class Person{
    private int id;
    private String name;
    private String lastName;
    
    public Person(){
        super();
    }
    
    public Person(int id,String name, String lastName){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setLastName(String lastName){
        this.lastName= lastName;
    }
    
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getLastName(){
        return this.lastName;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true; // Reflexivity   
        }
        if(this.getClass() != obj.getClass()){
            return false; // Instance of test
        }
        if(obj == null){
            return false; // Non Null
        }
        Person p =(Person)obj;
        return p.id == this.id && p.name.equals(this.name);
    }
    @Override
    public int hashCode(){
        final int testPrime = 37;
        int result = 17;
        result = testPrime*result + id;
        result = testPrime*result + ((name == null)?0:name.hashCode());
        result = testPrime*result + ((lastName == null)?0:lastName.hashCode());
        return result;
    }
    @Override
    public String toString(){
        return "Person Age is ["+this.id+"], name is ["+this.name+"], lastName is ["+this.lastName+"]." ;
    }
}
public class HelloWorld{

     public static void main(String []args){
        Person p = new Person(1,"Vinodh","Thimmisetty");
        System.out.println(p);
        Person p2 = new Person(1,"Vinodh","Thimmisetty");
        System.out.println("Reference equal ??"+ (p == p2));
        System.out.println("Objects equal ??"+p.equals(p2));
        
        Person p3 = new Person(2,"Kumar","Thimmisetty");
        Person p4 = new Person(2,"Yoo","Yoo");
        Person p5 = new Person(2,"Thimmisetty","Yoyo");
        List<Person> l = new ArrayList<>();
        l.add(p);
        l.add(p2);l.add(p3);l.add(p4);l.add(p5);
        Comparator<Person> grouping= Comparator.comparing(Person::getId).thenComparing(Person::getName).thenComparing(Person::getLastName);
        //l.sort(grouping);
        System.out.println("--------Person comparing --------");
        l.stream().sorted(grouping).forEach(System.out::println);
        System.out.println("--------Convert All names to UPPER Case and find the fist match of VINODH --------");
        System.out.println(l.stream().filter(y -> y.getName().toUpperCase().equals("VINODH")).findFirst().get());
        System.out.println("--------Remove person whose first name length is > 7 and remove Duplicates--------");
        Set<Person> distinctList = l.stream().filter(x-> x.getName().length()<=7).collect(Collectors.toSet());
        distinctList.stream().sorted(grouping).forEach(System.out::println);
        System.out.println("--converting the result to Person Array--");
        Person[] arrayOfPersons = distinctList.stream().toArray(Person[]::new);
        System.out.println(Arrays.toString(arrayOfPersons));
     }
}
