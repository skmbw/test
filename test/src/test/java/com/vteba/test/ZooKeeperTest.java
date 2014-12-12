package com.vteba.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;

public class ZooKeeperTest {
	
	public static void main(String[] args) {
		Watcher watcher = new Watcher() {
			
			@Override
			public void process(WatchedEvent event) {
				event.getState();
			}
		};
		try {
			ZooKeeper zooKeeper = new ZooKeeper("localhost", 2000, watcher);
			zooKeeper.getSessionId();
			
			List<ACL> acls = new ArrayList<>();
			Id id = new Id("", "");
			ACL acl = new ACL(1, id);
			acls.add(acl);
			
			try {
				zooKeeper.create("/data", "test".getBytes(), Ids.READ_ACL_UNSAFE, CreateMode.EPHEMERAL);
			} catch (KeeperException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			try {
				zooKeeper.close();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			
		}
	}
}
