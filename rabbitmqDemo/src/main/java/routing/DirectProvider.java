package routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitMqUtil.RabbitMqUtil;

import java.io.IOException;

/**
 * @ClassName Direct
 * @Description 路由直连类型
 * @Author cailun
 */
public class DirectProvider {

    public static void main(String[] args) throws IOException {

        Connection connection = RabbitMqUtil.getConnection();

        Channel channel = connection.createChannel();
        //声明交换机，并绑定
        channel.exchangeDeclare("logs_direct","direct");
        //路由key，与消费之接收消息的key对应
        String routingKet = "info";
        channel.basicPublish("logs_direct",routingKet,null,"routingDirect type message".getBytes());

        RabbitMqUtil.closeConnection(connection,channel);

    }

}
