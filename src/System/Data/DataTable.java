package System.Data;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class DataTable {
    
    /**
    * 保存DataRow的集合，在DataTable初始化時，便會建立
    */
    @OneToOne()
	public DataRowCollection Rows; 
    /**
     * 保存DataColumn的集合，在DataTable初始化時，便會建立
     */
    @OneToOne()
	public DataColumnCollection Columns; 
    /**
     * DataTable的名稱，沒什麼用到
     */
    public String TableName; 

    /**
     * 初始化DataTable，並建立DataColumnCollection，DataRowCollection
     */
    public DataTable() {
        this.Columns = new DataColumnCollection(this);
        this.Rows = new DataRowCollection(this);
        
    }
    
    /**
    * 除了初始化DataTable， 可以指定DataTable的名字(沒什麼意義)
    * @param dataTableName DataTable的名字
    */
    public DataTable(String tableName) {
        this();
        this.TableName = tableName;
    }



   /**
     * 由此DataTable物件來建立一個DataRow物件
     * @return DataRow
     */
    public DataRow NewRow()  {
       
       DataRow row = new DataRow(this);//DataRow為呼叫此方法DataTable的成員
       
       return row;
  }

   
    /**
     * 把DataTable當做二維陣列，給列索引和行索引，設定值的方法
     * <br/>(發佈者自行寫的方法)
     * @param rowIndex 列索引(從0算起)
     * @param columnIndex 行索引(從0算起)
     * @param value 要給的值
     */
   public void setValue(int rowIndex, int columnIndex,Object value) {
       this.Rows.get(rowIndex).setValue(columnIndex, value);
   }

   /**
     * 把DataTable當做二維陣列，給列索引和行名稱，設定值的方法
     * <br/>(發佈者自行寫的方法)
     * @param rowIndex 列索引(從0算起)
     * @param columnIndex 行名稱
     * @param value 要給的值
     */
    public void setValue(int rowIndex,String columnName,Object value) {
        this.Rows.get(rowIndex).setValue(columnName.toLowerCase(), value);
    }
    
    
    /**
     * 把DataTable當做二維陣列，給列索引和行索引，取得值的方法
     * <br/>(發佈者自行寫的方法)
     * @param rowIndex 列索引(從0算起)
     * @param columnIndex 行索引(從0算起)
     * @return 回傳該位置的值
     */
   public Object getValue(int rowIndex,int columnIndex) {
       return this.Rows.get(rowIndex).getValue(columnIndex);
   }
         
         
    /**
    * 把DataTable當做二維陣列，給列索引和行名稱，取得值的方法
    * <br/>(發佈者自行寫的方法)
    * @param rowIndex 列索引(從0算起)
    * @param columnName 行名稱
    * @return 回傳該位置的值
    */
    public Object getValue(int rowindex,String columnName) {
       return this.Rows.get(rowindex).getValue(columnName.toLowerCase());
   }
    
     //叶小钗
    @OneToMany
	List<DataRow> row;
    public DataTable(List<DataRow> r) {
        row = r;
    }
 
    public List<DataRow> getRow() {
        return row;
    }
 
    public void setRow(List<DataRow> row) {
        this.row = row;
    }

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}
