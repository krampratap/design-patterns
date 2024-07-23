package c_Structural.adapter;

import c_Structural.adapter.toolMigration.DataAnalyticsNewToolAdapter;
import c_Structural.adapter.toolMigration.DataAnalyticsOldTool;
import c_Structural.adapter.toolMigration.IDataAnalyticsOldTool;
import c_Structural.adapter.toolMigration.Xml;

public class Adapter {
    public static void main(String[] args) {
        Xml xmlData = new Xml("Dummy XML data");
        /* Section 1
        Xml data = new Xml("dummy xml data");
        1. Tool expects the data json because it is very good at analyzing json data but we have only xml data
        DataAnalyticsOldTool tool = new DataAnalyticsOldTool();
        2. Client wants to process the data using the tool*/
        IDataAnalyticsOldTool dataAnalyticsOldTool = new DataAnalyticsOldTool();
        dataAnalyticsOldTool.analyseData(xmlData);

        
        /* Section 2 Adapter Implementation
        3. Now as the tool is not able to process xml data we have to change the tool
        // to ADAPTER */
        IDataAnalyticsOldTool adapter = new DataAnalyticsNewToolAdapter();
        //As we are implementing the same Interface, the client does not have to change the code..we can inject the new tool
        //using dependency injection
        adapter.analyseData(xmlData);
    }
}
