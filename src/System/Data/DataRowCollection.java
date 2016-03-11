package System.Data;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
public class DataRowCollection extends ArrayList<DataRow>{
    
    /**
     * DataRowCollection所屬的DataTable，唯讀
     */
    @OneToOne(mappedBy = "Rows")
	private DataTable Table;

    protected DataRowCollection() {
	}

	/**
     * DataRowCollection被建立時，一定要指定所屬的DataTable
     * @param table 
     */
    public DataRowCollection(DataTable table)
    {
     this.Table = table;
    
    }
    
    /**
     * 取得所屬的DataTable
     * @return DataTable
     */
    public DataTable getTable()
    {
     return this.Table;
    }
    
    
    
}
