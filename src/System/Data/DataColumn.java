package System.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
@Entity
public class DataColumn {
    
	
	//ҶС��
	String key;
    Object value;
 
    protected DataColumn() {
	}

	public DataColumn(String k, Object v) {
        key = k;
        value = v;
    }
 
    public String getKey() {
        return key;
    }
 
    public Object getValue() {
        return value;
    }
 
    public void setKey(String key) {
        this.key = key;
    }
 
    public void setValue(Object value) {
        this.value = value;
    }
	
	
    /**
    * DataColumn���ٵ�DataTable
    */
    @ManyToOne
	private DataTable table; 
    /**
     * DataColumn�ę�λ���Q
     */
    public String ColumnName; // ����������DataRow��key
    

   /**
     * DataColumn�������r��һ��Ҫָ������
     * @param columnName ����
     */
    public DataColumn(String columnName) {
      this.ColumnName = columnName.toLowerCase();
    }
   
   /**
    * �oDataColumnCollection����DataColumn�r�O�����ٵ�DataTable�ķ�����ͬһ��package���õ�
    * @param table 
    */
    void setTable(DataTable table)
   {
     this.table = table;
   }
   
   /**
    * ȡ��DataColumn���ٵ�DataTable��Ψ�x
    * @return DataTable
    */
   public DataTable getTable()
   {
      return this.table;
   }
 
    /**
    * DataColumn�����toString()�����؂��Լ��ę���
    * @return 
    */
    @Override
    public String toString(){
        return this.ColumnName;
    }
 }

