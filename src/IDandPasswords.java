import java.util.HashMap;

public class IDandPasswords {

    // using hashmap to store user IDs and passwords
    HashMap<String, String> loginInfo = new HashMap<String, String>();

    IDandPasswords (){
        // creating a few userIDs and passwords for testing
        loginInfo.put("Bohdan", "123");
        loginInfo.put("Java", "notJavaScript");
        loginInfo.put("Coding", "isFun");
    }

    protected HashMap getLoginInfo(){
        return loginInfo;
    }
}


