package gr303.luhsheidergerman.myconvertor;

import android.widget.ArrayAdapter;

import java.text.DecimalFormat;

public class Unit {
    private String unit;

    public ArrayAdapter setUnit(ArrayAdapter<String> adp, String unit) {
        this.unit = unit;
        switch (unit) {
            case "length":
                adp.add("mm");
                adp.add("cm");
                adp.add("m");
                adp.add("km"); break;
            case "time":
                adp.add("ms");
                adp.add("s");
                adp.add("min");
                adp.add("h"); break;
            case "weight":
                adp.add("mg");
                adp.add("g");
                adp.add("kg");
                adp.add("t"); break;
        }
        return adp;
    }

    public String Calculate(double from, String sFrom, String sTo) {
        double m = 0.0, to = 0.0;
        switch (unit) {
            case "length":
                if(sFrom.equals("mm")) m = from/1000;
                if(sFrom.equals("cm")) m = from/100;
                if(sFrom.equals("m")) m = from;
                if(sFrom.equals("km")) m = from*1000;

                if(sTo.equals("mm")) to = m*1000;
                if(sTo.equals("cm")) to = m*100;
                if(sTo.equals("m")) to = m;
                if(sTo.equals("km")) to = m/1000; break;
            case "time":
                if(sFrom.equals("ms")) m = from/60000;
                if(sFrom.equals("s")) m = from/60;
                if(sFrom.equals("min")) m = from;
                if(sFrom.equals("h")) m = from*60;

                if(sTo.equals("ms")) to = m*60000;
                if(sTo.equals("s")) to = m*60;
                if(sTo.equals("min")) to = m;
                if(sTo.equals("h")) to = m/60; break;
            case "weight":
                if(sFrom.equals("mg")) m = from/1000000;
                if(sFrom.equals("g")) m = from/1000;
                if(sFrom.equals("kg")) m = from;
                if(sFrom.equals("t")) m = from*1000;

                if(sTo.equals("mg")) to = m*1000000;
                if(sTo.equals("g")) to = m*1000;
                if(sTo.equals("kg")) to = m;
                if(sTo.equals("t")) to = m/1000; break;
        }
        DecimalFormat format = new DecimalFormat("#.#######");
        format.setDecimalSeparatorAlwaysShown(false);
        return format.format(to);
    }
}
