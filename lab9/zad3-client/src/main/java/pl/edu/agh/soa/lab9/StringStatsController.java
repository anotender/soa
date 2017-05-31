package pl.edu.agh.soa.lab9;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class StringStatsController {
    private String string;
    private StringStats stringStats = new ObjectFactory().createStringStats();
    private StringService stringService = getStringService();

    public void countStats() {
        stringStats = stringService.getStringStats(string);
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public StringStats getStringStats() {
        return stringStats;
    }

    public void setStringStats(StringStats stringStats) {
        this.stringStats = stringStats;
    }

    private StringService getStringService() {
        return new StringServiceImplService().getStringServiceImplPort();
    }
}
