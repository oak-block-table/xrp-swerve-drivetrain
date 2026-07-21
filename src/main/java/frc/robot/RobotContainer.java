// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AutoCommandExerciseDriveTrain;
import frc.robot.commands.AutoCommandExerciseOneWheelModule;
import frc.robot.subsystems.WheelHomeSensor;
import frc.robot.subsystems.XRPDifferentialSwerveWheel;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final XRPDrivetrain m_xrpDrivetrain = new XRPDrivetrain();
  private final XRPDifferentialSwerveWheel wheelModule0 = new XRPDifferentialSwerveWheel(0, 2);
  private final XRPDifferentialSwerveWheel wheelModule1 = new XRPDifferentialSwerveWheel(1, 3);
  public final WheelHomeSensor wheelHomeSensor0 = new WheelHomeSensor(); //(22);

  //private final Command m_autoCommand = new AutoCommandExerciseOneWheelModule(wheelModule1);
  private final Command m_autoCommand = new AutoCommandExerciseDriveTrain(wheelModule0, wheelModule1);

  //private final CommandXboxController controller = new CommandXboxController(0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
