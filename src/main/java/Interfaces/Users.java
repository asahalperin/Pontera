package Interfaces;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;


//Interface that get values from properties file (for flexible run)
@Sources({
        "classpath:Users/${user}.properties" // mention the property file name
})
public interface Users extends Config{
    String platform();
    String env();
    String user();
    String url();
    String email();
    String clientEmail();
    String password();
    String firm();
    String advisorFirstName();
    String advisorLastName();
    String ssn();
    String mobilePhone();
    String city();
    String state();
    String advisorName();
}
