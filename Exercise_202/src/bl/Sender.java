
package bl;

public class Sender {
    private String sendername;
    private double frequenz;
    private String band;

    public Sender(String sendername, double frequenz, String band) {
        this.sendername = sendername;
        this.frequenz = frequenz;
        this.band = band;
    }

    public String getSendername() {
        return sendername;
    }

    public double getFrequenz() {
        return frequenz;
    }

    public String getBand() {
        return band;
    }
}
