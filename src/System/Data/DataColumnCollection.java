package System.Data;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class DataColumnCollection extends ArrayList<DataColumn>{

    /**
     * DataColumnCollection���ٵ�DataTable��Ψ�x
     */
    @OneToOne(mappedBy = "Columns")
	private DataTable Table;
    
    protected DataColumnCollection() {
	}

	/**
     * DataColumnCollection�������r��һ��Ҫָ�����ٵ�DataTable
     * @param table 
     */
    public DataColumnCollection(DataTable table)
    {
      this.Table = table;
    }
    
    /**
     * ȡ��DataColumnCollection���ٵ�DataTable
     * @return DataTable
     */
    public DataTable getTable()
    {
      return this.Table;
    }
    
    /**
     * ����һ��DataColumn�������ʽ�a���O��ԓDataColumn��DataTable�ͺ���Add()������DataColumnCollectionͬһ��DataTable
     * @param column 
     */
    public void Add(DataColumn column)
    {  
       column.setTable(this.Table);
       this.add(column);
    }
    
    /**
     * �o��λ���Q
     * <br/>����һ��DataColumn�������ʽ�a���O��ԓDataColumn��DataTable�ͺ���Add()������DataColumnCollectionͬһ��DataTable
     * @param columnName
     * @return 
     */
    public DataColumn Add(String columnName)
    {  
       DataColumn column = new DataColumn(columnName.toLowerCase());
       column.setTable(this.Table);
       this.add(column);
       return column;
    }
     
    /**
     * ����������ȡ��DataColumn
     * @param columnName ����
     * @return DataColumn
     */
    public DataColumn get(String columnName)
    {   
        
       DataColumn column = null;
       for(DataColumn dataColumn :this)
       {
           if (dataColumn.ColumnName.toLowerCase().equals(columnName.toLowerCase())) {
               return dataColumn;
           }
       
       }
        return column;
    }
    

}