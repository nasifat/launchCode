package launchCode;


import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MaterialDAOImpl implements MaterialDAO {

	private final String jdbcDriverStr;
    private final String jdbcURL;
 
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
 
    public MaterialDAOImpl(String jdbcDriverStr, String jdbcURL){
        this.jdbcDriverStr = jdbcDriverStr;
        this.jdbcURL = jdbcURL;
    }

	@Override
	public RawMaterial get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upDate() throws SQLException {
		// TODO Auto-generated method stub
		preparedStatement = connection.prepareStatement("insert into javaTestDB.test_table values (default,?)");
        preparedStatement.setString(1,"insert test from java");
        preparedStatement.executeUpdate();
	}

	@Override
	public List<RawMaterial> findALl() throws Exception {
		try {
        Class.forName(jdbcDriverStr);
        connection = DriverManager.getConnection(jdbcURL);
        statement = connection.createStatement();
        resultSet = statement.executeQuery("select * from javaTestDB.test_table;");
        getResultSet(resultSet);
        
    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
        close();
    }
		return null;}
	private void close(){
        try {
            if(resultSet!=null) resultSet.close();
            if(statement!=null) statement.close();
            if(connection!=null) connection.close();
        } catch(Exception e){}
    }

	private void getResultSet(ResultSet resultSet2) throws Exception {
		// TODO Auto-generated method stub
		 while(resultSet.next()){
	            Integer id = resultSet.getInt(TestTableColumns.id.toString());
	            String text = resultSet.getString(TestTableColumns.TEXT.toString());
	            System.out.println("id: "+id);
	            System.out.println("text: "+text);
	        }
	}
	

}
