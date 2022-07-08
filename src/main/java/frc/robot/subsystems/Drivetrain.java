package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import frc.robot.Constants;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    
    private WPI_TalonFX m_leftFront = new WPI_TalonFX(Constants.Drivetrain.leftFront_id);
    private WPI_TalonFX m_leftRear = new WPI_TalonFX(Constants.Drivetrain.leftRear_id);

    private WPI_TalonFX m_rightFront = new WPI_TalonFX(Constants.Drivetrain.rightFront_id);
    private WPI_TalonFX m_rightRear = new WPI_TalonFX(Constants.Drivetrain.rightRear_id);

    private MotorControllerGroup m_right = new MotorControllerGroup(m_rightFront, m_rightRear);
    private MotorControllerGroup m_left = new MotorControllerGroup(m_leftFront, m_leftRear);

    NetworkTableInstance m_default = NetworkTableInstance.getDefault();
    NetworkTable m_limelight = m_default.getTable("limelight");  
    NetworkTableEntry m_tx = m_limelight.getEntry("tx");
    NetworkTableEntry m_ty = m_limelight.getEntry("ty");

    public Drivetrain() {
        m_rightFront.setNeutralMode(NeutralMode.Brake);
        m_rightRear.setNeutralMode(NeutralMode.Brake);
        m_leftFront.setNeutralMode(NeutralMode.Brake);
        m_leftRear.setNeutralMode(NeutralMode.Brake);
    }


    public void tankDrive( double right, double left ) {
        m_right.set(right);
        m_left.set(left);
    }



}
