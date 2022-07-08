
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Reverse extends CommandBase {

    private final Drivetrain m_drivetrain;

    public Reverse(Drivetrain drivetrain) {
        m_drivetrain = drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        m_drivetrain.tankDrive(0.0, 0.0);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_drivetrain.tankDrive(-0.5, -0.5);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_drivetrain.tankDrive(0.0, 0.0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
