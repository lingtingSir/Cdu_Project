package System.Data;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
public class DataRowCollection extends ArrayList<DataRow>{
    
    /**
     * DataRowCollection���ٵ�DataTable��Ψ�x
     */
    @OneToOne(mappedBy = "Rows")
	private DataTable Table;

    protected DataRowCollection() {
	}

	/**
     * DataRowCollection�������r��һ��Ҫָ�����ٵ�DataTable
     * @param table 
     */
    public DataRowCollection(DataTable table)
    {
     this.Table = table;
    
    }
    
    /**
     * ȡ�����ٵ�DataTable
     * @return DataTable
     */
    public DataTable getTable()
    {
     return this.Table;
    }
    
    
    
}
