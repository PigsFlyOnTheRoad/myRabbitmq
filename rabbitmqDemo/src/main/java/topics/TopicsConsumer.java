package topics;

import com.rabbitmq.client.*;
import rabbitMqUtil.RabbitMqUtil;

import java.io.IOException;

/**
 * @ClassName TopicsConsumer
 * @Description 动态路由提供者
 * @Author cailun
 */
public class TopicsConsumer {

    public static void main(String[] args) throws IOException {

        Connection connection = RabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("logs_topics","topic");
        String queue = channel.queueDeclare().getQueue();
        //动态路由，多一个通配符，在消费者中配置通配符
        String routingKey = "user.*";
        channel.queueBind(queue,"logs_topics",routingKey);
        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                System.out.println(new String(body));
            }
        });


    }
}
