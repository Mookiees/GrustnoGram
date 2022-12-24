
<div id="header" align="center">

  <img src="https://is1-ssl.mzstatic.com/image/thumb/Purple122/v4/20/92/e6/2092e6d9-bf91-9877-525b-3e7ad56ec758/AppIcon-1x_U007emarketing-0-7-0-85-220.png/1200x630wa.png" width="600"/>
  
   ### Client for social network https://grustnogram.ru written on java
</div>

### Login Example:
```Java
import grustnogram.Client;
import grustnogram.client.auth.login.Login;

public class Test {
    public static void main(String[] args){
        Client.loginRequest(new Login("email", "password"));
        
    }
}

```

### Register Example:

```Java
import grustnogram.Client;
import grustnogram.client.auth.register.PhoneActive;
import grustnogram.client.auth.register.Register;
import grustnogram.client.auth.register.SendVerificationCode;

import java.util.Scanner;

public class Test {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String phone_key = Client.registerRequest(new Register("nickname", "email", "password"));
        Client.sendVerificationCodeRequest(new SendVerificationCode("+7xxxxxxxxxx", phone_key));

        System.out.print("Enter Code: ");
        String code = sc.nextLine();
        Client.phoneActiveRequest(new PhoneActive(code));


    }
}

```
### Send Message Example:
```Java
import grustnogram.Client;
import grustnogram.client.auth.login.Login;
import grustnogram.client.functions.chat.message.Message.SendMessage;


public class Test {

    public static void main(String[] args){
        Client.loginRequest(new Login("email", "password"));
        Client.sendMessageRequest(new SendMessage("chat_id", "Hello from GrustnoGramm Client!"));

    }
}
```

if you have any questions, u can write me on telegram @Mookiees

