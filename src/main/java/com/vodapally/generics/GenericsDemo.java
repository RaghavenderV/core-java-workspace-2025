package com.abhi.generics;

class Test<T>{
    // an object of type T is declared
    T obj;

    Test(T obj){
        this.obj = obj;
    }

    public T getObject(){
        return obj;
    }

    // generic function
    public static <T>  void genericDisplay(T t){
        System.out.println(t.getClass().getName()+" : "+t);
    }

}

class User{
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
public class GenericsDemo {
    public static void main(String[] args) {
        // instance of type integer type
        Test<Integer> intObj = new Test<>(3055);
        System.out.println("intObj = " + intObj.getObject());

        // instance of type String type
        Test<String> stringObj = new Test<>("Hello Generics!!");
        System.out.println("stringObj = " + stringObj.getObject());

        //instance of type User
        Test<User> userObj = new Test<>(new User(101,"Haneesh"));
        System.out.println("userObj = " + userObj.getObject());

        Test.genericDisplay("Raghu");

    }
}
