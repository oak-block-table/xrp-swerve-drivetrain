package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.XRPDrivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/** A command to test that the drive train is working. */
public class AutoCommandFirstTestPath extends SequentialCommandGroup {
  /**
   * Creates a new Autonomous Drive based on distance. This will drive out for a specified distance,
   * turn around and drive back.
   *
   * @param drivetrain The drivetrain subsystem on which this command will run
   */
  public AutoCommandFirstTestPath(XRPDrivetrain drivetrain) {
    addCommands(
        new WaitSeconds(0.6),
        new DriveDistance(Constants.CalibrationDriveSpeed, Constants.CalibrationDriveDistanceInches, drivetrain),
        new TurnDegrees(Constants.DriveTurnSpeed, 180, drivetrain),
        new WaitSeconds(0.6),
        new DriveDistance(Constants.CalibrationDriveSpeed, Constants.CalibrationDriveDistanceInches, drivetrain),
        new TurnDegrees(Constants.DriveTurnSpeed, 180, drivetrain)
    );
  }

  // // Called when the command is initially scheduled.
  // @Override
  // public void initialize() {}

  // // Called every time the scheduler runs while the command is scheduled.
  // @Override
  // public void execute() {}

  // // Called once the command ends or is interrupted.
  // @Override
  // public void end(boolean interrupted) {}

  // // Returns true when the command should end.
  // @Override
  // public boolean isFinished() {
  //   return false;
  // }
}
