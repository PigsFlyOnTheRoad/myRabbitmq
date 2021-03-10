package fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitMqUtil.RabbitMqUtil;

import java.io.IOException;

/**
 * @ClassName Provider
 * @Description 广播类型
 * @Author cailun
 */
public class Provider {

    public static void main(String[] args) throws IOException {


        Connection connection = RabbitMqUtil.getConnection();

        //绑定通道
        Channel channel = connection.createChannel();
        //指明交换机        交换机名称，交换机类型
        channel.exchangeDeclare("logs", "fanout");
                                                    //队列名称
            channel.basicPublish("logs","",null,"fanout type message".getBytes());
        RabbitMqUtil.closeConnection(connection,channel);
    }
}
