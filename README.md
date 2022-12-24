# GrustnoGram

<div id="header" align="center">

  
  <img src="https://is1-ssl.mzstatic.com/image/thumb/Purple122/v4/20/92/e6/2092e6d9-bf91-9877-525b-3e7ad56ec758/AppIcon-1x_U007emarketing-0-7-0-85-220.png/1200x630wa.png" width="600"/>
  
   ### API for social network https://grustnogram.ru written on java
</div>

### Login Example:
```Java
import grustnogram.Client;
import grustnogram.client.auth.login.Login;

public class test {

    public static void main(String[] args){
        Client.LoginRequest(new Login("email", "password"));
    }
}
```

### Register Example:

```Java
import grustnogram.Client;
import grustnogram.client.auth.Register.PhoneActive;
import grustnogram.client.auth.Register.Register;
import grustnogram.client.auth.Register.SendVerificationCode;

import java.util.Scanner;

public class test {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String phone_key = Client.RegisterRequest(new Register("nickname", "email", "password"));
        Client.SendVerificationCodeRequest(new SendVerificationCode("+7xxxxxxxxxx", phone_key));

        System.out.print("Enter Code: ");
        String code = sc.nextLine();
        Client.PhoneActiveRequest(new PhoneActive(code));
        

    }
}

```
### Send Message Example:
```Java
import grustnogram.Client;
import grustnogram.client.auth.login.Login;
import grustnogram.client.functions.chat.message.SendMessage;


public class test {

    public static void main(String[] args){
        Client.LoginRequest(new Login("email", "password"));
        Client.SendMessageRequest(new SendMessage("chat_id", "Hello from GrustnoGram API!"));

    }
}
```



