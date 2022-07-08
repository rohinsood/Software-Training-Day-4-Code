package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {
    
    CANSparkMax m_elevator = new CANSparkMax(Constants.Elevator.elevator_id, MotorType.kBrushless);

    public Elevator() {
        m_elevator.setIdleMode(IdleMode.kBrake);
    }

    public void extend() {
        m_elevator.set(.5);
    }

    public void retract() {
        m_elevator.set(-.75);
    }

    public void stop() {
        m_elevator.stopMotor();
    }
}
