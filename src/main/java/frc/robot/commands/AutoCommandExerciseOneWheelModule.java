package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.XRPDifferentialSwerveWheel;
import edu.wpi.first.wpilibj2.command.Command;

/** A command to test that the drive one swever wheel module is working. */
public class AutoCommandExerciseOneWheelModule  extends Command {
    private static double STEP_DURATION_millis = 500;
    private static int NUM_STEPS = 15;

    private final XRPDifferentialSwerveWheel wheelSubsystem;
    private long stepStartTime;
    private int stepNumber;
    private final double defaultMotorSpeed = 0.5;

   /**
     * Runs each of the motors individually, turns the wheel both directions,
     * and runs the whell in both directions.
     *
     * @param swerveWheel The wheel module subsystem on which this command will run
     */
    public AutoCommandExerciseOneWheelModule(XRPDifferentialSwerveWheel swerveWheel) {
        wheelSubsystem = swerveWheel;
        // Use addRequirements() here to declare subsystem dependencies.
        //addRequirements(swerveWheel);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        System.out.println("Starting auto command ExerciseOneWheelModule");
        stepNumber = 0;
        stepStartTime = System.currentTimeMillis();
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        switch(stepNumber) {
            case 0: 
              wheelSubsystem.runTopModuleGear(defaultMotorSpeed);
              break;
            case 2:
              wheelSubsystem.runTopModuleGear(-defaultMotorSpeed);
              break;
            case 4:
              wheelSubsystem.runBottomModuleGear(defaultMotorSpeed);
              break;
            case 6:
              wheelSubsystem.runBottomModuleGear(-defaultMotorSpeed);
              break;
            case 8:
              wheelSubsystem.runAzimuthSteeringAxis(defaultMotorSpeed);
              break;
            case 10:
              wheelSubsystem.runAxialDriveAxis(defaultMotorSpeed);
              break;
            case 12:
              wheelSubsystem.runAzimuthSteeringAxis(-defaultMotorSpeed);
              break;
            case 14:
              wheelSubsystem.runAxialDriveAxis(defaultMotorSpeed);
              break;
            default:
              wheelSubsystem.stopMotors();
        }
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        System.out.println("Stopping Motors.");
        wheelSubsystem.stopMotors();
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if (System.currentTimeMillis() - stepStartTime >= STEP_DURATION_millis)
        {
            stepNumber++;
            System.out.println(String.format(
                "Step number: %6d" , stepNumber));
            stepStartTime = System.currentTimeMillis();
        }
        if (stepNumber < NUM_STEPS) {
            return false;
        }
        return true;
    }
  
}
