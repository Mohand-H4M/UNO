public class Game {

    private enum sens {
        ClockWise,NotClockWise
    }

    public String getSens(){
        String string = sens.NotClockWise.toString();
        return string;
    }

    public void sensSetter(String NewSens){
        this.sens = NewSens;
    }

    public void SkipNext(){

    }


}
