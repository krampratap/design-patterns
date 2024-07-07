package c_Structural.adapter.toolMigration;

public class DataAnalyticsOldTool implements IDataAnalyticsOldTool{
    @Override
    public void analyseData(Xml xmlData) {
        System.out.println("Analysing Xml data" + xmlData);
    }
}
