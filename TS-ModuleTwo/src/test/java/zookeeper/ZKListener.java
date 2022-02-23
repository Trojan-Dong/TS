package zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.*;

public class ZKListener {


    public static void main(String[] args) throws Exception {
        CuratorFramework zkClient = new ZookeeperClient().getClient();
        zkClient.start();
        TreeCache treeCache = new TreeCache(zkClient, "/root/node1");
        treeCache.getListenable().addListener((client, event) -> {
            System.out.println("listening");
            if (TreeCacheEvent.Type.NODE_ADDED.equals(event.getType()) || TreeCacheEvent.Type.NODE_UPDATED.equals(event.getType())) {
                System.out.println("数据改变" + event.getType().name());
            }
//            System.out.println(new String(zkClient.getData().forPath("/root/node1"),
//                    "UTF-8"));
        });
        treeCache.start();
        int i = 0;
        while (i < 20) {
            i++;
            Thread.sleep(3000);
        }

    }
}
