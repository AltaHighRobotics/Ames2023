import edu.wpi.first.networktables.IntegerPublisher;
import edu.wpi.first.networktables.IntegerTopic;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Apriltaglibrary extends limelight {
    //declare the table and limelight 
    final limelight m_limelight;
    final NetworkTableInstance NWTI;
    final NetworkTable NTable;


    //This is topic we will get
    private final IntegerTopic IdTopic;

    
    //private final IntegerPublisher IdReceiver;

    //setting up the table and limelight at the start.
    public Apriltaglibrary(){
        //set up limelight
        // m_limelight = new limelight();

        //set up netWorkTable and the NetWorkTableInstance
        NWTI = NetworkTableInstance.getDefault();
        NTable = NWTI.getTable("AprilTagDataTable");

        //set up topic to track Id

    }
    

    //this will get and return the ID to the value 
    public void getAndReturnId(){
        NetworkTableEntry ID = NTable.getIntegerTopic("tclass").publish();        

        return ID.getInteger(0.0);
    
    }
    
    public void getAndReturnTv(){}

    public void getAndReturnTx(){}

    public void getAndReturnTy(){}

    public void getAndReturnTa(){}

    public void getAndReturnTl(){}


    public void close(){

    }

}

