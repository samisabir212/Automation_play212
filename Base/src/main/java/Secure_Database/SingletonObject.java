package Secure_Database;

public class SingletonObject {

    public static void main(String[] args) {


        SecureDB_Sample secureDB_sample = SecureDB_Sample.getInstanceOfSecureDB();

        secureDB_sample.demonstratingSingletonObject();

        //SecureDB_Sample db = new SecureDB_Sample(); <---- you cant use this. SecureDB_Sample is private!


    }
}
