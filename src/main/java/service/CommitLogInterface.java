package service;

import java.util.concurrent.Future;

public interface CommitLogInterface {
    public Future<?> attachCommitLog(CommitLogDefaults config, boolean replay);
    public Future<?> detachCommitLog(boolean deletingExisting);
}
