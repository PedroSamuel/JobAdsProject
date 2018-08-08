package authentication;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.omnifaces.util.Faces;


@Named
@RequestScoped
public class Login {
	
	
    public static final String HOME_URLRH = "DashboardRH.xhtml";
   

    private String username;
    private String password;


    public void submit() throws IOException {
        try {
            SecurityUtils.getSubject().login(new UsernamePasswordToken(username, password));
            SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(Faces.getRequest());
            Faces.redirect(savedRequest != null ? savedRequest.getRequestUrl() : HOME_URLRH);
        }
        catch (AuthenticationException e) {
            //defineGrowl("Dados inseridos invalidos. Tente novamente", "", "login");
            e.printStackTrace(); // TODO: logger.
        }
    }
    
 

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
