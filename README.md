 public static void main(String[] args) {
        
        User user = new User("joao", "1234", "joao@gmail.com");

        
        System.out.println("Username: " + user.getUsername());  
        System.out.println("Email: " + user.getEmail());        
   
        if (user.validatePassword("1234")) {
            System.out.println("Senha correta!");
        } else {
            System.out.println("Senha incorreta!");
        }
