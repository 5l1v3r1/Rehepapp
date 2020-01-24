package CLI;

public class CliHelp implements CliCommand
{
    @Override
    public String handle(String input)
    {
        String helpData = "---Commands list---\n";
        helpData += "add-project\n";
        helpData += "activate\n";
        helpData += "deactivate\n";
        helpData += "default\n\n";
        
        helpData += "projects\n";
        helpData += "bots\n\n";
        
        helpData += "coverage\n";
        return helpData;
    }
}
