package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.xrp.XRPOnBoardIO;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class WheelHomeSensor extends SubsystemBase {

  /*  This is a proof-of-concept hack
   *  Our first digital sensor is attached to IO PIN22 on the 
   *  XRP port labled Extra which is shared by the USER button.  
   *  Instead of referencing the input by pin number, 
   *  we simply read the state of the user button.
   */ 

  private XRPOnBoardIO io = new XRPOnBoardIO();
  //private DigitalInput signalFromSensor;

  private boolean lastReportedState;

  public WheelHomeSensor() { //int inputPin) {
    //signalFromSensor = new DigitalInput(inputPin);

    // We did not attempt to use this example since the pull-up resistor was
    // enabled by default on PIN22 that we used in our initial test.
    // // Example code to Enable internal pull-up resistor on a GPIO pin
    // try {
    //   signalFromSensor.setPullUp(true);
    //   System.out.println("Pull-up resistor enabled on GPIO pin" + inputPin);
    // } catch (UnsupportedOperationException e) {
    //   // This feature was not suppored until a 2024 version of WPILib firmware 
    //   System.err.println("Pull-up configuration not supported on this firmware.");
    // }

    lastReportedState = getState();
    reportStateToConsole(lastReportedState);
  }

  private boolean getState() {
    //return signalFromSensor.get();
    return io.getUserButtonPressed();
  }

  private void reportStateToConsole(boolean state) {
    if (state) {
      System.out.println("Wheel Home sensor state: A  Logical High");
    } else {
      System.out.println("Wheel Home state:  V Logical Low");
    }
  }

  private void setLedState(boolean state) {
    io.setLed(state);
  }
  // public void clearState(){
  //   System.out.println("Clearing Wheel Home State");
  //   lastReportedState = false;
  //   setLedState(lastReportedState);
  // }
   
  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    // Read the switch state (true = high, false = low)
    boolean state = getState();
    if (state != lastReportedState) {
      lastReportedState = state;
      reportStateToConsole(state);
      setLedState(state);
    }
  }

}
