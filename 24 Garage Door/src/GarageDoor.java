class GarageDoor {

    private Motor motor;
    private DoorState currentState;


    GarageDoor() {
        this.motor = new Motor();
        this.currentState = new Closed();
    }
    void openDoor() {
        currentState.openDoor();
    }
    void closeDoor(){
        currentState.closeDoor();
    }
    void stopper() {
        currentState.stopper();
    }

    private Motor getMotor() {
        return this.motor;
    }

    private void setState(DoorState doorState){
        this.currentState = doorState;
    }

    protected abstract class DoorState {
        public abstract void openDoor();
        public abstract void closeDoor();
        public abstract void stopper();
    }

    protected class Closed extends DoorState {
        @Override
        public void openDoor(){
            setState(new Opening());
            getMotor().upwards();
        }

        @Override
        public void stopper(){
            throw new IllegalStateException();
        }

        @Override
        public void closeDoor() {
            throw new IllegalStateException();
        }
    }

    protected class Opening extends DoorState {
        @Override
        public void openDoor() {
            throw new IllegalStateException();
        }

        @Override
        public void closeDoor(){
            getMotor().downwards();
            setState(new Closing());
        }

        @Override
        public void stopper(){
            getMotor().stop();
            setState(new Open());
        }
    }

    protected class Open extends DoorState {
        @Override
        public void openDoor() {
            throw new IllegalStateException();
        }

        @Override
        public void closeDoor(){
            getMotor().downwards();
            setState(new Closing());
        }

        @Override
        public void stopper(){
            throw new IllegalStateException();
        }
    }
    protected class Closing extends DoorState {

        @Override
        public void openDoor(){
            getMotor().upwards();
            setState(new Opening());
        }

        @Override
        public void closeDoor() {
            throw new IllegalStateException();
        }

        @Override
        public void stopper(){
            getMotor().stop();
            setState(new Closed());
        }
    }






}
