
package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TankDrive extends CommandBase {
    
    private Drivetrain m_drivetrain;
    private DoubleSupplier right;
    private DoubleSupplier left; 

    public TankDrive(Drivetrain yourmom, DoubleSupplier right, DoubleSupplier left) {
        m_drivetrain = yourmom;
        this.right = right;
        this.left = left;
        addRequirements(yourmom);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_drivetrain.tankDrive(0.0, 0.0);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_drivetrain.tankDrive( right.getAsDouble(), left.getAsDouble() );
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }


}
