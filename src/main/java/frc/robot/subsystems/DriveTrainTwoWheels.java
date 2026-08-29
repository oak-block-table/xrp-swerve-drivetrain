package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainTwoWheels extends SubsystemBase {
    private static final double TURNING_SPEED = 0.5;
    private static final double MAX_DRIVE_SPEED = 0.6;
    private static final double DEADBAND = 0.1;

    private final XRPDifferentialSwerveWheel wheelModuleLeft, wheelModuleRight;

    public DriveTrainTwoWheels(XRPDifferentialSwerveWheel wheelModule0, XRPDifferentialSwerveWheel wheelModule1) {
        wheelModuleLeft = wheelModule0;
        wheelModuleRight = wheelModule1;
    }

    public void driveWithController(XboxController controller) {
        double leftYAxisValue = controller.getLeftY();
        if (controller.getLeftBumperButton()) {
            wheelModuleLeft.runAzimuthSteeringAxis(TURNING_SPEED);
        } else if (Math.abs(leftYAxisValue) > DEADBAND) {
            wheelModuleLeft.runAxialDriveAxis(leftYAxisValue * MAX_DRIVE_SPEED);
        } else {
            wheelModuleLeft.stopMotors();
        }

        boolean isRightTriggerPressed = controller.getRightTriggerAxis() > DEADBAND;  // Treat axis as a button; ignore deadband of: < 0.1
        double rightYAxisValue = controller.getRightY();
        if (isRightTriggerPressed) {  
            wheelModuleRight.runAzimuthSteeringAxis(-TURNING_SPEED);
        } else if (Math.abs(rightYAxisValue) > DEADBAND) {
            wheelModuleRight.runAxialDriveAxis(rightYAxisValue * MAX_DRIVE_SPEED);
        } else {
            wheelModuleRight.stopMotors();
        }
    }

    public void haltMotion() {
        wheelModuleLeft.stopMotors();
        wheelModuleRight.stopMotors();
    }
}
