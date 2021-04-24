class Bulb{
    boolean blueIsOn;
    boolean redIsOn;
    
    void turnOn(){
        if (!blueIsOn && !redIsOn) {
            blueIsOn = true;
        } 
        else if(blueIsOn && !redIsOn) {
            redIsOn = true;
            blueIsOn = false;
        } else if(!blueIsOn && redIsOn){
            blueIsOn = true;
            redIsOn = false;
        }
    }

    void turnOff(){
        redIsOn = false;
        blueIsOn = false;
    }

    void getStatement(){
        if (blueIsOn && !redIsOn) {
            System.out.println("blue is on & red is off");
        } else if(!blueIsOn && redIsOn) {
            System.out.println("blue is off & red is on");
        } else {
            System.out.println("blue is off & red is off");
        }
    }
}