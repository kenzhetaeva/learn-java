package optional_2;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Address address = new Address("Kyrgyzstan", "Bishkek", "Chuy");
        User user = new User("Aidana", address);

        System.out.println(getUserCity(user));
    }

    public static String getUserCity(User user) {
        return Optional.ofNullable(user)
                .map(User::getAddress)
                .map(Address::getCity)
                .orElse("");
    }
}
