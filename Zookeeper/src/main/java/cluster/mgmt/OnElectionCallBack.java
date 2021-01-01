package cluster.mgmt;

public interface OnElectionCallback {

    void onElectedToBeLeader();

    void onWorker();
}
