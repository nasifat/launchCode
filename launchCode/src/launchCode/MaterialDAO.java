package launchCode;

import java.sql.SQLException;
import java.util.List;

public interface MaterialDAO {

	public RawMaterial get();
	public void delete();
	public void upDate(RawMaterial rawMaterial) throws SQLException, ClassNotFoundException;
	public List<RawMaterial> findALl() throws Exception;
}
