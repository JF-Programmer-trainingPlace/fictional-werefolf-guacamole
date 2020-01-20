package uabc.josueeduardo.climapp.Model;

import java.util.ArrayList;
import java.util.List;

import uabc.josueeduardo.climapp.Model.Day;

public class Week {
    private List<Day> days=new ArrayList<>();
    public void addForecast(Day forecast) {
        days.add(forecast);
        //System.out.println("Add forecast ["+forecast+"]");
    }

    public Day getForecast(int dayNum) {
        return days.get(dayNum);
    }
}
