package demo.demomemcached;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.spy.memcached.MemcachedClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMemcached {
	
	  @Resource
	  private MemcachedRunner memcachedRunner;

	  @Test
	  public void testSetGet()  {
	    MemcachedClient memcachedClient = memcachedRunner.getClient();
	    memcachedClient.set("testkey",1000,"666666");
	    System.out.println("***********  "+ memcachedClient.get("testkey").toString());
	    
	    memcachedClient.set("message", 1000, "this is secret message");
	    
	    System.out.println("message: " + memcachedClient.get("message"));
	  }
}
