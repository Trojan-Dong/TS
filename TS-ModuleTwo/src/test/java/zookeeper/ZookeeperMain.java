package zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class ZookeeperMain {

    private static final int BASE_SLEEP_TIME = 1000;
    private static final int MAX_RETRIES = 3;

    public static void main(String[] args) throws Exception {
        // Retry strategy. Retry 3 times, and will increase the sleep time between retries.
        CuratorFramework zkClient = new ZookeeperClient().getClient();
        zkClient.start();
        zkClient.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/root/node1/node2","123".getBytes());
//        zkClient.setData().forPath("/root/node1", "change".getBytes());
//        zkClient.create().creatingParentContainersIfNeeded().withMode(CreateMode.EPHEMERAL)
//        System.out.println(new String(zkClient.getData().forPath("/root"), "UTF-8"));
    }
}
