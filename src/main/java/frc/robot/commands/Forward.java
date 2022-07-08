
package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;


public class Forward extends CommandBase {
    
    private final Drivetrain m_drivetrain;

    Timer m_timer = new Timer();

    public Forward(Drivetrain drivetrain) {
        m_drivetrain = drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        m_timer.start();
        m_drivetrain.tankDrive(0.0, 0.0);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        System.out.println("Time elapsed of forward command " + m_timer.get());
        m_drivetrain.tankDrive(0.5, 0.5);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_timer.stop();
        m_drivetrain.tankDrive(0.0, 0.0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return (m_timer.get() > 5);
    }
}
