package timer;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import control.ControlAnuncioPlataforma;

@Startup
@Singleton
public class Timer {
	@Inject
	private ControlAnuncioPlataforma controlAP; 

    @Schedule(hour="0", minute="0", second="0", persistent=false)
    public void someDailyJob() {
       verifyDates();
    }
    
    @PostConstruct
    private void verifyDates() {
    System.out.println("Verifying Dates");
     controlAP.verifyDates();
    }


} 