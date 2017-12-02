package Secure_Database;

public class SecureDB_Sample {

    /*this allows users get access to a DB securely*/

    private SecureDB_Sample() { }

    public static SecureDB_Sample secureDB_sample = new SecureDB_Sample();

    public static SecureDB_Sample getInstanceOfSecureDB() {
        return secureDB_sample;
    }


    public void demonstratingSingletonObject() {

        System.out.println("this is the singleton object");


    }
}
