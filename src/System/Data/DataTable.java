package System.Data;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class DataTable {
    
    /**
    * ����DataRow�ļ��ϣ���DataTable��ʼ���r���������
    */
    @OneToOne()
	public DataRowCollection Rows; 
    /**
     * ����DataColumn�ļ��ϣ���DataTable��ʼ���r���������
     */
    @OneToOne()
	public DataColumnCollection Columns; 
    /**
     * DataTable�����Q���]ʲ�N�õ�
     */
    public String TableName; 

    /**
     * ��ʼ��DataTable���K����DataColumnCollection��DataRowCollection
     */
    public DataTable() {
        this.Columns = new DataColumnCollection(this);
        this.Rows = new DataRowCollection(this);
        
    }
    
    /**
    * ���˳�ʼ��DataTable�� ����ָ��DataTable������(�]ʲ�N���x)
    * @param dataTableName DataTable������
    */
    public DataTable(String tableName) {
        this();
        this.TableName = tableName;
    }



   /**
     * �ɴ�DataTable�������һ��DataRow���
     * @return DataRow
     */
    public DataRow NewRow()  {
       
       DataRow row = new DataRow(this);//DataRow����д˷���DataTable�ĳɆT
       
       return row;
  }

   
    /**
     * ��DataTable�������S��У��o�����������������O��ֵ�ķ���
     * <br/>(�l�������Ќ��ķ���)
     * @param rowIndex ������(��0����)
     * @param columnIndex ������(��0����)
     * @param value Ҫ�o��ֵ
     */
   public void setValue(int rowIndex, int columnIndex,Object value) {
       this.Rows.get(rowIndex).setValue(columnIndex, value);
   }

   /**
     * ��DataTable�������S��У��o�������������Q���O��ֵ�ķ���
     * <br/>(�l�������Ќ��ķ���)
     * @param rowIndex ������(��0����)
     * @param columnIndex �����Q
     * @param value Ҫ�o��ֵ
     */
    public void setValue(int rowIndex,String columnName,Object value) {
        this.Rows.get(rowIndex).setValue(columnName.toLowerCase(), value);
    }
    
    
    /**
     * ��DataTable�������S��У��o����������������ȡ��ֵ�ķ���
     * <br/>(�l�������Ќ��ķ���)
     * @param rowIndex ������(��0����)
     * @param columnIndex ������(��0����)
     * @return �؂�ԓλ�õ�ֵ
     */
   public Object getValue(int rowIndex,int columnIndex) {
       return this.Rows.get(rowIndex).getValue(columnIndex);
   }
         
         
    /**
    * ��DataTable�������S��У��o�������������Q��ȡ��ֵ�ķ���
    * <br/>(�l�������Ќ��ķ���)
    * @param rowIndex ������(��0����)
    * @param columnName �����Q
    * @return �؂�ԓλ�õ�ֵ
    */
    public Object getValue(int rowindex,String columnName) {
       return this.Rows.get(rowindex).getValue(columnName.toLowerCase());
   }
    
     //ҶС��
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
