package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.Drivetrain;

public class RobotContainer {

  private final Drivetrain m_drivetrain = new Drivetrain();
  
  private final Forward m_forward = new Forward(m_drivetrain);
  private final Reverse m_reverse = new Reverse(m_drivetrain);
  private final RightTurn m_rightTurn = new RightTurn(m_drivetrain);
  private final LeftTurn m_leftTurn = new LeftTurn(m_drivetrain);

  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    XboxController Pilot = new XboxController(0);
    Pilot.getPOV();

    JoystickButton A = new JoystickButton(Pilot, Button.kA.value);
    JoystickButton B = new JoystickButton(Pilot, Button.kB.value);
    JoystickButton X = new JoystickButton(Pilot, Button.kX.value);
    JoystickButton Y = new JoystickButton(Pilot, Button.kY.value);

    m_drivetrain.setDefaultCommand( (new TankDrive(m_drivetrain, Pilot::getLeftY, Pilot::getRightY)) );

    A.whenHeld(m_reverse);
    B.whenHeld(m_leftTurn);
    X.whenHeld(m_rightTurn);
    Y.whenHeld(m_forward);
  }

  public Command getAutonomousCommand() {
    return new SequentialCommandGroup(
      m_forward, m_rightTurn
    );
  }

}