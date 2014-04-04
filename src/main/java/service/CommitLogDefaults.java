package service;

public enum CommitLogDefaults {
    COMMIT_LOG_DIRECTORY("/tmp/bluelight-commit-log");

    static {
        CommitLogConfigurator.getInstance().loadDefaults(CommitLogDefaults.values());
    }

    private String value;
    private CommitLogDefaults(String val) {
        this.value = val;
    }
    public String getValue() {
        return value;
    }

}
