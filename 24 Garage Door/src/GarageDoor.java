class GarageDoor {

    private Motor motor;
    private DoorState currentState;


    GarageDoor() {
        this.motor = new Motor();
        this.currentState = new Closed();
    }

    void openDoor() {

    }

    void closeDoor(){

    }

    void stopper() {

    }

    public Motor getMotor() {
        return this.motor;
    }

    private void setState(DoorState doorState){

    }

    abstract class DoorState {
        void openDoor(){};
        void closeDoor(){};
        void stopper(){};
    }

    class Closed extends DoorState {
        void openDoor(){
            setState(Open);
        }
    }

    class Opening extends DoorState {
        void closeDoor(){

        }

        void stopper(){

        }
    }

    class Open extends DoorState {
        void closeDoor(){

        }
    }
    class Closing extends DoorState {
        void openDoor(){

        }

        void stopper(){

        }
    }






}
