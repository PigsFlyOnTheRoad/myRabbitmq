package topics;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitMqUtil.RabbitMqUtil;

import java.io.IOException;

/**
 * @ClassName TopicsProvider
 * @Description 动态路由提供者
 * @Author cailun
 */
public class TopicsProvider {

    public static void main(String[] args) throws IOException {

        Connection connection = RabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();
        //声明交换机
        channel.exchangeDeclare("logs_topics", "topic");
        String queue = channel.queueDeclare().getQueue();
        String routingKey = "user.info";
        channel.queueBind(queue,"logs_topics",routingKey);

        channel.basicPublish("logs_topics",routingKey,null,"routingTopics message".getBytes());

        RabbitMqUtil.closeConnection(connection,channel);
    }
}
