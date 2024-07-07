package c_Structural.adapter.toolMigration;

public class DataAnalyticsNewToolAdapter implements IDataAnalyticsOldTool {
    //The ADAPTER class will use both inheritance (up) and composition (down ex: final )
    private final DataAnalyticsNewTool dataAnalyticsNewTool;
    public DataAnalyticsNewToolAdapter()
    {
        dataAnalyticsNewTool = new DataAnalyticsNewTool();
    }
    @Override
    public void analyseData(Xml xmlData) {
        String jsonData = convertXmlToJson(xmlData);
        dataAnalyticsNewTool.analyseData(jsonData);
    }

    private String convertXmlToJson(Xml xml){
        return "Converted to Json data : " + xml;
    }
}
