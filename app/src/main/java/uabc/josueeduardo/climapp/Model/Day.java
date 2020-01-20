package uabc.josueeduardo.climapp.Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Day {
    //private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH); //falta private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(new Date(updatedAt * 1000));
    //public ForecastTemp forecastTemp = new ForecastTemp();
    //public long timestamp;
    private String weatherDesc, tempp, addrss;

    //public class ForecastTemp {
      //  public float day;
        //public float min;
        //public float max;
        //public float night;
        //public float eve;
        //public float morning;
    //}

    //public String getStringDate() {
      //  return sdf.format(new Date(timestamp));
    //}

    public Day(String weatherDesc, String temp, String addrs) {
        this.weatherDesc = weatherDesc;
        this.tempp = temp;
        this.addrss = addrs;
    }

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(String weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    public String getTemp() {
        return tempp;
    }

    public void setTemp(String temp) {
        this.tempp = temp;
    }

    public String getAddrs() {
        return addrss;
    }

    public void setAddrs(String addrs) {
        this.addrss = addrs;
    }
}
