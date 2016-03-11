package System.Data;

import java.util.LinkedHashMap;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class DataRow extends LinkedHashMap<String,Object>{

  
  /**
    * ��getValue()��setValue()�r�򣬳�ʽ�a�͸�^�˳ɆT�ę�λ���Q���ҳ�Map�ֵ��e�����
    */
   @ManyToOne
private DataColumnCollection columns;
   /**
    * ���Y�������ٵ�DataTable��Ψ�x
    */
   @ManyToOne
private DataTable table; 
   
 
   protected DataRow() {
}


/**
    * DataRow�������r�����ָ�����ٵ�DataTable
    * @param DataRow���ٵ�DataTable 
    */
   public DataRow(DataTable table) {
      this.table = table;
      this.columns = table.Columns;
   }

   
  /**
    * ȡ��DataRow���ٵ�DataTable
    * @return DataTable
    */
  public DataTable getTable()
  {
    return this.table;
  }

  /**
   * �O��ԓ��ԓ�е�ֵ
   * @param columnindex ������(��0����)
   * @param value Ҫ�O����ֵ
   */
   public void setValue(int columnindex,Object value) {
       setValue(this.columns.get(columnindex), value);
  }
 
  /**
    * �O��ԓ��ԓ�е�ֵ
    * @param columnName �����Q
    * @param value Ҫ�O����ֵ
    */
   public void setValue(String columnName,Object value) {
       this.put(columnName.toLowerCase(), value);
   }

   /**
    * �O��ԓ��ԓ�е�ֵ
    * @param column DataColumn���
    * @param value Ҫ�O����ֵ
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
    * ȡ��ԓ��ԓ�е�ֵ
    * @param columnIndex ������(��0����)
    * @return Object
    */
  public Object getValue(int columnIndex) {
      String columnName = this.columns.get(columnIndex).ColumnName.toLowerCase();//ȡ��Key
      return this.get(columnName);
  }

  /**
   * ȡ��ԓ��ԓ�е�ֵ
   * @param columnName �����Q
   * @return Object
   */
  public Object getValue(String columnName) {
      return this.get(columnName.toLowerCase());//���Ù���(Key)��ȡֵ
  }
 
 /**
   * ȡ��ԓ��ԓ�е�ֵ
   * @param column DataColumn���
   * @return Object
   */
  public Object getValue(DataColumn column) {
    return this.get(column.ColumnName.toLowerCase());//���Ù���(Key)��ȡֵ
 }
 //ҶС��
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