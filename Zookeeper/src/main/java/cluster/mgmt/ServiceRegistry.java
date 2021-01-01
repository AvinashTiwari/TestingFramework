package cluster.mgmt;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServiceRegistry implements Watcher {
    private static final String REGISTRY_ZNODE = "/service_registry";
    private final ZooKeeper zooKeeper;
    private String currentZnode = null;
    private List<String> allServiceAddress = null;


    public ServiceRegistry(ZooKeeper zooKeeper ){
        this.zooKeeper = zooKeeper;

        createServiceRegistryZnode();
    }
    public void registerToCluster(String metadata) throws KeeperException, InterruptedException {
        this.currentZnode = zooKeeper.create(REGISTRY_ZNODE + "/n_", metadata.getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("Registered to service registry");

    }
    public void registerForUpdates(){
        try {
            updateAddress();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

     public synchronized List<String> getAllServiceAddress(){
        if(allServiceAddress == null){
            try {
                updateAddress();
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return  allServiceAddress;
     }

     public void unregisterFromCluster() throws KeeperException, InterruptedException {
        if(currentZnode != null && zooKeeper.exists(currentZnode ,false) !=null){
           zooKeeper.delete(currentZnode, -1);
        }
     }

    private void createServiceRegistryZnode(){
        try {
            if (zooKeeper.exists(REGISTRY_ZNODE,false) == null){
             zooKeeper.create(REGISTRY_ZNODE, new byte[]{},
                     ZooDefs.Ids.OPEN_ACL_UNSAFE,
                     CreateMode.PERSISTENT);
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private  synchronized void updateAddress() throws KeeperException, InterruptedException {
      List<String> workZones = zooKeeper.getChildren(REGISTRY_ZNODE, this);
      List<String> address = new ArrayList<>();
      for (String workZone: workZones){
          String workerZnodeFullPath = REGISTRY_ZNODE +"/"+workZone;
          Stat stat = zooKeeper.exists(workerZnodeFullPath,false);
          if(stat == null){
              continue;
          }

          byte[]  addressBytes = zooKeeper.getData(workerZnodeFullPath, false, stat);
          String addresss = new String(addressBytes);
          address.add(addresss);

      }
      this.allServiceAddress = Collections.unmodifiableList(address);
        System.out.println("The cluster address are " + this.allServiceAddress);
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        try {
            updateAddress();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
