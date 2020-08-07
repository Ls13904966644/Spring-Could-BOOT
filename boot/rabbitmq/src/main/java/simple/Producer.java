package simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


public class Producer {
        public static void main(String[] args) throws Exception {
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
