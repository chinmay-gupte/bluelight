package service;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class CommitLogConfigurator {
    private static final Properties defaultProps = new Properties();
    private static Properties props;
    private static final CommitLogConfigurator instance = new CommitLogConfigurator();

    public static CommitLogConfigurator getInstance() {
        return instance;
    }

    private CommitLogConfigurator() {
        try {
            init();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void loadDefaults(CommitLogDefaults[] configDefaults) {
        for (CommitLogDefaults configDefault : configDefaults) {
            defaultProps.setProperty(configDefault.toString(), configDefault.getValue());
        }
    }

    public void init() throws IOException {
        props = new Properties(defaultProps);
        // load the configuration.
        String configStr = System.getProperty("bluelight.config");
        if (configStr != null) {
            URL configUrl = new URL(configStr);
            props.load(configUrl.openStream());
        }
    }
}
