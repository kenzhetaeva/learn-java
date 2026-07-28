package patterns.builder;

public class Main {
    public static void main(String[] args) {
        UserDTO dto = new UserDTO.Builder()
                .firstName("Aidana")
                .age(25)
                .build();
        System.out.println(dto.toString());
    }
}
