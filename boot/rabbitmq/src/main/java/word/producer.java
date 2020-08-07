package word;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class producer {
        public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory f = new ConnectionFactory();
        f.setHost("192.168.75.130");
        f.setPort(5672);
        f.setUsername("admin");
        f.setPassword("admin");
        Connection con = f.newConnection();
        Channel c = con.createChannel();
        c.queueDeclare("helloword",false,false,false,null);


        c.basicPublish("","Helloword",null,"HelloWord".getBytes());
        System.out.println("消息已发送！！");
        c.close();
        con.close();
    }
}
