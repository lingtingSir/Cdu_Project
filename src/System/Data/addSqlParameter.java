package System.Data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.persistence.Entity;

@Entity
public class addSqlParameter {
	protected addSqlParameter() {
	}

	public void addSqlParameter(PreparedStatement ps, SqlParameter[] p)
            throws SQLException {
        for (int j = 0; j < p.length; j++) {
            // wl(p[j].getValue() + "--" + p[j].getType() + "--" + j);
            if (p[j].getType().equals("int")) {
                ps.setInt(j + 1, p[j].getIntValue());
            }
            if (p[j].type.equals("String")) {
                ps.setString(j + 1, p[j].getValue());
            }
            if (p[j].type.equals("boolean")) {
                ps.setBoolean(j + 1, p[j].getBoolValue());
            }
            if (p[j].type.equals("Date")) {
                ps.setDate(j + 1, p[j].getDateValue());
            }
            if (p[j].type.equals("Blob")) {
                ps.setBlob(j + 1, p[j].getBlobValue());
            }
        }
    }
}
