package pl.edu.agh.soa.lab9;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class DayCounterController {
    private DayCounterService dayCounterService = getDatCounterService();
    private long days = dayCounterService.countDays();

    public Long getDays() {
        return days;
    }

    public void setDays(Long days) {
        this.days = days;
    }

    private DayCounterService getDatCounterService() {
        return new DayCounterServiceImplService().getDayCounterServiceImplPort();
    }
}
