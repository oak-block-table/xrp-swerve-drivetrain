package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainTwoWheels extends SubsystemBase {
    private static final double TURNING_SPEED = 0.5;
    private static final double MAX_DRIVE_SPEED = 0.6;


    private final XRPDifferentialSwerveWheel wheelModuleLeft, wheelModuleRight;

    public DriveTrainTwoWheels(XRPDifferentialSwerveWheel wheelModule0, XRPDifferentialSwerveWheel wheelModule1) {
        wheelModuleLeft = wheelModule0;
        wheelModuleRight = wheelModule1;
    }

    public void driveWithController(XboxController controller) {
        if (controller.getLeftBumperButton()) {
            wheelModuleLeft.runAzimuthSteeringAxis(TURNING_SPEED);
        } else {
            wheelModuleLeft.runAxialDriveAxis(controller.getLeftY() * MAX_DRIVE_SPEED);
        }

        if (controller.getRightTriggerAxis() > 0.1) {  // Treat axis as a button; ignore deadband of: < 0.1
            wheelModuleRight.runAzimuthSteeringAxis(-TURNING_SPEED);
        } else {
            wheelModuleRight.runAxialDriveAxis(controller.getRightY() * MAX_DRIVE_SPEED);
        }
    }

    public void haltMotion() {
        wheelModuleLeft.stopMotors();
        wheelModuleRight.stopMotors();
    }
}
