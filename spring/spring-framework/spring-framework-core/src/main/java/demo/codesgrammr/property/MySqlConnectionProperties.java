package demo.codesgrammr.property;

import org.springframework.beans.factory.annotation.Value;

public class MySqlConnectionProperties {

    @Value("${database.host}")
    private String databaseHost;

    @Value("${database.name}")
    private String databaseName;

    // default value of true because it does not exist in property file
    @Value("${connection.switch:true}")
    private boolean connectionSwitch;

    public String getDatabaseHost() {
        return databaseHost;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public boolean isConnectionSwitch() {
        return connectionSwitch;
    }

    @Override
    public String toString() {
        return "MySqlConnectionProperties{" +
                "databaseHost='" + databaseHost + '\'' +
                ", databaseName='" + databaseName + '\'' +
                ", connectionSwitch=" + connectionSwitch +
                '}';
    }
}
