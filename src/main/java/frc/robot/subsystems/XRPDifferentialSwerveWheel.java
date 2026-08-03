package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.xrp.XRPMotor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class XRPDifferentialSwerveWheel  extends SubsystemBase {
  // These values were taken directly form the XRP example motor
  // TODO: Verify that these values are correct for the motor 22mm SparkFun motor
  // private static final double kGearRatio =
  //   (30.0 / 14.0) * (28.0 / 16.0) * (36.0 / 9.0) * (26.0 / 8.0); // 48.75:1
  // private static final double kCountsPerMotorShaftRev = 12.0;
  // private static final double kCountsPerRevolution = kCountsPerMotorShaftRev * kGearRatio; // 585.0

  // The XRP has the left and right motors set to
  // channels 0 and 1 respectively
  private final XRPMotor topGearMotor; //= new XRPMotor(0);
  private final XRPMotor bottomGearMotor;// = new XRPMotor(2);//1);

  // The XRP has onboard encoders that are hardcoded
  // to use DIO pins 4/5 and 6/7 for the left and right
  // TODO: These channels will change for the swerve drive train; each module will use four distinct channels
  //private final Encoder topEncoder = new Encoder(4, 5);
  //private final Encoder bottomEncoder = new Encoder(6, 7);

  /** Creates a new XRPDifferentialSwerveWheel. */
  public XRPDifferentialSwerveWheel(int topGearMotorPort, int bottomGearMotorPort) {
    topGearMotor = new XRPMotor(topGearMotorPort);
    bottomGearMotor = new XRPMotor(bottomGearMotorPort);
   }

  // These are temporary diagnositic methods that may be removed after prototyping
  // All inputs range from -1 (reverse) to +1 (forward) where 0 means stop
  public void runTopModuleGear(double speed) {
    topGearMotor.set(speed);
  }
  public void runBottomModuleGear(double speed) {
    bottomGearMotor.set(speed);
  }

  public void runAzimuthSteeringAxis(double speed) {
    topGearMotor.set(speed);
    bottomGearMotor.set(speed);
  }
  public void runAxialDriveAxis(double speed) {
    topGearMotor.set(speed);
    bottomGearMotor.set(-speed);
  }

  public void stopMotors() {
    topGearMotor.set(0);
    bottomGearMotor.set(0);
  }
}
