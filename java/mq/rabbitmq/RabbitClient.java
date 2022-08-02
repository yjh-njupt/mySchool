package mq.rabbitmq;

import com.rabbitmq.client.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class RabbitClient {
    private static final Logger logger = LoggerFactory.getLogger(RabbitClient.class);
    private final static String QUEUE_NAME = "hello world";
    @Test
    public void demo() {
        Connection connection = null;
        Channel channel = null;
        //#设置连接属性。未设置时使用默认值:使用默认账号guest连接到localhost到默认vhost "/"
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.135.131");
        factory.setPort(5672);
        //connectionFactory.setVirtualHost("/");
        factory.setUsername("guest");
        factory.setPassword("guest");
        //#生成Connection & Channel
        try {
             connection = factory.newConnection();
             channel = connection.createChannel();

            // 声明一个队列：名称、持久性的（重启仍存在此队列）、非私有的、非自动删除的
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            String message = "hello world...message"; // 需发送的信息
            /* 发送消息，使用默认的direct交换器 */
            channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
            logger.info("Send message -> " + message);

        } catch (IOException e) {
            logger.error("{}",e);
        } catch (Exception e) {
            logger.error("{}",e);
        } finally {
             //关闭连接、通道
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            logger.info("Closed the channel and conn.");
        }
    }

    @Test
    public void demo2(){
        try {
            /* 创建连接工厂 */
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("192.168.135.131");
            factory.setPort(5672);
            factory.setUsername("guest");
            factory.setPassword("guest");
            /* 创建连接 */
            Connection connection = factory.newConnection();
            /* 创建信道 */
            Channel channel = connection.createChannel();
            // 声明一个队列：名称、持久性的（重启仍存在此队列）、非私有的、非自动删除的
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            System.out.println("Waiting for messages.");
            /* 定义消费者 */
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println("Received the message -> " + message);
                }
            };
            // 将消费者绑定到队列，并设置自动确认消息（即无需显示确认，如何设置请慎重考虑）
            //channel.basicConsume(QUEUE_NAME, true, consumer);
            GetResponse response = channel.basicGet(QUEUE_NAME, false);
            //handle(response) //消费消息
            System.out.println(response.getMessageCount());
            String s = new String(response.getBody());
            System.out.println(s);
            channel.basicAck(response.getEnvelope().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
