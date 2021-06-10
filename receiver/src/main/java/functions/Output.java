package functions;

public class Output {
    private String device;
    private Integer temp;
    private Integer humidity;

    public Output(Input data) {
        this.device = data.getDevice();
        this.temp = data.getTemp();
        this.humidity = data.getHumidity();
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }
}
