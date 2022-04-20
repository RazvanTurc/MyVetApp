package ro.fasttrackit.myvet1.MyVet1.model;

public enum Times {

    TIME900("9:00"),
    TIME930("9:30"),
    TIME1000("10:00"),
    TIME1030("10:30"),
    TIME1100("11:00"),
    TIME1130("11:30"),
    TIME1200("12:00"),
    TIME1230("12:30"),
    TIME1300("13:00"),
    TIME1330("13:30"),
    TIME1400("14:00"),
    TIME1430("14:30"),
    TIME1500("15:00"),
    TIME1530("15:30"),
    TIME1600("16:00"),
    TIME1630("16:30"),
    TIME1700("17:00"),
    TIME1730("17:30"),
    TIME1800("18:00");

    String time;

    Times(String time) {
        this.time = time;
    }

    public String getTimeString() {
        return time;
    }

    public Times getTimesFromString(String time) {
        switch (time) {
            case "9:00": return TIME900;
            case "9:30": return TIME930;
            case "10:00": return TIME1000;
            case "10:30": return TIME1030;
            case "11:00": return TIME1100;
            case "11:30": return TIME1130;
            case "12:00": return TIME1200;
            case "12:30": return TIME1230;
            case "13:00": return TIME1300;
            case "13:30": return TIME1330;
            case "14:00": return TIME1400;
            case "14:30": return TIME1430;
            case "15:00": return TIME1500;
            case "15:30": return TIME1530;
            case "16:00": return TIME1600;
            case "16:30": return TIME1630;
            case "17:00": return TIME1700;
            case "17:30": return TIME1730;
            case "18:00": return TIME1800;
            default: throw new RuntimeException("Invalid Time");
        }
    }
}
