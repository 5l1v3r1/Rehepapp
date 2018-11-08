package CLI;

import Caches.ProjectsCache;
import Server.Server;
import Server.Database.Project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CliStats implements CliCommand
{
    Server server;
            
    CliStats(Server serverIn)
    {
        server = serverIn;
    }
    
    @Override
    public String handle(String input) throws Exception
    {
        Connection con = server.getDBconnection();
        String result = "";
        
        PreparedStatement stmt = con.prepareStatement("SELECT id, name, code, extension, magic, testcase_count, coverage_count, active, isdefault FROM project");
        ResultSet rs = stmt.executeQuery();
        while(rs.next())
        {
            result += "--- " + rs.getString("name") + " ---\n";
            result += "ID: " + rs.getInt("id") + "\n";
            result += "Code: " + rs.getString("code") + "\n";
            result += "Ext: " + rs.getString("extension") + "\n";
            result += "Magic: " + rs.getString("magic") + "\n";
            result += "Testcases: " + rs.getInt("testcase_count") + "\n";
            result += "Coverage done: " + rs.getInt("coverage_count") + "\n";
            if(rs.getInt("active") > 0)
                result += "ACTIVATED\n";
            if(rs.getInt("isdefault") > 0)
                result += "DEFAULT\n";
        }
        
        return result;
    }
}
