
<div id="header" align="center">

  <img src="https://is1-ssl.mzstatic.com/image/thumb/Purple122/v4/20/92/e6/2092e6d9-bf91-9877-525b-3e7ad56ec758/AppIcon-1x_U007emarketing-0-7-0-85-220.png/1200x630wa.png" width="600"/>
  
   ### Client for social network https://grustnogram.ru written on java
</div>

### Login Example:

```Java
import grustnogramm.client.auth.login.Login;

public class Test {
   public static void main(String[] args){
       
      Client.loginRequest(new Login("Email", "Password"));
      
   }
}

```

### Register Example:

```Java
import grustnogramm.client.auth.login.Login;
import grustnogramm.client.functions.chat.message.Message;
import grustnogramm.client.auth.register.PhoneActive;
import grustnogramm.client.auth.register.Register;
import grustnogramm.client.auth.register.SendVerificationCode;

import java.util.Scanner;

public class Test {
   public static void main(String[] args) {

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
public class Test {
   public static void main(String[] args) {

      Client.loginRequest(new Login("email", "password"));
      Client.sendMessageRequest(new Message.SendMessage("chat_id", "Hello from grustnogramm Client!"));
      
    }
    
}
```


