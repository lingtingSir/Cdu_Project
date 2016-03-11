package System.Data;

import java.util.LinkedHashMap;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class DataRow extends LinkedHashMap<String,Object>{

  
  /**
    * 在getValue()和setValue()時候，程式碼須透過此成員的欄位名稱來找出Map字典裡的物件
    */
   @ManyToOne
private DataColumnCollection columns;
   /**
    * 此資料列所屬的DataTable，唯讀
    */
   @ManyToOne
private DataTable table; 
   
 
   protected DataRow() {
}


/**
    * DataRow被建立時，必須指定所屬的DataTable
    * @param DataRow所屬的DataTable 
    */
   public DataRow(DataTable table) {
      this.table = table;
      this.columns = table.Columns;
   }

   
  /**
    * 取得DataRow所屬的DataTable
    * @return DataTable
    */
  public DataTable getTable()
  {
    return this.table;
  }

  /**
   * 設定該列該行的值
   * @param columnindex 行索引(從0算起)
   * @param value 要設定的值
   */
   public void setValue(int columnindex,Object value) {
       setValue(this.columns.get(columnindex), value);
  }
 
  /**
    * 設定該列該行的值
    * @param columnName 行名稱
    * @param value 要設定的值
    */
   public void setValue(String columnName,Object value) {
       this.put(columnName.toLowerCase(), value);
   }

   /**
    * 設定該列該行的值
    * @param column DataColumn物件
    * @param value 要設定的值
    */
   private void setValue(DataColumn column,Object value) {
       if (column != null) {
           String lowerColumnName = column.ColumnName.toLowerCase();
         if (this.containsKey(lowerColumnName))
              this.remove(lowerColumnName);
           this.put(lowerColumnName, value);
       }
   }

  /**
    * 取得該列該行的值
    * @param columnIndex 行索引(從0算起)
    * @return Object
    */
  public Object getValue(int columnIndex) {
      String columnName = this.columns.get(columnIndex).ColumnName.toLowerCase();//取得Key
      return this.get(columnName);
  }

  /**
   * 取得該列該行的值
   * @param columnName 行名稱
   * @return Object
   */
  public Object getValue(String columnName) {
      return this.get(columnName.toLowerCase());//利用欄名(Key)來取值
  }
 
 /**
   * 取得該列該行的值
   * @param column DataColumn物件
   * @return Object
   */
  public Object getValue(DataColumn column) {
    return this.get(column.ColumnName.toLowerCase());//利用欄名(Key)來取值
 }
 //叶小钗
  @OneToMany
List<DataColumn> col;

  

  public DataRow(List<DataColumn> c) {

     col = c;

  }



  public List<DataColumn> getCol() {

     return col;

  }



  public void setCol(List<DataColumn> col) {

     this.col = col;

  }
}