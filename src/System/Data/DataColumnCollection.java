package System.Data;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class DataColumnCollection extends ArrayList<DataColumn>{

    /**
     * DataColumnCollection所屬的DataTable，唯讀
     */
    @OneToOne(mappedBy = "Columns")
	private DataTable Table;
    
    protected DataColumnCollection() {
	}

	/**
     * DataColumnCollection被建立時，一定要指定所屬的DataTable
     * @param table 
     */
    public DataColumnCollection(DataTable table)
    {
      this.Table = table;
    }
    
    /**
     * 取得DataColumnCollection所屬的DataTable
     * @return DataTable
     */
    public DataTable getTable()
    {
      return this.Table;
    }
    
    /**
     * 加入一個DataColumn物件，程式碼會設定該DataColumn的DataTable和呼叫Add()方法的DataColumnCollection同一個DataTable
     * @param column 
     */
    public void Add(DataColumn column)
    {  
       column.setTable(this.Table);
       this.add(column);
    }
    
    /**
     * 給欄位名稱
     * <br/>加入一個DataColumn物件，程式碼會設定該DataColumn的DataTable和呼叫Add()方法的DataColumnCollection同一個DataTable
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
     * 依據欄名，取得DataColumn
     * @param columnName 欄名
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