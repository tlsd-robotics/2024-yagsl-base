package TLsdLibrary.Vision;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {

    NetworkTable table;
    NetworkTableEntry tx;
    NetworkTableEntry ty;
    NetworkTableEntry ta;
    int currentPipeline;
    int defaultPipeline;
    double height;
    double angle;
    
    
    
    public Limelight(int defaultPipeline, String tableName, double height, double angle) {
        this.defaultPipeline = defaultPipeline;
        this.height = height;
        this.angle = angle;
        this.table = NetworkTableInstance.getDefault().getTable(tableName);
        this.tx = table.getEntry("tx");
        this.ty = table.getEntry("ty");
        this.ta = table.getEntry("ta");
    }


    public double getHorizontalError() {
        return tx.getDouble(0.0);
    }

    public double getVerticalError() {
        return ty.getDouble(0.0);
    }

    public double getTargetArea() {
        return ta.getDouble(0.0);
    }

    public double getDistanceToTarget(Target target) {
        double angleToGoalDegrees = angle + getVerticalError();
        double angleToGoalRadians = angleToGoalDegrees * (3.14159 / 180.0);

        //calculate distance
        return (target.getHeight() - height) / Math.tan(angleToGoalRadians);
    }
}
