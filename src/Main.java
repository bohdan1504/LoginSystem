public class Main {
    public static void main(String[] args) {

        // getting user IDs and passwords
        IDandPasswords idandPasswords = new IDandPasswords();

        // creating a new LoginPage and passing hashmap with IDs and passwords
        new LoginPage(idandPasswords.getLoginInfo());

    }
}